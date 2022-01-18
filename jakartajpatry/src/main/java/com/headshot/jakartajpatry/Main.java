package com.headshot.jakartajpatry;

import java.io.IOException;
import java.io.InputStream;
//import java.util.HashMap;
import java.util.Properties;

import com.headshot.jakartajpatry.entities.Appuser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 
 * @author nikheel.patel
 *
 */
public class Main {

	static EntityManagerFactory entityManagerFactory;
	static EntityManager entityManager;

//	public static void init2() {
//		entityManagerFactory = Persistence.createEntityManagerFactory("jakartajpatry");
//		entityManager = entityManagerFactory.createEntityManager();
//	}

	public static void init() {
//		loadHsqlConfig();
		loadDbConfig();
		entityManager = entityManagerFactory.createEntityManager();
//		System.out.println(entityManager.getProperties());
	}

	public static void loadDbConfig() {
		Properties config = new Properties();
		try (InputStream input = Main.class.getClassLoader()
				.getResourceAsStream("jakartaeedatasource.properties")) {
			if (input != null) {
				config.load(input);
			} else {
				System.err.println("default dbconfig file not found");
			}
		} catch (IOException e) {
			System.err.println("check default dbconfig file access permission");
		}
		entityManagerFactory = Persistence.createEntityManagerFactory("jakartajpatry", config);
		System.out.println("===========================================================");
		entityManagerFactory.getProperties().forEach((i, j) -> {
			System.out.printf("%s : %s%s", i, j, System.lineSeparator());
		});
		System.out.println("===========================================================");
	}

//	/**
//	 * <properties> <property name="jakarta.persistence.jdbc.driver" value=
//	 * "org.hsqldb.jdbcDriver" />
//	 * <property name="jakarta.persistence.jdbc.url" value=
//	 * "jdbc:hsqldb:file:target/myDB;shutdown=true" />
//	 * <property name="jakarta.persistence.jdbc.user" value="user" />
//	 * <property name="jakarta.persistence.jdbc.password" value="password" />
//	 * <property name="jakarta.persistence.schema-generation.database.action" value=
//	 * "create" /> </properties>
//	 */
//	public static void loadHsqlConfig() {
//		HashMap<String, String> config = new HashMap<String, String>();
//		config.put("jakarta.persistence.jdbc.driver", "org.hsqldb.jdbcDriver");
//		config.put("jakarta.persistence.jdbc.url", "jdbc:hsqldb:file:target/myDB;shutdown=true");
//		config.put("jakarta.persistence.jdbc.user", "user");
//		config.put("jakarta.persistence.jdbc.password", "password");
//		config.put("jakarta.persistence.schema-generation.database.action", "create");
//		entityManagerFactory = Persistence.createEntityManagerFactory("jakartajpatry", config);
////		System.out.println(entityManagerFactory.getProperties());
//	}

	public static void main(String[] args) {

		init();
		// check xml file

		entityManager.getTransaction().begin();
		insertOne();
		entityManager.getTransaction().commit();
		printOne();
		entityManager.close();
		entityManagerFactory.close();
	}

	static void printOne() {
		Long key = 1L;
		Appuser user = entityManager.find(Appuser.class, key);
		if (user != null) {
			System.out.printf("Found %s", user);
		} else {
			System.out.println("Not Found");
		}
	}

	/**
	 * eclipselink with h2 db sequence table issue
	 */
	static void insertOne() {
		Appuser user = new Appuser();
		user.setFirstName("Nikheel");
		user.setLastName("Patel");
		user.setAge(23);
		entityManager.persist(user);
	}
}