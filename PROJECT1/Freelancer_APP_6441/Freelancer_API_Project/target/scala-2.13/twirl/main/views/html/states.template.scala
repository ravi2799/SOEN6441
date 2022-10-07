
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

object states extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Map[String, Integer],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(IssueMap : Map[String, Integer]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.35*/("""
"""),format.raw/*2.1*/("""<html>
<head>
<style>
#issueTab """),format.raw/*5.11*/("""{"""),format.raw/*5.12*/("""
  """),format.raw/*6.3*/("""font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 45%;
"""),format.raw/*9.1*/("""}"""),format.raw/*9.2*/("""

"""),format.raw/*11.1*/("""#issueTab td, #issueTab th """),format.raw/*11.28*/("""{"""),format.raw/*11.29*/("""
  """),format.raw/*12.3*/("""border: 1px solid #ddd;
  padding: 8px;
"""),format.raw/*14.1*/("""}"""),format.raw/*14.2*/("""

"""),format.raw/*16.1*/("""#issueTab tr:nth-child(even)"""),format.raw/*16.29*/("""{"""),format.raw/*16.30*/("""background-color: #f2f2f2;"""),format.raw/*16.56*/("""}"""),format.raw/*16.57*/("""

"""),format.raw/*18.1*/("""#issueTab tr:hover """),format.raw/*18.20*/("""{"""),format.raw/*18.21*/("""background-color: #ddd;"""),format.raw/*18.44*/("""}"""),format.raw/*18.45*/("""

"""),format.raw/*20.1*/("""#issueTab th """),format.raw/*20.14*/("""{"""),format.raw/*20.15*/("""
  """),format.raw/*21.3*/("""padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
"""),format.raw/*26.1*/("""}"""),format.raw/*26.2*/("""
"""),format.raw/*27.1*/("""</style>
</head>

<body>
<!--<h3>Hello There</h3>-->
<h3>This is the issue statistic page of the repository.</h3>

<center>
<h1>Issue Statistics</h1>
<div>
<table id = "issueTab">
	<tr>
		<th>Word</th>
		<th>Count</th>
	</tr>
"""),_display_(/*42.2*/for((issue, count) <- IssueMap) yield /*42.33*/{_display_(Seq[Any](format.raw/*42.34*/("""
	"""),_display_(/*43.3*/if(count != 0)/*43.17*/{_display_(Seq[Any](format.raw/*43.18*/("""
		"""),format.raw/*44.3*/("""<tr>
			<td>"""),_display_(/*45.9*/issue),format.raw/*45.14*/("""</th>
			<td>"""),_display_(/*46.9*/count),format.raw/*46.14*/("""</th>
		</tr>
	""")))}),format.raw/*48.3*/("""
""")))}),format.raw/*49.2*/("""
"""),format.raw/*50.1*/("""</table>
</div>
</center>
</body>
</html>"""))
      }
    }
  }

  def render(IssueMap:Map[String, Integer]): play.twirl.api.HtmlFormat.Appendable = apply(IssueMap)

  def f:((Map[String, Integer]) => play.twirl.api.HtmlFormat.Appendable) = (IssueMap) => apply(IssueMap)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/states.scala.html
                  HASH: 9ce910c0d28753c5ca24ce41f5db48bfaa10392b
                  MATRIX: 922->1|1050->34|1078->36|1140->71|1168->72|1198->76|1313->165|1340->166|1371->170|1426->197|1455->198|1486->202|1555->244|1583->245|1614->249|1670->277|1699->278|1753->304|1782->305|1813->309|1860->328|1889->329|1940->352|1969->353|2000->357|2041->370|2070->371|2101->375|2241->488|2269->489|2298->491|2566->733|2613->764|2652->765|2682->769|2705->783|2744->784|2775->788|2815->802|2841->807|2882->822|2908->827|2956->845|2989->848|3018->850
                  LINES: 27->1|32->1|33->2|36->5|36->5|37->6|40->9|40->9|42->11|42->11|42->11|43->12|45->14|45->14|47->16|47->16|47->16|47->16|47->16|49->18|49->18|49->18|49->18|49->18|51->20|51->20|51->20|52->21|57->26|57->26|58->27|73->42|73->42|73->42|74->43|74->43|74->43|75->44|76->45|76->45|77->46|77->46|79->48|80->49|81->50
                  -- GENERATED --
              */
          