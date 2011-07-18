package poc

import _root_.com.google.inject.Guice
import _root_.com.google.inject.servlet.GuiceServletContextListener
import _root_.org.fusesource.scalate.guice.ScalateModule
import poc.service.TimetableService
import poc.service.impl.TimetableServiceImpl

class ServletContextListener extends GuiceServletContextListener {
  def getInjector = Guice.createInjector(new ScalateModule() {

    override def configureServlets() = {
    	super.configureServlets
    	bind(classOf[TimetableService]).to(classOf[TimetableServiceImpl])
    }
    
    override def resourcePackageNames = "poc.resources" :: super.resourcePackageNames
    
  })
}
