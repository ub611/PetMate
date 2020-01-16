package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SellCommentDTO {
	private String userid;
	private int sellid;
	private String time;
	private String content;
	private String index;
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public SellCommentDTO() {
	}
	
	public SellCommentDTO(String userid, int sellid, String time, String content, String index) {
		this.userid = userid;
		this.sellid = sellid;
		this.time = time;
		this.content = content;
		this.index = index;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getSellid() {
		return sellid;
	}
	public void setSellid(int sellid) {
		this.sellid = sellid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.time = sdf.format(time);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
