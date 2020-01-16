package model;

public class SellDTO {
	private String userID;
	private int sell_ID;
	private String item_kind_ID;
	private int item_price;
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getSell_ID() {
		return sell_ID;
	}
	public void setSell_ID(int sell_ID) {
		this.sell_ID = sell_ID;
	}
	public String getItem_kind_ID() {
		return item_kind_ID;
	}
	public void setItem_kind_ID(String item_kind_ID) {
		this.item_kind_ID = item_kind_ID;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public SellDTO() { }
	
	public SellDTO(String userID, int sell_ID, String item_kind_ID, int item_price, String title, String content) {
		this.userID = userID;
		this.sell_ID = sell_ID;
		this.item_kind_ID = item_kind_ID;
		this.item_price = item_price;
		this.title = title;
		this.content = content;
	};
}
