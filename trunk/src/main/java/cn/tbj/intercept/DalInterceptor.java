
package cn.tbj.intercept;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Description: DAOintercepter
 * DalInterceptor.java Create on 2012-12-18 下午6:06:28 
 * @author Strong
 * @version 1.0
 * Copyright (c) 2012 T.b.j,Inc. All Rights Reserved.
 */
public class DalInterceptor {
    private static final Logger logger = LoggerFactory.getLogger("DAL_LOGGER");
    
	public Object doAround(ProceedingJoinPoint jp) throws Throwable{
		long time = System.currentTimeMillis();
		Object obj = null;
		try {
			obj = jp.proceed(jp.getArgs());
		} catch (Throwable e) {
			logger.error(jp.getTarget().getClass().getSimpleName()+"#"+jp.getSignature().getName()+"("+Arrays.toString(jp.getArgs())+") ",e);
			throw e;
		}
		if(logger.isInfoEnabled()){
			logger.info(jp.getTarget().getClass().getSimpleName()+"#"+jp.getSignature().getName()+"("+Arrays.toString(jp.getArgs())+") "+(System.currentTimeMillis()-time)+"ms");
		}
		return obj;
	}
}
