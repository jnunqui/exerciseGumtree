package com.exercise.gumtreeuk;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class App 
{
    public static void main( String[] args ) {
      
   
    	
    	List<Person> list=new ArrayList<Person>();
    	InputStream inputStream = null;
		Resource resource = null;
		Scanner scanner =null;
		
		try {
			
			resource = new FileSystemResource("input/AddressBook.txt");
			inputStream = resource.getInputStream();
			scanner = new Scanner(inputStream);
			while (scanner.hasNext()) {
				String []li=null;
				li=scanner.nextLine().split(",");
				Person person=new Person (li[0],li[1],li[2]);
	        	list.add(person);
			}
			 //Answer: How many males are in the address book?
	        System.out.println("There are "+howManyMales(list)+" males.");
	        
	        //Answer: Who is the oldest person in the address book?
	        list= whoIsOldest(list);
	        System.out.println("The oldest person is "+list.get(0).getName()+" "+list.get(0).getSurname());
	        
	        //Answer: How many days older is Bill than Paul?
	        
	        System.out.println("Bill is "+howManyDaysOlder(list,"Bill","Paul")+" days older than Paul");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (inputStream != null) {
				try {
					
					inputStream.close();
					scanner.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

    }
	public static int howManyMales(List<Person> listP){
		int numPerson=0;
		for (Person temp : listP) {
			if(temp.isMale())
				numPerson+=1;
		}
		
		return numPerson;
	}
	
	public static List<Person> whoIsOldest(List<Person> listP){
				
		Collections.sort(listP,new Comparator<Person>(){				
			 public int compare(Person e1,Person e2){
				 return(e1.getBirthday().compareTo(e2.getBirthday()));
			 }
		});
		return listP;
	}
	
	public static int howManyDaysOlder(List<Person> listP,String name1,String name2){
		Person p1=null;
		Person p2=null;
		for(Person temp : listP){
			if(name1.equals(temp.getName()))
				p1=temp;
			if(name2.equals(temp.getName()))
				p2=temp;
		}
		
		return (int)( (p2.getBirthday().getTime() - p1.getBirthday().getTime()) / (1000 * 60 * 60 * 24));
	}
}
