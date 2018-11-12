package eecs2030.lab5;

import java.util.Set;
import java.util.TreeSet;

public class TestingClass {
	
	
	public static void main(String []arg) {
		String test = "Hello";
		
		
		Set<String> s = new TreeSet<String>();
		
		s.add("a");
		s.add("b");
		s.add("c");
		
		
		System.out.println(s.toString());
		s.toArray();
		System.out.println(s.toString());
		
		
		
	}
}
