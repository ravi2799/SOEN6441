package wrapper;
/***This class is the wrapper class for Employer's Projects information
 * @author Geetika Rathi
 * @version 1.0
 */
public class ProjectEmployeeInfo {
	public String status; // success
	public cls_result result;
	public String request_id; // 7e0f2ca067ccc2d752b3c8012afd97db

	public static class cls_result {
    public cls_projects[] projects;
	}

	public static class cls_projects {
		public Integer id; // 33140506
		public Integer owner_id; // 58954485
		public String title; // Need full time react native developer -- 2
		public String status; // active
		public String seo_url; // javascript/Need-full-time-react-native-33140506
		public cls_currency currency;
		public Integer submitdate; // 1646737780
		public String preview_description; // We are in need of a full time or part time react native developer to help
											// with our projects. Develop
		public boolean deleted;
		public boolean nonpublic;
		public boolean hidebids;
		public String type; // fixed
		public Integer bidperiod; // 7
		public cls_budget budget;
		public boolean featured;
		public boolean urgent;
		public cls_bid_stats bid_stats;
		public String time_submitted; // 1646737780
		public cls_upgrades upgrades;
		public String language; // en
		public boolean hireme;
		public String frontend_project_status; // open
		public boolean local;
		public boolean negotiated;
		public Integer time_free_bids_expire; // 1646734180
		public boolean is_escrow_project;
		public boolean is_seller_kyc_required;
		public boolean is_buyer_kyc_required;
	}

	public static class cls_currency {
		public Integer id; // 11
		public String code; // INR
		public String sign; // ₹
		public String name; // Indian Rupee
		public Double exchange_rate; // 0.013002
		public String country; // IN
		public boolean is_external;
		public boolean is_escrowcom_supported;
	}


	public static class cls_budget {
		public Integer minimum; // 5000
		public Integer maximum; // 25000
	}


	public static class cls_bid_stats {
		public Integer bid_count; // 10
		public Double bid_avg; // 23193.3
	}


	public static class cls_upgrades {
		public boolean featured;
		public boolean sealed;
		public boolean nonpublic;
		public boolean fulltime;
		public boolean urgent;
		public boolean qualified;
		public boolean NDA;
		public boolean ip_contract;
		public boolean non_compete;
		public boolean project_management;
		public boolean pf_only;
	}
}




