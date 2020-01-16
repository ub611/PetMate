package model;

public class ItemKindDTO {
	private String item_kind_ID;
	private String item_kind_name;
	
	public ItemKindDTO() { };
	
	public ItemKindDTO(String item_kind_ID, String item_kind_name) {
		this.item_kind_ID = item_kind_ID;
		this.item_kind_name = item_kind_name;
	};
	
	public String getItem_kind_ID() {
		return item_kind_ID;
	}
	public void setItem_kind_ID(String item_kind_ID) {
		this.item_kind_ID = item_kind_ID;
	}
	public String getItem_kind_name() {
		return item_kind_name;
	}
	public void setItem_kind_name(String item_kind_name) {
		this.item_kind_name = item_kind_name;
	}
	
	
}
