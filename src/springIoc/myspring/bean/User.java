package springIoc.myspring.bean;

/**
 * 
 * Title: User.java
 * Description: 创建测试类
 * @author chengge
 * @date 2018年5月23日
 *
 */
public class User {
	
	private String userName;
	private Address address;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
	
	

}
