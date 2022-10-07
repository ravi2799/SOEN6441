package wrapper;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * This class is the wrapper class for employer information
 * @author Geetika Rathi
 * @version 1.0
 */
public class EmployeeBioData {
	
		public String status;	//success
		public cls_result result;
		public String request_id;	//bd270a0729af183596f53720f5332cdc
	public static class cls_result {
			public Integer id;	//58954485
			public String username;	//appgiantLTD
			public boolean closed;
			public Integer hourly_rate;	//20
			public String registration_date;	//1636203357
	    	public boolean limited_account;
			public String display_name;	//App Giant
			public cls_location location;
			public String role;	//freelancer
			public String chosen_role;	//freelancer
			public cls_status status;
			public cls_primary_currency primary_currency;
			public String public_name;	//App Giant
			public String company;	
			public boolean escrowcom_account_linked;
			public boolean escrowcom_interaction_required;
			public boolean oauth_password_credentials_allowed;
			public boolean registration_completed;
			public boolean is_profile_visible;
		}
	public static class cls_location {
		public cls_country country;
		
	}
	public static class cls_country {
		public String name;	//India
	}
	public static class cls_status {
		public boolean email_verified;
	}
	
	public static class cls_primary_currency {
		public String name;	//Indian Rupee
	}
		
	}

