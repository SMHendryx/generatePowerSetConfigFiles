import com.typesafe.config.ConfigFactory
import utils.Texter
import java.io.File

object genConfigFiles extends App {
    val config =
      // Assumes path to which output should be written is the first argument.  Optional second argument is an alternate application.conf file.
      // If args only contain output path:
      if (args.length == 1) ConfigFactory.load()
      // else, specifying config file as second argument:
      else ConfigFactory.parseFile(new File(args(1))).resolve()

    val featureFamiliesList = config.getStringList("contextCrossValidation.featureFamilies")
    print(config.root.render())
    //print(config.toString())
}
