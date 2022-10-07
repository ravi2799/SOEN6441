package helper;

import javax.inject.*;
import play.libs.ws.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.RestfulService;
import helper.SearchHelper;
import wrapper.ProjectInfoWrapper;
import wrapper.ProjectResults;
import wrapper.Project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

// import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Arvind Sangwan, Shaurya Ahuja, Raviraj Savaliya
 * @version 1.0
 */

public class SearchHelper {
    ProjectResults projectResults;
    RestfulService restfulService;
    private ObjectMapper mapper;
    static StringBuilder globalPreviewDesc = new StringBuilder();

    @Inject
    public SearchHelper(
            RestfulService restfulService, ProjectResults projectResults) {
        this.projectResults = projectResults;
        this.restfulService = restfulService;
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * This method return the list of projects on basis of searched keyword id
     * 
     * @param searchKeyWord,projectDataMap searched keyword and hashmap
     * @return list of projects on basis of searchKeyWord
     */
    public CompletableFuture<List<Project>> searchProject(String searchKeyWord,
            HashMap<String, List<Project>> projectDataMap) {

        return restfulService.searchProjectKeyword(searchKeyWord).thenApplyAsync(
                json -> {
                    ProjectInfoWrapper projectInfo = new ProjectInfoWrapper();
                    try {
                        projectInfo = mapper.convertValue(json, new TypeReference<ProjectInfoWrapper>() {
                        });

                        // projectInfo.time_submitted = new
                        // SimpleDateFormat(projectInfo.time_submitted);
                    } catch (Exception ex) {
                        System.out.println("Parsing json Failure !!!!!!   - Exception :" + ex);
                    }
                    if (this.projectResults.getProjectsSize() < 100 && projectInfo.result != null)
                        this.projectResults.setProjects(projectInfo.result.projects, searchKeyWord);
                    projectDataMap.put(searchKeyWord, this.projectResults.getProjects());
                    return this.projectResults.getProjects();
                });
    }

    /**
     * This method return the list of projects on basis of skill id
     * 
     * @param skillsName,skillsID,projectDataMap name of skill,skill id and hashmap
     * @return list of projects on basis of preview_description
     */

    public CompletableFuture<List<Project>> searchProjectsBySkills(String skillsName, String skillsID,
            HashMap<String, List<Project>> projectDataMap) {
        return restfulService.getProjectsBySkills(skillsID).thenApplyAsync(
                json -> {
                    ProjectInfoWrapper projectInfo = new ProjectInfoWrapper();
                    try {
                        projectInfo = mapper.convertValue(json, new TypeReference<ProjectInfoWrapper>() {
                        });
                    } catch (Exception ex) {
                        System.out.println("Parsing json Failure !!!!!!   - Exception :" + ex);
                    }
                    if (this.projectResults.getProjectsSize() < 100 && projectInfo.result != null)
                        this.projectResults.setProjects(projectInfo.result.projects, skillsName);
                    projectDataMap.put(skillsName, this.projectResults.getProjects());
                    return this.projectResults.getProjects();
                });
    }

    /**
     * This method return the syllables count present in the preview_description of
     * project
     * 
     * @param preview_description to decide the fIndex
     * @return syllables on basis of preview_description
     */

    public static double getSyllables(String preview_description) {
        Pattern pattern = Pattern.compile("[aeiouy]+[^$e(,.:;!?)]");
        Matcher matcher = pattern.matcher(preview_description);
        int syllableCounter = 0;
        while (matcher.find()) {
            syllableCounter++;
        }
        return syllableCounter;
    }

    /**
     * This method return the appropriate fkgl level on basis of preview_description
     * of project
     * 
     * @param preview_description to decide the fkgl index
     * @return fkgl on basis of preview_description
     */

    public static double getSentences(String preview_description) {
        double sentences = 0;
        String[] sentenceList = preview_description.split("[!?.:]+");
        sentences = sentences + sentenceList.length;
        return sentences;
    }
    
    /**
     * This method return the word count on basis of preview_description
     * of project
     * 
     * @param preview_description to decide the fkgl index
     * @return wordCount on basis of preview_description
     */
    public static double getWords(String preview_description) {
        double wordCounter = 0;
        for (int i = 0; i < preview_description.length(); i++) {
            if (((i > 0) && (preview_description.charAt(i) != ' ') && (preview_description.charAt(i - 1) == ' '))
                    || ((preview_description.charAt(0) != ' ') && (i == 0)))
                wordCounter++;
        }
        return wordCounter;
    }

    /**
     * This method return the appropriate fIndex level on basis of
     * preview_description of project
     * 
     * @param preview_description to decide the fIndex
     * @return fIndex on basis of preview_description
     */

    public static double getFindex(String preview_description) {
        double words = getWords(preview_description);
        double syllables = getSyllables(preview_description);
        double sentences = getSentences(preview_description);

        if (preview_description == "" || words == 0) {
            return 999;
        }
        return 206.835 - 84.6 * (syllables / words) - 1.015 * (words / sentences);
    }

    /**
     * This method return the appropriate fkgl level on basis of
     * preview_description of project
     * 
     * @param preview_description to decide the fIndex
     * @return fIndex on basis of preview_description
     */
    public static double getFKglIndex(String preview_description) {
        double words = getWords(preview_description);
        double syllables = getSyllables(preview_description);
        double sentences = getSentences(preview_description);
        if (preview_description == "" || words == 0) {
            return 999;
        }
        return 0.39 * (words / sentences) + 11.8 * (syllables / words);
    }

    /**
     * This method return the appropriate education level on basis of fIndex
     * 
     * @param fIndex to decide the education level
     * @return string on basis of fIndex
     */

    public static String educationalLevelMapper(double fIndex) {
        if (fIndex <= 0)
            return "Law School Graduate";
        else if (fIndex <= 30 && fIndex > 0)
            return "College Graduate";
        else if (fIndex <= 51 && fIndex > 31)
            return "Some College";
        else if (fIndex <= 61 && fIndex > 51)
            return "High School";
        else if (fIndex <= 66 && fIndex > 61)
            return "9th Grade";
        else if (fIndex <= 71 && fIndex > 66)
            return "8th Grade";
        else if (fIndex <= 81 && fIndex > 71)
            return "7th Grade";
        else if (fIndex <= 91 && fIndex > 81)
            return "6th Grade";
        else if (fIndex <= 100 && fIndex > 91)
            return "5th Grade";
        return "Early";
    }

    /**
     * This method return the string of preview_description of global data
     * @author Raviraj Savaliya
     * @param projectDataMap List of project
     * @return string containing the info of preview description
     */
    public static String get_GlobalPreviewDesc(List<Project> projectDataMap) {
        if (projectDataMap != null) {
            String globalPreviewDesc1 = projectDataMap.stream()
                    .map(Project::getPreview_description)
                    .collect(Collectors.joining("\n"));
            globalPreviewDesc = globalPreviewDesc.append(globalPreviewDesc1);
            System.out.println("Inside search :" + globalPreviewDesc);
            return globalPreviewDesc.toString();
        }
        return "";

    }

    /**
     * This method returns the string of preview_description of local data
     * @author Raviraj Savaliya
     * @param projects - List of project
     * @param projectId - Id of the projects
     * @return string containing the info of preview description for local data
     */
    public static String getLocalPreviewDesc(List<Project> projects, int projectId) {
        if (projects != null) {
            return projects.stream()
                    .filter(e -> (e.id) == (projectId))
                    .map(pm -> pm.preview_description)
                    .collect(Collectors.joining("\n"));
        }
        return "";

    }

    /**
     * This is the getter method for string builder
     * @return global preview description
     */
    public static StringBuilder getGlobalPreviewDesc() {
        return globalPreviewDesc;
    }
    
    /**
     * This is the setter method for string builder
     */
    public static void setGlobalPreviewDesc(StringBuilder globalPreviewDesc) {
        SearchHelper.globalPreviewDesc = globalPreviewDesc;
    }

    public List<Project> transformDuplicaceResults(List<Project> response, String keyWord,
                        HashMap<String, List<Project>> cacheData) {
                List<Project> searchedProjects = cacheData.get(keyWord);
                System.out.print("Searched Project" + searchedProjects);
                List<Project> latestProjects = new ArrayList<>();

                latestProjects = response.stream().filter(
                                project -> searchedProjects.stream().allMatch(project1 -> project1.id != project.id))
                                .collect(Collectors.toList());
                return latestProjects;
        }

}
