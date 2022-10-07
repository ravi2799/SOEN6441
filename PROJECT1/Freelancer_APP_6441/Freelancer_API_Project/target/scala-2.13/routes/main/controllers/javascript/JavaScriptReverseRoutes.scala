// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:9
package controllers.javascript {

  // @LINE:9
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def tutorial: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.tutorial",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tutorial"})
        }
      """
    )
  
    // @LINE:18
    def renderlocalStats: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.renderlocalStats",
      """
        function(keyword0,projectid1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "LocalStatistics/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("keyword", keyword0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("projectid", projectid1))})
        }
      """
    )
  
    // @LINE:17
    def renderStats: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.renderStats",
      """
        function(keyword0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "GlobalStatistics/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("keyword", keyword0))})
        }
      """
    )
  
    // @LINE:12
    def searchProjectsPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.searchProjectsPage",
      """
        function(keyword0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "SearchPage" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("keyword", keyword0)])})
        }
      """
    )
  
    // @LINE:14
    def clearSession: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.clearSession",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "clearSession"})
        }
      """
    )
  
    // @LINE:16
    def ownerInfoPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ownerInfoPage",
      """
        function(owner_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "owner_id/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("owner_id", owner_id0))})
        }
      """
    )
  
    // @LINE:10
    def explore: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.explore",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "explore"})
        }
      """
    )
  
    // @LINE:15
    def searchBySkills: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.searchBySkills",
      """
        function(skillsName0,skillsID1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projectsBySkill" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("skillsName", skillsName0), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("skillsID", skillsID1)])})
        }
      """
    )
  
    // @LINE:9
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:21
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
