Lift Filter for use with CloudBees
==================================

When running a Lift application on CloudBees the Lift `run.mode` will default to "development".  This servlet filter will set the `run.mode` based on the value set in the `cloudbees-web.xml` configuration, defaulting to development if not set.

This means a local `container:start` will default to development mode, but a CloudBees deployment will default to production mode (or whatever value you put in the `WEB-INF/cloudbees-web.xml` file).

To use
======

There are three modifications you need to make to your Lift application
based on the contents of this repository.

First, copy the `src/main/scala/net.liftmodules.cloudbees.servlet/CloudBeesLiftFilter.scala` from this project into  your project.

Next, modify your `src/main/webapp/WEB-INF/web.xml` to remove this line...

    <filter-class>net.liftweb.http.LiftFilter</filter-class>

...and replace it with this line:

    <filter-class>net.liftmodules.cloudbees.servlet.CloudBeesLiftFilter</filter-class> 

 Finally, if you already have `src/main/webapp/WEB-INF/cloudbees-web.xml` then add the following lines after the `appid`:

     <context-param>
       <param-name>run.mode</param-name>
       <param-value>production</param-value>
     </context-param>

If you don't have a `cloudbees-web.xml`, copy the example one from this repository.

Bonus step!

You may need to add the Servlet API as a dependency in your SBT build file if you don't already have it:

    "javax.servlet" % "servlet-api" % "2.5" % "provided->default"
   
Running this project
====================

This git repository contains a Lift application. Run it via:

    $ sbt
    > container:start

 Open http://127.0.0.1:8080/ to see the report: "Your run mode is development".  

Run it via a CloudBees on in your local bees environment:

	$ sbt package
    $ bees app:run ./target/scala-2.9.1/cloudbees-lift-filter_2.9.1-0.1-SNAPSHOT.war

..and it'll report "Your run mode is Production".
 

Links
=====

* [Tim's original solution](http://groups.google.com/group/liftweb/browse_thread/thread/93f315f98641a63b/5149cd4b4efe49c2?lnk=gst&q=run+mode#5149cd4b4efe49c2)
  
* [CloudBees documentation](https://cloudbees.zendesk.com/entries/459274)

