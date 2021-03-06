package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDAO;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner{

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("User id 10001 -> {}",repository.findById(10001));
		logger.info("All users-> {}",repository.findAll());
//		logger.info("Deleting 10002-> No. of rows Deleted-{}",repository.deleteById(10002));
      logger.info("Inserting {}",repository.insert(new Person("Tara","Berlin",new Date())));
      logger.info("update 10003 {}",repository.update(new Person(10003,"frisky","chennai",new Date())));

      repository.deleteById(10002);
	}

}
