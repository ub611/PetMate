package model;

public class MemberDTO {
	private String userID;
	private String pwd;
	private String name;
	private String region;
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region){
		this.region = region;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public MemberDTO() { };
   
   	public MemberDTO(String userID, String pwd, String name, String region){
      	this.userID = userID;
      	this.pwd = pwd;
     	this.name = name;
     	this.region = region;
   }
	
   	/* 비밀번호 검사 */
    public boolean matchPassword(String pwd) {
       if (pwd == null) {
          return false;
       }
       return this.pwd.equals(pwd);
    }
    
    public boolean isSameUser(String userID) {
         return this.userID.equals(userID);
     }
    
    /* 업데이트 정보 */
    public void update(MemberDTO updateUser) {
         this.pwd = updateUser.pwd;
         this.name = updateUser.name;
         this.userID = updateUser.userID;
     }
}