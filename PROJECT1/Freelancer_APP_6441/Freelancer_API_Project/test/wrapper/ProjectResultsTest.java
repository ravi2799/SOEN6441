package wrapper;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ProjectResultsTest {

/**
 * @author Raviraj Savaliya
 * @version 1.0
 */

	@Test
	public void test() {
		
		
		ProjectResults pr = new ProjectResults();
		pr.setAvgFindex(20.1020d);
		assertEquals(10.1020d , pr.getAvgFindex() , 10.100d);
		
		pr.setAvgFkglIndex(10.20d);
		assertEquals(10.20d, pr.getAvgFkglIndex() , 10.20d);
		
		ArrayList<String> key = new ArrayList<String>();
		key.add("java");
		pr.setKeyword(key);
		assertEquals(key , pr.getKeyword() ); 
		
		pr.setProjectsSize(100);
		assertTrue(pr.getProjectsSize() < 100); 
		
		pr.setTotal_count(10);
		assertEquals(10 ,pr.getTotal_count()); 
		
		//pr.setProjects(null , null);
		//assertTrue(pr.getProjects() == null);
		//ArrayList<Project> pro = new ArrayList<>();
				
	}

}
