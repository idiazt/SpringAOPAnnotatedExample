package com.idiazt.springaopaspectjannotationsexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idiazt.springaopaspectjannotationsexample.entities.BaseEntity;

@Aspect
public class RetrieveObjectsAspect {

	private static Logger logger = LoggerFactory
			.getLogger(RetrieveObjectsAspect.class);

	@Pointcut("execution(* com.idiazt.springaopaspectjannotationsexample.service.*.findById(..))")
	public void findByIdMethods() {
		// As a general rule, the @Pointcut annotated method must have an empty
		// method body and must not have any throws clause. If formal are bound
		// (using args(), target(), this(), @args(), @target(), @this(),
		// @annotation()) in the pointcut, then they must appear in the method
		// signature.
	}

	@Before("findByIdMethods()")
	public void executeBefore() {
		logger.info("Entering the aspect...");
	}

	@AfterReturning(value = "findByIdMethods()", returning = "result")
	public void executeAfter(JoinPoint joinpoint, BaseEntity result) {
		logger.info("Leaving the aspect. Method: "
				+ joinpoint.getSignature().getName() + ", Result: " + result);
	}

	@Around("findByIdMethods()")
	public Object executeAround(ProceedingJoinPoint joinpoint) {
		try {
			Object result = joinpoint.proceed();
			logger.info(result.toString());
			return result;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
