package springIoc.myspring.bean;

/**
 * 
 * Title: Property.java
 * Description: 封装配置文件中的property节点
 * @author chengge
 * @date 2018年5月23日
 *
 */
public class Property {
	
	private String name;
	private String value;//使用value属性直接指定值
	private String ref;//使用ref属性来指定依赖的对象
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	

}
