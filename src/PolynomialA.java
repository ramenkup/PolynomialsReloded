import java.util.*;

/*+----------------------------------------------------------------------
||
||  Class PolynomialA.java
||
||         Author:  Spencer Klinge
||
||        Purpose:  Handals the saving and operations of the polynomial represented
					by a single array of Term class objects. This class has the ability
					to do basic polynomial arithmatic, along with being able to print out
					a String representation of the  current polynomial object. An Adaptation
					of Polynomial.java, where instead of methods being outfitted to handal arrays,
					instead handals ArrayLists.
||
||  Inherits From:  N/A
||
||     Interfaces:  Quantity- Keeps track of amount of Term objects
|+-----------------------------------------------------------------------
||
||      Constants:  N/A
||
|+-----------------------------------------------------------------------
||
||   Constructors: public PolynomialA()

||  Class Methods:  N/A
||
||  Inst. Methods:  public boolean isEmpty()
||					public boolean isFull()
||					public int holding()
||					public void grow()
||					public void addTerm(int, int)
||					public Polynomial add(Polynomial)
||					public Polynomial replicate()
||					public void scalerMultiply(int)
||					public Polynomial negate()
||					public double evaluate(double)
||					public String toString()
++-----------------------------------------------------------------------*/
public class PolynomialA implements Quantity {
	ArrayList<Term> poly;
    /*---------------------------------------------------------------------
    |  Method: public boolean isEmpty()
    |
    |  Purpose:  Uses arrayLists .isEmpty() to determine the number of valid
    			 Term objects in the Polynomial object.
    |
    |  Pre-condition: Poly has been initalized;
    |
    |  Post-condition: N/A
    |
    |  Parameters:N/A
    |
    |  Returns:  Boolean- True: the object is empty
    				False- The object contains at least one valid Term object.
    *-------------------------------------------------------------------*/
	@Override
	public boolean isEmpty() {
	return poly.isEmpty();
	}
    /*---------------------------------------------------------------------
    |  Method: public boolean isFull()
    |
    |  Purpose:  To return false because the ArrayList object can always grow.
    |
    |  Pre-condition: N/A
    |
    |  Post-condition: N/A
    |
    |  Parameters: N/A
    
    |  Returns:  false.
    *-------------------------------------------------------------------*/
	@Override
	public boolean isFull() {
	return false;
	}

    /*---------------------------------------------------------------------
    |  Method: public int holding()
    |
    |  Purpose: Returns the number of non-zero and non null coefficient Term objects
    			by iterating through the arrayList and checking with getCoeff().
    |
    |  Pre-condition: Valid PolynomialA object initialized.
    |
    |  Post-condition:N/A
    |
    |  Parameters:N/A
    |
    |  Returns:  The number of non 0 coefficient terms in the polynomial object.
    *-------------------------------------------------------------------*/
	@Override
	public int holding() {
	int count=0;
	for(int i=0; i < poly.size(); i++){
		if(poly.get(i) != null && poly.get(i).getCoeff()!=0)
			count++;
	}
	return count;
	}
	
	public PolynomialA(){
		poly= new ArrayList<Term>();
	}
	  /*---------------------------------------------------------------------
    |  Method: addTerm(int c, int e)
    |
    |  Purpose: using the coeffient(c) and exponant(e) variables, this method
    			either initializes a new term object into the poly ArrayList, or
    			adds to terms coefficent to an already existing value
    |
    |  Pre-condition: Polynomial object has been initialized
    |
    |  Post-condition: The polynomial will be updated with proper Polynomial
    |				   addition to add the term to the object.
    |  Parameters: int c- the Coefficient int e- the Exponant
    |
    |  Returns: Void
    *-------------------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public void addTerm(int c, int e){
		int i=0;
		while(i < poly.size() && poly.get(i).getExp() != e){
			i++;
		}
		if(i < poly.size())
			poly.get(i).setCoeff(poly.get(i).getCoeff()+c);
		else{
			if(i == poly.size())
		  	poly.add(new Term(c,e));
		}
		Collections.sort(poly);	
	}
    /*---------------------------------------------------------------------
    |  Method: replicate()
    |
    |  Purpose:  makes an exact and initalized copy of the Polynomial Object by 
    			repeatedly calling addTerm into a new temporary PolynomialA object
    |
    |  Pre-condition: N/A
    |
    |  Post-condition:N/A
    |
    |  Parameters:N/A
    |
    |  Returns: An exact copy of the poly object
    *-------------------------------------------------------------------*/
	public PolynomialA replicate() {
		PolynomialA tempPoly= new PolynomialA();
			for(int i=0; i < poly.size(); i++){
				if(poly.get(i) != null)
					tempPoly.addTerm(poly.get(i).getCoeff(),poly.get(i).getExp());
				
			}
			return tempPoly;
			
		}
	
    /*---------------------------------------------------------------------
    |  Method: public add(PolynomialA p)
    |
    |  Purpose: conducts a sort on the poly by calling Collection .sort(), then,
    |			instead of taking a single term, this takes and adds a whole PolynomialA
    |			object, p, to the calling object, by repeatedly calling addTerm()
    
    |  Pre-condition: PolynomialA object has been initialized
    |
    |  Post-condition: the PolynomialA has been updated with the new addition of the term.
    |
    |  Parameters: PolynomialA p- the polynomial being added to the calling polynomial.
    |
    |  Returns:  temp- the updated and added version of the polynomial.
    *-------------------------------------------------------------------*/
	public PolynomialA add(PolynomialA p){
		PolynomialA temp= this.replicate();
		for(int i=0; i < p.poly.size(); i++){//i < p.poly.length changed to i < p.holding
			temp.addTerm(p.poly.get(i).getCoeff(),p.poly.get(i).getExp());
			
		}
		return temp;
	}
	
    /*---------------------------------------------------------------------
    |  Method: public void scalerMultiply(int s)
    |
    |  Purpose: takes interger s and multipliess each term's coefficent in the poly
    			arrayList by this value.
    |
    |  Pre-condition:  N/a
    |
    |  Post-condition: Polynomial object will be updated and be muliplyed by the value of s.
    |
    |  Parameters: int s- the value multiplying each term.
    |
    |  Returns:  void.
    *-------------------------------------------------------------------*/
	public void scalerMultiply(int s){
		for(int i=0; i< poly.size(); i++){
			poly.get(i).setCoeff(poly.get(i).getCoeff()*s);
		}
	}
    /*---------------------------------------------------------------------
    |  Method: public Polynomial negate()
    |
    |  Purpose: A method that calls the scalerMultiply() method and multiplys
    |			the object by -1, negating all its value, thus returning a negated
    			version of the poly ArrayList
    |
    |  Pre-condition: Valid Polynomial object
    |
    |  Post-condition: poly will be negated.
    |
    |  Parameters: N/A
    
    |  Returns: A negated PolynomialB object
    *-------------------------------------------------------------------*/
	public PolynomialA negate(){
		PolynomialA temp= replicate();
		temp.scalerMultiply(-1);
		return temp;
	}
    /*---------------------------------------------------------------------
    |  Method: public double evaluate(double)
    |
    |  Purpose: given a double value of x, this method plugs the value into all
    			the would be x's of the polynomial, by first raising it to the exponant
    			using Math.pow, then then  multiplying that by the coefficent. This value
    			is then added to a collective double value, sum that is returned at the end 
    			of the method.
    			
    |  Pre-condition: Valid Polynomial object
    |
    |  Post-condition: N/A
    |  Parameters:
    |      double x- the value being plugged into the polynomial
    |
    |  Returns:  The plugged sum of the polynomial.
    *-------------------------------------------------------------------*/
	public double evaluate(double x){
		double sum= 0;
		int i=0;
		while(i < poly.size()){
			if(poly.get(i).getCoeff() != 0){
			double val= Math.pow(x, poly.get(i).getExp());
			val*=poly.get(i).getCoeff();
			sum+=val;
			}
			i++;
		}
		return sum;
	}
    /*---------------------------------------------------------------------
    |  Method: public String toString()
    |
    |  Purpose:  Outputs a represention of the the poly ArrayList in String format
    			 for the user to read. this method properly sorts using Collections.sort()
    			  and restores the exponant values so the polynomial is represented in 
    			  proper expotential order.
    |
    |  Pre-condition: The Polynomial holds terms other than 0 coeffiecnt terms.
    |
    |  Post-condition: N/A
    
    |  Parameters: N/A
    |
    |  Returns:  a String version of the polynomial.
    *-------------------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public String  toString(){
	//Term[]temp= new Term[poly.length];
	@SuppressWarnings("unused")
	Term tempty;//Miguel thinks this is 'slick' and 'hardcore'
	String tempReturn="";
	Collections.sort(poly);
	//while(termCounter>0)
	/*for(int i=0; i < numTerms; i++){
		int greatest= i;
		for(int n=i; n< numTerms; n++){
			if(poly[n].getExp()> poly[greatest].getExp())
				greatest=n;
			
			
		}
		tempty= poly[greatest];
		poly[greatest]= poly[i];
		poly[i]=tempty;
	}*/
	for(int n=0; n < poly.size(); n++){
		if(poly.get(n).getExp()==0 && poly.get(n).getCoeff()!=0){
			if(poly.get(n).getCoeff() > 0 && n!=0)
			tempReturn+= "+" + poly.get(n).getCoeff();
			else tempReturn+= poly.get(n).getCoeff() + "";
		}
		else if(poly.get(n).getCoeff() == 0)
			tempReturn+="";
		else if(n > 0 && poly.get(n).getCoeff() > 0)
		tempReturn+= "+" + poly.get(n).getCoeff()+"x^"+ poly.get(n).getExp();
		else
		tempReturn+= poly.get(n).getCoeff()+"x^"+ poly.get(n).getExp();
	}
	return tempReturn;	
	
	}
	
	
	
	
	
	
	
	}


