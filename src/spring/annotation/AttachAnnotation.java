package spring.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * Title: AttachAnnotation.java
 * Description: 自定义注解，注解包括：注解声明、使用注解的元素、操作使用注解元素的代码
 * @author chengge
 * @date 2018年5月24日
 *
 */

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;
@Retention(RetentionPolicy.RUNTIME) //定义注解的保留时间,注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target(ElementType.METHOD) //注解的作用目标，作用在方法上
public @interface AttachAnnotation { //@interface 表示是注解类
	String paramValue() default "深圳市";//参数名为“paramValue”的默认值为“深圳市”

}
