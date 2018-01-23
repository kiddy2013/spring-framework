package org.springframework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.bean.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jack
 */
public class MainEnter {

	protected static final Log logger = LogFactory.getLog(MainEnter.class);

	public static void main(String[] args) {
		BeanFactory context = new ClassPathXmlApplicationContext("application.xml");
		User user = (User)context.getBean("user");
		logger.info("user=" + user.getName());
	}
}
