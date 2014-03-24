package com.dianping.service.echo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.unidal.test.jetty.JettyServer;

@RunWith(JUnit4.class)
public class TestServerForClient extends JettyServer {
	public static void main(String[] args) throws Exception {
		TestServerForClient server = new TestServerForClient();

		System.setProperty("devMode", "true");
		server.startServer();
		server.startWebApp();
		server.stopServer();
	}

	@Before
	public void before() throws Exception {
		System.setProperty("devMode", "true");
		super.startServer();
	}

	@Override
	protected String getContextPath() {
		return "/echo";
	}

	@Override
	protected int getServerPort() {
		return 8082;
	}

	@Test
	public void startWebApp() throws Exception {
		// open the page in the default browser
		display("/echo/echoServlet");
		waitForAnyKey();
	}
}
