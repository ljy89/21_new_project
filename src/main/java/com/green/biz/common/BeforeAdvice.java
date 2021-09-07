package com.green.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		Signature sig = jp.getSignature();
		String method = sig.getName(); 
		Object[] args = jp.getArgs();
		
		if(args.length != 0) {
			System.out.printf("[BEFORE] : %s() args : %s \n", method,args[0].toString());
		}else {
			System.out.printf("[BEFORE] : %s() args : 없음 \n", method);
		}
		
	}
}
