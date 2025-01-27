package com.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Shutdown cleanup thread from MySQL Connector
		AbandonedConnectionCleanupThread.checkedShutdown();
        System.out.println("Application is stopping, and MySQL resources are cleaned up.");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application is starting.");
    }
}
