package com.kiet.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(LibraryApplication.class); 
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		log.info("Library Book Managment Started.");
		log.info("Loading Book Catalogue....");
		log.info("Book Management Rest API is ready.");
	}

}
