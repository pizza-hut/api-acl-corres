package org.owlet.corres.model;

public class CorresJobResponse {
	private String jobId;
	private String priority;
	private String status;
	private String responseXML;
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponseXML() {
		return responseXML;
	}
	public void setResponseXML(String responseXML) {
		this.responseXML = responseXML;
	}



}
