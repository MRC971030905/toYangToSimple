package com.byxy.aop;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.byxy.entity.Log;
import com.byxy.service.LogService;

@Aspect        // 1 ��������
@Component  // 2.ע��ΪBean
public class LogAop {
	@Resource
	private LogService logService;
	@Pointcut("execution(* com.byxy.action.*.*(..))") // 3. ��������
	public void actionTime(){
	};	
	@Around("actionTime()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable{
		long start =System.currentTimeMillis();
		Log log=new Log();
		Object target = pjp.getTarget();//�������
		Signature sig = pjp.getSignature();
		MethodSignature msig = null;
		String name=pjp.getSignature().getName();
		if (!(sig instanceof MethodSignature)) {
			throw new IllegalArgumentException("��ע��ֻ�����ڷ���");
		}
		msig = (MethodSignature) sig;
		Class[] parameterTypes = msig.getMethod().getParameterTypes();
		Method method = null;
		try {
			method = target.getClass().getMethod(name, parameterTypes);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
		if (null != method) {
			// �ж��Ƿ�����Զ����ע�⣬˵��һ�������SystemLog�������Լ��Զ����ע��
			if (method.isAnnotationPresent(LogAnn.class)) {
				LogAnn systemlog = method.getAnnotation(LogAnn.class);
				log.setModel(systemlog.module() + "-" + systemlog.methods());
			}
		}
		Object object =	pjp.proceed();
		long end=System.currentTimeMillis();
		log.setName(name);
		log.setBeginDate(new Date());	
		log.setNtime(end-start);
		logService.add(log);
		return object;
	}
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	
}
