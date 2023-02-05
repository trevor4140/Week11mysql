package project.service;
import project.entity.Project;
import project.exception.DbException;

import java.util.List;
import java.util.NoSuchElementException;

import project.dao.ProjectDao;

public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}
	public List<Project> fetchAllProject() {
		return projectDao.fetchAllProject();
	}
	public Project fetchProjectById(Integer projectId) {
	return  projectDao.fetchProjectById(projectId).orElseThrow(
			() -> new NoSuchElementException(
			"Project with project ID=" +  projectId  + " does not exist."));
	}
	public void modifyProjectDetails(Project project) {
		if(!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID =" 
					+ project.getProjectId() + "does not exist");	
			
		}
	}
	public void deleteProject(Integer projectId) {
		if(!projectDao.deleteProject(projectId)) {
			throw new DbException("Project" + projectId + "does not exist.");
		}
		
	}
	
		
		
	
}
