package model;

import java.util.Date;

public class FestivalDTO {
	private String userID;
	private String festival_ID;
	private Date festival_date;
	private String festival_title;
	private String festival_place;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFestival_ID() {
		return festival_ID;
	}
	public void setFestival_ID(String festival_ID) {
		this.festival_ID = festival_ID;
	}
	public Date getFestival_date() {
		return festival_date;
	}
	public void setFestival_date(Date festival_date) {
		this.festival_date = festival_date;
	}
	public String getFestival_title() {
		return festival_title;
	}
	public void setFestival_title(String festival_title) {
		this.festival_title = festival_title;
	}
	public String getFestival_place() {
		return festival_place;
	}
	public void setFestival_place(String festival_place) {
		this.festival_place = festival_place;
	}
	public FestivalDTO() { };
   
   public FestivalDTO(String festival_title, Date festival_date, String festival_place){
      this.festival_date = festival_date;
      this.festival_title = festival_title;
      this.festival_place = festival_place;
   }
	
}