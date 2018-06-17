package springIoc.myspring.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import org.dom4j.Node;

import springIoc.myspring.bean.Bean;
import springIoc.myspring.bean.Property;

/**
 * 
 * Title: XmlConfig.java
 * Description: 读取配置文件的工具类
 * @author chengge
 * @date 2018年5月23日
 *
 */
public class XmlConfig {
	
	/**
	 * 
	 * Title: getConfig
	 * Description:  读取配置文件
	 * @time 2018年5月23日 下午4:04:55
	 * @param path 配置文件的路径
	 * @return
	 */
	public static Map<String, Bean> getConfig(String path){
		
		Map<String, Bean> configMap=new HashMap<String,Bean>();
		//使用demo4j和xpath读取xml文件
		Document doc=null;
		SAXReader reader=new SAXReader();
		InputStream in=XmlConfig.class.getResourceAsStream(path);
		
		try {
			doc=reader.read(in);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException("xml配置文件路径有误！");
		}
		//定义xpath,取出所有的bean
		String xpath="//bean";
		// 对bean进行遍历
		Element beans=doc.getRootElement();
		Iterator<Element> list = beans.elementIterator();
		while(list.hasNext()) {
			Element element=list.next();
			Bean bean=new Bean();
			String id=element.attributeValue("id");
			String className=element.attributeValue("class");
			//把值封装到bean对象中
			bean.setId(id);
			bean.setClassName(className);
			
			//获取bean节点下的所有的property节点
			List<Element> prolist=element.elements("property");
			if (prolist!=null) {
				for (Element proEle : prolist) {
					Property property=new Property();
					String proName=proEle.attributeValue("name");
					String proValue=proEle.attributeValue("value");
					String proRef=proEle.attributeValue("ref");
					//封装property
					property.setName(proName);
					property.setValue(proValue);
					property.setRef(proRef);
					
					//添加到bean的property列表中
					bean.getProperties().add(property);
				}
			}
			//id 不可以重复
			if (configMap.containsKey(id)) {
				throw new RuntimeException("bean节点id重复了："+id);
			}
			//将bean封装到map中
			configMap.put(id, bean);
		}
		
		return configMap;
	}

}
