// package helper;

// import org.mockito.Mock;
// import scala.compat.java8.FutureConverters;
// import static akka.pattern.Patterns.ask;

// import org.junit.Test;
// import play.libs.ws.*;
// import akka.actor.*;
// import akka.testkit.javadsl.TestKit;

// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import static org.hamcrest.CoreMatchers.*;

// import java.io.IOException;
// import java.io.InterruptedIOException;
// import java.util.List;
// import java.util.concurrent.*;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// import wrapper.*;

// import java.util.Map;

// import org.mockito.*;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.*;

// import org.junit.Before;

// import models.RestfulService;

// public class EmployerInfoHelperV2Test {
// @Mock
// private WSClient ws;
// @Mock
// private RestfulService restfulService;
// @Mock
// static ActorSystem systemMock;

// @Before
// public void setup() {
// MockitoAnnotations.initMocks(this);

// }

// @Test
// public void testGetEmployerProfileInfo() throws InterruptedException,
// ExecutionException, JsonProcessingException,
// InterruptedIOException, IOException {
// systemMock = ActorSystem.create();
// new TestKit(systemMock) {{

// final ActorRef tar = systemMock.actorOf(EmployerInfoHelperV2.props(ws));
// WSRequest wsR2 = mock(WSRequest.class);
// WSResponse wsResponse2 = mock(WSResponse.class);
// when(ws.url("https://www.freelancer.com/api/users/0.1/users/")).thenReturn(
// wsR2
// );
// when(wsR2.addHeader(any(), any())).thenReturn(wsR2);

// String jsonString = "{\n \"status\": \"success\",\n \"result\": {\n \"id\":
// 58954485,\n \"username\": \"appgiantLTD\",\n \"suspended\": null,\n
// \"closed\": false,\n \"is_active\": null,\n \"force_verify\": null,\n
// \"avatar\": null,\n \"email\": null,\n \"reputation\": null,\n \"jobs\":
// null,\n \"profile_description\": null,\n \"hourly_rate\": 20.0,\n
// \"registration_date\": 1636203357,\n \"limited_account\": false,\n
// \"display_name\": \"App Giant\",\n \"tagline\": null,\n \"location\": {\n
// \"country\": {\n \"name\": \"India\",\n \"flag_url\": null,\n \"code\":
// null,\n \"highres_flag_url\": null,\n \"flag_url_cdn\": null,\n
// \"highres_flag_url_cdn\": null,\n \"iso3\": null,\n \"region_id\": null,\n
// \"phone_code\": null,\n \"demonym\": null,\n \"person\": null,\n \"seo_url\":
// null,\n \"sanction\": null,\n \"language_code\": null,\n \"language_id\":
// null\n },\n \"city\": \"Udumalaipettai, Tiruppur\",\n \"latitude\": null,\n
// \"longitude\": null,\n \"vicinity\": null,\n \"administrative_area\": null,\n
// \"full_address\": null,\n \"administrative_area_code\": null,\n
// \"postal_code\": null\n },\n \"avatar_large\": null,\n \"role\":
// \"freelancer\",\n \"chosen_role\": \"freelancer\",\n \"employer_reputation\":
// null,\n \"status\": {\n \"payment_verified\": null,\n \"email_verified\":
// true,\n \"deposit_made\": null,\n \"profile_complete\": null,\n
// \"phone_verified\": null,\n \"identity_verified\": null,\n
// \"facebook_connected\": null,\n \"freelancer_verified_user\": null,\n
// \"linkedin_connected\": null\n },\n \"avatar_cdn\": null,\n
// \"avatar_large_cdn\": null,\n \"primary_currency\": {\n \"id\": 11,\n
// \"code\": \"INR\",\n \"sign\": \"₹\",\n \"name\": \"Indian Rupee\",\n
// \"exchange_rate\": 0.013064,\n \"country\": \"IN\",\n \"is_external\":
// null,\n \"is_escrowcom_supported\": null\n },\n \"account_balances\": null,\n
// \"membership_package\": null,\n \"qualifications\": null,\n \"badges\":
// null,\n \"primary_language\": \"en\",\n \"search_languages\": null,\n
// \"cover_image\": null,\n \"true_location\": null,\n \"portfolio_count\":
// null,\n \"preferred_freelancer\": null,\n \"support_status\": null,\n
// \"first_name\": null,\n \"last_name\": null,\n \"mobile_tracking\": null,\n
// \"corporate\": {\n \"status\": \"active\",\n \"founder_id\": 60134646\n },\n
// \"public_name\": \"App Giant\",\n \"corporate_users\": null,\n \"is_local\":
// null,\n \"address\": null,\n \"company\": \"\",\n \"recommendations\":
// null,\n \"pool_ids\": [],\n \"enterprise_ids\": [],\n \"date_of_birth\":
// null,\n \"escrowcom_account_linked\": true,\n
// \"escrowcom_interaction_required\": false,\n \"marketing_mobile_number\":
// null,\n \"user_sanctions\": null,\n \"freelancer_verified_status\": null,\n
// \"secure_phone\": null,\n \"directory_follow_preferences\": null,\n
// \"is_payment_confirmation_required\": null,\n
// \"is_nominated_payment_controlled\": null,\n
// \"is_nominated_payment_share_setup_complete\": null,\n \"spam_profile\":
// null,\n \"endorsements\": null,\n \"timezone\": {\n \"id\": 403,\n
// \"country\": \"IN\",\n \"timezone\": \"Asia/Kolkata\",\n \"offset\": 5.5\n
// },\n \"responsiveness\": null,\n \"bid_quality_details\": null,\n
// \"test_user\": null,\n \"online_offline_status\": null,\n
// \"deposit_methods\": null,\n \"oauth_password_credentials_allowed\": false,\n
// \"registration_completed\": true,\n \"is_profile_visible\": true,\n
// \"enterprise_metadata_values\": null,\n \"mfa\": null,\n \"grants\": null,\n
// \"operating_areas\": null,\n \"equipment_groups\": null\n },\n
// \"request_id\": \"979f411898870d95ba19199f44022ccf\"\n}";

// JsonNode js = new ObjectMapper() .readTree(jsonString);

// when(wsResponse2.asJson()).thenReturn(js);
// when(wsR2.get()).thenReturn(CompletableFuture.completedFuture(wsResponse2));

// CompletableFuture<Object> userProfileInfoCompletableFuture=
// FutureConverters.toJava(ask(tar,new
// EmployerInfoHelperV2.EmployerProfileHelperActor("58954485"),
// 5000)).thenApplyAsync(response->{
// return response;
// }).toCompletableFuture();

// EmployeeBioData userProfileInfo = (EmployeeBioData)
// userProfileInfoCompletableFuture.get();
// // when(restfulService.getEmployerInfo(any())) .thenReturn(
// // CompletableFuture.completedFuture(js)); CompletableFuture<EmployeeBioData>
// // futureUserProfileInfo = employerInfoHelper.getEmployerInfo("58954485");

// // verify(restfulService).getEmployerInfo("58954485");
// // assertEquals(userProfileInfo.getBio(),"I am Enthusiastic learner. Keen on
// Building backend applications from Scratch. Would love to work on
// applications that make impact in real life");
// // System.out.println(userProfileInfo.bio);
// }};
// }
// }
