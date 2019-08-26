package com.server.admin.ServerAdmin;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServerManager {
	List<Connection> connectionList;
	String TopServer;

	public ServerManager(File f) {
		this.connectionList = readConnectionsFromFile(f);
	}

	/**
	 * read connection traced in specific file f
	 */
	private List<Connection> readConnectionsFromFile(File f) {
		List<Connection> connections = new ArrayList<Connection>();
		try (FileInputStream inputStream = new FileInputStream(f)) {
			Scanner sc = new Scanner(inputStream, "UTF-8");
			LocalDateTime date = LocalDateTime.now();
			while (sc.hasNextLine()) {
				Connection c = new Connection();
				String line = sc.nextLine();
				String[] array = line.split(" ");
				c.setId(array[0]);
				c.setSourceServer(array[1]);
				c.setTargetServer(array[2]);
				c.setDate(date);
				date = date.plusMinutes(5);
				connections.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connections;
	}

	/**
	 * show all connections
	 */
	public void showConnections() {
		connectionList.forEach(System.out::println);

	}

	/**
	 * the server that generated the most connections during this time
	 */
	public String getTopServer() {
		Map<String, Long> counting = connectionList.stream()
				.collect(Collectors.groupingBy(Connection::getTargetServer, Collectors.counting()));
		Long max = counting.values().stream().max(Comparator.comparing(a -> a)).get();

		counting.forEach((index, value) -> {
			if (value == max) {
				TopServer = index;
			}

		});
		return TopServer;
	}

	/**
	 * the list of servers that have been connected to a given server during this
	 * 
	 * @param target
	 */
	public List<String> getListServersConnectedTo(String target) {
		return connectionList.stream().filter(s -> s.getTargetServer().equals(target)).map(s -> s.getSourceServer())
				.collect(Collectors.toList());
	}

	/**
	 * the list of servers that a particular server connected to during this
	 * 
	 * @param source
	 */
	public List<String> getListServersConnectedFrom(String source) {
		return connectionList.stream().filter(s -> s.getSourceServer().equals(source)).map(s -> s.getTargetServer())
				.collect(Collectors.toList());
	}

}
