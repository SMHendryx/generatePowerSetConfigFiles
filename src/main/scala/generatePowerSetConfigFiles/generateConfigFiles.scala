import com.typesafe.config.ConfigFactory
import utils.Texter
import java.io.File

object genConfigFiles extends App {
  // Read in config file as string from first argument: 
  val configString = Texter.read(args(0))
  //println(configString)
  // Extract featureFamilies complete set using regex pattern matching:
  /*val pattern = "featureFamilies\\s*=\\s*\\[(.*)\\]".r
  pattern.findFirstIn(configString) match {
    case Some(featureFamilyString) => println("Found featureFamily string set.  The match was: " + featureFamilyString)
    case None => println("No matches found.")
  }
  */
  // ^ That's tough, let's just hard code the featureFamilies set for now:
  val featureFamilies = Set[String]("Dependency", "NegationProperty", "Phi", "POS", "Positional", "Tails")
  
  for (featureFamilySubset <- featureFamilies.subsets){
    // build featureFamilies subset string (using StringBuilder);
    val sb = new StringBuilder
    sb ++= """featureFamilies = [""""
    //featureFamilySubset.foreach(println)
    for (featureFamily <- featureFamilySubset){
      var i = 1
      sb ++= featureFamily
      if (i < featureFamilySubset.size){
        sb ++= """", """"
      } else{
        sb ++= """"]"""
      }
    i += 1
    }
    print(sb.toString)
  }


  //println(featureFamilies)
}
