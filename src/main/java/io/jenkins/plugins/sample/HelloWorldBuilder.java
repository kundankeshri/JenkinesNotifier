package io.jenkins.plugins.sample;

import java.util.Iterator;

import hudson.Extension;
import hudson.model.AbstractBuild;
import hudson.model.Action;
import hudson.model.TaskListener;
import hudson.model.listeners.RunListener;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Notifier;

public class HelloWorldBuilder extends Notifier {
	  
	@Extension
	static public class BuildListener extends RunListener<AbstractBuild> {

	  @Override
	  public void onStarted(AbstractBuild abstractBuild, TaskListener listener) {
		  listener.error("kundan Kumar");
		  abstractBuild.addAction(new Action() {

			@Override
			public String getIconFileName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getDisplayName() {
				// TODO Auto-generated method stub
				return "Plugin Test For Jenkins";
			}

			@Override
			public String getUrlName() {
				// TODO Auto-generated method stub
				return "www.google.com";
			}
		  
		  });
	  }

	 @Override
	  public void onCompleted(AbstractBuild abstractBuild, TaskListener listener) {
		 Iterator<Action> ie = abstractBuild.getActions().iterator();
		 while(ie.hasNext()) {
			 listener.error(ie.next().getDisplayName());
		 }
		
	    // new BuildListener().onCompleted(abstractBuild, listener);
	  }

	}

	@Override
	public BuildStepMonitor getRequiredMonitorService() {
		// TODO Auto-generated method stub
		return null;
	}
	  
   
}

