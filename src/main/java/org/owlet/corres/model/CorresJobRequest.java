package org.owlet.corres.model;

public class CorresJobRequest {
	private String projectName;
	private String type;
	private String clientApp;
	private String searchPaths;
	private String siteId;
	private String repoPath;
	private String dataFileContent;
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClientApp() {
		return clientApp;
	}
	public void setClientApp(String clientApp) {
		this.clientApp = clientApp;
	}
	public String getSearchPaths() {
		return searchPaths;
	}
	public void setSearchPaths(String searchPaths) {
		this.searchPaths = searchPaths;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getRepoPath() {
		return repoPath;
	}
	public void setRepoPath(String repoPath) {
		this.repoPath = repoPath;
	}
	public String getDataFileContent() {
		return dataFileContent;
	}
	public void setDataFileContent(String dataFileContent) {
		this.dataFileContent = dataFileContent;
	}

}
