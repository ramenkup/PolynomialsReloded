
public class prog8A {
	
	/*=============================================================================
	|   Assignment:  Program #[]:  PolynomialReloded.java
	|       Author:  Spencer Klinge- sklinge@email.arizona.edu
	| Sect. Leader:  LiZZzzZZZzZZie
	|
	|       Course:  CSC227
	|   Instructor:  L. McCann
	|     Due Date:  Tuesday April 1st, 9pm
	|
	|  Description:  The goal of this class is to conduct basic polynomial arithmatic and output a representation
					 of that polynomial in String format to the user. While PolynomialA.java,
					 Term.java, And Quantiity.java(interface) handle the operations of this class,
					 prog7.java acts as a main and testing terminal for the program. PolynomialA is an
					 adaptation of the orginial Polynomial.java class. the only difference is PolynomialA
					 Uses ArrayList
	|                
	| Deficiencies:  toString(0
	*===========================================================================*/
	public static void main(String args[]){
		//@SuppressWarnings("deprecation")
		
		PolynomialA test= new PolynomialA();
		//PolynomialA adder= new PolynomialA();
		test.addTerm(2, 2);
		System.out.println(test.toString());
		test.addTerm(-4, 3);
		System.out.println(test.toString());
		test.addTerm(5,0);
		System.out.println(test.toString());
		test.addTerm(-5,0);
		System.out.println(test.toString());
		System.out.println(test.evaluate(2));
		System.out.println(test.negate().toString());
	}

	}

