/*+----------------------------------------------------------------------
 ||
 ||  Class Term.java
 ||
 ||         Author:  Spencer KLinge
 ||
 ||        Purpose:  Objects held in Polynomials single array poly[], containing
 					 the coefficiant and exponant of each term of the polynomial.
 ||                  
 ||
 ||  Inherits From:  N/A
 ||
 ||     Interfaces:  N/A
 ||
 ||      Constants:  N/A
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  public Term(int x, int y)
 ||
 ||  Class Methods:  N/a
 ||
 ||  Inst. Methods:  public int getCoeff()
 					 public int getExp()
 					 public void setCoeff(int x)
 					 public void setExp(int)
 ++-----------------------------------------------------------------------*/

public class Term implements Comparable{
	
	private int coeff=0;//inital coeff value
	private int exp=0;//no longer null
	
	
    /*---------------------------------------------------------------------
    |  Method : Term(int x, int y)
    |
    |  Purpose:  Constructor of the coefficient and exponant variables for 
    			 a term object.
    |
    |  Pre-condition: N/A
    |
    |  Post-condition: Constructed term object
    |
    |  Parameters: int x- value of ther terms coefficent
    			   int y- value of the terms exponant
    |
    |  Returns:  N/a
    *-------------------------------------------------------------------*/

	public Term (int x, int y){
		coeff=x;
		exp=y;
	}
  

	public int getCoeff(){
		return coeff;
	}
	
	public int getExp(){
		return exp;
	}
	
	public void setCoeff(int x){
		coeff=x;
	}
	
	public void setExp(int y){
		exp=y;
	}


	@Override
	public int compareTo(Object arg0) {
		Term arg=(Term) arg0;
		if(this.getExp() > arg.getExp())
			return 1;
		if(this.getExp() < arg.getExp())
			return -1;
		return 0;
	}

}
