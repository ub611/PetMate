package model;

public class PetDTO {
	private String userID;
	private int pet_ID;
	private String kind_ID;
	private String pet_age;
	private String pet_gender;
	private String pet_name;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getPet_ID() {
		return pet_ID;
	}
	public void setPet_ID(int pet_ID) {
		this.pet_ID = pet_ID;
	}
	public String getKind_ID() {
		return kind_ID;
	}
	public void setKind_ID(String kind_ID) {
		this.kind_ID = kind_ID;
	}
	public String getPet_age() {
		return pet_age;
	}
	public void setPet_age(String pet_age) {
		this.pet_age = pet_age;
	}
	public String getPet_gender() {
		return pet_gender;
	}
	public void setPet_gender(String pet_gender) {
		this.pet_gender = pet_gender;
	}
	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	
	public PetDTO() { };
   
   public PetDTO(String userID, int pet_ID, String kind_ID, String pet_age, String pet_gender, String pet_name){
      this.userID = userID;
      this.pet_ID = pet_ID;
      this.kind_ID = kind_ID;
      this.pet_age = pet_age;
      this.pet_gender = pet_gender;
      this.pet_name = pet_name;
   }
	
}
