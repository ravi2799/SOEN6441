package wrapper;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import helper.SearchHelper;

/**
 * @author Arvind Sangwan, Raviraj Savaliya, Shaurya Ahuja, Geetika 
 * @version 1.0
 */

public class ProjectResults {
    public ArrayList<Project> projects = new ArrayList<>();
    public int total_count;
    public int projectsSize;
    public ArrayList<String> keyword = new ArrayList<>();
    public double avgFindex;
    public double avgFkglIndex;

    public double getAvgFindex() {
        return avgFindex;
    }

    public void setAvgFindex(double avgFindex) {
        this.avgFindex = avgFindex;
    }

    public double getAvgFkglIndex() {
        return avgFkglIndex;
    }

    public void setAvgFkglIndex(double avgFkglIndex) {
        this.avgFkglIndex = avgFkglIndex;
    }

    public ArrayList<String> getKeyword() {
        return this.keyword;
    }

    public void setKeyword(ArrayList<String> keyword) {
        this.keyword = keyword;
    }

    public int getProjectsSize() {
        return this.projects.size();
    }

    public void setProjectsSize(int projectsSize) {
        this.projectsSize = projectsSize;
    }

    public ArrayList<Project> getProjects() {
        return this.projects;
    }

    /**
     * This method sets the list of project for a certain keyword
     * 
     * @param projects list of projects
     * @param Keyword searched keyword
     */
    public void setProjects(ArrayList<Project> projects, String keyword) {
        this.projects = new ArrayList<>();
        projects.stream().forEach(project -> {
            double fIndex = (int) SearchHelper.getFindex(project.preview_description);
            project.educationalStatus = SearchHelper.educationalLevelMapper(fIndex);
            project.time_submitted = new SimpleDateFormat("MMMM d, yyyy")
                    .format(new Date(Integer.parseInt(project.time_submitted) * 1000L));
            project.fkglIndex = (int) SearchHelper.getFKglIndex(project.preview_description);
            project.fIndex = fIndex;
            this.avgFindex += project.fIndex;
            this.avgFkglIndex += project.fkglIndex;
            this.projects.add(project);
        });
        this.avgFindex = this.avgFindex / projects.size();
        this.avgFkglIndex = this.avgFkglIndex / projects.size();
        this.keyword.add(keyword);
    }

    public int getTotal_count() {
        return this.total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

}
