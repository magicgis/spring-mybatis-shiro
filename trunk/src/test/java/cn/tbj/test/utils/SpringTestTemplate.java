
package cn.tbj.test.utils;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;


/**
 * Description: SpringJunit4
 * SpringTestTemplate.java 
 * Create on 2012-12-18 下午5:57:10 
 * @author Strong
 * @version 1.0
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved.
 */
@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestTemplate {
	@BeforeClass
	public static void initLog4j(){
		try {
			Log4jConfigurer.initLogging("classpath:log4j.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
