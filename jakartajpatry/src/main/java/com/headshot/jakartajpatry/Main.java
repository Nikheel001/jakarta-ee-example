package com.headshot.jakartajpatry;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import com.headshot.jakartajpatry.library.MouseMoveLibrary;

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

	public static void init() {
		loadDbConfig("sqliteconfig.properties");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public static void loadDbConfig(String configPropFile) {
		Properties config = new Properties();
		try (InputStream input = Main.class.getClassLoader()
				.getResourceAsStream(configPropFile)) {
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
	
	public static void main(String[] args) {
		init();
		MouseMoveLibrary mml = new MouseMoveLibrary(entityManager);
		System.out.println();
		System.out.println("====================== Native query ========================");
		System.out.println();
		mml.listfirst10Native();
		System.out.println();
		System.out.println("====================== Jakarta Query Language ========================");
		System.out.println();
		mml.listfirst10JakartaQueryLanguage();
		System.out.println();
		System.out.println("====================== Jakarta Criteria API ========================");
		System.out.println();
		mml.listfirst10JakartaCriteriaQueryBuilder();
		entityManager.close();
		entityManagerFactory.close();
	}
}