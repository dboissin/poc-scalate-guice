package poc.scalatra.service

import javax.servlet.http.{HttpServletRequest, HttpServletResponse, HttpServlet}

@com.google.inject.Singleton
class BlipService extends HttpServlet {


  override def doGet(request: HttpServletRequest, response: HttpServletResponse) = response.getWriter().println("BlipService")


}