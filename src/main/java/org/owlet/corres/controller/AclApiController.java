package org.owlet.corres.controller;

import org.owlet.corres.model.CorresJobRequest;

//import java.util.List;

import org.owlet.corres.model.CorresJobResponse;
import org.owlet.corres.model.CorresStatusResponse;
import org.owlet.corres.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AclApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(AclApiController.class);

	@Autowired
	AclCorresService aclCorresService;
	
	@PostMapping(value="/corres/acl/submit")
	public ResponseEntity<CorresJobResponse> submitJob(@RequestBody CorresJobRequest req) {
		logger.info("RequestBody: '{}', '{}', '{}', '{}'", req.getProjectName(), req.getSiteId(), req.getDataFileContent(), req.getClientApp());
		CorresJobResponse corresJobResponse = new CorresJobResponse(); 
		try {
			corresJobResponse = aclCorresService.submitJob(req);
			logger.info("'{}' '{}' '{}' '{}'", corresJobResponse.getJobId(), corresJobResponse.getStatus(), corresJobResponse.getResponseXML());
			return new ResponseEntity<CorresJobResponse>(corresJobResponse, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}				
		return null;
	}
		
	@RequestMapping(value="/corres/acl/{siteId}/{jobId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<CorresStatusResponse> status(@PathVariable String siteId, @PathVariable String jobId, Object String) {
		try {
			CorresStatusResponse corresStatusResponse = new CorresStatusResponse();
			corresStatusResponse = aclCorresService.getStatus(siteId, jobId);
			return new ResponseEntity<CorresStatusResponse>(corresStatusResponse, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
