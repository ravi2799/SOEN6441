
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
/*1.2*/import java.util
/*2.2*/import wrapper.Project

object skills extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[List[wrapper.Project],String,HashMap[String, List[wrapper.Project]],HashMap[String, List[wrapper.Project]],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(searchResult: List[wrapper.Project], searchedKeyword: String, cacheData: HashMap[String, List[wrapper.Project]], projectDataMap: HashMap[String, List[wrapper.Project]], globalPreviewDesc:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.197*/("""


"""),format.raw/*7.1*/("""<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
.container"""),format.raw/*13.11*/("""{"""),format.raw/*13.12*/("""
"""),format.raw/*14.1*/("""margin-top:4em;
"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/("""
"""),format.raw/*16.1*/(""".ml-2"""),format.raw/*16.6*/("""{"""),format.raw/*16.7*/("""
    """),format.raw/*17.5*/("""margin-left: 1em;
"""),format.raw/*18.1*/("""}"""),format.raw/*18.2*/("""
"""),format.raw/*19.1*/(""".flex__row"""),format.raw/*19.11*/("""{"""),format.raw/*19.12*/("""
"""),format.raw/*20.1*/("""display: flex;
justify-content:center;
align-items:center;
"""),format.raw/*23.1*/("""}"""),format.raw/*23.2*/("""
"""),format.raw/*24.1*/(""".search__field"""),format.raw/*24.15*/("""{"""),format.raw/*24.16*/("""
"""),format.raw/*25.1*/("""padding:3px;
outline: none;
outline-width:none;
min-width: 20em;
min-height: 3em;
"""),format.raw/*30.1*/("""}"""),format.raw/*30.2*/("""
"""),format.raw/*31.1*/(""".search__btn"""),format.raw/*31.13*/("""{"""),format.raw/*31.14*/("""
"""),format.raw/*32.1*/("""padding:5px;
margin-left:1em;
width:10em;
height: 2em;
border-radius: 1em;
color: #fff;
background-color: #2196f3eb;
font-weight: 600;
"""),format.raw/*40.1*/("""}"""),format.raw/*40.2*/("""
"""),format.raw/*41.1*/(""".flex__row__project"""),format.raw/*41.20*/("""{"""),format.raw/*41.21*/("""
"""),format.raw/*42.1*/("""display: flex;
justify-content:flex-start;

"""),format.raw/*45.1*/("""}"""),format.raw/*45.2*/("""
"""),format.raw/*46.1*/(""".mt-3"""),format.raw/*46.6*/("""{"""),format.raw/*46.7*/("""
    """),format.raw/*47.5*/("""margin-top: 2em;
"""),format.raw/*48.1*/("""}"""),format.raw/*48.2*/("""
"""),format.raw/*49.1*/("""</style>
<style>
           

            body """),format.raw/*53.18*/("""{"""),format.raw/*53.19*/("""
                """),format.raw/*54.17*/("""background-color: #e7e7e7;
            """),format.raw/*55.13*/("""}"""),format.raw/*55.14*/("""
            
    """),format.raw/*57.5*/("""</style>
<body>
    <form method="GET" action="/SearchPage">
        <div class="flex__row container">
            <input name="keyword" id="search__text" class="search__field" placeholder="Enter Search items"></input>
            <button  type="submit"  class="search__btn">GO!</button>
        </div>
    </form>


    <div class="layout-container">
        <div class="container-fluid">
        """),_display_(/*69.10*/if(searchResult != null && searchResult.size > 0)/*69.59*/{_display_(Seq[Any](format.raw/*69.60*/("""
            """),_display_(/*70.14*/for( (keyword, projectList:List[Project]) <- cacheData ) yield /*70.70*/{_display_(Seq[Any](format.raw/*70.71*/("""
                """),_display_(/*71.18*/if(keyword == searchedKeyword)/*71.48*/{_display_(Seq[Any](format.raw/*71.49*/("""
                    """),format.raw/*72.21*/("""<span>Search term is: """),_display_(/*72.44*/keyword),format.raw/*72.51*/("""  """),format.raw/*72.53*/("""Findex:"""),_display_(/*72.61*/{projectList.map(_.fIndex).sum/searchResult.size()}),format.raw/*72.112*/("""  """),format.raw/*72.114*/("""FKGL:"""),_display_(/*72.120*/{projectList.map(_.fkglIndex).sum/searchResult.size()}),format.raw/*72.174*/(""" """),format.raw/*72.175*/("""<a class="ml-2" href="/GlobalStatistics/"""),_display_(/*72.216*/searchedKeyword),format.raw/*72.231*/("""">GlobalStats</a></span>
                    
                """),_display_(/*74.18*/for((project,index) <- (projectList.zipWithIndex).reverse) yield /*74.76*/ {_display_(Seq[Any](format.raw/*74.78*/("""
                """),format.raw/*75.17*/("""<div class="flex__row__project">
                    
                    """),_display_(/*77.22*/{-(index-searchResult.size)}),format.raw/*77.50*/(""". <a class="ml-2" href="/owner_id/"""),_display_(/*77.85*/project/*77.92*/.owner_id),format.raw/*77.101*/("""">Owner ID </a>
                    <span class="ml-2">"""),_display_(/*78.41*/project/*78.48*/.time_submitted),format.raw/*78.63*/("""</span>
                    <span class="ml-2"><a href="https://www.freelancer.com/projects/"""),_display_(/*79.86*/project/*79.93*/.seo_url),format.raw/*79.101*/("""?w=f&ngsw-bypass=" target="_blank">"""),_display_(/*79.137*/project/*79.144*/.title),format.raw/*79.150*/("""</a>
                    </span>
                    <span class="ml-2">type:"""),_display_(/*81.46*/project/*81.53*/.project_type),format.raw/*81.66*/("""</span>
                    
                    <span class="ml-2">Educational Level: """),_display_(/*83.60*/project/*83.67*/.educationalStatus),format.raw/*83.85*/("""</span>
		            <span class="ml-2"> <a class="ml-2" href="/LocalStatistics/"""),_display_(/*84.75*/searchedKeyword),format.raw/*84.90*/("""/"""),_display_(/*84.92*/project/*84.99*/.id),format.raw/*84.102*/("""">LocalStats</a></span>
                    <span class="ml-2">Findex: """),_display_(/*85.49*/project/*85.56*/.fIndex),format.raw/*85.63*/("""</span>
                    <span class="ml-2">Skills: </span>
                        """),_display_(/*87.26*/for(skill <- (project.jobs)) yield /*87.54*/ {_display_(Seq[Any](format.raw/*87.56*/("""
                            """),format.raw/*88.29*/("""<a href ="/projectsBySkill?skillsName="""),_display_(/*88.68*/skill/*88.73*/.name),format.raw/*88.78*/("""&skillsID="""),_display_(/*88.89*/skill/*88.94*/.id),format.raw/*88.97*/("""" class="ml-2">"""),_display_(/*88.113*/skill/*88.118*/.name),format.raw/*88.123*/("""</a>
                        """)))}),format.raw/*89.26*/("""
		
                """),format.raw/*91.17*/("""</div>
            """)))}),format.raw/*92.14*/("""
                """)))}),format.raw/*93.18*/("""
                
            """)))}),format.raw/*95.14*/("""
           
        """)))}),format.raw/*97.10*/("""
"""),format.raw/*98.1*/("""</div>
    
        <div id="cacheContent">
        </div></div>
   
</body>
</html>"""))
      }
    }
  }

  def render(searchResult:List[wrapper.Project],searchedKeyword:String,cacheData:HashMap[String, List[wrapper.Project]],projectDataMap:HashMap[String, List[wrapper.Project]],globalPreviewDesc:String): play.twirl.api.HtmlFormat.Appendable = apply(searchResult,searchedKeyword,cacheData,projectDataMap,globalPreviewDesc)

  def f:((List[wrapper.Project],String,HashMap[String, List[wrapper.Project]],HashMap[String, List[wrapper.Project]],String) => play.twirl.api.HtmlFormat.Appendable) = (searchResult,searchedKeyword,cacheData,projectDataMap,globalPreviewDesc) => apply(searchResult,searchedKeyword,cacheData,projectDataMap,globalPreviewDesc)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/skills.scala.html
                  HASH: 68d09ca937032db322a110fd9073e1916bbd0a40
                  MATRIX: 610->1|634->20|1069->47|1360->242|1392->248|1528->356|1557->357|1586->359|1630->376|1658->377|1687->379|1719->384|1747->385|1780->391|1826->410|1854->411|1883->413|1921->423|1950->424|1979->426|2068->488|2096->489|2125->491|2167->505|2196->506|2225->508|2339->595|2367->596|2396->598|2436->610|2465->611|2494->613|2664->756|2692->757|2721->759|2768->778|2797->779|2826->781|2900->828|2928->829|2957->831|2989->836|3017->837|3050->843|3095->861|3123->862|3152->864|3231->915|3260->916|3306->934|3374->974|3403->975|3450->995|3888->1406|3946->1455|3985->1456|4027->1471|4099->1527|4138->1528|4184->1547|4223->1577|4262->1578|4312->1600|4362->1623|4390->1630|4420->1632|4455->1640|4528->1691|4559->1693|4593->1699|4669->1753|4699->1754|4768->1795|4805->1810|4897->1875|4971->1933|5011->1935|5057->1953|5161->2030|5210->2058|5272->2093|5288->2100|5319->2109|5403->2166|5419->2173|5455->2188|5576->2282|5592->2289|5622->2297|5686->2333|5703->2340|5731->2346|5838->2426|5854->2433|5888->2446|6005->2536|6021->2543|6060->2561|6170->2644|6206->2659|6235->2661|6251->2668|6276->2671|6376->2744|6392->2751|6420->2758|6537->2848|6581->2876|6621->2878|6679->2908|6745->2947|6759->2952|6785->2957|6823->2968|6837->2973|6861->2976|6905->2992|6920->2997|6947->3002|7009->3033|7059->3055|7111->3076|7161->3095|7225->3128|7280->3152|7309->3154
                  LINES: 23->1|24->2|29->4|34->4|37->7|43->13|43->13|44->14|45->15|45->15|46->16|46->16|46->16|47->17|48->18|48->18|49->19|49->19|49->19|50->20|53->23|53->23|54->24|54->24|54->24|55->25|60->30|60->30|61->31|61->31|61->31|62->32|70->40|70->40|71->41|71->41|71->41|72->42|75->45|75->45|76->46|76->46|76->46|77->47|78->48|78->48|79->49|83->53|83->53|84->54|85->55|85->55|87->57|99->69|99->69|99->69|100->70|100->70|100->70|101->71|101->71|101->71|102->72|102->72|102->72|102->72|102->72|102->72|102->72|102->72|102->72|102->72|102->72|102->72|104->74|104->74|104->74|105->75|107->77|107->77|107->77|107->77|107->77|108->78|108->78|108->78|109->79|109->79|109->79|109->79|109->79|109->79|111->81|111->81|111->81|113->83|113->83|113->83|114->84|114->84|114->84|114->84|114->84|115->85|115->85|115->85|117->87|117->87|117->87|118->88|118->88|118->88|118->88|118->88|118->88|118->88|118->88|118->88|118->88|119->89|121->91|122->92|123->93|125->95|127->97|128->98
                  -- GENERATED --
              */
          