package controllers

import play.api.data.Forms._
import play.api.data._
import play.api.libs.json.Json
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  val loginForm = Form(
    tuple(
      "username" -> text,
      "password" -> nonEmptyText
    )
  )

  def login = Action { implicit request =>
    val (username, password) = loginForm.bindFromRequest.get
    if (username == "lrh" && password == "111")
      Ok(Json.toJson("Token"))
    else
      BadRequest
  }
}