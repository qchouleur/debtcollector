package service;

import models.Person;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import data.StaticDataStorage;


public class StringToPersonTypeConverter  implements Converter<String, Person> {

	public StaticDataStorage data = new StaticDataStorage();
	
	@Override
	public Person convert(String personId) {

		int id = -1;
        try{
            id = Integer.parseInt(personId);
        } catch (NumberFormatException e) {
            throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Person.class), personId, null);
        }
        Person person = data.getUserById(id);
        
        return person;
	}
	
	

}
