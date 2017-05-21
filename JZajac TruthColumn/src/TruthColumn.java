
/* Jacob Zajac
 * 5/19/17
 * 
 * Truth Column
 * 
 * Introduction
 *
 * This assignment asked us to implement various logical operators on either one or two arrays of boolean data.
 * An example is the And operator, which is boolean from array 1 and boolean from array 2.  An example of the And operator is as follows:
 * Value 1 | Value 2 | Value 1 And 2
 *    T    |    T    |     T
 *    T    |    F    |     F
 *    F    |    T    |     F
 *    F    |    F    |     F
 * 
 * It is assumed that the boolean arrays are of equal size.
 * 
 * Specifications
 * 
 * This project fulfills the specifications of the assignment.  
 * It can take 1 or 2 same size arrays of boolean values and apply various operators.
 * The list of operators:
 * And, Or, Negate, Imply, Biconditional, Imply
 * Valid, Unsatisfiable, Contingent, Equivalent, Entails
 * 
 * Current errors
 * 
 * There are no current errors.  
 * 
 * Code Overview
 * 
 * Each operator has its own method associated with it.
 * Depending on the operator, the method takes either 1 or 2 arrays of boolean values.
 * Using for loops, the program iterates through each item in single array operators, or through corresponding items 
 * in two array operators.  
 * In some methods, such as And, applying the operator to the data creates a new piece of data.
 * In these cases, that data is put into a new array, which is then returned.
 * In other methods, such as Valid, the program checks for a condition.
 * Depending on the condition, a single value, true or false, is returned.
 * 
 * Challenges
 * 
 * The largest challenge was learning the behavior of each logical operator.
 * However, once the behaviors were learned, some of them were actually very easy to implement, 
 * such as Consistent.
 * 
 * Acknowledgments
 * 
 * The Stanford Logic website was very helpful in explaining the logical operators and their behaviors.
 * 
 * 
 */

public class TruthColumn {
	
	public static boolean[] Array1 = {true, true, false, false};
	public static boolean[] Array2 = {true, false, true, false};
	
	public static void main (String args[]) {
		
		//Testing a few of the methods
		
		System.out.println("And:");
		printArray(and(Array1, Array2));
		
		System.out.println("\nNegate:");
		printArray(negate(Array1));
		
		System.out.println("\nConsistent:");
		System.out.println(consistent(Array1, Array2));
	}
	
	//Prints the contents of an array
	//@param Arr The array to be printed
	public static void printArray(boolean[] Arr) {
	      for (int i = 0; i < Arr.length; i++) {
	         if (i > 0) {
	            System.out.print(", ");
	         }
	         System.out.print(Arr[i]);
	      }
	  }
	
	//Returns an array which contains object from array 1 *and* object from array 2.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns Arr1 and Arr2 
	public static boolean[] and(boolean[] Arr1, boolean[] Arr2) {
		boolean[] retval = new boolean[Arr1.length];
		for (int pos = 0; pos < retval.length; pos++) {
			retval[pos] = Arr1[pos] && Arr2[pos];
		}
		
		return retval;
	}
	
	//Returns an array which contains object from array 1 *or* object from array 2.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns Arr1 or Arr2`ss 
	public static boolean[] or(boolean[] Arr1, boolean[] Arr2) {
		boolean[] retval = new boolean[Arr1.length];
		for (int pos = 0; pos < retval.length; pos++) {
			retval[pos] = Arr1[pos] || Arr2[pos];
		} 
		
		return retval;
	}
	
	//Returns an array which is the negated version of an array.
	//@param Arr1 The original array of booleans
	//@return Returns negated version of Arr1 
	public static boolean[] negate(boolean[] Arr1) {
		boolean[] retval = new boolean[Arr1.length];
		for (int pos = 0; pos < retval.length; pos++) {
			retval[pos] = !Arr1[pos];
		}
		return retval; 
	}
	
	//Returns an array where the object is true if an object in Arr1 implies an object inArr2.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns an array of values for Arr1 implies Arr2
	public static boolean[] imply(boolean[] Arr1, boolean[] Arr2) {
		boolean[] retval = new boolean[Arr1.length];
		for (int pos = 0; pos < retval.length; pos++) {
			retval[pos] = !Arr1[pos] || Arr2[pos];
		}
		
		return retval;
	}
	
	//Returns an array which represents the biconditional.  It is true only when the object in Arr1 equals the object in Arr2.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns the biconditional of Arr1 and Arr2
	public static boolean[] biconditional(boolean[] Arr1, boolean[] Arr2) {
		boolean[] retval = new boolean[Arr1.length];
		for (int pos = 0; pos < retval.length; pos++) {
			retval[pos] = Arr1[pos] == Arr2[pos];
		}
		
		return retval;
	}
	
	//Returns a boolean which represents the validity of the array.
	//@param Arr1 The first array of booleans
	//@return Returns true if every value in Arr1 is true, false otherwise
	public static boolean valid(boolean[] Arr1) {

		for (int pos = 0; pos < Arr1.length; pos++) {
			if (Arr1[pos] == false) {
				return false;
			}
		}
		
		return true;
	}
	
	//Returns a boolean which represents the unsatisfiability of the array.
	//@param Arr1 The first array of booleans
	//@return Returns false if at least 1 value in Arr1 is true, returns false otherwise
	public static boolean unsatisfiable(boolean[] Arr1) {

		for (int pos = 0; pos < Arr1.length; pos++) {
			if (Arr1[pos] == true) {
				return false;
			}
		}
		 
		return true; 
	}
	
	//Returns a boolean which represents the contingency of the array.
	//@param Arr1 The first array of booleans
	//@return Returns true if there is at least 1 true value and at least 1 false value, false otherwise
	public static boolean contingent(boolean[] Arr1) {
		
		return (!valid(Arr1) && !unsatisfiable(Arr1));
		
	}
	
	//Returns a boolean which represents the equivalency of two arrays.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns true if Arr1 is the same as Arr2, false otherwise
	public static boolean equivalent(boolean[] Arr1, boolean[] Arr2) {
		return (Arr1.equals(Arr2));
	}
	
	//Returns a boolean value determined by if Arr1 entails Arr2.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns false if there is any instance when Arr1 is true but Arr2 is false, returns true otherwise
	public static boolean entails(boolean[] Arr1, boolean [] Arr2) {
	
		for (int pos = 0; pos < Arr1.length; pos++) {
			if (Arr1[pos] == true && Arr2[pos] == false) {
				return false;
			}
		}
		return true;
	}
	
	//Returns a boolean value determined by if Arr1 and Arr2 are consistent.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns true if the array of Arr1 and Arr2 is valid, false otherwise
	public static boolean consistent(boolean[] Arr1, boolean[] Arr2) {
		return !unsatisfiable(and(Arr1, Arr2));
	}

}
