import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	public int[] fibArray(int n) {
		/* Your Task. */
		int[] fib = new int[n];
		fibHelper(fib, n);
		return fib;
	}

	public void fibHelper(int[] f, int n) {
		if (n == 1) {
			f[0] = 1;
		} else if (n == 2) {
			f[0] = 1;
			f[1] = 1;
		} else {
			f[n - 1] = fibonacci(n);
			fibHelper(f, n - 1);
		}
	}

	public int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> fibList(int n) {
		List<Integer> fib = new ArrayList<Integer>();
		fibListHelper(fib, n);
		Collections.reverse(fib);
		return fib;
	}

	public void fibListHelper(List<Integer> f, int n) {
		if (n == 1) {
			f.add(1);
		} else if (n == 2) {
			f.add(1);
			f.add(1);
		} else {
			f.add(fibonacci(n));
			fibListHelper(f, n - 1);
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibArray({1, 2}) returns false and isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input array a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibArray(int[] a) {
		/* Your Task. */
		if (a.length == 1 & a[0] != 1) {
			return false;
		}
		if ((a.length == 1 & a[0] == 1)) {
			return true;
		}
		if (a.length == 2 & a[0] != 1 || a[1] != 1) {
			return false;
		}
		if (a.length == 2 & a[0] == 1 & a[1] == 1) {
			return true;
		}

		if (a.length >= 3 & a[a.length - 1] == a[a.length - 2] + a[a.length - 3]) {
			a = Arrays.copyOfRange(a, 0, a.length - 2);
			return isFibArray(a);
		} else {
			return false;
		}
	}

	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibList({1, 2}) returns false and isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input list a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibList(List<Integer> list) {
		/* Your Task. */
		if (list.size() == 1 & list.get(0) != 1) {
			return false;
		}
		if (list.size() == 1 & list.get(0) == 1) {
			return true;
		}
		if ((list.size() == 2 & list.get(0) != 1 || list.get(1) != 1)) {
			return false;
		}
		if ((list.size() == 2 & list.get(0) == 1 & list.get(1) == 1)) {
			return true;
		}
		if (list.size() >= 3 & list.get(list.size() - 1) == list.get(list.size() - 2) + list.get(list.size() - 3)) {
			list.remove(list.size() - 1);
			return isFibList(list);
		} else {
			return false;
		}
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1, 
	 * consisting of all elements of array a and integer i.
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of array a and integer i.
	 * e.g., insertIntoSortedArray({1, 2, 4, 5}, 3) returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/* Your Task. */
		int l = a.length;
		int[] n = { i };
		int[] newArray = new int[l + 1];
		System.arraycopy(n, 0, newArray, 0, 1);
		System.arraycopy(a, 0, newArray, 1, l);
		helper(newArray, 0);
		return newArray;
	}

	public int[] helper(int[] a, int index) {
		if (index == a.length - 1) {
			return a;
		} else if (a[index] > a[index + 1]) {
			int tmp = a[index];
			a[index] = a[index + 1];
			a[index + 1] = tmp;
			helper(a, index + 1);
		}
		return a;
	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1, 
	 * consisting of all elements of the input list and integer i.
	 * @param list a list that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of the input list and integer i.
	 * e.g., insertIntoSortedList({1, 2, 4, 5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		// lol just do this
		/*list.add(i);
		Collections.sort(list);
		return list;
		*/
		list.add(i);
		//list = helper(list, list.size()-1);
		return list;
	}

	public List<Integer> helper(List<Integer> a, int index) {
		if (index == a.size() - 1) {
			return a;
		} else if (a.get(index) > a.get(index + 1)) {
			int tmp1 = a.get(index);
			int tmp2 = a.get(index -1);
			a.set(index, tmp2);
			a.set(index - 1, tmp1);
			return helper(a, index - 1);
		}
		return a;
	}

	/**
	 * Given two sorted arrays left and right, 
	 * return a sorted array of size left.length + right.length, 
	 * consisting of all elements of arrays left and right.
	 * @param left a sorted array
	 * @param right a sorted array 
	 * @return a sorted array of size left.length + right.length, consisting of all elements of arrays left and right.
	 * e.g., mergeSortedArrays({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedLists method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/* Your Task. */
		return null;
	}

	/**
	 * Given two sorted lists left and right, 
	 * return a sorted list of size left.size() + right.size(), 
	 * consisting of all elements of lists left and right.
	 * @param left a sorted list
	 * @param right a sorted list 
	 * @return a sorted list of size left.size() + right.size(), consisting of all elements of lists left and right.
	 * e.g., mergeSortedLists({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedArrays method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		return null;
	}
}
