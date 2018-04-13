package org.owlet.corres.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"executionEndTime",
"executionStartTime",
"job-completion-time",
"job-end-time",
"job-fail-reason",
"job-percentage",
"job-start-time",
"job-status",
"job-submittion-time",
"jobfailreason",
"percentage",
"pfjstatus",
"project",
"project-name",
"submittedOn",
"time",
"userId"
})
public class Info {

	@JsonProperty("executionEndTime")
	private String executionEndTime;
	@JsonProperty("executionStartTime")
	private String executionStartTime;
	@JsonProperty("job-completion-time")
	private String jobCompletionTime;
	@JsonProperty("job-end-time")
	private String jobEndTime;
	@JsonProperty("job-fail-reason")
	private String jobFailReason;
	@JsonProperty("job-percentage")
	private int jobPercentage;
	@JsonProperty("job-start-time")
	private String jobStartTime;
	@JsonProperty("job-status")
	private String jobStatus;
	@JsonProperty("job-submittion-time")
	private String jobSubmittionTime;
	@JsonProperty("jobfailreason")
	private String jobfailreason;
	@JsonProperty("percentage")
	private int percentage;
	@JsonProperty("pfjstatus")
	private String pfjstatus;
	@JsonProperty("project")
	private String project;
	@JsonProperty("project-name")
	private String projectName;
	@JsonProperty("submittedOn")
	private String submittedOn;
	@JsonProperty("time")
	private String time;
	@JsonProperty("userId")
	private String userId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("executionEndTime")
	public String getExecutionEndTime() {
	return executionEndTime;
	}
	
	@JsonProperty("executionEndTime")
	public void setExecutionEndTime(String executionEndTime) {
	this.executionEndTime = executionEndTime;
	}
	
	@JsonProperty("executionStartTime")
	public String getExecutionStartTime() {
	return executionStartTime;
	}
	
	@JsonProperty("executionStartTime")
	public void setExecutionStartTime(String executionStartTime) {
	this.executionStartTime = executionStartTime;
	}
	
	@JsonProperty("job-completion-time")
	public String getJobCompletionTime() {
	return jobCompletionTime;
	}
	
	@JsonProperty("job-completion-time")
	public void setJobCompletionTime(String jobCompletionTime) {
	this.jobCompletionTime = jobCompletionTime;
	}
	
	@JsonProperty("job-end-time")
	public String getJobEndTime() {
	return jobEndTime;
	}
	
	@JsonProperty("job-end-time")
	public void setJobEndTime(String jobEndTime) {
	this.jobEndTime = jobEndTime;
	}
	
	@JsonProperty("job-fail-reason")
	public String getJobFailReason() {
	return jobFailReason;
	}
	
	@JsonProperty("job-fail-reason")
	public void setJobFailReason(String jobFailReason) {
	this.jobFailReason = jobFailReason;
	}
	
	@JsonProperty("job-percentage")
	public int getJobPercentage() {
	return jobPercentage;
	}
	
	@JsonProperty("job-percentage")
	public void setJobPercentage(int jobPercentage) {
	this.jobPercentage = jobPercentage;
	}
	
	@JsonProperty("job-start-time")
	public String getJobStartTime() {
	return jobStartTime;
	}
	
	@JsonProperty("job-start-time")
	public void setJobStartTime(String jobStartTime) {
	this.jobStartTime = jobStartTime;
	}
	
	@JsonProperty("job-status")
	public String getJobStatus() {
	return jobStatus;
	}
	
	@JsonProperty("job-status")
	public void setJobStatus(String jobStatus) {
	this.jobStatus = jobStatus;
	}
	
	@JsonProperty("job-submittion-time")
	public String getJobSubmittionTime() {
	return jobSubmittionTime;
	}
	
	@JsonProperty("job-submittion-time")
	public void setJobSubmittionTime(String jobSubmittionTime) {
	this.jobSubmittionTime = jobSubmittionTime;
	}
	
	@JsonProperty("jobfailreason")
	public String getJobfailreason() {
	return jobfailreason;
	}
	
	@JsonProperty("jobfailreason")
	public void setJobfailreason(String jobfailreason) {
	this.jobfailreason = jobfailreason;
	}
	
	@JsonProperty("percentage")
	public int getPercentage() {
	return percentage;
	}
	
	@JsonProperty("percentage")
	public void setPercentage(int percentage) {
	this.percentage = percentage;
	}
	
	@JsonProperty("pfjstatus")
	public String getPfjstatus() {
	return pfjstatus;
	}
	
	@JsonProperty("pfjstatus")
	public void setPfjstatus(String pfjstatus) {
	this.pfjstatus = pfjstatus;
	}
	
	@JsonProperty("project")
	public String getProject() {
	return project;
	}
	
	@JsonProperty("project")
	public void setProject(String project) {
	this.project = project;
	}
	
	@JsonProperty("project-name")
	public String getProjectName() {
	return projectName;
	}
	
	@JsonProperty("project-name")
	public void setProjectName(String projectName) {
	this.projectName = projectName;
	}
	
	@JsonProperty("submittedOn")
	public String getSubmittedOn() {
	return submittedOn;
	}
	
	@JsonProperty("submittedOn")
	public void setSubmittedOn(String submittedOn) {
	this.submittedOn = submittedOn;
	}
	
	@JsonProperty("time")
	public String getTime() {
	return time;
	}
	
	@JsonProperty("time")
	public void setTime(String time) {
	this.time = time;
	}
	
	@JsonProperty("userId")
	public String getUserId() {
	return userId;
	}
	
	@JsonProperty("userId")
	public void setUserId(String userId) {
	this.userId = userId;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}