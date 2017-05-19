/* Jacob Zajac
 * 5/16/17
 * 
 * This asignment asked us to implement various logical operators on either one or two boolean arrays.
 * It is assumed that the boolean arrays are of equal size.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class TruthColumn {
	
	//Returns an array which contains object from array 1 *and* object from array 2.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns Arr1 and Arr2 
	public boolean[] and(boolean[] Arr1, boolean[] Arr2) {
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
	public boolean[] or(boolean[] Arr1, boolean[] Arr2) {
		boolean[] retval = new boolean[Arr1.length];
		for (int pos = 0; pos < retval.length; pos++) {
			retval[pos] = Arr1[pos] || Arr2[pos];
		} 
		
		return retval;
	}
	
	//Returns an array which is the negated version of an array.
	//@param Arr1 The original array of booleans
	//@return Returns negated version of Arr1 
	public boolean[] negate(boolean[] Arr1) {
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
	public boolean[] imply(boolean[] Arr1, boolean[] Arr2) {
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
	public boolean[] biconditional(boolean[] Arr1, boolean[] Arr2) {
		boolean[] retval = new boolean[Arr1.length];
		for (int pos = 0; pos < retval.length; pos++) {
			retval[pos] = Arr1[pos] == Arr2[pos];
		}
		
		return retval;
	}
	
	//Returns a boolean which represents the validity of the array.
	//@param Arr1 The first array of booleans
	//@return Returns true if every value in Arr1 is true, false otherwise
	public boolean valid(boolean[] Arr1) {

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
	public boolean unsatisfiable(boolean[] Arr1) {

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
	public boolean contingent(boolean[] Arr1) {
		
		return (!valid(Arr1) && !unsatisfiable(Arr1));
		
	}
	
	//Returns a boolean which represents the equivalency of two arrays.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns true if Arr1 is the same as Arr2, false otherwise
	public boolean equivalent(boolean[] Arr1, boolean[] Arr2) {
		return (Arr1.equals(Arr2));
	}
	
	//Returns a boolean value determined by if Arr1 entails Arr2.
	//@param Arr1 The first array of booleans
	//@param Arr2 The second array of booleans
	//@return Returns false if there is any instance when Arr1 is true but Arr2 is false, returns true otherwise
	public boolean entails(boolean[] Arr1, boolean [] Arr2) {
	
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
	public boolean consistent(boolean[] Arr1, boolean[] Arr2) {
		return valid(and(Arr1, Arr2));
	}

}
