package com.green.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {


	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		
		StopWatch sw = new StopWatch();
		
		sw.start();
		Object returnObj = pjp.proceed();
		sw.stop();
		
		
		System.out.printf("%s() : 수행시간 = %d (ms)\n",method,sw.getTotalTimeMillis());
		return returnObj;
	}
}
