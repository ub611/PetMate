package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class AdoptCommentDTO {
	private String userid;
	private int adoptid;
	private String time;
	private String content;
	private String index;
	
	public AdoptCommentDTO() {
	}
	
	public AdoptCommentDTO(String userid, int adoptid, String time, String content, String index) {
		super();
		this.userid = userid;
		this.adoptid = adoptid;
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
	public int getAdoptid() {
		return adoptid;
	}
	public void setAdoptid(int adoptid) {
		this.adoptid = adoptid;
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
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
}
