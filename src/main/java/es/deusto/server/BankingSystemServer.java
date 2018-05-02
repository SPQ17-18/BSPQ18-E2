package main.java.es.deusto.server;

import java.rmi.Naming;
import java.rmi.Remote;
import org.apache.log4j.Logger;

import main.java.es.deusto.server.remote.BankingSystemRemote;
import main.java.es.deusto.server.remote.IBankingSystemRemote;

import java.rmi.Naming;

@SuppressWarnings("deprecation")
public class BankingSystemServer {
	
	private static final Logger logger = Logger.getLogger(BankingSystemServer.class);
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		if (args.length != 3) {
			logger.info("How to invoke: java [policy] [codebase] Server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
	
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			
			IBankingSystemRemote objServer = new BankingSystemRemote();
			Naming.rebind(name,objServer);
			logger.info("Deusto BankingSystemServer '" + name + "' active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			String line  = stdin.readLine();
		} catch (Exception e) {
			logger.error("Messager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
