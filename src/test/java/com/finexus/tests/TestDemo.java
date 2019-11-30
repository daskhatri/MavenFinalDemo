package com.finexus.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo {

	@Test
	public void sum() {

		System.out.println("SUM ");
		int a = 10;
		int b = 20;

		Assert.assertEquals(30, a + b);
	}

	@Test
	public void mul() {
		int a = 10;
		int b = 2;

		Assert.assertEquals(20, a * b);
	}

	@Test
	public void sub() {

		System.out.println("SUBTRACT ");
		int a = 20;
		int b = 10;

		Assert.assertEquals(10, a - b);
	}

}
