package com.shelmark.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);

	}

	@Autowired
	private DataSource datasource;

	@Override
	public void run(String... args) throws Exception {
		String script = System.getProperty("user.dir")+"/src/main/resources/schema.sql";

		// Approch 1: using native way to create instance of Connection
		ScriptRunner scriptRunner = new ScriptRunner(
				DriverManager.getConnection("jdbc:mysql://localhost:3306/shelmark?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", ""));

		// Approch 2: using spring boot injected DataSource to get the connection
		// ScriptRunner scriptRunner = new ScriptRunner(datasource.getConnection());
		scriptRunner.runScript(new BufferedReader(new FileReader(script)));
	}

}
