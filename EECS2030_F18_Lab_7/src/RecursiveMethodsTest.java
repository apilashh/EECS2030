import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RecursiveMethodsTest {

	@Test
	public void testFibArray1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.fibArray(2);
		int[] a2 = {1, 1};
		assertArrayEquals(seq, a2);
	}
	
	@Test
	public void testFibArray2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.fibArray(3);
		int[] a3 = {1, 1, 2};
		assertArrayEquals(seq, a3);
	}
	
	@Test
	public void testFibArray3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.fibArray(4);
		int[] a4 = {1, 1, 2, 3};
		assertArrayEquals(seq, a4);
	}
	
	@Test
	public void testFibArray4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.fibArray(5);
		int[] a5 = {1, 1, 2, 3, 5};
		assertArrayEquals(seq, a5);
	}
	
	@Test
	public void testFibArray5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] seq = rm.fibArray(6);
		int[] a6 = {1, 1, 2, 3, 5, 8};
		assertArrayEquals(seq, a6);
	}
	
	@Test
	public void testFibList1() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.fibList(2);
		int[] a2 = {1, 1};
		List<Integer> l2 = a2l(a2);
		assertEquals(seq, l2);
	}
	
	@Test
	public void testFibList2() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.fibList(3);
		int[] a3 = {1, 1, 2};
		List<Integer> l3 = a2l(a3);
		assertEquals(seq, l3);
	}
	
	@Test
	public void testFibList3() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.fibList(4);
		int[] a4 = {1, 1, 2, 3};
		List<Integer> l4 = a2l(a4);
		assertEquals(seq, l4);
	}
	
	@Test
	public void testFibList4() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.fibList(5);
		int[] a5 = {1, 1, 2, 3, 5};
		List<Integer> l5 = a2l(a5);
		assertEquals(seq, l5);
	}
	
	@Test
	public void testFibList5() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> seq = rm.fibList(6);
		int[] a6 = {1, 1, 2, 3, 5, 8};
		List<Integer> l6 = a2l(a6);
		assertEquals(seq, l6);
	}
	
	@Test
	public void testIsFibArray1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a1 = {1};
		assertTrue(rm.isFibArray(a1));
	}
	
	@Test
	public void testIsFibArray2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a2 = {2};
		assertTrue(!rm.isFibArray(a2));
	}
	
	@Test
	public void testIsFibArray3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a3 = {1, 1};
		assertTrue(rm.isFibArray(a3));
	}
	
	@Test
	public void testIsFibArray4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a4 = {2, 1};
		assertTrue(!rm.isFibArray(a4));
	}
	
	@Test
	public void testIsFibArray5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a5 = {2, 2, 4, 6, 10, 16};
		assertTrue(!rm.isFibArray(a5));
	}
	
	@Test
	public void testIsFibArray6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a6 = {1, 1, 2, 3, 5, 7};
		assertTrue(!rm.isFibArray(a6));
	}
	
	@Test
	public void testIsFibArray7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a7 = {1, 1, 2, 3, 6, 8};
		assertTrue(!rm.isFibArray(a7));
	}
	
	@Test
	public void testIsFibArray8() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a8 = {1, 1, 2, 3, 5, 8};
		assertTrue(rm.isFibArray(a8));
	}
	
	@Test
	public void testIsFibList1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a1 = {1};
		List<Integer> l1 = a2l(a1);
		assertTrue(rm.isFibList(l1));
	}
	
	@Test
	public void testIsFibList2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a2 = {2};
		List<Integer> l2 = a2l(a2);
		assertTrue(!rm.isFibList(l2));
	}
	
	@Test
	public void testIsFibList3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a3 = {1, 1};
		List<Integer> l3 = a2l(a3);
		assertTrue(rm.isFibList(l3));
	}
	
	@Test
	public void testIsFibList4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a4 = {2, 1};
		List<Integer> l4 = a2l(a4);
		assertTrue(!rm.isFibList(l4));
	}
	
	@Test
	public void testIsFibList5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a5 = {2, 2, 4, 6, 10, 16};
		List<Integer> l5 = a2l(a5);
		assertTrue(!rm.isFibList(l5));
	}
	
	@Test
	public void testIsFibList6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a6 = {1, 1, 2, 3, 5, 7};
		List<Integer> l6 = a2l(a6);
		assertTrue(!rm.isFibList(l6));
	}
	
	@Test
	public void testIsFibList7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a7 = {1, 1, 2, 3, 6, 8};
		List<Integer> l7 = a2l(a7);
		assertTrue(!rm.isFibList(l7));
	}
	
	@Test
	public void testIsFibList8() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] a8 = {1, 1, 2, 3, 5, 8};
		List<Integer> l8 = a2l(a8);
		assertTrue(rm.isFibList(l8));
	}

	@Test
	public void testInsertIntoSortedArray1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa0 = {};
		int[] sa1 = rm.insertIntoSortedArray(sa0, 1);
		int[] sa1_ = {1};
		assertArrayEquals(sa1, sa1_);
	}
	
	@Test
	public void testInsertIntoSortedArray2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa0 = rm.insertIntoSortedArray(sa, 0);
		int[] sa0_ = {0, 1, 3, 5};
		assertArrayEquals(sa0, sa0_);
	}
	
	@Test
	public void testInsertIntoSortedArray3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa1 = rm.insertIntoSortedArray(sa, 1);
		int[] sa1_ = {1, 1, 3, 5};
		assertArrayEquals(sa1, sa1_);
	}
	
	@Test
	public void testInsertIntoSortedArray4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa2 = rm.insertIntoSortedArray(sa, 2);
		int[] sa2_ = {1, 2, 3, 5};
		assertArrayEquals(sa2, sa2_);
	}
	
	@Test
	public void testInsertIntoSortedArray5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa3 = rm.insertIntoSortedArray(sa, 3);
		int[] sa3_ = {1, 3, 3, 5};
		assertArrayEquals(sa3, sa3_);
	}
	
	@Test
	public void testInsertIntoSortedArray6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa4 = rm.insertIntoSortedArray(sa, 4);
		int[] sa4_ = {1, 3, 4, 5};
		assertArrayEquals(sa4, sa4_);
	}
	
	@Test
	public void testInsertIntoSortedArray7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa5 = rm.insertIntoSortedArray(sa, 5);
		int[] sa5_ = {1, 3, 5, 5};
		assertArrayEquals(sa5, sa5_);
	}
	
	@Test
	public void testInsertIntoSortedArray8() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		int[] sa6 = rm.insertIntoSortedArray(sa, 6);
		int[] sa6_ = {1, 3, 5, 6};
		assertArrayEquals(sa6, sa6_);
	}
	
	@Test
	public void testInsertIntoSortedList1() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> sl0 = new ArrayList<>();
		List<Integer> sl1 = rm.insertIntoSortedList(sl0, 1);
		int[] sa1 = {1};
		List<Integer> sl1_ = a2l(sa1);
		assertEquals(sl1, sl1_);
	}
	
	@Test
	public void testInsertIntoSortedList2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl0 = rm.insertIntoSortedList(sl, 0);
		int[] sa0_ = {0, 1, 3, 5};
		List<Integer> sl0_ = a2l(sa0_);
		assertEquals(sl0, sl0_);
	}
	
	@Test
	public void testInsertIntoSortedList3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl1 = rm.insertIntoSortedList(sl, 1);
		int[] sa1_ = {1, 1, 3, 5};
		List<Integer> sl1_ = a2l(sa1_);
		assertEquals(sl1, sl1_);
	}
	
	@Test
	public void testInsertIntoSortedList4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl2 = rm.insertIntoSortedList(sl, 2);
		int[] sa2_ = {1, 2, 3, 5};
		List<Integer> sl2_ = a2l(sa2_);
		assertEquals(sl2, sl2_);
	}
	
	@Test
	public void testInsertIntoSortedList5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl3 = rm.insertIntoSortedList(sl, 3);
		int[] sa3_ = {1, 3, 3, 5};
		List<Integer> sl3_ = a2l(sa3_);
		assertEquals(sl3, sl3_);
	}
	
	@Test
	public void testInsertIntoSortedList6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl4 = rm.insertIntoSortedList(sl, 4);
		int[] sa4_ = {1, 3, 4, 5};
		List<Integer> sl4_ = a2l(sa4_);
		assertEquals(sl4, sl4_);
	}
	
	@Test
	public void testInsertIntoSortedList7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl5 = rm.insertIntoSortedList(sl, 5);
		int[] sa5_ = {1, 3, 5, 5};
		List<Integer> sl5_ = a2l(sa5_);
		assertEquals(sl5, sl5_);
	}
	
	@Test
	public void testInsertIntoSortedList8() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] sa = {1, 3, 5};
		List<Integer> sl = a2l(sa);
		List<Integer> sl6 = rm.insertIntoSortedList(sl, 6);
		int[] sa6_ = {1, 3, 5, 6};
		List<Integer> sl6_ = a2l(sa6_);
		assertEquals(sl6, sl6_);
	}
	
	@Test
	public void testMergeSortedArrays1() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L0 = {};
		int[] R0 = {};
		int[] merge0 = rm.mergeSortedArrays(L0, R0);
		int[] merge0_ = {};
		assertArrayEquals(merge0, merge0_);
	}
	
	@Test
	public void testMergeSortedArrays2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L1 = {};
		int[] R1 = {1, 2, 3};
		int[] merge1 = rm.mergeSortedArrays(L1, R1);
		int[] merge1_ = {1, 2, 3};
		assertArrayEquals(merge1, merge1_);
	}
	
	@Test
	public void testMergeSortedArrays3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L2 = {1, 2, 3};
		int[] R2 = {};
		int[] merge2 = rm.mergeSortedArrays(L2, R2);
		int[] merge2_ = {1, 2, 3};
		assertArrayEquals(merge2, merge2_);
	}
	
	@Test
	public void testMergeSortedArrays4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L3 = {-3, -1, 1, 3, 5, 7         };
		int[] R3 = {          2, 4, 6, 8, 9, 10};
		int[] merge3 = rm.mergeSortedArrays(L3, R3);
		int[] merge3_ = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(merge3, merge3_);
	}
	
	@Test
	public void testMergeSortedArrays5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L4 = {         2, 4, 6, 8, 9, 10};
		int[] R4 = {-3, -1, 1, 3, 5, 7        };
		int[] merge4 = rm.mergeSortedArrays(L4, R4);
		int[] merge4_ = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(merge4, merge4_);
	}
	
	@Test
	public void testMergeSortedArrays6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L5 = {         2, 4, 6            };
		int[] R5 = {-3, -1, 1, 3, 5, 7, 8, 9, 10};
		int[] merge5 = rm.mergeSortedArrays(L5, R5);
		int[] merge5_ = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(merge5, merge5_);
	}
	
	@Test
	public void testMergeSortedArrays7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] L6 = {-3, -1, 1, 3, 5, 7, 8, 9, 10};
		int[] R6 = {         2, 4, 6            };
		int[] merge6 = rm.mergeSortedArrays(L6, R6);
		int[] merge6_ = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(merge6, merge6_);
	}
	
	@Test
	public void testMergeSortedLists1() {
		RecursiveMethods rm = new RecursiveMethods();	
		int[] La0 = {};
		int[] Ra0 = {};
		List<Integer> L0 = a2l(La0);
		List<Integer> R0 = a2l(Ra0);
		List<Integer> merge0 = rm.mergeSortedLists(L0, R0);
		int[] merge0a_ = {};
		List<Integer> merge0_ = a2l(merge0a_);
		assertEquals(merge0, merge0_);
	}
	
	@Test
	public void testMergeSortedLists2() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] La1 = {};
		int[] Ra1 = {1, 2, 3};
		List<Integer> L1 = a2l(La1);
		List<Integer> R1 = a2l(Ra1);
		List<Integer> merge1 = rm.mergeSortedLists(L1, R1);
		int[] merge1a_ = {1, 2, 3};
		List<Integer> merge1_ = a2l(merge1a_);
		assertEquals(merge1, merge1_);
	}
	
	@Test
	public void testMergeSortedLists3() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] La2 = {1, 2, 3};
		int[] Ra2 = {};
		List<Integer> L2 = a2l(La2);
		List<Integer> R2 = a2l(Ra2);
		List<Integer> merge2 = rm.mergeSortedLists(L2, R2);
		int[] merge2a_ = {1, 2, 3};
		List<Integer> merge2_ = a2l(merge2a_);
		assertEquals(merge2, merge2_);
	}
	
	@Test
	public void testMergeSortedLists4() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] La3 = {-3, -1, 1, 3, 5, 7         };
		int[] Ra3 = {          2, 4, 6, 8, 9, 10};
		List<Integer> L3 = a2l(La3);
		List<Integer> R3 = a2l(Ra3);
		List<Integer> merge3 = rm.mergeSortedLists(L3, R3);
		int[] merge3a_ = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> merge3_ = a2l(merge3a_);
		assertEquals(merge3, merge3_);
	}
	
	@Test
	public void testMergeSortedLists5() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] La4 = {         2, 4, 6, 8, 9, 10};
		int[] Ra4 = {-3, -1, 1, 3, 5, 7        };
		List<Integer> L4 = a2l(La4);
		List<Integer> R4 = a2l(Ra4);
		List<Integer> merge4 = rm.mergeSortedLists(L4, R4);
		int[] merge4a_ = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> merge4_ = a2l(merge4a_);
		assertEquals(merge4, merge4_);
	}
	
	@Test
	public void testMergeSortedLists6() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] La5 = {         2, 4, 6            };
		int[] Ra5 = {-3, -1, 1, 3, 5, 7, 8, 9, 10};
		List<Integer> L5 = a2l(La5);
		List<Integer> R5 = a2l(Ra5);
		List<Integer> merge5 = rm.mergeSortedLists(L5, R5);
		int[] merge5a_ = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> merge5_ = a2l(merge5a_);
		assertEquals(merge5, merge5_);
	}
	
	@Test
	public void testMergeSortedLists7() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] La6 = {-3, -1, 1, 3, 5, 7, 8, 9, 10};
		int[] Ra6 = {         2, 4, 6            };
		List<Integer> L6 = a2l(La6);
		List<Integer> R6 = a2l(Ra6);
		List<Integer> merge6 = rm.mergeSortedLists(L6, R6);
		int[] merge6a_ = {-3, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> merge6_ = a2l(merge6a_);
		assertEquals(merge6, merge6_);
	} 
	
	private List<Integer> a2l(int[] a) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < a.length; i ++) {
			list.add(a[i]);
		}
		return list;
	}
}
