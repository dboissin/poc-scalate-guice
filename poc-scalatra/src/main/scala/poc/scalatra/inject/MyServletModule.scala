package poc.scalatra.inject

import com.google.inject.servlet.ServletModule
import poc.scalatra.service.BlipService
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer
import org.atmosphere.guice.GuiceManagedAtmosphereServlet
import poc.scalatra.resource.MessageResource
import poc.scalatra.WebApp

class MyServletModule extends ServletModule {

  override def configureServlets() {
    bind(classOf[MessageResource])


    serve("/blip/*").`with`(classOf[BlipService])

   // serve("/hello/*").`with`(classOf[WebApp])
    serve("/rest/*").`with`(classOf[GuiceContainer])
    serve("/async/*").`with`(classOf[GuiceManagedAtmosphereServlet])
  }

}