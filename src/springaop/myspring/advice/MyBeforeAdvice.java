package springaop.myspring.advice;

import java.lang.reflect.Method;

import springaop.myspring.aop.MethodBeforeAdvice;

/**
 * 
 * Title: MyBeforeAdvice.java
 * Description: 自定义前置通知类
 * @author chengge
 * @date 2018年5月24日
 *
 */
public class MyBeforeAdvice extends MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) {
		System.out.println("method:"+method+"Object[] args:"+args.length+" "+args+" 前置通知"+" target:"+target);
		
	}

}
