package com.qaprosoft.jenkins.pipeline

import com.qaprosoft.jenkins.pipeline.Configuration
import com.qaprosoft.scm.ISCM

public abstract class AbstractRunner {
	protected def context
	protected ISCM scmClient

	protected final def FACTORY_TARGET = "qps-pipeline/src/com/qaprosoft/jenkins/jobdsl/Factory.groovy"
	protected def additionalClasspath = "qps-pipeline/src"

	
	//this is very important line which should be declared only as a class member!
	protected Configuration configuration = new Configuration(context)
	
	public AbstractRunner(context) {
		this.context = context
	}

	//Methods
	abstract public void build()
	
	//Events
	abstract public void onPush()
	abstract public void onPullRequest()

	protected void printStackTrace(Exception e) {
//		context.println("exception: " + e.getMessage())
//		context.println("exception class: " + e.getClass().getName())
//		context.println("stacktrace: " + Arrays.toString(e.getStackTrace()))

        context.println "${e.getClass().getName()}: ${e.getMessage()}"
        e.getStackTrace().each { traceLine ->
            context.println "\tat " + traceLine
        }
	}
}
