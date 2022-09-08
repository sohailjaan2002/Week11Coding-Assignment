package projects.service;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();

//	public static Project addProject(Project project) {
//		
//		return null;
//	}
//	
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}

	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();

	}

	public Project fetchProjectById(int projectId) {
		return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException(
				"Project with project ID =" + projectId + " project ID does not exist."));
	}

	public void modifyProjectDetails(Project project) {
		if(!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID= " + project.getProjectId() + " does not exist." );
		}
		
	}

	public void deleteProject(Integer projectID) {
		if(!projectDao.deleteProject(projectID)) {
			throw new DbException("Project with ID= " + projectID + " does not exist.");
		}

}
}
	