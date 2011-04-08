package poc.scalatra.inject

import com.google.inject.servlet.ServletModule
import poc.scalatra.service.BlipService


class MyServletModule extends ServletModule {

  override def configureServlets() {
    println("configureServlets - ENTER")
    serve("/blip/*").`with`(classOf[BlipService])
    println("configureServlets - LEAVE")
  }

}