package genericSortedLinkedList;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SuperfluousMain{
	
	public static void main(String[] args) {
		System.out.println("-- STRING SECTION --");
		
		GSLL<String> linkedStrings = new GSLL<String>();
		linkedStrings.add("INTERCAL");
		linkedStrings.add("MALBOLGE");
		linkedStrings.add("COBOL");
		linkedStrings.add("DELPHI");
		linkedStrings.add("LISP");
		linkedStrings.add("PROLOG");
		linkedStrings.add("FORTRAN");
		linkedStrings.add("ADA");
		//It sorts things!
		linkedStrings.print();
		System.out.println(linkedStrings.get(0));
		System.out.println(linkedStrings.get(4));
		//Map with Lambdas!
		System.out.println("Map lowercase:");
		UnaryOperator<String> lambda1 = (String s) -> s.toLowerCase();
		linkedStrings.map(lambda1);
		linkedStrings.print();
		//Filter with Lambdas!
		System.out.println("Filter longer than 5");
		Predicate<String> lambda2 = (String s) -> 6 > s.length();
		linkedStrings.filter(lambda2);
		linkedStrings.print();
		System.out.println("Filter not equal to ERLANG");
		lambda2 = (String s) -> s.equalsIgnoreCase("ERLANG");
		linkedStrings.filter(lambda2);
		linkedStrings.print();
		
		System.out.println("-- INTEGER SECTION --");
		
		GSLL<Integer> linkedInts = new GSLL<Integer>();
		linkedInts.add(6);
		linkedInts.add(874);
		linkedInts.add(25);
		linkedInts.add(42);
		linkedInts.add(5876305);
		linkedInts.add(8675309);
		linkedInts.add(11);
		//It sorts things!
		linkedInts.print();
		//Map with Lambdas!
		System.out.println("Map increment");
		UnaryOperator<Integer> lambda3 = (Integer i) -> i = i+1;
		linkedInts.map(lambda3);
		linkedInts.print();
		System.out.println("Map count number of on (1) bits in number");
		lambda3 = (Integer i) -> Integer.bitCount(i);
		linkedInts.map(lambda3);
		linkedInts.print();
		//Filter with Lambdas!
		System.out.println("Filter even numbers");
		Predicate<Integer> 
		lambda4 = (Integer i) -> (i % 2) == 1;
		linkedInts.filter(lambda4);
		linkedInts.print();
		System.out.println("Filter less than 1 and greater than 8");
		lambda4 = (Integer i) -> (i > 1) && (i < 8);
		linkedInts.filter(lambda4);
		linkedInts.print();
	}
}