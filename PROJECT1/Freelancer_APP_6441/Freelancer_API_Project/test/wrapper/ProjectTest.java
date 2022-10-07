package wrapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
/**
 * @author Arvind Sangwan, Raviraj Savaliya
 * @version 1.0
 */
public class ProjectTest {
	/**
	 * This method test the getter setter methods of Project class.
	 */
	@Test
	public void test() {
		
		Project p = new Project();
		p.setId(8);
		assertEquals(8, p.getId());	
		
		p.setOwner_id(123);
		assertEquals(123, p.getOwner_id());
		
		p.setTitle("hel");
		assertEquals("hel" , p.getTitle());
		
		p.setTime_submitted("20220222");
		assertEquals("20220222" ,p.getTime_submitted());
		
		p.setProject_type("Fixed");
		assertEquals("Fixed" , p.getProject_type());
		
		p.setPreview_description("hello new java client");
		assertEquals("hello new java client",p.getPreview_description());
		
		p.setFkglIndex(0.01d);
		assertEquals(0.01d ,  p.getFkglIndex() , 0.01d);
		
		
		//jobs and educational status is pending
		p.setFIndex(203311);
		assertEquals(203311 , p.getFIndex() , 121212);
		
		p.setSeo_url("http://a/");
		assertEquals("http://a/" , p.getSeo_url());
		
		p.setEducationalStatus("I am looking for someone who ");
		assertNotEquals("College Graduate", p.getEducationalStatus());
		
		Skill skill  = new Skill();
	    ArrayList<Skill> inventory1 = new ArrayList<Skill>();
	    
	    p.setSkills(inventory1);
	    assertNotEquals(skill , p.getSkills() );
		
	}

}
