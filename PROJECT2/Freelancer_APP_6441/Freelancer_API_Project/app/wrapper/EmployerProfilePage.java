package wrapper;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/***This class is the POJO class for Employer Page
 * @author Geetika Rathi
 * @version 1.0
 */
public class EmployerProfilePage {
	public EmployeeBioData employerProfileInfo;
	public ProjectEmployeeInfo employerProjectInfo;
	public EmployeeBioData getEmployerProfileInfo() {
		return employerProfileInfo;
	}
	public void setEmployerProfileInfo(EmployeeBioData employerProfileInfo) {
		employerProfileInfo.result.registration_date = new SimpleDateFormat("MMMM d, yyyy")
                .format(new Date(Integer.parseInt(employerProfileInfo.result.registration_date) * 1000L));
		this.employerProfileInfo = employerProfileInfo;
	}
	public ProjectEmployeeInfo getEmployerProjectInfo() {
		return employerProjectInfo;
	}
	public void setEmployerProjectInfo(ProjectEmployeeInfo employerProjectInfo) {
		
		  Arrays.asList(employerProjectInfo.result.projects).stream().forEach(pr1 ->{
		  pr1.time_submitted = new SimpleDateFormat("MMMM d, yyyy")
                  .format(new Date(Integer.parseInt(pr1.time_submitted) * 1000L));
		 });   
		this.employerProjectInfo = employerProjectInfo;
	}
	
	
}
