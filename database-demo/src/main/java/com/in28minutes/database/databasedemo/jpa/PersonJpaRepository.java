package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {
//connnect database
	@PersistenceContext
	EntityManager entitymanager;
	
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entitymanager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}

	
	public Person findById(int id){
		return entitymanager.find(Person.class,id);
				}
	public Person update(Person person) {
		return entitymanager.merge(person);
		
	}

	public Person insert(Person person) {
		return entitymanager.merge(person);
		
	}
	public void deleteById(int id) {
		Person person=findById(id);
		
		 entitymanager.remove(person);
		
	}
	

}
