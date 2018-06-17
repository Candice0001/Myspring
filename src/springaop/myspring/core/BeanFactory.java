package springaop.myspring.core;

public interface BeanFactory {
	/**
	 * 根据name返回bean
	 * @param name
	 * @return
	 */
	Object getBean(String name);
}
