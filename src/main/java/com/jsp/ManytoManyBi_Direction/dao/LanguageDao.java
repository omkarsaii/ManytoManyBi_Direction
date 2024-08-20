package com.jsp.ManytoManyBi_Direction.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.ManytoManyBi_Direction.dta.Language;

public class LanguageDao {
	
	 public EntityManager getEntityManager()
	 {
		 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Omkarr");
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 return entityManager;
	 }
	 
	 public void savelanguage(Language language)
	 {
		 EntityManager entityManager=getEntityManager();
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 
		 entityTransaction.begin();
		 entityManager.persist(language);
		 entityTransaction.commit();
	 }
	 
	 public void updateLanguage(int id,Language language)
	 {
		 EntityManager entityManager=getEntityManager();
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 
		 Language lan1=entityManager.find(Language.class, id);
		 if(lan1!=null)
		 {
			 language.setId(id);
			entityTransaction.begin();
			entityManager.merge(language);
			entityTransaction.commit();
		 }
		 else
		 {
			 System.out.println("Language not found"); 
		 }
	 }
	 public void deleteLanguage(int id) {
	        EntityManager entityManager = getEntityManager();
	        EntityTransaction entityTransaction = entityManager.getTransaction();

	        Language language = entityManager.find(Language.class, id);

	        if (language != null) {
	            entityTransaction.begin();
	            entityManager.remove(language);
	            entityTransaction.commit();
	        } else {
	            System.out.println("Language doesn't exist.");
	        }
	    }
}
