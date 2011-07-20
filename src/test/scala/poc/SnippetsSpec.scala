package poc


import poc.resources.Snippets
import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test
import org.junit.Before
import java.util.Date

class SnippetsSpec extends AssertionsForJUnit {
  
  @Test def verifyGenateTabletime() {
    println(Snippets.generateTimetable(new Date())) 
  }
   
}