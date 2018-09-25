import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMatrix {

	@Test
	public void test01_MatrixConstructor_1() {
		Matrix m = new Matrix();
		assertEquals("1 row 2D array", 1, m.imp.length);
		assertEquals("1 column 2D array", 1, m.imp[0].length);
	}
	
	@Test
	public void test02_MatrixConstructor_2() {
		Matrix m = new Matrix(3, 4);
		assertEquals("3 row 2D array", 3, m.imp.length);
		for(int r = 0; r < 3; r ++) {
			assertEquals("4 columns on row " + r + " in 2D array", 4, m.imp[r].length);
		}
	}
	
	@Test
	public void test03_MatrixConstructor_3() {
		Matrix m = new Matrix(3, 4, 5);
		assertEquals("3 row 2D array", 3, m.imp.length);
		for(int r = 0; r < 3; r ++) {
			assertEquals("4 columns on row " + r + " in 2D array", 4, m.imp[r].length);
			for(int c = 0; c < 4; c ++) {
				assertEquals("wrong value on cell (" + r + ", " + c + ") in 2D array", 5, m.imp[r][c]);
				assertEquals("wrong value on cell (" + r + ", " + c + ") in matrix", 5, m.get(r, c));
			}
		}
	}
	
	@Test
	public void test04_getNumberOfRows() {
		Matrix m = new Matrix();
		assertEquals("1 row matrix", 1, m.getNumberOfRows());
	}
	
	@Test
	public void test05_getNumberOfRows() {
		Matrix m = new Matrix(3, 4);
		assertEquals("3 row matrix", 3, m.getNumberOfRows());
	}
	
	@Test
	public void test06_getNumberOfRows() {
		Matrix m = new Matrix(3, 4, 5);
		assertEquals("3 row matrix", 3, m.getNumberOfRows());
	}
	
	@Test
	public void test07_getNumberOfColumns() {
		Matrix m = new Matrix();
		assertEquals("1 column matrix", 1, m.getNumberOfColumns());
	}
	
	@Test
	public void test08_getNumberOfColumns() {
		Matrix m = new Matrix(3, 4);
		assertEquals("4 column matrix", 4, m.getNumberOfColumns());
	}
	
	@Test
	public void test09_getNumberOfColumns() {
		Matrix m = new Matrix(3, 4, 5);
		assertEquals("4 column matrix", 4, m.getNumberOfColumns());
	}
	
	@Test
	public void test10_get() {
		Matrix m = new Matrix();
		m.imp = new int[4][2];
		for (int c = 0; c < 2; c++) {
			for (int r = 0; r < 4; r++) {
				m.imp[r][c] = (r + 1) * (c + 1);
			}
		}
		for (int c = 0; c < 2; c++) {
			for (int r = 0; r < 4; r++) {
				int exp = (r + 1) * (c + 1);
				String err = String.format("get(%d, %d) failed\n", r, c);
				assertEquals(err, exp, m.get(r, c));
			}
		}
	}
	
	@Test
	public void test11_set() {
		Matrix m = new Matrix();
		m.imp = new int[4][2];
		for (int c = 0; c < 2; c++) {
			for (int r = 0; r < 4; r++) {
				m.set(r, c, (r + 10) * (c - 100));
			}
		}
		for (int c = 0; c < 2; c++) {
			for (int r = 0; r < 4; r++) {
				int exp = (r + 10) * (c - 100);
				String err = String.format("set(%d, %d, %d) failed\n", r, c, exp);
				assertEquals(err, exp, m.imp[r][c]);
			}
		}
	}
	
	
	@Test
	public void test12_GetRow() {
		Matrix m = new Matrix(3, 4);
		
		int[] row0 = {13, 4 , 7 , 10};
		int[] row1 = {2 , 14, 8 , 11};
		int[] row2 = {3 , 6 , 15, 12};
		
		m.imp[0] = Arrays.copyOf(row0, 4);
		m.imp[1] = Arrays.copyOf(row1, 4);
		m.imp[2] = Arrays.copyOf(row2, 4);
				
		assertTrue("getRow should return a new array", m.getRow(0) != m.imp[0]);
		assertTrue("getRow should return a new array", m.getRow(1) != m.imp[1]);
		assertTrue("getRow should return a new array", m.getRow(2) != m.imp[2]);
		
		assertArrayEquals("getRow returned the wrong array\n", row0, m.getRow(0));
		assertArrayEquals("getRow returned the wrong array\n", row1, m.getRow(1));
		assertArrayEquals("getRow returned the wrong array\n", row2, m.getRow(2));
	}
	
	@Test
	public void test13_GetColumn() {
		Matrix m = new Matrix(3, 4);
		
		int[] nr0 = {13 , 2 , 3 , 4 };
		int[] nr1 = {5 , 14 , 7 , 8 };
		int[] nr2 = {9 , 10, 15, 12};
		
		m.imp[0] = Arrays.copyOf(nr0, 4);
		m.imp[1] = Arrays.copyOf(nr1, 4);
		m.imp[2] = Arrays.copyOf(nr2, 4);
		
		int[] col0 = {13, 5 , 9 };
		int[] col1 = {2 , 14, 10};
		int[] col2 = {3 , 7 , 15}; 
		int[] col3 = {4 , 8 , 12};
		
		assertArrayEquals("getColumn returned the wrong array\n", col0, m.getColumn(0));
		assertArrayEquals("getColumn returned the wrong array\n", col1, m.getColumn(1));
		assertArrayEquals("getColumn returned the wrong array\n", col2, m.getColumn(2));
		assertArrayEquals("getColumn returned the wrong array\n", col3, m.getColumn(3));
	}
	
	@Test
	public void test14_setRow() {
		Matrix m = new Matrix();
		int[] q = {99};
		m.setRow(0, q);
		assertNotSame("setRow should copy elements into the matrix", 
				m.imp[0], q);
		assertEquals("setRow failed to set the elements of row 0 correctly", 
				99, m.imp[0][0]);
	}
	
	@Test
	public void test15_setRow() {
		Matrix m = new Matrix(3, 4);
		int[] nr0 = {13 , 2 , 3 , 4 };
		int[] nr1 = {5 , 14 , 7 , 8 };
		int[] nr2 = {9 , 10, 15, 12};
		m.imp[0] = Arrays.copyOf(nr0, 4);
		m.imp[1] = Arrays.copyOf(nr1, 4);
		m.imp[2] = Arrays.copyOf(nr2, 4);
		
		int[] q = {100, 99, 98, -1};
		for (int r = 0; r < 3; r++) {
			m.setRow(r, q);
			assertNotSame("setRow should copy elements into the matrix", 
					m.imp[r], q);
			assertArrayEquals(q, m.imp[r]);
		}
	}
	
	@Test
	public void test16_setColumn() {
		Matrix m = new Matrix();
		int[] q = {99};
		m.setColumn(0, q);
		assertNotSame("setColumn should copy elements into the matrix", 
				m.imp[0], q);
		assertEquals("setColumn failed to set the elements of column 0 correctly", 
				99, m.imp[0][0]);
	}
	
	@Test
	public void test17_setColumn() {
		Matrix m = new Matrix(3, 4);
		int[] nr0 = {13 , 2 , 3 , 4 };
		int[] nr1 = {5 , 14 , 7 , 8 };
		int[] nr2 = {9 , 10, 15, 12};
		m.imp[0] = Arrays.copyOf(nr0, 4);
		m.imp[1] = Arrays.copyOf(nr1, 4);
		m.imp[2] = Arrays.copyOf(nr2, 4);
		
		int[] q = {100, 99, -1};
		for (int c = 0; c < 4; c++) {
			int[] exp = {q[0], q[1], q[2]};
			m.setColumn(c, q);
			int[] theCol = {m.imp[0][c], m.imp[1][c], m.imp[2][c]};
			assertArrayEquals("setColumn failed to set the elements of a column correctly", 
					exp, theCol);
		}
	}
	
	@Test
	public void test18_RotateClockwise() {
		Matrix m1 = new Matrix(3, 4); 
		
		int[] nr0 = {1 , 2 , 3 , 4 };
		int[] nr1 = {5 , 6 , 7 , 8 };
		int[] nr2 = {9 , 10, 11, 12};
		m1.setRow(0, nr0);
		m1.setRow(1, nr1);
		m1.setRow(2, nr2);
		
		int[] nc0 = {9, 10, 11, 12};
		int[] nc1 = {5, 6 , 7 , 8 };
		int[] nc2 = {1, 2 , 3 , 4 }; 
		
		int[] nr0_ = {12, 11 , 10 , 9 };
		int[] nr1_ = {8 , 7  , 6  , 5 };
		int[] nr2_ = {4 , 3  , 2  , 1 }; 
		
		m1.rotateClockwise();
		assertArrayEquals(nc0, m1.getColumn(0));
		assertArrayEquals(nc1, m1.getColumn(1));
		assertArrayEquals(nc2, m1.getColumn(2));
		
		m1.rotateClockwise();
		assertArrayEquals(nr0_, m1.getRow(0));
		assertArrayEquals(nr1_, m1.getRow(1));
		assertArrayEquals(nr2_, m1.getRow(2));
	}
	
	@Test
	public void test19_ShiftLeft() {
		Matrix m1 = new Matrix(3, 4); 
		
		int[] nr0 = {1 , 2 , 3 , 4 };
		int[] nr1 = {5 , 6 , 7 , 8 };
		int[] nr2 = {9 , 10, 11, 12};
		m1.setRow(0, nr0);
		m1.setRow(1, nr1);
		m1.setRow(2, nr2);
		
		int[] nr0_ = {2 , 3 , 4 , 1};
		int[] nr1_ = {6 , 7 , 8 , 5};
		int[] nr2_ = {10, 11, 12, 9}; 
		
		int[] nr0__ = {3 , 4 , 1, 2 };
		int[] nr1__ = {7 , 8 , 5, 6 };
		int[] nr2__ = {11, 12, 9, 10}; 
		
		m1.shiftLeft();
		assertArrayEquals(nr0_, m1.imp[0]); 
		assertArrayEquals(nr1_, m1.imp[1]);
		assertArrayEquals(nr2_, m1.imp[2]);
		assertArrayEquals(nr0_, m1.getRow(0));
		assertArrayEquals(nr1_, m1.getRow(1));
		assertArrayEquals(nr2_, m1.getRow(2));
		
		m1.shiftLeft();
		assertArrayEquals(nr0__, m1.imp[0]); 
		assertArrayEquals(nr1__, m1.imp[1]);
		assertArrayEquals(nr2__, m1.imp[2]);
		assertArrayEquals(nr0__, m1.getRow(0));
		assertArrayEquals(nr1__, m1.getRow(1));
		assertArrayEquals(nr2__, m1.getRow(2));
	}
	
	@Test
	public void test20_ShiftUp() {
		Matrix m1 = new Matrix(3, 4); 
		
		int[] nr0 = {1 , 2 , 3 , 4 };
		int[] nr1 = {5 , 6 , 7 , 8 };
		int[] nr2 = {9 , 10, 11, 12};
		
		m1.setRow(0, nr0);
		m1.setRow(1, nr1);
		m1.setRow(2, nr2); 
		
		m1.shiftUp();
		assertArrayEquals(nr1, m1.imp[0]); 
		assertArrayEquals(nr2, m1.imp[1]);
		assertArrayEquals(nr0, m1.imp[2]);
		assertArrayEquals(nr1, m1.getRow(0));
		assertArrayEquals(nr2, m1.getRow(1));
		assertArrayEquals(nr0, m1.getRow(2));
		
		m1.shiftUp();
		assertArrayEquals(nr2, m1.imp[0]); 
		assertArrayEquals(nr0, m1.imp[1]);
		assertArrayEquals(nr1, m1.imp[2]);
		assertArrayEquals(nr2, m1.getRow(0));
		assertArrayEquals(nr0, m1.getRow(1));
		assertArrayEquals(nr1, m1.getRow(2));
	}
}
