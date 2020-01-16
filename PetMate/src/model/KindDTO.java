package model;

public class KindDTO {
	private String kind_ID;
	private String kind_name;
	
	public KindDTO() { };
	
	public KindDTO(String kind_ID, String kind_name){
		this.kind_ID = kind_ID;
		this.kind_name = kind_name;
	}
	
	public String getKind_ID() {
		return kind_ID;
	}
	public void setKind_ID(String kind_ID) {
		this.kind_ID = kind_ID;
	}
	public String getKind_name() {
		return kind_name;
	}
	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}
	
	
}
