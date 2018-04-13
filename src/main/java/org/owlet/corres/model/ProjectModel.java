package org.owlet.corres.model;

import java.io.Serializable;

public class ProjectModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String projectName;
	private String repoPath;
	
	protected ProjectModel() {
		
	}

	public ProjectModel(String projectName, String repoPath) {
		this.projectName = projectName;
		this.repoPath = repoPath;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRepoPath() {
		return repoPath;
	}

	public void setRepoPath(String repoPath) {
		this.repoPath = repoPath;
	}
	
	@Override
	public String toString() {
		return String.format("[projectName='%s', repoPath='%s']", projectName, repoPath);
	}
}
