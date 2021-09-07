package com.green.biz.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {

	@Pointcut("execution(* com.green.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@Pointcut("execution(* com.green.biz..*Impl.*(..))")
	public void allPointcut() {}
}
