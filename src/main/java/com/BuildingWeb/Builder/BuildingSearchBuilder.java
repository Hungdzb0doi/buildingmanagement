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
	private Integer IdDistrict;
	private Integer AreaFrom;
	private Integer AreaTo;
	private Integer RentFrom;
	private Integer RentTo;
	private Integer IdUser;
    private String Direction;
    private String Class;
	private List<String> TypeCode;
	
	private BuildingSearchBuilder(Builder builder) {
	BuildingName=builder.BuildingName;
	 Ward=builder.Ward;
	 Way=builder.Way;
	 NumberOfBasement=builder.NumberOfBasement;
	 FloorArea=builder.FloorArea;
	 ManagerName=builder.ManagerName;
	 ManagerPhone=builder.ManagerPhone;
	 IdDistrict=builder.IdDistrict;
	 AreaFrom=builder.AreaFrom;
	 AreaTo=builder.AreaTo;
	 RentFrom=builder.RentFrom;
	 RentTo=builder.RentTo;
	 IdUser=builder.IdUser;
     Direction=builder.Direction;
     Class=builder.Class;
	 TypeCode=builder.TypeCode;
		
	}
    public String getDirection() {
        return Direction;
    }

    public String getclass() {
        return Class;
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


	public Integer getIdDistrict() {
		return IdDistrict;
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


	public Integer getIdUser() {
		return IdUser;
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
		private Integer IdDistrict;
		private Integer AreaFrom;
		private Integer AreaTo;
		private Integer RentFrom;
		private Integer RentTo;
        private String Direction;
        private String Class;
		private Integer IdUser;
		private List<String> TypeCode;
        public Builder setDirection(String direction) {
            Direction = direction;
            return this;
        }
        public Builder setClass(String class1) {
            Class = class1;
            return this;
        }
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
		public Builder setIdDistrict(Integer idDistrict) {
			IdDistrict = idDistrict;
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
		public Builder setIdUser(Integer Iduser) {
			IdUser = Iduser;
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
