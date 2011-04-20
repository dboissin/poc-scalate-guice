package poc.scalatra

import org.scalatra._

@com.google.inject.Singleton
class WebApp extends ScalatraServlet {
get("/hello") {
<html><head><title>Hello!</title></head><body><h1>Hello</h1></body></html>
}
}

