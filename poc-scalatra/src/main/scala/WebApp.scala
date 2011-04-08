import org.scalatra._
 
class WebApp extends ScalatraServlet {
get("/hello") {
<html><head><title>Hello!</title></head><body><h1>Hello</h1></body></html>
}
}

