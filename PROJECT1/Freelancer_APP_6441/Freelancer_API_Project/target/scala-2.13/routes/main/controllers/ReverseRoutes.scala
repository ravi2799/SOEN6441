// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:9
package controllers {

  // @LINE:9
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def tutorial: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tutorial")
    }
  
    // @LINE:18
    def renderlocalStats(keyword:String, projectid:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "LocalStatistics/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("keyword", keyword)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("projectid", projectid)))
    }
  
    // @LINE:17
    def renderStats(keyword:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "GlobalStatistics/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("keyword", keyword)))
    }
  
    // @LINE:12
    def searchProjectsPage(keyword:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "SearchPage" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("keyword", keyword)))))
    }
  
    // @LINE:14
    def clearSession(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "clearSession")
    }
  
    // @LINE:16
    def ownerInfoPage(owner_id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "owner_id/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("owner_id", owner_id)))
    }
  
    // @LINE:10
    def explore: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "explore")
    }
  
    // @LINE:15
    def searchBySkills(skillsName:String, skillsID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projectsBySkill" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("skillsName", skillsName)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("skillsID", skillsID)))))
    }
  
    // @LINE:9
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:21
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
