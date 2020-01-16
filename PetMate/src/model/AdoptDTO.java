package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class AdoptDTO {
   private String userID;
   private int adopt_ID;
   private int adopt_price;
   private int adopt_age;
   private String adopt_kind;
   private String adopt_gender;
   private int is_adopted;
   private String adopt_date;
   
  
   public void setIs_adopted(int is_adopted){
	   this.is_adopted = is_adopted;
   }
   public int getIs_adopted(){
	   return is_adopted;
   }
   
   public void setAdopt_date(Date adopt_date){
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   this.adopt_date = sdf.format(adopt_date);
   }
   public String getAdopt_date(){
	   return adopt_date;
   }
   
   public String getUserID() {
      return userID;
   }
   public void setUserID(String userID) {
      this.userID = userID;
   }
   public int getAdopt_ID() {
      return adopt_ID;
   }
   public void setAdopt_ID(int adopt_ID) {
      this.adopt_ID = adopt_ID;
   }
   public int getAdopt_price() {
      return adopt_price;
   }
   public void setAdopt_price(int adopt_price) {
      this.adopt_price = adopt_price;
   }
   public int getAdopt_age() {
      return adopt_age;
   }
   public void setAdopt_age(int adopt_age) {
      this.adopt_age = adopt_age;
   }
   public String getAdopt_kind() {
      return adopt_kind;
   }
   public void setAdopt_kind(String adopt_kind) {
      this.adopt_kind = adopt_kind;
   }
   public String getAdopt_gender() {
      return adopt_gender;
   }
   public void setAdopt_gender(String adopt_gender) {
      this.adopt_gender = adopt_gender;
   }

   public AdoptDTO() { };
   
   public AdoptDTO(String userID, int adopt_ID, int adopt_price, int adopt_age, String adopt_kind, String adopt_gender, int is_adopted, String adopt_date){
      this.userID = userID;
      this.adopt_ID = adopt_ID;
      this.adopt_price = adopt_price;
      this.adopt_age = adopt_age;
      this.adopt_kind = adopt_kind;
      this.adopt_gender = adopt_gender;
      this.is_adopted = is_adopted;
      this.adopt_date = adopt_date;
   }
   
  
}	