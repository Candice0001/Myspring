package springIoc.myspring.bean;

/**
 * 
 * Title: Address.java
 * Description: 
 * @author chengge
 * @date 2018年5月23日
 *
 */
public class Address {
	
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address[city="+city+"]";
	}
	

}
