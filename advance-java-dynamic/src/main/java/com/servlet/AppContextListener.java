package com.servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

@WebListener
public class AppContextListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce) {
        // Shutdown cleanup thread from MySQL Connector
		AbandonedConnectionCleanupThread.checkedShutdown();
        System.out.println("Application is stopping, and MySQL resources are cleaned up.");
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application is starting.");
    }
}
