
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

object landingPage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[List[wrapper.Project],play.mvc.Http.Request,String,HashMap[String, List[wrapper.Project]],HashMap[String, List[wrapper.Project]],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(searchResult: List[wrapper.Project], request: play.mvc.Http.Request, searchedKeyword: String, cacheData: HashMap[String, List[wrapper.Project]], projectDataMap: HashMap[String, List[wrapper.Project]], globalPreviewDesc:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.229*/("""


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
<script>
            let rawLine="";
            function loadDataFromWrapper() """),format.raw/*52.44*/("""{"""),format.raw/*52.45*/("""
                """),format.raw/*53.17*/("""let raw = "";
                """),_display_(/*54.18*/for( (keyword, searchResult:List[Project]) <- cacheData ) yield /*54.75*/{_display_(Seq[Any](format.raw/*54.76*/("""
                """),_display_(/*55.18*/if(keyword!=searchedKeyword)/*55.46*/ {_display_(Seq[Any](format.raw/*55.48*/("""
                """),_display_(/*56.18*/if(request.session().get(keyword+ "-result").isPresent())/*56.75*/{_display_(Seq[Any](format.raw/*56.76*/("""
                """),format.raw/*57.17*/("""raw += "<table>" +

                    "<tr> " +
                    "<td>Search term is: """),_display_(/*60.43*/keyword),format.raw/*60.50*/(""" """),format.raw/*60.51*/("""</td>" +
                    "<td> Findex: """),_display_(/*61.36*/{searchResult.map(_.fIndex).sum/searchResult.size()}),format.raw/*61.88*/("""</td>" +
                    "<td>Fkgl index is: """),_display_(/*62.42*/{searchResult.map(_.fkglIndex).sum/searchResult.size()}),format.raw/*62.97*/("""</td>" +
                    "<td><a class=\"ml-2\" href=\"/GlobalStatistics/"""),_display_(/*63.70*/searchedKeyword),format.raw/*63.85*/("""\">GlobalStats</a></td>"+
                
                    """),_display_(/*65.22*/for((project,index)<-searchResult.zipWithIndex) yield /*65.69*/{_display_(Seq[Any](format.raw/*65.70*/("""
                        """),format.raw/*66.25*/(""""<tr>" +
                            "<td>"""),_display_(/*67.35*/{index+11}),format.raw/*67.45*/("""</td>"+
                        "<td><a class=\"ml-2\" href=\"/owner_id/"""),_display_(/*68.66*/project/*68.73*/.owner_id),format.raw/*68.82*/("""\">Owner ID </a></td>"
                        
                        +

                        "<td><span class=\"ml-2\">"""),_display_(/*72.52*/project/*72.59*/.time_submitted),format.raw/*72.74*/("""</span></td>"+

                        "<td><span class=\"ml-2\"><a href=\"https://www.freelancer.com/projects/"""),_display_(/*74.98*/project/*74.105*/.seo_url),format.raw/*74.113*/("""?w=f&ngsw-bypass=\" target=\"_blank\">"""),_display_(/*74.152*/project/*74.159*/.title),format.raw/*74.165*/("""</a></span></td>"
                        +

                        "<td><span class=\"ml-2\">type:"""),_display_(/*77.57*/project/*77.64*/.project_type),format.raw/*77.77*/("""</span></td>"+

                        "<td><span class=\"ml-2\">"""),_display_(/*79.52*/project/*79.59*/.educationalStatus),format.raw/*79.77*/(""" """),format.raw/*79.78*/("""</span></td>"
                        
                        +
                        "<td><span class=\"ml-2\">Findex: </span></td>"
                        +
                        "<td><span class=\"ml-2\"> <a class=\"ml-2\" href=\"/LocalStatistics/"""),_display_(/*84.95*/keyword),format.raw/*84.102*/("""/"""),_display_(/*84.104*/project/*84.111*/.id),format.raw/*84.114*/("""\">LocalStats</a></span></td>"
                        +
                            
                        
                        "<td><span class=\"ml-2\">"""),_display_(/*88.52*/project/*88.59*/.fIndex),format.raw/*88.66*/("""</span></td>"

                        +
                        "<td><span class=\"ml-2\">Skills: </span></td>"

                        +"<td>"+ "[" + 
                        """),_display_(/*94.26*/for(skill <- (project.jobs)) yield /*94.54*/ {_display_(Seq[Any](format.raw/*94.56*/("""
                                """),format.raw/*95.33*/(""""<a href =\"/projectsBySkill?skillsName="""),_display_(/*95.74*/skill/*95.79*/.name),format.raw/*95.84*/("""&skillsID="""),_display_(/*95.95*/skill/*95.100*/.id),format.raw/*95.103*/("""\" class=\"ml-2\">"""),_display_(/*95.122*/skill/*95.127*/.name),format.raw/*95.132*/("""</a> " + 
                        """)))}),format.raw/*96.26*/("""
                        """),format.raw/*97.25*/(""""]" +
                    """)))}),format.raw/*98.22*/("""
                    """),format.raw/*99.21*/(""""</td></tr>" +
                     "</table>";
                """)))})))})))}),format.raw/*101.20*/("""
                """),format.raw/*102.17*/("""document.getElementById("cacheContent").innerHTML = raw;
            """),format.raw/*103.13*/("""}"""),format.raw/*103.14*/("""

"""),format.raw/*105.1*/("""</script>
<style>
            table """),format.raw/*107.19*/("""{"""),format.raw/*107.20*/("""
                """),format.raw/*108.17*/("""display: inline;
            """),format.raw/*109.13*/("""}"""),format.raw/*109.14*/("""

            """),format.raw/*111.13*/(""".infoTable, .infoTable2 """),format.raw/*111.37*/("""{"""),format.raw/*111.38*/("""
                """),format.raw/*112.17*/("""font-family: Arial, Helvetica, sans-serif;
                border-collapse: collapse;

            """),format.raw/*115.13*/("""}"""),format.raw/*115.14*/("""

            """),format.raw/*117.13*/("""body """),format.raw/*117.18*/("""{"""),format.raw/*117.19*/("""
                """),format.raw/*118.17*/("""background-color: #e7e7e7;
            """),format.raw/*119.13*/("""}"""),format.raw/*119.14*/("""

            """),format.raw/*121.13*/(""".infoTable td, .infoTable th """),format.raw/*121.42*/("""{"""),format.raw/*121.43*/("""
                """),format.raw/*122.17*/("""border: 1px solid #ddd;
                padding: 8px;
            """),format.raw/*124.13*/("""}"""),format.raw/*124.14*/("""

            """),format.raw/*126.13*/(""".infoTable2 td, .infoTable2 th """),format.raw/*126.44*/("""{"""),format.raw/*126.45*/("""
                """),format.raw/*127.17*/("""border: 1px solid #ddd;
                padding: 8px;
            """),format.raw/*129.13*/("""}"""),format.raw/*129.14*/("""

            """),format.raw/*131.13*/("""#titleOfIssue """),format.raw/*131.27*/("""{"""),format.raw/*131.28*/("""
                """),format.raw/*132.17*/("""font-size: 20px;
                text-align: center;
            """),format.raw/*134.13*/("""}"""),format.raw/*134.14*/("""

            """),format.raw/*136.13*/("""input[type=text] """),format.raw/*136.30*/("""{"""),format.raw/*136.31*/("""
                """),format.raw/*137.17*/("""border: 2px solid green;
                border-radius: 4px;
                width: 100%;
                height: 40px;
                padding-left: 20px;
            """),format.raw/*142.13*/("""}"""),format.raw/*142.14*/("""

            """),format.raw/*144.13*/("""#btn_submit """),format.raw/*144.25*/("""{"""),format.raw/*144.26*/("""
                """),format.raw/*145.17*/("""background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin-top: 10px;
            """),format.raw/*154.13*/("""}"""),format.raw/*154.14*/("""

            """),format.raw/*156.13*/("""div """),format.raw/*156.17*/("""{"""),format.raw/*156.18*/("""
                """),format.raw/*157.17*/("""display: inline-block;
            """),format.raw/*158.13*/("""}"""),format.raw/*158.14*/("""

            """),format.raw/*160.13*/(""".infoTable tr:nth-child(even) """),format.raw/*160.43*/("""{"""),format.raw/*160.44*/("""
                """),format.raw/*161.17*/("""background-color: #f2f2f2;
            """),format.raw/*162.13*/("""}"""),format.raw/*162.14*/("""

            """),format.raw/*164.13*/(""".infoTable tr:hover """),format.raw/*164.33*/("""{"""),format.raw/*164.34*/("""
                """),format.raw/*165.17*/("""background-color: #ddd;
            """),format.raw/*166.13*/("""}"""),format.raw/*166.14*/("""

            """),format.raw/*168.13*/(""".infoTable th """),format.raw/*168.27*/("""{"""),format.raw/*168.28*/("""
                """),format.raw/*169.17*/("""padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #04AA6D;
                color: white;
            """),format.raw/*174.13*/("""}"""),format.raw/*174.14*/("""

            """),format.raw/*176.13*/(""".infoTable2 tr:nth-child(even) """),format.raw/*176.44*/("""{"""),format.raw/*176.45*/("""
                """),format.raw/*177.17*/("""background-color: #f2f2f2;
            """),format.raw/*178.13*/("""}"""),format.raw/*178.14*/("""

            """),format.raw/*180.13*/(""".infoTable2 tr:hover """),format.raw/*180.34*/("""{"""),format.raw/*180.35*/("""
                """),format.raw/*181.17*/("""background-color: #ddd;
            """),format.raw/*182.13*/("""}"""),format.raw/*182.14*/("""

            """),format.raw/*184.13*/(""".infoTable2 th """),format.raw/*184.28*/("""{"""),format.raw/*184.29*/("""
                """),format.raw/*185.17*/("""padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #04AA6D;
                color: white;
            """),format.raw/*190.13*/("""}"""),format.raw/*190.14*/("""

            """),format.raw/*192.13*/("""a """),format.raw/*192.15*/("""{"""),format.raw/*192.16*/("""
                """),format.raw/*193.17*/("""text-decoration: none;
                text-size: 100px;
            """),format.raw/*195.13*/("""}"""),format.raw/*195.14*/("""
            """),format.raw/*196.13*/(""".layout-container"""),format.raw/*196.30*/("""{"""),format.raw/*196.31*/("""
                """),format.raw/*197.17*/("""display: flex;
                flex-direction: column;
            """),format.raw/*199.13*/("""}"""),format.raw/*199.14*/("""
            """),format.raw/*200.13*/(""".container-fluid"""),format.raw/*200.29*/("""{"""),format.raw/*200.30*/("""
                """),format.raw/*201.17*/("""max-width: 100vw;
                overflow: hidden;
                display: flex;
                flex-direction: column;
                flex-wrap: wrap;
            """),format.raw/*206.13*/("""}"""),format.raw/*206.14*/("""
            
    """),format.raw/*208.5*/("""</style>
<body onload="loadDataFromWrapper()">

    <form method="GET" action="/SearchPage">
        <div class="flex__row container">
            <input name="keyword" id="search__text" class="search__field" placeholder="Enter Search items"></input>
            <button  type="submit"  class="search__btn">GO!</button>
        </div>
    </form>


    <div class="layout-container">
        <div class="container-fluid">
        """),_display_(/*221.10*/if(searchResult != null && searchResult.size > 0)/*221.59*/{_display_(Seq[Any](format.raw/*221.60*/("""
            """),_display_(/*222.14*/for( (keyword, projectList:List[Project]) <- cacheData ) yield /*222.70*/{_display_(Seq[Any](format.raw/*222.71*/("""
                """),_display_(/*223.18*/if(keyword == searchedKeyword)/*223.48*/{_display_(Seq[Any](format.raw/*223.49*/("""
                    """),format.raw/*224.21*/("""<span>Search term is: """),_display_(/*224.44*/keyword),format.raw/*224.51*/("""  """),format.raw/*224.53*/("""Findex:"""),_display_(/*224.61*/{projectList.map(_.fIndex).sum/searchResult.size()}),format.raw/*224.112*/("""  """),format.raw/*224.114*/("""FKGL:"""),_display_(/*224.120*/{projectList.map(_.fkglIndex).sum/searchResult.size()}),format.raw/*224.174*/("""  """),format.raw/*224.176*/("""<a class="ml-2" href="/GlobalStatistics/"""),_display_(/*224.217*/searchedKeyword),format.raw/*224.232*/("""">GlobalStats</a></span>
                    
                """),_display_(/*226.18*/for((project,index) <- (projectList.zipWithIndex).reverse) yield /*226.76*/ {_display_(Seq[Any](format.raw/*226.78*/("""
                """),format.raw/*227.17*/("""<div class="flex__row__project">
                    
                    """),_display_(/*229.22*/{-(index-searchResult.size)}),format.raw/*229.50*/(""". <a class="ml-2" href="/owner_id/"""),_display_(/*229.85*/project/*229.92*/.owner_id),format.raw/*229.101*/("""">Owner ID </a>
                    <span class="ml-2">"""),_display_(/*230.41*/project/*230.48*/.time_submitted),format.raw/*230.63*/("""</span>
                    <span class="ml-2"><a href="https://www.freelancer.com/projects/"""),_display_(/*231.86*/project/*231.93*/.seo_url),format.raw/*231.101*/("""?w=f&ngsw-bypass=" target="_blank">"""),_display_(/*231.137*/project/*231.144*/.title),format.raw/*231.150*/("""</a>
                    </span>
                    <span class="ml-2">type:"""),_display_(/*233.46*/project/*233.53*/.project_type),format.raw/*233.66*/("""</span>
                    
                    <span class="ml-2">Educational Level: """),_display_(/*235.60*/project/*235.67*/.educationalStatus),format.raw/*235.85*/("""</span>
                    <span class="ml-2"> <a class="ml-2" href="/LocalStatistics/"""),_display_(/*236.81*/searchedKeyword),format.raw/*236.96*/("""/"""),_display_(/*236.98*/project/*236.105*/.id),format.raw/*236.108*/("""">LocalStats</a></span>
                    <span class="ml-2">Findex: """),_display_(/*237.49*/project/*237.56*/.fIndex),format.raw/*237.63*/("""</span>
                    <span class="ml-2">Skills: </span>
                        """),_display_(/*239.26*/for(skill <- (project.jobs)) yield /*239.54*/ {_display_(Seq[Any](format.raw/*239.56*/("""
                            """),format.raw/*240.29*/("""<a href ="/projectsBySkill?skillsName="""),_display_(/*240.68*/skill/*240.73*/.name),format.raw/*240.78*/("""&skillsID="""),_display_(/*240.89*/skill/*240.94*/.id),format.raw/*240.97*/("""" class="ml-2">"""),_display_(/*240.113*/skill/*240.118*/.name),format.raw/*240.123*/("""</a>
                        """)))}),format.raw/*241.26*/("""
        
                """),format.raw/*243.17*/("""</div>
            """)))}),format.raw/*244.14*/("""
                """)))}),format.raw/*245.18*/("""
                
            """)))}),format.raw/*247.14*/("""
           
        """)))}),format.raw/*249.10*/("""
"""),format.raw/*250.1*/("""</div>
    
        <div id="cacheContent">
        </div></div>
   
</body>
</html>"""))
      }
    }
  }

  def render(searchResult:List[wrapper.Project],request:play.mvc.Http.Request,searchedKeyword:String,cacheData:HashMap[String, List[wrapper.Project]],projectDataMap:HashMap[String, List[wrapper.Project]],globalPreviewDesc:String): play.twirl.api.HtmlFormat.Appendable = apply(searchResult,request,searchedKeyword,cacheData,projectDataMap,globalPreviewDesc)

  def f:((List[wrapper.Project],play.mvc.Http.Request,String,HashMap[String, List[wrapper.Project]],HashMap[String, List[wrapper.Project]],String) => play.twirl.api.HtmlFormat.Appendable) = (searchResult,request,searchedKeyword,cacheData,projectDataMap,globalPreviewDesc) => apply(searchResult,request,searchedKeyword,cacheData,projectDataMap,globalPreviewDesc)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/landingPage.scala.html
                  HASH: 05b7f5187af60dc637aa4fc17f03dfdabd16813f
                  MATRIX: 610->1|634->20|1096->47|1419->274|1451->280|1587->388|1616->389|1645->391|1689->408|1717->409|1746->411|1778->416|1806->417|1839->423|1885->442|1913->443|1942->445|1980->455|2009->456|2038->458|2127->520|2155->521|2184->523|2226->537|2255->538|2284->540|2398->627|2426->628|2455->630|2495->642|2524->643|2553->645|2723->788|2751->789|2780->791|2827->810|2856->811|2885->813|2959->860|2987->861|3016->863|3048->868|3076->869|3109->875|3154->893|3182->894|3211->896|3331->988|3360->989|3406->1007|3465->1039|3538->1096|3577->1097|3623->1116|3660->1144|3700->1146|3746->1165|3812->1222|3851->1223|3897->1241|4019->1336|4047->1343|4076->1344|4148->1389|4221->1441|4299->1492|4375->1547|4481->1626|4517->1641|4610->1707|4673->1754|4712->1755|4766->1781|4837->1825|4868->1835|4969->1909|4985->1916|5015->1925|5172->2055|5188->2062|5224->2077|5366->2192|5383->2199|5413->2207|5480->2246|5497->2253|5525->2259|5656->2363|5672->2370|5706->2383|5802->2452|5818->2459|5857->2477|5886->2478|6175->2740|6204->2747|6234->2749|6251->2756|6276->2759|6469->2925|6485->2932|6513->2939|6725->3124|6769->3152|6809->3154|6871->3188|6939->3229|6953->3234|6979->3239|7017->3250|7032->3255|7057->3258|7104->3277|7119->3282|7146->3287|7213->3323|7267->3349|7326->3377|7376->3399|7483->3468|7530->3486|7629->3556|7659->3557|7691->3561|7758->3599|7788->3600|7835->3618|7894->3648|7924->3649|7969->3665|8022->3689|8052->3690|8099->3708|8230->3810|8260->3811|8305->3827|8339->3832|8369->3833|8416->3851|8485->3891|8515->3892|8560->3908|8618->3937|8648->3938|8695->3956|8792->4024|8822->4025|8867->4041|8927->4072|8957->4073|9004->4091|9101->4159|9131->4160|9176->4176|9219->4190|9249->4191|9296->4209|9392->4276|9422->4277|9467->4293|9513->4310|9543->4311|9590->4329|9792->4502|9822->4503|9867->4519|9908->4531|9938->4532|9985->4550|10351->4887|10381->4888|10426->4904|10459->4908|10489->4909|10536->4927|10601->4963|10631->4964|10676->4980|10735->5010|10765->5011|10812->5029|10881->5069|10911->5070|10956->5086|11005->5106|11035->5107|11082->5125|11148->5162|11178->5163|11223->5179|11266->5193|11296->5194|11343->5212|11553->5393|11583->5394|11628->5410|11688->5441|11718->5442|11765->5460|11834->5500|11864->5501|11909->5517|11959->5538|11989->5539|12036->5557|12102->5594|12132->5595|12177->5611|12221->5626|12251->5627|12298->5645|12508->5826|12538->5827|12583->5843|12614->5845|12644->5846|12691->5864|12791->5935|12821->5936|12864->5950|12910->5967|12940->5968|12987->5986|13085->6055|13115->6056|13158->6070|13203->6086|13233->6087|13280->6105|13482->6278|13512->6279|13560->6299|14032->6743|14091->6792|14131->6793|14174->6808|14247->6864|14287->6865|14334->6884|14374->6914|14414->6915|14465->6937|14516->6960|14545->6967|14576->6969|14612->6977|14686->7028|14718->7030|14753->7036|14830->7090|14862->7092|14932->7133|14970->7148|15063->7213|15138->7271|15179->7273|15226->7291|15331->7368|15381->7396|15444->7431|15461->7438|15493->7447|15578->7504|15595->7511|15632->7526|15754->7620|15771->7627|15802->7635|15867->7671|15885->7678|15914->7684|16022->7764|16039->7771|16074->7784|16192->7874|16209->7881|16249->7899|16366->7988|16403->8003|16433->8005|16451->8012|16477->8015|16578->8088|16595->8095|16624->8102|16742->8192|16787->8220|16828->8222|16887->8252|16954->8291|16969->8296|16996->8301|17035->8312|17050->8317|17075->8320|17120->8336|17136->8341|17164->8346|17227->8377|17284->8405|17337->8426|17388->8445|17453->8478|17509->8502|17539->8504
                  LINES: 23->1|24->2|29->4|34->4|37->7|43->13|43->13|44->14|45->15|45->15|46->16|46->16|46->16|47->17|48->18|48->18|49->19|49->19|49->19|50->20|53->23|53->23|54->24|54->24|54->24|55->25|60->30|60->30|61->31|61->31|61->31|62->32|70->40|70->40|71->41|71->41|71->41|72->42|75->45|75->45|76->46|76->46|76->46|77->47|78->48|78->48|79->49|82->52|82->52|83->53|84->54|84->54|84->54|85->55|85->55|85->55|86->56|86->56|86->56|87->57|90->60|90->60|90->60|91->61|91->61|92->62|92->62|93->63|93->63|95->65|95->65|95->65|96->66|97->67|97->67|98->68|98->68|98->68|102->72|102->72|102->72|104->74|104->74|104->74|104->74|104->74|104->74|107->77|107->77|107->77|109->79|109->79|109->79|109->79|114->84|114->84|114->84|114->84|114->84|118->88|118->88|118->88|124->94|124->94|124->94|125->95|125->95|125->95|125->95|125->95|125->95|125->95|125->95|125->95|125->95|126->96|127->97|128->98|129->99|131->101|132->102|133->103|133->103|135->105|137->107|137->107|138->108|139->109|139->109|141->111|141->111|141->111|142->112|145->115|145->115|147->117|147->117|147->117|148->118|149->119|149->119|151->121|151->121|151->121|152->122|154->124|154->124|156->126|156->126|156->126|157->127|159->129|159->129|161->131|161->131|161->131|162->132|164->134|164->134|166->136|166->136|166->136|167->137|172->142|172->142|174->144|174->144|174->144|175->145|184->154|184->154|186->156|186->156|186->156|187->157|188->158|188->158|190->160|190->160|190->160|191->161|192->162|192->162|194->164|194->164|194->164|195->165|196->166|196->166|198->168|198->168|198->168|199->169|204->174|204->174|206->176|206->176|206->176|207->177|208->178|208->178|210->180|210->180|210->180|211->181|212->182|212->182|214->184|214->184|214->184|215->185|220->190|220->190|222->192|222->192|222->192|223->193|225->195|225->195|226->196|226->196|226->196|227->197|229->199|229->199|230->200|230->200|230->200|231->201|236->206|236->206|238->208|251->221|251->221|251->221|252->222|252->222|252->222|253->223|253->223|253->223|254->224|254->224|254->224|254->224|254->224|254->224|254->224|254->224|254->224|254->224|254->224|254->224|256->226|256->226|256->226|257->227|259->229|259->229|259->229|259->229|259->229|260->230|260->230|260->230|261->231|261->231|261->231|261->231|261->231|261->231|263->233|263->233|263->233|265->235|265->235|265->235|266->236|266->236|266->236|266->236|266->236|267->237|267->237|267->237|269->239|269->239|269->239|270->240|270->240|270->240|270->240|270->240|270->240|270->240|270->240|270->240|270->240|271->241|273->243|274->244|275->245|277->247|279->249|280->250
                  -- GENERATED --
              */
          