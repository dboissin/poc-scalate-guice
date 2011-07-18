package poc


import poc.resources.Snippets
import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test
import org.junit.Before

class SnippetsSpec extends AssertionsForJUnit {
  
  @Test def verifyGenateTabletime() {
    println(Snippets.generateTimetable(2011, 7, 18)) 
  }
   
}