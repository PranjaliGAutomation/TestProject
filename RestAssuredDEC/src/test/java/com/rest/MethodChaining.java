package com.rest;

public class MethodChaining {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//MethodChaining methodchaining = new MethodChaining();
		//methodchaining.
		
		a1().
		a2().
		a3();
		}

	public static MethodChaining a1() 
	   {
		System.out.println("This is a1 method");
	    return new MethodChaining();
	   }
	
	public static MethodChaining a2() 
	{System.out.println("This is a2 method");
	return new MethodChaining();
	}
	
	public static MethodChaining a3(){
		System.out.println("This is a3 method");
		return new MethodChaining();
		}
}




/*Method Chaining is the practice of calling different methods in a single line instead of calling other methods with the same object reference separately. Under this procedure, we have to write the object reference once and then call the methods by separating them with a (dot.).

Method chaining in Java is a common syntax to invoke multiple methods calls in OOPs. Each method in chaining returns an object. It violates the need for intermediate variables. In other words, the method chaining can be defined as if we have an object and we call methods on that object one after another is called method chaining.*/
/*
public void a1() {System.out.println("This is a1 method");}

public void a2(){System.out.println("This is a2 method");}

public MethodChaining a3(){System.out.println("This is a3 method");}
*/