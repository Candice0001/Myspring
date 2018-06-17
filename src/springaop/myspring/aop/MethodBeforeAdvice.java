package springaop.myspring.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * Title: MethodBeforeAdvice.java
 * Description: 前置通知接口
 * @author chengge
 * @date 2018年5月24日
 *
 */
public abstract class MethodBeforeAdvice implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("proxy:"+proxy);
		//前置通知方法，在目标方法前执行
		before(method,args,obj);
		//目标执行方法
		Object result=proxy==null?method.invoke(obj, args):proxy.invokeSuper(obj, args);
		return result;
	}
	/**
	 * 
	 * Title: before
	 * Description:  前置通知方法
	 * @time 2018年5月24日 下午2:08:10
	 * @param method 目标方法
	 * @param args 目标方法所需参数
	 * @param target 目标对象
	 */
	public abstract void before(Method method, Object[] args, Object target);

}
