package com.finexus.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo2 {

	@Test
	public void sum() {

		System.out.println("Demo2 SUM ");
		int a = 10;
		int b = 20;

		Assert.assertEquals(30, a + b);
	}

	@Test
	public void mul() {
		System.out.println("Demo2 MUL ");
		int a = 10;
		int b = 2;

		Assert.assertEquals(20, a * b);
	}

	@Test
	public void sub() {

		System.out.println("Demo2 SUBTRACT ");
		int a = 20;
		int b = 10;

		Assert.assertEquals(10, a - b);
	}

}
