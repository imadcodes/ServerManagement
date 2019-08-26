package com.server.admin.ServerAdmin;

import java.io.File;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		File f = new File("src/main/resources/test.txt");
		ServerManager s = new ServerManager(f);
		s.showConnections();
	    System.out.println(s.getTopServer());
	    System.out.println(s.getListServersConnectedTo("garak"));
	    System.out.println(s.getListServersConnectedFrom("lilac"));
	}
}
