package wrapper;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Raviraj Savaliya, Arvind Sangwan
 * @version 1.0
 */

public class ProjectInfoWrapperTest {

	@Test
	public void test() {
		// fail("Not yet implemented");
		ProjectInfoWrapper piw = new ProjectInfoWrapper();

		piw.setRequest_id("try1");
		assertEquals("try1", piw.getRequest_id());

		piw.setStatus("Success");
		assertEquals("Success", piw.getStatus());

		ProjectResults resultObj = new ProjectResults();
		piw.setResult(resultObj);

		ProjectResults resultObject = piw.getResult();
		resultObject.setTotal_count(3);
		assertEquals(3, resultObject.getTotal_count());
	}

}
