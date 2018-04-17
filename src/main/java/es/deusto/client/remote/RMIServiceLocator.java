package main.java.es.deusto.client.remote;
import main.java.es.deusto.server.remote.IBankingSystemRemote;
public class RMIServiceLocator {

	private IBankingSystemRemote remoteFacade;

	public void setService(String[] args) {

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		System.out.println(name);
		
		try {
			this.remoteFacade = (IBankingSystemRemote) java.rmi.Naming.lookup(name);
		} catch (Exception ex) {

			System.out.println("An error has happened while setting the service");
		}
	}

	public IBankingSystemRemote getService() {
		return this.remoteFacade;
	}
	
}
