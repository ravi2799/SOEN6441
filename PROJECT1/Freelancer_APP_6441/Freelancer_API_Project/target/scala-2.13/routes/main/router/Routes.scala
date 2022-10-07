// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:9
  HomeController_1: controllers.HomeController,
  // @LINE:21
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:9
    HomeController_1: controllers.HomeController,
    // @LINE:21
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """explore""", """controllers.HomeController.explore"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tutorial""", """controllers.HomeController.tutorial"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """SearchPage""", """controllers.HomeController.searchProjectsPage(request:Request, keyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """clearSession""", """controllers.HomeController.clearSession(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projectsBySkill""", """controllers.HomeController.searchBySkills(request:Request, skillsName:String, skillsID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """owner_id/""" + "$" + """owner_id<[^/]+>""", """controllers.HomeController.ownerInfoPage(owner_id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """GlobalStatistics/""" + "$" + """keyword<[^/]+>""", """controllers.HomeController.renderStats(keyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """LocalStatistics/""" + "$" + """keyword<[^/]+>/""" + "$" + """projectid<[^/]+>""", """controllers.HomeController.renderlocalStats(keyword:String, projectid:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:9
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.index(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_explore1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("explore")))
  )
  private[this] lazy val controllers_HomeController_explore1_invoker = createInvoker(
    HomeController_1.explore,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "explore",
      Nil,
      "GET",
      this.prefix + """explore""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_tutorial2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tutorial")))
  )
  private[this] lazy val controllers_HomeController_tutorial2_invoker = createInvoker(
    HomeController_1.tutorial,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "tutorial",
      Nil,
      "GET",
      this.prefix + """tutorial""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_searchProjectsPage3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("SearchPage")))
  )
  private[this] lazy val controllers_HomeController_searchProjectsPage3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.searchProjectsPage(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "searchProjectsPage",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """SearchPage""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_clearSession4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("clearSession")))
  )
  private[this] lazy val controllers_HomeController_clearSession4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.clearSession(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "clearSession",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """clearSession""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_searchBySkills5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projectsBySkill")))
  )
  private[this] lazy val controllers_HomeController_searchBySkills5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.searchBySkills(fakeValue[play.mvc.Http.Request], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "searchBySkills",
      Seq(classOf[play.mvc.Http.Request], classOf[String], classOf[String]),
      "GET",
      this.prefix + """projectsBySkill""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_ownerInfoPage6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("owner_id/"), DynamicPart("owner_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_ownerInfoPage6_invoker = createInvoker(
    HomeController_1.ownerInfoPage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ownerInfoPage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """owner_id/""" + "$" + """owner_id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_renderStats7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("GlobalStatistics/"), DynamicPart("keyword", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_renderStats7_invoker = createInvoker(
    HomeController_1.renderStats(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "renderStats",
      Seq(classOf[String]),
      "GET",
      this.prefix + """GlobalStatistics/""" + "$" + """keyword<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HomeController_renderlocalStats8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("LocalStatistics/"), DynamicPart("keyword", """[^/]+""",true), StaticPart("/"), DynamicPart("projectid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_renderlocalStats8_invoker = createInvoker(
    HomeController_1.renderlocalStats(fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "renderlocalStats",
      Seq(classOf[String], classOf[Int]),
      "GET",
      this.prefix + """LocalStatistics/""" + "$" + """keyword<[^/]+>/""" + "$" + """projectid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Assets_versioned9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned9_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:9
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(
          req => HomeController_1.index(req))
      }
  
    // @LINE:10
    case controllers_HomeController_explore1_route(params@_) =>
      call { 
        controllers_HomeController_explore1_invoker.call(HomeController_1.explore)
      }
  
    // @LINE:11
    case controllers_HomeController_tutorial2_route(params@_) =>
      call { 
        controllers_HomeController_tutorial2_invoker.call(HomeController_1.tutorial)
      }
  
    // @LINE:12
    case controllers_HomeController_searchProjectsPage3_route(params@_) =>
      call(params.fromQuery[String]("keyword", None)) { (keyword) =>
        controllers_HomeController_searchProjectsPage3_invoker.call(
          req => HomeController_1.searchProjectsPage(req, keyword))
      }
  
    // @LINE:14
    case controllers_HomeController_clearSession4_route(params@_) =>
      call { 
        controllers_HomeController_clearSession4_invoker.call(
          req => HomeController_1.clearSession(req))
      }
  
    // @LINE:15
    case controllers_HomeController_searchBySkills5_route(params@_) =>
      call(params.fromQuery[String]("skillsName", None), params.fromQuery[String]("skillsID", None)) { (skillsName, skillsID) =>
        controllers_HomeController_searchBySkills5_invoker.call(
          req => HomeController_1.searchBySkills(req, skillsName, skillsID))
      }
  
    // @LINE:16
    case controllers_HomeController_ownerInfoPage6_route(params@_) =>
      call(params.fromPath[String]("owner_id", None)) { (owner_id) =>
        controllers_HomeController_ownerInfoPage6_invoker.call(HomeController_1.ownerInfoPage(owner_id))
      }
  
    // @LINE:17
    case controllers_HomeController_renderStats7_route(params@_) =>
      call(params.fromPath[String]("keyword", None)) { (keyword) =>
        controllers_HomeController_renderStats7_invoker.call(HomeController_1.renderStats(keyword))
      }
  
    // @LINE:18
    case controllers_HomeController_renderlocalStats8_route(params@_) =>
      call(params.fromPath[String]("keyword", None), params.fromPath[Int]("projectid", None)) { (keyword, projectid) =>
        controllers_HomeController_renderlocalStats8_invoker.call(HomeController_1.renderlocalStats(keyword, projectid))
      }
  
    // @LINE:21
    case controllers_Assets_versioned9_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned9_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
