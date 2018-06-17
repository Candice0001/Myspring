package spring.annotation;

/**
 * 
 * Title: AttachEmlement.java
 * Description: 使用自定义注解
 * @author chengge
 * @date 2018年5月24日
 *
 */
public class AttachEmlement {
	
	//不使用注解
	public void AttachDefault(String name) {
		System.out.println("地址是："+name);
	}
	
	//使用注解并传入参数
	@AttachAnnotation(paramValue="广东省惠州市")
	public void AttachAnnotation(String name) {
		System.out.println("地址是："+name);
	}
	
	//使用注解的默认参数
	@AttachAnnotation
	public void AttachAnnotationDefault(String name) {
		System.out.println("地址："+name);
	}

}
