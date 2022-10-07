package wrapper;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Arvind Sangwan
 * @version 1.0
 */

public class ProjectsInfoListTest {

	@Test
	public void test() {
		ProjectsInfoList pil = new ProjectsInfoList();
	}

	@Test
	public void infoListTest() {
		List<ProjectInfoWrapper> projectsList = new ArrayList<>();
		projectsList.add(new ProjectInfoWrapper());
		ProjectsInfoList infoList = new ProjectsInfoList(projectsList);
	}

	@Test
	public void getProjectsListTest() {
		ProjectsInfoList pil = new ProjectsInfoList();
		List<ProjectInfoWrapper> projectsList = new ArrayList<>();
		projectsList.add(new ProjectInfoWrapper());
		ProjectsInfoList infoList = new ProjectsInfoList(projectsList);
		pil.setProjectsList(projectsList);
		assertEquals(1, infoList.getProjectsList().size());
	}

}
