package main.java.es.deusto.client.remote;

import main.java.es.deusto.server.remote.IBankingSystemRemote;
import org.apache.log4j.Logger;

public class RMIServiceLocator {

	private IBankingSystemRemote remoteFacade;
	private static final Logger logger = Logger.getLogger(RMIServiceLocator.class);

	public void setService(String[] args) {

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		logger.info(name);
		
		try {
			this.remoteFacade = (IBankingSystemRemote) java.rmi.Naming.lookup(name);
		} catch (Exception ex) {

			logger.error("An error has happened while setting the service");
		}
	}

	public IBankingSystemRemote getService() {
		return this.remoteFacade;
	}
	
}
