package net.liftmodules.cloudbees.servlet { 

import javax.servlet._ 
import javax.servlet.http._ 

import net.liftweb.http.LiftFilter 

//Based on http://groups.google.com/group/liftweb/browse_thread/thread/93f315f98641a63b/5149cd4b4efe49c2?lnk=gst&q=run+mode#5149cd4b4efe49c2
class CloudBeesLiftFilter extends LiftFilter { 
			
  private def run_mode_set_? = (null != System.getProperty("run.mode"))

  private def run_mode_from(config: FilterConfig) = Option(config.getServletContext.getInitParameter("run.mode"))

	override def init(config: FilterConfig) { 
		if (!run_mode_set_?) {
			val mode = run_mode_from(config) getOrElse "development"
			System.setProperty("run.mode", mode)
		}
		super.init(config) 
	} 
} 




}