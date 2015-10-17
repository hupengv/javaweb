package com.java.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	protected Connection conn;
	protected Statement stmt;
	protected ResultSet rs ;
	protected PreparedStatement pst;
	
}
