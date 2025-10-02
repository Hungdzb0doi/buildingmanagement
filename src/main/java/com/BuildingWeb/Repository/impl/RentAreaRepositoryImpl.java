package com.BuildingWeb.Repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.BuildingWeb.Entity.RentAreaEntity;
import com.BuildingWeb.Repository.RentAreaRepository;
import com.BuildingWeb.Utils.ConnectionJDBCUtil;
@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {
	
	@Override
	public List<RentAreaEntity> FindRentArea(int id) {
		String sql="select * from rentarea where IdBuilding = "+id;
		List<RentAreaEntity> ListRentArea=new ArrayList<>();
		try(Connection con=ConnectionJDBCUtil.getConnection();
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery(sql);){
			while(rs.next()) {
			RentAreaEntity raett=new RentAreaEntity();
			raett.setIdRentArea(rs.getInt("IdRentArea"));
			raett.setArea(rs.getInt("Area"));
			raett.setIdBuilding(rs.getInt("IdBuilding"));
			ListRentArea.add(raett);}
	}catch(SQLException e) {
		System.out.print(e.getMessage());
	}
		return ListRentArea;
	}
}
