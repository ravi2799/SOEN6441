package wrapper;

import java.util.List;

/**
 * @author Arvind Sangwan
 * @version 1.0
 */
public class ProjectsInfoList {

    public List<ProjectInfoWrapper> projectsList;

    public ProjectsInfoList() {

    }

    public ProjectsInfoList(List<ProjectInfoWrapper> projectsList) {
        this.projectsList = projectsList;
    }

    /**
     * This method return the list of wrapper ProjectInfoWrapper
     */

    public List<ProjectInfoWrapper> getProjectsList() {
        return this.projectsList;
    }

    /**
     * This method saves the project list
     * 
     * @param projectsList list of projects
     */
    public void setProjectsList(List<ProjectInfoWrapper> projectsList) {
        this.projectsList = projectsList;
    }

}
