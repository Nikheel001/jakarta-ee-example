package com.headshot.dbfirstjpatry;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.headshot.dbfirstjpatry.entities.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 
 * @author nikheel.patel
 *
 */
public class Main {

	static Logger log = Logger.getLogger(Main.class.getName());
	static Handler h = new ConsoleHandler();
	static Formatter f = new Formatter() {
		@Override
		public String format(LogRecord record) {
			return String.format(" %s : %s : %s %s", Thread.currentThread().getName(), record.getMessage(),
					new Date(record.getMillis()), System.lineSeparator());
		}
	};

	static EntityManagerFactory entityManagerFactory;
	static EntityManager entityManager;

	public static void init() {
		// set logger config
		log.setUseParentHandlers(false);
		h.setFormatter(f);
		log.addHandler(h);

		loadDbConfig("mysql.properties");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public static void loadDbConfig(String configPropFile) {
		Properties config = new Properties();
		try (InputStream input = Main.class.getClassLoader().getResourceAsStream(configPropFile)) {
			if (input != null) {
				config.load(input);
			} else {
				System.err.println("default dbconfig file not found");
			}
		} catch (IOException e) {
			System.err.println("check default dbconfig file access permission");
		}
		entityManagerFactory = Persistence.createEntityManagerFactory("dbfirstjpatry", config);
		log.info("EMF configs|properties");
		entityManagerFactory.getProperties().forEach((i, j) -> {
			log.info(String.format("%s : %s%s", i, j, System.lineSeparator()));
		});
	}

	public static void main(String[] args) {
		init();
		
		entityManager.getTransaction().begin();
		
		Category c = new Category();
		c.setName("MutualFundDividend");
		entityManager.persist(c);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}