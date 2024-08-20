package com.jsp.ManytoManyBi_Direction;

import java.util.ArrayList;
import java.util.List;

import com.jsp.ManytoManyBi_Direction.dao.LanguageDao;
import com.jsp.ManytoManyBi_Direction.dao.Persondao;
import com.jsp.ManytoManyBi_Direction.dta.Language;
import com.jsp.ManytoManyBi_Direction.dta.Person;

public class App 
{
    public static void main( String[] args )
    {
    	LanguageDao languageDao = new LanguageDao();
       Persondao persondao=new Persondao();
    	
      Language english=new Language();
      english.setName("English");
      english.setOrigin("England");
      
      Language spanish = new Language();
      spanish.setName("Spanish");
      spanish.setOrigin("Spain");
      
      Person john = new Person();
      john.setName("John Doe");
      john.setAge(30);
      
      List<Language>list=new ArrayList<Language>();
      list.add(english);
      list.add(spanish);
      john.setLanguages(list);
      
      List<Person> personsForEnglish = new ArrayList<>();
      personsForEnglish.add(john);
      english.setPersons(personsForEnglish);

      List<Person> personsForSpanish = new ArrayList<>();
      personsForSpanish.add(john);
      spanish.setPersons(personsForSpanish);
      
      persondao.saveperson(john);
      
    }
}
