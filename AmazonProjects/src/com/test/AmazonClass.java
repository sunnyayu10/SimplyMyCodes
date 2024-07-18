package com.test;

import com.pages.SearchAddProduct;

public class AmazonClass {

	public static void main(String[] args) throws InterruptedException {
		
		SearchAddProduct sp = new SearchAddProduct();
		AmazonJdbc am = new AmazonJdbc();
		sp.search();
		am.jdbc();
	}
}
