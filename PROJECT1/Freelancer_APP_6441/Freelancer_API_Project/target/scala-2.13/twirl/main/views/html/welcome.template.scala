
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

object welcome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(firstName: String, lastName: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.39*/("""

"""),_display_(/*3.2*/main("Welcome")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""


"""),format.raw/*6.1*/("""<p>Welcome """),_display_(/*6.13*/firstName),format.raw/*6.22*/(""" """),_display_(/*6.24*/lastName),format.raw/*6.32*/("""</p>

""")))}))
      }
    }
  }

  def render(firstName:String,lastName:String): play.twirl.api.HtmlFormat.Appendable = apply(firstName,lastName)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (firstName,lastName) => apply(firstName,lastName)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/welcome.scala.html
                  HASH: bed89d26d440dc60d0d7baaccc017a0dc77b5b88
                  MATRIX: 916->1|1048->38|1078->43|1101->58|1140->60|1172->66|1210->78|1239->87|1267->89|1295->97
                  LINES: 27->1|32->1|34->3|34->3|34->3|37->6|37->6|37->6|37->6|37->6
                  -- GENERATED --
              */
          