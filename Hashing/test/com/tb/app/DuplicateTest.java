package com.tb.app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DuplicateTest {
	Duplicate d;

	@Before
	public void setup() {
		d = new Duplicate();
	}

	@Test
	public void testEmptyArrayFalseResult() {
		int arr[] = {};
		Assert.assertTrue(!d.containsDuplicate(arr));
	}

	@Test
	public void testArrayNoDuplicates() {
		int arr[] = { 1, 2, 5, 7, 9, 12 };
		Assert.assertTrue(!d.containsDuplicate(arr));
	}

	@Test
	public void testArrayWithDuplicates() {
		int arr[] = { 6, 5, 4, 5, 2, 9 };
		Assert.assertTrue(d.containsDuplicate(arr));
	}

	@Test
	public void testNullArray() {
		Assert.assertTrue(!d.containsDuplicate(null));
	}
}
