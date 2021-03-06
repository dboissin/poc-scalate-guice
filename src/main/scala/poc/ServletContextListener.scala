package poc

import org.fusesource.scalate.guice.ScalateModule
import com.google.inject.servlet.GuiceServletContextListener
import com.google.inject.Guice
import poc.service.impl.TimetableServiceImpl
import poc.service.TimetableService
import poc.schema.BootStrap

class ServletContextListener extends GuiceServletContextListener {
  def getInjector = Guice.createInjector(new ScalateModule() {

    override def configureServlets() = {
    	super.configureServlets
    	
    	BootStrap.testBootStrapDB
    	
    	bind(classOf[TimetableService]).to(classOf[TimetableServiceImpl])
    }
    
    override def resourcePackageNames = "poc.resources" :: "org.codehaus.jackson.jaxrs" :: super.resourcePackageNames
    
  })
}
