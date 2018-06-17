package springaop.myspring.advice;

import java.lang.reflect.Method;

import springaop.myspring.aop.AfterReturningAdvice;

public class MyAfterReturningAdvice extends AfterReturningAdvice{

	@Override
	public void afterReturning(Object resultvalue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("目标方法返回值"+resultvalue+"后置方法");
		
	}

}
