package com.byxy.aop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.byxy.entity.Log;
import com.byxy.service.LogService;

@Aspect // 1 声明切面
@Component // 2.注册为Bean
public class LogAop {
	@Resource
	private LogService logService;

	@Pointcut("execution(* com.byxy.action.*.*(..))") // 3. 声明切面
	public void actionTime() {
	};

	@Around("actionTime()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Log log = new Log();
		Object target = pjp.getTarget();// 类的名字
		Signature sig = pjp.getSignature();
		MethodSignature msig = null;
		String name = pjp.getSignature().getName();
		if (!(sig instanceof MethodSignature)) {
			throw new IllegalArgumentException("该注解只能用于方法");
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
			// 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
			if (method.isAnnotationPresent(LogAnn.class)) {
				LogAnn systemlog = method.getAnnotation(LogAnn.class);
				log.setModel(systemlog.module() + "-" + systemlog.methods());
			}
		}
		Object object = pjp.proceed();
		long end = System.currentTimeMillis();
		log.setName(name);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		log.setBeginDate(new Date());
		log.setNtime(end - start);
		String time=df.format(log.getBeginDate());
		ServletActionContext.getRequest().getSession().setAttribute("log",log);
		ServletActionContext.getRequest().getSession().setAttribute("time",time);
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
