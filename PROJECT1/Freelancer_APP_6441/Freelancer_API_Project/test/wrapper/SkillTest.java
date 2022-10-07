package wrapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
/**
 * @author Arvind Sangwan
 * @version 1.0
 */
public class SkillTest {

	/**
     * This is a unit test method for the getId and getName method of skills class
     * 
     */
	@Test
	public void testSkill() {
		System.out.println("Printing inside idTest=------------------------");
		Skill obj = new Skill();
		obj.setId(8);
		obj.setName("React");
		assertEquals(8, obj.getId());
		assertEquals("React", obj.getName());
	}

}
