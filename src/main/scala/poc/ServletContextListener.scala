package poc

import org.fusesource.scalate.guice.ScalateModule

import com.google.inject.servlet.GuiceServletContextListener
import com.google.inject.Guice

import poc.service.impl.TimetableServiceImpl
import poc.service.TimetableService

class ServletContextListener extends GuiceServletContextListener {
  def getInjector = Guice.createInjector(new ScalateModule() {

    override def configureServlets() = {
    	super.configureServlets
    	bind(classOf[TimetableService]).to(classOf[TimetableServiceImpl])
//    	bind(classOf[MessageBodyReader[Object]]).to(classOf[JacksonJsonProvider])
//        bind(classOf[MessageBodyWriter[Object]]).to(classOf[JacksonJsonProvider])
    }
    
    override def resourcePackageNames = "poc.resources" :: "org.codehaus.jackson.jaxrs" :: super.resourcePackageNames
    
  })
}
