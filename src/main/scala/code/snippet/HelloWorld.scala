package code
package snippet

import net.liftweb.util._
import net.liftweb.common._
import Helpers._

import Props.RunModes._

class HelloWorld {

  def runmode = "#mode-name *" #> Props.mode.toString

}

