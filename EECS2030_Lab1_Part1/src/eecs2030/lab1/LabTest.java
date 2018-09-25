package eecs2030.lab1;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.rules.Timeout;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LabTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void test00_one() {
		assertEquals(1, Lab.one());
	}
	
	
	@Test
	public void test01_numRevolutions() {
		final long[] DEG = { 0, 1, 360, 719, 720, 800, Long.MAX_VALUE };
		final long[] EXP = { 0, 0, 1, 1, 2, 2, 25620477880152155L };
		for (int i = 0; i < DEG.length; i++) {
			long got = Lab.numRevolutions(DEG[i]);
			long exp = EXP[i];
			String err = String.format("numRevolutions(%s) failed", DEG[i]);
			assertEquals(err, exp, got);
		}
	}

	@Test
	public void test01_fixAngle() {
		final long[] DEG = { 0, 1, 359, 360, 700, 720, 725, Long.MAX_VALUE };
		final int[] EXP = { 0, 1, 359, 0, 340, 0, 5, 7 };
		for (int i = 0; i < DEG.length; i++) {
			int got = Lab.fixAngle(DEG[i]);
			int exp = EXP[i];
			String err = String.format("fixAngle(%s) failed", DEG[i]);
			assertEquals(err, exp, got);
		}
	}

	@Test
	public void test03_avg() {
		final int[] A = { 1, 0, -100, 0 };
		final int[] B = { 1, 1, -101, Integer.MAX_VALUE };
		final int[] C = { 1, 1, -103, Integer.MAX_VALUE };
		final double[] EXP = { 1.0, 2.0 / 3, -304.0 / 3, (2.0 * Integer.MAX_VALUE) / 3 };
		for (int i = 0; i < A.length; i++) {
			int a = A[i];
			int b = B[i];
			int c = C[i];
			double exp = EXP[i];
			String error = String.format("avg(%d, %d, %d) failed", a, b, c);
			assertEquals(error, exp, Lab.avg(a, b, c), 10 * Math.ulp(exp));
		}
	}

	@Test
	public void test05_isEven() {
		final int[] X = { Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE };
		final boolean[] EXP = {true, false, true, false, false};
		for (int i = 0; i < X.length; i++) {
			int x = X[i];
			boolean exp = EXP[i];
			String error = String.format("isEven(%d) failed", x);
			assertEquals(error, exp, Lab.isEven(x));
		}
	}

	@Test
	public void test06_badUnits() {
		final String[] U = { "C", "F", 
				"c", "f", "celcius", "fahrenheit"};
		final boolean[] EXP = {false, false, 
				true, true, true, true};
		for (int i = 0; i < U.length; i++) {
			String units = U[i];
			boolean exp = EXP[i];
			String error = String.format("badUnits(%s) failed", units);
			assertEquals(error, exp, Lab.badUnits(units));
		}
	}
	
	
	@Test
	public void test07_badUnits() {
		final String[] U = { new String("C"), new String("F") };
		final boolean[] EXP = {false, false};
		for (int i = 0; i < U.length; i++) {
			String units = U[i];
			boolean exp = EXP[i];
			String error = String.format("badUnits(%s) failed; are you using == instead of equals?", units);
			assertEquals(error, exp, Lab.badUnits(units));
		}
	}
	
	@Test
	public void test08_isInRange() {
		final double[] X = {100.0,
				100.0,
				-200.5,
				-200.5
				};
		final double[] LO = {0.0,
				99.99,
				-300,
				-200.50001
				};
		final double[] HI = {200.0,
				100.01,
				10.0,
				-200.4999
				};
		for (int i = 0; i < X.length; i++) {
			double x = X[i];
			double lo = LO[i];
			double hi = HI[i];
			String error = String.format("isInRange(%s, %s, %s) failed", x, lo, hi);
			assertEquals(error, true, Lab.isInRange(x, lo, hi));
		}
	}
	
	@Test
	public void test09_isInRange() {
		final double[] X = {0.0,
				0.0,
				0.0,
				0.0};
		final double[] LO = {0.0,
				-10.0,
				1.0,
				-10.0
				};
		final double[] HI = {1.0,
				0.0,
				-1.0,
				-5.0};
		for (int i = 0; i < X.length; i++) {
			double x = X[i];
			double lo = LO[i];
			double hi = HI[i];
			String error = String.format("isInRange(%s, %s, %s) failed", x, lo, hi);
			assertEquals(error, false, Lab.isInRange(x, lo, hi));
		}
	}
	
	private static int counterValue(HiddenCounter c) {
		int result = 0;
		try {
			Class<?> cl = c.getClass();
			Field value = cl.getDeclaredField("value");
			value.setAccessible(true);
			result = value.getInt(c);
		}
		catch (NoSuchFieldException x) {
			fail("this should not happen; missing field named value");
		}
		catch (IllegalAccessException x) {
			fail("this should not happen; IllegalAccessException");
		}
		return result;
	}
	
	@Test
	public void test10_twiddle() {
		HiddenCounter c = new HiddenCounter(4);
		Lab.twiddle(c);
		String error = "twiddling an even counter failed";
		assertTrue(error, 5 == counterValue(c));
	}
	
	@Test
	public void test11_twiddle() {
		HiddenCounter c = new HiddenCounter(5);
		Lab.twiddle(c);
		String error = "twiddling an odd counter failed";
		assertTrue(error, 4 == counterValue(c));
	}
	
	@Test
	public void test12_twiddle() {
		HiddenCounter c = new HiddenCounter(0);
		Lab.twiddle(c);
		String error = "twiddling a counter with value 0 failed";
		assertTrue(error, 2 == counterValue(c));
	}
	
	@Test
	public void test13_swapFirstAndLast() {
		List<String> t = new ArrayList<>();
		List<String> exp = new ArrayList<>();
		Lab.swapFirstAndLast(t);
		assertEquals("swapFirstAndLast(<empty list>) failed",
				exp, t);
	}
	
	@Test
	public void test14_swapFirstAndLast() {
		List<String> t = Arrays.asList("first");
		String error = String.format("swapFirstAndLast(%s) failed", t);
		
		List<String> exp = Arrays.asList("first");
		Lab.swapFirstAndLast(t);
		assertEquals(error,
				exp, t);
	}
	
	@Test
	public void test15_swapFirstAndLast() {
		List<String> t = Arrays.asList("first", "last");
		String error = String.format("swapFirstAndLast(%s) failed", t);
		
		List<String> exp = Arrays.asList("last", "first");
		Lab.swapFirstAndLast(t);
		assertEquals(error,
				exp, t);
	}
	
	@Test
	public void test16_swapFirstAndLast() {
		List<String> t = Arrays.asList("first", "second", "last");
		String error = String.format("swapFirstAndLast(%s) failed", t);
		
		List<String> exp = Arrays.asList("last", "second", "first");
		Lab.swapFirstAndLast(t);
		assertEquals(error,
				exp, t);
	}
	
	@Test
	public void test17_swapFirstAndLast() {
		List<String> t = Arrays.asList("first", "x", "x", "x", "x", "x", "x", "last");
		String error = String.format("swapFirstAndLast(%s) failed", t);
		
		List<String> exp = Arrays.asList("last", "x", "x", "x", "x", "x", "x", "first");
		Lab.swapFirstAndLast(t);
		assertEquals(error,
				exp, t);
	}
	
	@Test
	public void test18_numShortWords() {
		List<String> t = new ArrayList<>();
		String error = String.format("numShortWords(%s) failed", t);
		int exp = 0;
		assertEquals(error, exp, Lab.numShortWords(t));
		assertTrue("numShortWords(t) changed the list t", t.isEmpty());
	}
	
	@Test
	public void test19_numShortWords() {
		List<String> t = Arrays.asList("am", "I", "in", "on", "of");
		List<String> u = new ArrayList<>(t);
		String error = String.format("numShortWords(%s) failed", t);
		int exp = 5;
		assertEquals(error, exp, Lab.numShortWords(t));
		assertEquals("numShortWords(t) changed the list t",
				u, t);
	}
	
	@Test
	public void test20_numShortWords() {
		List<String> t = Arrays.asList("the", "for", "how", "when", "where");
		List<String> u = new ArrayList<>(t);
		String error = String.format("numShortWords(%s) failed", t);
		int exp = 0;
		assertEquals(error, exp, Lab.numShortWords(t));
		assertEquals("numShortWords(t) changed the list t",
				u, t);
	}
	
	@Test
	public void test21_numShortWords() {
		List<String> t = Arrays.asList("so", "list", "a", "big", "small", "at", "or", "in");
		List<String> u = new ArrayList<>(t);
		String error = String.format("numShortWords(%s) failed", t);
		int exp = 5;
		assertEquals(error, exp, Lab.numShortWords(t));
		assertEquals("numShortWords(t) changed the list t",
				u, t);
	}
	
	@Test
	public void test22_numShortWords() {
		List<String> t = Arrays.asList("also", "far", "big", "cat", "door", "a");
		List<String> u = new ArrayList<>(t);
		String error = String.format("numShortWords(%s) failed", t);
		int exp = 1;
		assertEquals(error, exp, Lab.numShortWords(t));
		assertEquals("numShortWords(t) changed the list t",
				u, t);
	}
}
