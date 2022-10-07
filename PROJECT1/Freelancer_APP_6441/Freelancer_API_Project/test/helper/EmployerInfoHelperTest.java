package helper;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.io.InterruptedIOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import wrapper.EmployeeBioData;
import wrapper.*;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

import models.RestfulService;
/*** This class is used to test EmployerInfoHelper
 * @author Geetika Rathi
 * @version 1.0
 */
public class EmployerInfoHelperTest {
	@Mock
	private RestfulService restfulService;

	 @InjectMocks private EmployerInfoHelper employerInfoHelper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	/**
     * This method is used to test EmployerProfileInfo
     */
	@Test
	public void testGetEmployerProfileInfo() throws InterruptedException, ExecutionException, JsonProcessingException,
			InterruptedIOException, IOException {
		
String jsonString = "{\n    \"status\": \"success\",\n    \"result\": {\n        \"id\": 58954485,\n        \"username\": \"appgiantLTD\",\n        \"suspended\": null,\n        \"closed\": false,\n        \"is_active\": null,\n        \"force_verify\": null,\n        \"avatar\": null,\n        \"email\": null,\n        \"reputation\": null,\n        \"jobs\": null,\n        \"profile_description\": null,\n        \"hourly_rate\": 20.0,\n        \"registration_date\": 1636203357,\n        \"limited_account\": false,\n        \"display_name\": \"App Giant\",\n        \"tagline\": null,\n        \"location\": {\n            \"country\": {\n                \"name\": \"India\",\n                \"flag_url\": null,\n                \"code\": null,\n                \"highres_flag_url\": null,\n                \"flag_url_cdn\": null,\n                \"highres_flag_url_cdn\": null,\n                \"iso3\": null,\n                \"region_id\": null,\n                \"phone_code\": null,\n                \"demonym\": null,\n                \"person\": null,\n                \"seo_url\": null,\n                \"sanction\": null,\n                \"language_code\": null,\n                \"language_id\": null\n            },\n            \"city\": \"Udumalaipettai, Tiruppur\",\n            \"latitude\": null,\n            \"longitude\": null,\n            \"vicinity\": null,\n            \"administrative_area\": null,\n            \"full_address\": null,\n            \"administrative_area_code\": null,\n            \"postal_code\": null\n        },\n        \"avatar_large\": null,\n        \"role\": \"freelancer\",\n        \"chosen_role\": \"freelancer\",\n        \"employer_reputation\": null,\n        \"status\": {\n            \"payment_verified\": null,\n            \"email_verified\": true,\n            \"deposit_made\": null,\n            \"profile_complete\": null,\n            \"phone_verified\": null,\n            \"identity_verified\": null,\n            \"facebook_connected\": null,\n            \"freelancer_verified_user\": null,\n            \"linkedin_connected\": null\n        },\n        \"avatar_cdn\": null,\n        \"avatar_large_cdn\": null,\n        \"primary_currency\": {\n            \"id\": 11,\n            \"code\": \"INR\",\n            \"sign\": \"₹\",\n            \"name\": \"Indian Rupee\",\n            \"exchange_rate\": 0.013064,\n            \"country\": \"IN\",\n            \"is_external\": null,\n            \"is_escrowcom_supported\": null\n        },\n        \"account_balances\": null,\n        \"membership_package\": null,\n        \"qualifications\": null,\n        \"badges\": null,\n        \"primary_language\": \"en\",\n        \"search_languages\": null,\n        \"cover_image\": null,\n        \"true_location\": null,\n        \"portfolio_count\": null,\n        \"preferred_freelancer\": null,\n        \"support_status\": null,\n        \"first_name\": null,\n        \"last_name\": null,\n        \"mobile_tracking\": null,\n        \"corporate\": {\n            \"status\": \"active\",\n            \"founder_id\": 60134646\n        },\n        \"public_name\": \"App Giant\",\n        \"corporate_users\": null,\n        \"is_local\": null,\n        \"address\": null,\n        \"company\": \"\",\n        \"recommendations\": null,\n        \"pool_ids\": [],\n        \"enterprise_ids\": [],\n        \"date_of_birth\": null,\n        \"escrowcom_account_linked\": true,\n        \"escrowcom_interaction_required\": false,\n        \"marketing_mobile_number\": null,\n        \"user_sanctions\": null,\n        \"freelancer_verified_status\": null,\n        \"secure_phone\": null,\n        \"directory_follow_preferences\": null,\n        \"is_payment_confirmation_required\": null,\n        \"is_nominated_payment_controlled\": null,\n        \"is_nominated_payment_share_setup_complete\": null,\n        \"spam_profile\": null,\n        \"endorsements\": null,\n        \"timezone\": {\n            \"id\": 403,\n            \"country\": \"IN\",\n            \"timezone\": \"Asia/Kolkata\",\n            \"offset\": 5.5\n        },\n        \"responsiveness\": null,\n        \"bid_quality_details\": null,\n        \"test_user\": null,\n        \"online_offline_status\": null,\n        \"deposit_methods\": null,\n        \"oauth_password_credentials_allowed\": false,\n        \"registration_completed\": true,\n        \"is_profile_visible\": true,\n        \"enterprise_metadata_values\": null,\n        \"mfa\": null,\n        \"grants\": null,\n        \"operating_areas\": null,\n        \"equipment_groups\": null\n    },\n    \"request_id\": \"979f411898870d95ba19199f44022ccf\"\n}";
		

		  
		  JsonNode js = new ObjectMapper() .readTree(jsonString);
		  when(restfulService.getEmployerInfo(any())) .thenReturn(
		  CompletableFuture.completedFuture(js)); CompletableFuture<EmployeeBioData>
		  futureUserProfileInfo = employerInfoHelper.getEmployerInfo("58954485");
		
		  verify(restfulService).getEmployerInfo("58954485");
		  
	}
	
	/**
     * This method is used to test EmployerProjectInfo
     */
	@Test
	public void testgetEmployerProjectInfo() {

			try {
			
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = "{\n    \"status\": \"success\",\n    \"result\": {\n        \"projects\": [\n            {\n                \"id\": 33140506,\n                \"owner_id\": 58954485,\n                \"title\": \"Need full time react native developer  -- 2\",\n                \"status\": \"active\",\n                \"sub_status\": null,\n                \"seo_url\": \"javascript/Need-full-time-react-native-33140506\",\n                \"currency\": {\n                    \"id\": 11,\n                    \"code\": \"INR\",\n                    \"sign\": \"₹\",\n                    \"name\": \"Indian Rupee\",\n                    \"exchange_rate\": 0.013064,\n                    \"country\": \"IN\",\n                    \"is_external\": false,\n                    \"is_escrowcom_supported\": false\n                },\n                \"description\": null,\n                \"jobs\": null,\n                \"submitdate\": 1646737780,\n                \"preview_description\": \"We are in need of a full time or part time react native developer to help with our projects. Develop\",\n                \"deleted\": false,\n                \"nonpublic\": false,\n                \"hidebids\": false,\n                \"type\": \"fixed\",\n                \"bidperiod\": 7,\n                \"budget\": {\n                    \"minimum\": 5000.0,\n                    \"maximum\": 25000.0,\n                    \"name\": null,\n                    \"project_type\": null,\n                    \"currency_id\": null\n                },\n                \"hourly_project_info\": null,\n                \"featured\": false,\n                \"urgent\": false,\n                \"assisted\": null,\n                \"active_prepaid_milestone\": null,\n                \"bid_stats\": {\n                    \"bid_count\": 13,\n                    \"bid_avg\": 22841.0\n                },\n                \"time_submitted\": 1646737780,\n                \"time_updated\": null,\n                \"upgrades\": {\n                    \"featured\": false,\n                    \"sealed\": false,\n                    \"nonpublic\": false,\n                    \"fulltime\": false,\n                    \"urgent\": false,\n                    \"qualified\": false,\n                    \"NDA\": false,\n                    \"assisted\": null,\n                    \"active_prepaid_milestone\": null,\n                    \"ip_contract\": false,\n                    \"success_bundle\": null,\n                    \"non_compete\": false,\n                    \"project_management\": false,\n                    \"pf_only\": false,\n                    \"recruiter\": null,\n                    \"listed\": null,\n                    \"extend\": null,\n                    \"unpaid_recruiter\": null\n                },\n                \"qualifications\": null,\n                \"language\": \"en\",\n                \"attachments\": null,\n                \"hireme\": false,\n                \"hireme_initial_bid\": null,\n                \"invited_freelancers\": null,\n                \"recommended_freelancers\": null,\n                \"frontend_project_status\": \"open\",\n                \"nda_signatures\": null,\n                \"location\": {\n                    \"country\": {\n                        \"name\": null,\n                        \"flag_url\": null,\n                        \"code\": null,\n                        \"highres_flag_url\": null,\n                        \"flag_url_cdn\": null,\n                        \"highres_flag_url_cdn\": null,\n                        \"iso3\": null,\n                        \"region_id\": null,\n                        \"phone_code\": null,\n                        \"demonym\": null,\n                        \"person\": null,\n                        \"seo_url\": null,\n                        \"sanction\": null,\n                        \"language_code\": null,\n                        \"language_id\": null\n                    },\n                    \"city\": null,\n                    \"latitude\": null,\n                    \"longitude\": null,\n                    \"vicinity\": null,\n                    \"administrative_area\": null,\n                    \"full_address\": null,\n                    \"administrative_area_code\": null,\n                    \"postal_code\": null\n                },\n                \"true_location\": null,\n                \"local\": false,\n                \"negotiated\": false,\n                \"negotiated_bid\": null,\n                \"time_free_bids_expire\": 1646734180,\n                \"can_post_review\": null,\n                \"files\": null,\n                \"user_distance\": null,\n                \"from_user_location\": null,\n                \"project_collaborations\": null,\n                \"support_sessions\": null,\n                \"track_ids\": null,\n                \"drive_files\": null,\n                \"nda_details\": null,\n                \"pool_ids\": [\n                    \"freelancer\"\n                ],\n                \"enterprise_ids\": [],\n                \"timeframe\": null,\n                \"deloitte_details\": null,\n                \"is_escrow_project\": false,\n                \"is_seller_kyc_required\": false,\n                \"is_buyer_kyc_required\": false,\n                \"local_details\": null,\n                \"equipment\": null,\n                \"nda_signatures_new\": null,\n                \"billing_code\": null,\n                \"enterprise_metadata_values\": null,\n                \"project_reject_reason\": {\n                    \"description\": null,\n                    \"message\": null\n                },\n                \"repost_id\": null,\n                \"client_engagement\": null,\n                \"contract_signatures\": null,\n                \"quotation_id\": null,\n                \"quotation_version_id\": null,\n                \"enterprise_linked_projects_details\": null,\n                \"equipment_groups\": null,\n                \"project_source\": null,\n                \"project_source_reference\": null\n            },\n            {\n                \"id\": 33127568,\n                \"owner_id\": 58954485,\n                \"title\": \"Need full time react native developer \",\n                \"status\": \"frozen\",\n                \"sub_status\": \"frozen_timeout\",\n                \"seo_url\": \"javascript/Need-full-time-react-native-33127568\",\n                \"currency\": {\n                    \"id\": 11,\n                    \"code\": \"INR\",\n                    \"sign\": \"₹\",\n                    \"name\": \"Indian Rupee\",\n                    \"exchange_rate\": 0.013064,\n                    \"country\": \"IN\",\n                    \"is_external\": false,\n                    \"is_escrowcom_supported\": false\n                },\n                \"description\": null,\n                \"jobs\": null,\n                \"submitdate\": 1646633569,\n                \"preview_description\": \"We are in need of a full time or part time react native developer to help with our projects. Develop\",\n                \"deleted\": false,\n                \"nonpublic\": false,\n                \"hidebids\": false,\n                \"type\": \"fixed\",\n                \"bidperiod\": 7,\n                \"budget\": {\n                    \"minimum\": 12500.0,\n                    \"maximum\": 37500.0,\n                    \"name\": null,\n                    \"project_type\": null,\n                    \"currency_id\": null\n                },\n                \"hourly_project_info\": null,\n                \"featured\": false,\n                \"urgent\": false,\n                \"assisted\": null,\n                \"active_prepaid_milestone\": null,\n                \"bid_stats\": {\n                    \"bid_count\": 10,\n                    \"bid_avg\": 33499.9\n                },\n                \"time_submitted\": 1646633569,\n                \"time_updated\": null,\n                \"upgrades\": {\n                    \"featured\": false,\n                    \"sealed\": false,\n                    \"nonpublic\": false,\n                    \"fulltime\": false,\n                    \"urgent\": false,\n                    \"qualified\": false,\n                    \"NDA\": false,\n                    \"assisted\": null,\n                    \"active_prepaid_milestone\": null,\n                    \"ip_contract\": false,\n                    \"success_bundle\": null,\n                    \"non_compete\": false,\n                    \"project_management\": false,\n                    \"pf_only\": false,\n                    \"recruiter\": null,\n                    \"listed\": null,\n                    \"extend\": null,\n                    \"unpaid_recruiter\": null\n                },\n                \"qualifications\": null,\n                \"language\": \"en\",\n                \"attachments\": null,\n                \"hireme\": false,\n                \"hireme_initial_bid\": null,\n                \"invited_freelancers\": null,\n                \"recommended_freelancers\": null,\n                \"frontend_project_status\": \"open\",\n                \"nda_signatures\": null,\n                \"location\": {\n                    \"country\": {\n                        \"name\": null,\n                        \"flag_url\": null,\n                        \"code\": null,\n                        \"highres_flag_url\": null,\n                        \"flag_url_cdn\": null,\n                        \"highres_flag_url_cdn\": null,\n                        \"iso3\": null,\n                        \"region_id\": null,\n                        \"phone_code\": null,\n                        \"demonym\": null,\n                        \"person\": null,\n                        \"seo_url\": null,\n                        \"sanction\": null,\n                        \"language_code\": null,\n                        \"language_id\": null\n                    },\n                    \"city\": null,\n                    \"latitude\": null,\n                    \"longitude\": null,\n                    \"vicinity\": null,\n                    \"administrative_area\": null,\n                    \"full_address\": null,\n                    \"administrative_area_code\": null,\n                    \"postal_code\": null\n                },\n                \"true_location\": null,\n                \"local\": false,\n                \"negotiated\": false,\n                \"negotiated_bid\": null,\n                \"time_free_bids_expire\": 1646629969,\n                \"can_post_review\": null,\n                \"files\": null,\n                \"user_distance\": null,\n                \"from_user_location\": null,\n                \"project_collaborations\": null,\n                \"support_sessions\": null,\n                \"track_ids\": null,\n                \"drive_files\": null,\n                \"nda_details\": null,\n                \"pool_ids\": [\n                    \"freelancer\"\n                ],\n                \"enterprise_ids\": [],\n                \"timeframe\": null,\n                \"deloitte_details\": null,\n                \"is_escrow_project\": false,\n                \"is_seller_kyc_required\": false,\n                \"is_buyer_kyc_required\": false,\n                \"local_details\": null,\n                \"equipment\": null,\n                \"nda_signatures_new\": null,\n                \"billing_code\": null,\n                \"enterprise_metadata_values\": null,\n                \"project_reject_reason\": {\n                    \"description\": null,\n                    \"message\": null\n                },\n                \"repost_id\": null,\n                \"client_engagement\": null,\n                \"contract_signatures\": null,\n                \"quotation_id\": null,\n                \"quotation_version_id\": null,\n                \"enterprise_linked_projects_details\": null,\n                \"equipment_groups\": null,\n                \"project_source\": null,\n                \"project_source_reference\": null\n            },\n            {\n                \"id\": 33120434,\n                \"owner_id\": 58954485,\n                \"title\": \"Need full time react native freelancer \",\n                \"status\": \"closed\",\n                \"sub_status\": \"closed_awarded\",\n                \"seo_url\": \"javascript/Need-full-time-react-native-33120434\",\n                \"currency\": {\n                    \"id\": 11,\n                    \"code\": \"INR\",\n                    \"sign\": \"₹\",\n                    \"name\": \"Indian Rupee\",\n                    \"exchange_rate\": 0.013064,\n                    \"country\": \"IN\",\n                    \"is_external\": false,\n                    \"is_escrowcom_supported\": false\n                },\n                \"description\": null,\n                \"jobs\": null,\n                \"submitdate\": 1646563761,\n                \"preview_description\": \"We are in need of a full time or part time react native developer to help with our projects. Develop\",\n                \"deleted\": false,\n                \"nonpublic\": false,\n                \"hidebids\": false,\n                \"type\": \"fixed\",\n                \"bidperiod\": 7,\n                \"budget\": {\n                    \"minimum\": 5000.0,\n                    \"maximum\": 37500.0,\n                    \"name\": null,\n                    \"project_type\": null,\n                    \"currency_id\": null\n                },\n                \"hourly_project_info\": null,\n                \"featured\": false,\n                \"urgent\": false,\n                \"assisted\": null,\n                \"active_prepaid_milestone\": null,\n                \"bid_stats\": {\n                    \"bid_count\": 6,\n                    \"bid_avg\": 26506.333333333332\n                },\n                \"time_submitted\": 1646563761,\n                \"time_updated\": null,\n                \"upgrades\": {\n                    \"featured\": false,\n                    \"sealed\": false,\n                    \"nonpublic\": false,\n                    \"fulltime\": false,\n                    \"urgent\": false,\n                    \"qualified\": false,\n                    \"NDA\": false,\n                    \"assisted\": null,\n                    \"active_prepaid_milestone\": null,\n                    \"ip_contract\": false,\n                    \"success_bundle\": null,\n                    \"non_compete\": false,\n                    \"project_management\": false,\n                    \"pf_only\": false,\n                    \"recruiter\": null,\n                    \"listed\": null,\n                    \"extend\": null,\n                    \"unpaid_recruiter\": null\n                },\n                \"qualifications\": null,\n                \"language\": \"en\",\n                \"attachments\": null,\n                \"hireme\": false,\n                \"hireme_initial_bid\": null,\n                \"invited_freelancers\": null,\n                \"recommended_freelancers\": null,\n                \"frontend_project_status\": \"work_in_progress\",\n                \"nda_signatures\": null,\n                \"location\": {\n                    \"country\": {\n                        \"name\": null,\n                        \"flag_url\": null,\n                        \"code\": null,\n                        \"highres_flag_url\": null,\n                        \"flag_url_cdn\": null,\n                        \"highres_flag_url_cdn\": null,\n                        \"iso3\": null,\n                        \"region_id\": null,\n                        \"phone_code\": null,\n                        \"demonym\": null,\n                        \"person\": null,\n                        \"seo_url\": null,\n                        \"sanction\": null,\n                        \"language_code\": null,\n                        \"language_id\": null\n                    },\n                    \"city\": null,\n                    \"latitude\": null,\n                    \"longitude\": null,\n                    \"vicinity\": null,\n                    \"administrative_area\": null,\n                    \"full_address\": null,\n                    \"administrative_area_code\": null,\n                    \"postal_code\": null\n                },\n                \"true_location\": null,\n                \"local\": false,\n                \"negotiated\": false,\n                \"negotiated_bid\": null,\n                \"time_free_bids_expire\": 1646560161,\n                \"can_post_review\": null,\n                \"files\": null,\n                \"user_distance\": null,\n                \"from_user_location\": null,\n                \"project_collaborations\": null,\n                \"support_sessions\": null,\n                \"track_ids\": null,\n                \"drive_files\": null,\n                \"nda_details\": null,\n                \"pool_ids\": [\n                    \"freelancer\"\n                ],\n                \"enterprise_ids\": [],\n                \"timeframe\": null,\n                \"deloitte_details\": null,\n                \"is_escrow_project\": false,\n                \"is_seller_kyc_required\": false,\n                \"is_buyer_kyc_required\": false,\n                \"local_details\": null,\n                \"equipment\": null,\n                \"nda_signatures_new\": null,\n                \"billing_code\": null,\n                \"enterprise_metadata_values\": null,\n                \"project_reject_reason\": {\n                    \"description\": null,\n                    \"message\": null\n                },\n                \"repost_id\": null,\n                \"client_engagement\": null,\n                \"contract_signatures\": null,\n                \"quotation_id\": null,\n                \"quotation_version_id\": null,\n                \"enterprise_linked_projects_details\": null,\n                \"equipment_groups\": null,\n                \"project_source\": null,\n                \"project_source_reference\": null\n            }\n        ],\n        \"users\": null,\n        \"selected_bids\": null,\n        \"total_count\": null\n    },\n    \"request_id\": \"278e01e66f6e10f47271911d8308feeb\"\n}";
				JsonNode js = new ObjectMapper()
						.readTree(jsonString);
				when(restfulService.getEmployerProjectInfo(any()))
						.thenReturn(
								CompletableFuture.completedFuture(js));
				CompletableFuture<ProjectEmployeeInfo> futureProjectInfo = employerInfoHelper.getEmployerProjectInfo("58954485");
				verify(restfulService).getEmployerProjectInfo("58954485");


			} catch (Exception ex) {
				System.out.println("Exception occured : " + ex.getStackTrace().toString());
			}


		}

}