package com.green.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		System.out.println("[예외처리] 비즈니스 로직 수행중 예외발생");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 매개변수 값이 입력되었습니다");
		}else if(exceptObj instanceof Exception){
			System.out.println("프로그램 실행 중 문제가 발생했습니다");
		}
	}
}
