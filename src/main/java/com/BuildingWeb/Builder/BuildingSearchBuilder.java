package com.BuildingWeb.Builder;
import java.util.List;

public class BuildingSearchBuilder {
	private String BuildingName;
	private String Ward;
	private String Way;
	private Integer NumberOfBasement;
	private Integer FloorArea;
	private String ManagerName;
	private String ManagerPhone;
	private String DistrictName;
	private Integer AreaFrom;
	private Integer AreaTo;
	private Integer RentFrom;
	private Integer RentTo;
	private String UserName;
	private List<String> TypeCode;
	
	private BuildingSearchBuilder(Builder builder) {
	BuildingName=builder.BuildingName;
	 Ward=builder.Ward;
	 Way=builder.Way;
	 NumberOfBasement=builder.NumberOfBasement;
	 FloorArea=builder.FloorArea;
	 ManagerName=builder.ManagerName;
	 ManagerPhone=builder.ManagerPhone;
	 DistrictName=builder.DistrictName;
	 AreaFrom=builder.AreaFrom;
	 AreaTo=builder.AreaTo;
	 RentFrom=builder.RentFrom;
	 RentTo=builder.RentTo;
	 UserName=builder.UserName;
	 TypeCode=builder.TypeCode;
		
	}
	

	public String getBuildingName() {
		return BuildingName;
	}


	public String getWard() {
		return Ward;
	}


	public String getWay() {
		return Way;
	}


	public Integer getNumberOfBasement() {
		return NumberOfBasement;
	}


	public Integer getFloorArea() {
		return FloorArea;
	}


	public String getManagerName() {
		return ManagerName;
	}


	public String getManagerPhone() {
		return ManagerPhone;
	}


	public String getDistrictName() {
		return DistrictName;
	}


	public Integer getAreaFrom() {
		return AreaFrom;
	}


	public Integer getAreaTo() {
		return AreaTo;
	}


	public Integer getRentFrom() {
		return RentFrom;
	}


	public Integer getRentTo() {
		return RentTo;
	}


	public String getUserName() {
		return UserName;
	}


	public List<String> getTypeCode() {
		return TypeCode;
	}


	public static class Builder{
		private String BuildingName;
		private String Ward;
		private String Way;
		private Integer NumberOfBasement;
		private Integer FloorArea;
		private String ManagerName;
		private String ManagerPhone;
		private String DistrictName;
		private Integer AreaFrom;
		private Integer AreaTo;
		private Integer RentFrom;
		private Integer RentTo;
		private String UserName;
		private List<String> TypeCode;
		public Builder setBuildingName(String buildingName) {
			BuildingName = buildingName;
			return this;
		}
		public Builder setWard(String ward) {
			Ward = ward;
			return this;
		}
		public Builder setWay(String way) {
			Way = way;
			return this;
		}
		public Builder setNumberOfBasement(Integer numberOfBasement) {
			NumberOfBasement = numberOfBasement;
			return this;
		}
		public Builder setFloorArea(Integer floorArea) {
			FloorArea = floorArea;
			return this;
		}
		public Builder setManagerName(String managerName) {
			ManagerName = managerName;
			return this;
		}
		public Builder setManagerPhone(String managerPhone) {
			ManagerPhone = managerPhone;
			return this;
		}
		public Builder setDistrictName(String districtName) {
			DistrictName = districtName;
			return this;
		}
		public Builder setAreaFrom(Integer areaFrom) {
			AreaFrom = areaFrom;
			return this;
		}
		public Builder setAreaTo(Integer areaTo) {
			AreaTo = areaTo;
			return this;
		}
		public Builder setRentFrom(Integer rentFrom) {
			RentFrom = rentFrom;
			return this;
		}
		public Builder setRentTo(Integer rentTo) {
			RentTo = rentTo;
			return this;
		}
		public Builder setUserName(String userName) {
			UserName = userName;
			return this;
		}
		public Builder setTypeCode(List<String> typeCode) {
			TypeCode = typeCode;
			return this;
		}
		
		public BuildingSearchBuilder Build() {
			return new BuildingSearchBuilder(this);
		}
		
		
	}
}
