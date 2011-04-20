package poc.scalatra.inject

import com.google.inject.{Injector, Guice}
import com.google.inject.servlet.GuiceServletContextListener



class MyGuiceServletConfig extends GuiceServletContextListener {

  override def contextInitialized(servletContextEvent: javax.servlet.ServletContextEvent) = {
    getInjector()
  }

  override def getInjector():Injector = {
    Guice.createInjector(new MyServletModule());
  }


}