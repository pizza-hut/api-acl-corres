package org.owlet.corres.service;

import java.io.ByteArrayInputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.owlet.corres.model.CorresJobResponse;
import org.owlet.corres.model.CorresStatusResponse;
import org.owlet.corres.model.CorresJobRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@Service("AclCorresService")
public class AclCorresServiceImpl implements AclCorresService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${tango.base.url}")
	private String BASE_URL;

	@Value("${tango.ticket.url}")
	private String TICKET_URL;	

	@Value("${tango.job.url}")
	private String JOB_URL;

	@Value("${tango.username}")
	private String tangoUsername;

	@Value("${tango.password}")
	private String tangoPassword;

	@Override
	public CorresJobResponse submitJob(CorresJobRequest req) throws Exception {

		logger.info(this.getClass().toString() + " submitJob");
		String ticket = this.getTangoTicket();
		logger.info("tango ticket '{}'", ticket);
		CorresJobResponse corresJobResponse = this.submitTangoProduction(ticket, req);		
		return corresJobResponse;		
	}


	private CorresJobResponse submitTangoProduction(String ticket, CorresJobRequest req) throws Exception{

		CorresJobResponse corresJobResponse = new CorresJobResponse();

		Client client = ClientBuilder.newClient();
		MultivaluedHashMap<String, String> formParams = new MultivaluedHashMap<>();
		formParams.add("tango-ticket", ticket);
		formParams.add("project-name", req.getProjectName());
		formParams.add("data-file-contents", req.getDataFileContent());
		formParams.add("client-app", "CUI");		
		//formParams.add("effective-date", "2018/01/31");
		formParams.add("site-id", req.getSiteId());

		//tested Tango Api, search-path not mandatory for now
		//formParams.add("search-path", req.getSearchPaths());		

		//hard code repoPath for now
		//TO-DO to use application.properties or redis for lookup
		//formParams.add("repoPath", req.getRepoPath());
		formParams.add("repoPath", "Projects/01Exercise/ShippingOrder");

		logger.info("submitTangoProduction parameters:" + formParams.toString());
		WebTarget resource = client.target(BASE_URL);
		Response res = resource.path(this.JOB_URL).request().post(Entity.form(formParams));
		String submitResultXML = res.readEntity(String.class);
		logger.info(resource.getUri().getPath().toString());
		logger.info("Response status: '{}', '{}'", res.getStatus(), res.getStatusInfo());
		logger.info("submit result in XML: '{}'", submitResultXML);
		
		//TO-DO add some logic to handle failures
		if (res.getStatus() == 201) {
			logger.info("Job is submitted successfully");
						
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(new ByteArrayInputStream(submitResultXML.getBytes()));

			corresJobResponse.setJobId(document.getChildNodes().item(0).getAttributes().item(0).getTextContent());
			corresJobResponse.setPriority(document.getChildNodes().item(0).getChildNodes().item(0).getTextContent());
			corresJobResponse.setStatus(document.getChildNodes().item(0).getChildNodes().item(1).getTextContent());		
			corresJobResponse.setResponseXML(submitResultXML);			
		}
			return corresJobResponse;

		}

		@Override
		public CorresStatusResponse getStatus(String siteId, String jobId) throws Exception {
			logger.info(this.getClass().toString() + " getStatus");		

			String ticket = this.getTangoTicket();
			return this.getTangoJobStatus(ticket, siteId, jobId);	
		}

		private String getTangoTicket() throws Exception {
			logger.info(this.getClass() + "..." + "getTangoTicket");
			logger.info(this.BASE_URL);

			Response res = null;
			String ticket = null;
			MultivaluedMap<String, String> formParams = new MultivaluedHashMap<>();
			formParams.add("username", this.tangoUsername);
			formParams.add("password", this.tangoPassword);
			logger.info(formParams.toString());

			Client client = ClientBuilder.newClient();

			WebTarget resource = client.target(this.BASE_URL);

			if (client!=null) {
				logger.info(client.getConfiguration().toString());
			}  

			if (resource!=null) {
				logger.info(resource.getClass() + ":" + resource.getUri().getPath().toString());
			}

			res = resource.path(this.TICKET_URL).request().accept(MediaType.TEXT_XML).post(Entity.form(formParams));

			if (res==null) {
				logger.info("response is null");
			}

			if(res.getStatus() == 201) {
				logger.info(res.getEntity().toString());
				String ticketResultXML = res.readEntity(String.class);
				logger.info(ticketResultXML);
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = builderFactory.newDocumentBuilder();
				Document document = builder.parse(new ByteArrayInputStream(ticketResultXML.getBytes()));
				NodeList nodeList = document.getChildNodes();

				if (nodeList != null && nodeList.getLength() > 0) {
					ticket = nodeList.item(0).getFirstChild().getNodeValue();
				}			
			} else {
				logger.info(res.getEntity().toString());
			}

			return ticket;

			//TO DO - throw exception when ticket is not given
		}

		private CorresStatusResponse getTangoJobStatus(String ticket, String siteId, String jobId) throws Exception {		

			logger.info(this.BASE_URL);
			logger.info(this.JOB_URL);
			logger.info(siteId);
			logger.info(jobId);
			String url = this.BASE_URL + this.JOB_URL + jobId+"?"+"tango-ticket="+ticket+"&site-id="+siteId;
			logger.info(url);

			logger.info("Start RestTemplate...");

			//TO-DO: change to RestTemplate injection
			RestTemplate restTemplate = new RestTemplate();
			CorresStatusResponse corresStatusResponse = restTemplate.getForObject(url, CorresStatusResponse.class);
			logger.info(corresStatusResponse.toString());

			logger.info("End RestTemplate");

			return corresStatusResponse;
		}
	}
