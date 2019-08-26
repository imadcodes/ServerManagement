package com.server.admin.ServerAdmin;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest{
	
	public static final String filePath = "src/main/resources/test.txt";
	public static ServerManager serverManager;
	
	@BeforeClass
	public static void initFile() {
		File testFile = new File(filePath);
		serverManager = new ServerManager(testFile);
	}
	
	@Test
	public void testGetTopServer(){
		String result = serverManager.getTopServer();
		assertEquals("garak", result);
	}
	
	@Test
	public void testGetListServersConnectedTo() {
		List<String> result = serverManager.getListServersConnectedTo("garak");
		List<String> actual = Arrays.asList("quark", "lilac");
		assertEquals(2, result.size());
		assertThat(actual, is(result));
	}
	@Test
	public void tesGetListServersConnectedFrom() {
		List<String> result = serverManager.getListServersConnectedFrom("lilac");
		List<String> actual = Arrays.asList("garak");
		assertEquals(1, result.size());
		assertThat(actual, is(result));
	}
	

}
