package com.jsp.ManytoManyBi_Direction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.ManytoManyBi_Direction.dta.Person;

public class Persondao {
	
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkarr");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveperson(Person person)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void updateperson(int id,Person person)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person1=entityManager.find(Person.class, id);
		if(person1!=null)
		{
			person.setId(id);
			person.setLanguages(person1.getLanguages());
			entityTransaction.begin();
            entityManager.merge(person);
            entityTransaction.commit();
		}
		else
		{
			System.out.println("Person not found");
		}
	}
	  public void deletePerson(int id) {
	        EntityManager entityManager = getEntityManager();
	        EntityTransaction entityTransaction = entityManager.getTransaction();

	        Person person = entityManager.find(Person.class, id);

	        if (person != null) {
	            entityTransaction.begin();
	            entityManager.remove(person);
	            entityTransaction.commit();
	        } else {
	            System.out.println("Person doesn't exist.");
	        }
	    }
}
