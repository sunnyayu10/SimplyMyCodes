package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AmazonJdbc {

	public void jdbc() {

		String strQuery = "select * from Mobile";

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_db", "root", "samehere");
			PreparedStatement st = con.prepareStatement(strQuery);
			ResultSet rs = st.executeQuery();
			rs.next();
			System.out.println(rs.getString(1) + " " + rs.getString(2) + "" + rs.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
