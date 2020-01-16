package model;

public class HospitalDTO {
	private String userID;
	private String hospital_ID;
	private String hospital_name;
	private String hospital_address;
	private String hospital_closed;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getHospital_ID() {
		return hospital_ID;
	}
	public void setHospital_ID(String hospital_ID) {
		this.hospital_ID = hospital_ID;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getHospital_address() {
		return hospital_address;
	}
	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}
	public String getHospital_closed() {
		return hospital_closed;
	}
	public void setHospital_closed(String hospital_closed) {
		this.hospital_closed = hospital_closed;
	}
	public HospitalDTO() { };
   
   public HospitalDTO(String userID, String hospital_ID, String hospital_name, String hospital_address, String hospital_closed){
      this.userID = userID;
      this.hospital_ID = hospital_ID;
      this.hospital_name = hospital_name;
      this.hospital_address = hospital_address;
      this.hospital_closed = hospital_closed;
   }
   
	
}