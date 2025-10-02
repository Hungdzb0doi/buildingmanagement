package com.BuildingWeb.Repository.impl;

import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;


import org.springframework.stereotype.Repository;

import com.BuildingWeb.Entity.DistrictEntity;
import com.BuildingWeb.Repository.DistrictRepository;
import com.BuildingWeb.Utils.ConnectionJDBCUtil;
@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

@Override
public DistrictEntity FindDistrict(int id) {
	String sql="select * from district where IdDistrict = "+id;
	DistrictEntity dett=new DistrictEntity();
	try(Connection con=ConnectionJDBCUtil.getConnection();
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);){
			while(rs.next()) {
			dett.setIdDistrict(rs.getInt("IdDistrict"));
			dett.setCodeDistrict(rs.getString("CodeDistrict"));
			dett.setDistrictName(rs.getString("DistrictName"));
			}
		
		
}catch(SQLException e) {
	System.out.print(e.getMessage());
}
	return dett;
}
}
