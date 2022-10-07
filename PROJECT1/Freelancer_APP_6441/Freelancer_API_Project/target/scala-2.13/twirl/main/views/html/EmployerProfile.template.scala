
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object EmployerProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[wrapper.EmployeeBioData,wrapper.ProjectEmployeeInfo,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(employerInfo: wrapper.EmployeeBioData, employerProjectInfo: wrapper.ProjectEmployeeInfo):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.91*/("""


"""),format.raw/*4.1*/("""<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
table"""),format.raw/*10.6*/("""{"""),format.raw/*10.7*/("""
	"""),format.raw/*11.2*/("""display: inline;
"""),format.raw/*12.1*/("""}"""),format.raw/*12.2*/("""
"""),format.raw/*13.1*/("""#infoTable """),format.raw/*13.12*/("""{"""),format.raw/*13.13*/("""
  """),format.raw/*14.3*/("""font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  
"""),format.raw/*17.1*/("""}"""),format.raw/*17.2*/("""
"""),format.raw/*18.1*/("""body"""),format.raw/*18.5*/("""{"""),format.raw/*18.6*/("""
	"""),format.raw/*19.2*/("""background-color:#e7e7e7;
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/("""
"""),format.raw/*21.1*/("""#infoTable td, #infoTable th """),format.raw/*21.30*/("""{"""),format.raw/*21.31*/("""
  """),format.raw/*22.3*/("""border: 1px solid #ddd;
  padding: 8px;
"""),format.raw/*24.1*/("""}"""),format.raw/*24.2*/("""
"""),format.raw/*25.1*/("""#titleOfIssue"""),format.raw/*25.14*/("""{"""),format.raw/*25.15*/("""
	"""),format.raw/*26.2*/("""font-size : 20px;
	text-align : center;
"""),format.raw/*28.1*/("""}"""),format.raw/*28.2*/("""
"""),format.raw/*29.1*/("""div"""),format.raw/*29.4*/("""{"""),format.raw/*29.5*/("""
 """),format.raw/*30.2*/("""display : inline-block;
"""),format.raw/*31.1*/("""}"""),format.raw/*31.2*/("""
"""),format.raw/*32.1*/("""#infoTable tr:nth-child(even)"""),format.raw/*32.30*/("""{"""),format.raw/*32.31*/("""background-color: #f2f2f2;"""),format.raw/*32.57*/("""}"""),format.raw/*32.58*/("""

"""),format.raw/*34.1*/("""#infoTable tr:hover """),format.raw/*34.21*/("""{"""),format.raw/*34.22*/("""background-color: #ddd;"""),format.raw/*34.45*/("""}"""),format.raw/*34.46*/("""

"""),format.raw/*36.1*/("""#infoTable th """),format.raw/*36.15*/("""{"""),format.raw/*36.16*/("""
  """),format.raw/*37.3*/("""padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
"""),format.raw/*42.1*/("""}"""),format.raw/*42.2*/("""
"""),format.raw/*43.1*/("""a"""),format.raw/*43.2*/("""{"""),format.raw/*43.3*/("""
	"""),format.raw/*44.2*/("""text-decoration:none; 
	text-size:100px;
"""),format.raw/*46.1*/("""}"""),format.raw/*46.2*/("""
	"""),format.raw/*47.2*/("""</style>
<body>

    <body>
<div style="padding-left:100px;height:100%;width:59%;">
	
	<table  class="infoTable">
	<span><h3>Employer Profile Page</h3></span>
	<tr ><th colspan="2">Employer Information</th></tr>
	"""),_display_(/*56.3*/if(employerInfo.result.id!= null)/*56.36*/{_display_(Seq[Any](format.raw/*56.37*/("""
	
	    """),_display_(/*58.7*/if(employerInfo.result.id !=null)/*58.40*/{_display_(Seq[Any](format.raw/*58.41*/("""
	    		
			"""),format.raw/*60.4*/("""<tr>
				<td>ID</td>
				<td>"""),_display_(/*62.10*/employerInfo/*62.22*/.result.id),format.raw/*62.32*/("""</td>
			</tr>
	    """)))}),format.raw/*64.7*/("""	
	    """),_display_(/*65.7*/if(employerInfo.result.username !=null)/*65.46*/{_display_(Seq[Any](format.raw/*65.47*/("""
	    		
			"""),format.raw/*67.4*/("""<tr>
				<td>User Name</td>
				<td>"""),_display_(/*69.10*/employerInfo/*69.22*/.result.username),format.raw/*69.38*/("""</td>
			</tr>
	    """)))}),format.raw/*71.7*/("""
		"""),_display_(/*72.4*/if(employerInfo.result.registration_date !=null)/*72.52*/{_display_(Seq[Any](format.raw/*72.53*/("""
	    		
			"""),format.raw/*74.4*/("""<tr>
				<td>Registration Date</td>
				<td>"""),_display_(/*76.10*/employerInfo/*76.22*/.result.registration_date),format.raw/*76.47*/("""</td>
			</tr>
	    """)))}),format.raw/*78.7*/("""
		"""),_display_(/*79.4*/if(employerInfo.result.limited_account !=null)/*79.50*/{_display_(Seq[Any](format.raw/*79.51*/("""
	    		
			"""),format.raw/*81.4*/("""<tr>
				<td>Limited Account</td>
				<td>"""),_display_(/*83.10*/employerInfo/*83.22*/.result.limited_account),format.raw/*83.45*/("""</td>
			</tr>
	    """)))}),format.raw/*85.7*/("""


	  
	    
	    """),_display_(/*90.7*/if(employerInfo.result.display_name != null)/*90.51*/{_display_(Seq[Any](format.raw/*90.52*/("""
	    		
			"""),format.raw/*92.4*/("""<tr>
				<td>Display Name</td>
				<td>"""),_display_(/*94.10*/employerInfo/*94.22*/.result.display_name),format.raw/*94.42*/("""</td>
			</tr>
	    """)))}),format.raw/*96.7*/("""
			    """),_display_(/*97.9*/if(employerInfo.result.location.country.name != null)/*97.62*/{_display_(Seq[Any](format.raw/*97.63*/("""
	    		
			"""),format.raw/*99.4*/("""<tr>
				<td>Country</td>
				<td>"""),_display_(/*101.10*/employerInfo/*101.22*/.result.location.country.name),format.raw/*101.51*/("""</td>
			</tr>
	    """)))}),format.raw/*103.7*/("""
		
		
		"""),_display_(/*106.4*/if(employerInfo.result.role != null)/*106.40*/{_display_(Seq[Any](format.raw/*106.41*/("""
	    		
			"""),format.raw/*108.4*/("""<tr>
				<td>Role</td>
				<td>"""),_display_(/*110.10*/employerInfo/*110.22*/.result.role),format.raw/*110.34*/("""</td>
			</tr>
			
	    """)))}),format.raw/*113.7*/("""
		"""),_display_(/*114.4*/if(employerInfo.result.chosen_role != null)/*114.47*/{_display_(Seq[Any](format.raw/*114.48*/("""
	    		
			"""),format.raw/*116.4*/("""<tr>
				<td>Chosen Role</td>
				<td>"""),_display_(/*118.10*/employerInfo/*118.22*/.result.chosen_role),format.raw/*118.41*/("""</td>
			</tr>
			
	    """)))}),format.raw/*121.7*/("""
		"""),_display_(/*122.4*/if(employerInfo.result.status.email_verified != null)/*122.57*/{_display_(Seq[Any](format.raw/*122.58*/("""
	    		
			"""),format.raw/*124.4*/("""<tr>
				<td>Email Verified</td>
				<td>"""),_display_(/*126.10*/employerInfo/*126.22*/.result.status.email_verified),format.raw/*126.51*/(""" """),format.raw/*126.52*/("""</td>
			</tr>
			
	    """)))}),format.raw/*129.7*/("""
		"""),_display_(/*130.4*/if(employerInfo.result.primary_currency.name != null)/*130.57*/{_display_(Seq[Any](format.raw/*130.58*/("""
	    		
			"""),format.raw/*132.4*/("""<tr>
				<td>Primary Currency</td>
				<td>"""),_display_(/*134.10*/employerInfo/*134.22*/.result.primary_currency.name),format.raw/*134.51*/("""</td>
			</tr>
			
	    """)))}),format.raw/*137.7*/("""
	""")))}),format.raw/*138.3*/("""
	"""),format.raw/*139.2*/("""<tr>
	
	</tr>
	
	</table>

<div></div>

<div style="padding-left:0px;height:100%;width:60%">
	<table  class="infoTable">
	<tr><th>Projects Overview
	</th></tr>
	"""),_display_(/*151.3*/if(employerProjectInfo!= null &&  employerProjectInfo.result.projects!=null)/*151.79*/{_display_(Seq[Any](format.raw/*151.80*/("""
	 """),_display_(/*152.4*/for(po <- employerProjectInfo.result.projects) yield /*152.50*/ {_display_(Seq[Any](format.raw/*152.52*/("""
		"""),format.raw/*153.3*/("""<tr>
			<td><b>ID : <span id="Id">"""),_display_(/*154.31*/po/*154.33*/.id),format.raw/*154.36*/("""<span></b></br></br>
				
			</td>
			<td><b><span id="Title">"""),_display_(/*157.29*/po/*157.31*/.title),format.raw/*157.37*/("""<span></b></br></br>
			</td>
			<td><b><span id="Time Submitted">"""),_display_(/*159.38*/po/*159.40*/.time_submitted),format.raw/*159.55*/("""<span></b></br></br>
		</tr>
		""")))}),format.raw/*161.4*/("""
	""")))}),format.raw/*162.3*/(""" 

	"""),format.raw/*164.2*/("""</table>
	

</body>
</html>"""))
      }
    }
  }

  def render(employerInfo:wrapper.EmployeeBioData,employerProjectInfo:wrapper.ProjectEmployeeInfo): play.twirl.api.HtmlFormat.Appendable = apply(employerInfo,employerProjectInfo)

  def f:((wrapper.EmployeeBioData,wrapper.ProjectEmployeeInfo) => play.twirl.api.HtmlFormat.Appendable) = (employerInfo,employerProjectInfo) => apply(employerInfo,employerProjectInfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/EmployerProfile.scala.html
                  HASH: a4c9bf2647139f0e88ac132856133d2aa3ec23b6
                  MATRIX: 962->1|1146->90|1178->96|1308->199|1336->200|1366->203|1411->221|1439->222|1468->224|1507->235|1536->236|1567->240|1672->318|1700->319|1729->321|1760->325|1788->326|1818->329|1872->356|1900->357|1929->359|1986->388|2015->389|2046->393|2115->435|2143->436|2172->438|2213->451|2242->452|2272->455|2341->497|2369->498|2398->500|2428->503|2456->504|2486->507|2538->532|2566->533|2595->535|2652->564|2681->565|2735->591|2764->592|2795->596|2843->616|2872->617|2923->640|2952->641|2983->645|3025->659|3054->660|3085->664|3225->777|3253->778|3282->780|3310->781|3338->782|3368->785|3438->828|3466->829|3496->832|3745->1055|3787->1088|3826->1089|3863->1100|3905->1133|3944->1134|3985->1148|4044->1180|4065->1192|4096->1202|4149->1225|4184->1234|4232->1273|4271->1274|4312->1288|4378->1327|4399->1339|4436->1355|4489->1378|4520->1383|4577->1431|4616->1432|4657->1446|4731->1493|4752->1505|4798->1530|4851->1553|4882->1558|4937->1604|4976->1605|5017->1619|5089->1664|5110->1676|5154->1699|5207->1722|5257->1746|5310->1790|5349->1791|5390->1805|5459->1847|5480->1859|5521->1879|5574->1902|5610->1912|5672->1965|5711->1966|5752->1980|5817->2017|5839->2029|5890->2058|5944->2081|5984->2094|6030->2130|6070->2131|6112->2145|6174->2179|6196->2191|6230->2203|6289->2231|6321->2236|6374->2279|6414->2280|6456->2294|6525->2335|6547->2347|6588->2366|6647->2394|6679->2399|6742->2452|6782->2453|6824->2467|6896->2511|6918->2523|6969->2552|6999->2553|7058->2581|7090->2586|7153->2639|7193->2640|7235->2654|7309->2700|7331->2712|7382->2741|7441->2769|7476->2773|7507->2776|7708->2950|7794->3026|7834->3027|7866->3032|7929->3078|7970->3080|8002->3084|8066->3120|8078->3122|8103->3125|8197->3191|8209->3193|8237->3199|8334->3268|8346->3270|8383->3285|8448->3319|8483->3323|8517->3329
                  LINES: 27->1|32->1|35->4|41->10|41->10|42->11|43->12|43->12|44->13|44->13|44->13|45->14|48->17|48->17|49->18|49->18|49->18|50->19|51->20|51->20|52->21|52->21|52->21|53->22|55->24|55->24|56->25|56->25|56->25|57->26|59->28|59->28|60->29|60->29|60->29|61->30|62->31|62->31|63->32|63->32|63->32|63->32|63->32|65->34|65->34|65->34|65->34|65->34|67->36|67->36|67->36|68->37|73->42|73->42|74->43|74->43|74->43|75->44|77->46|77->46|78->47|87->56|87->56|87->56|89->58|89->58|89->58|91->60|93->62|93->62|93->62|95->64|96->65|96->65|96->65|98->67|100->69|100->69|100->69|102->71|103->72|103->72|103->72|105->74|107->76|107->76|107->76|109->78|110->79|110->79|110->79|112->81|114->83|114->83|114->83|116->85|121->90|121->90|121->90|123->92|125->94|125->94|125->94|127->96|128->97|128->97|128->97|130->99|132->101|132->101|132->101|134->103|137->106|137->106|137->106|139->108|141->110|141->110|141->110|144->113|145->114|145->114|145->114|147->116|149->118|149->118|149->118|152->121|153->122|153->122|153->122|155->124|157->126|157->126|157->126|157->126|160->129|161->130|161->130|161->130|163->132|165->134|165->134|165->134|168->137|169->138|170->139|182->151|182->151|182->151|183->152|183->152|183->152|184->153|185->154|185->154|185->154|188->157|188->157|188->157|190->159|190->159|190->159|192->161|193->162|195->164
                  -- GENERATED --
              */
          