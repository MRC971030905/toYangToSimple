package com.byxy.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // ע�����class�д��ڣ�����ʱ��ͨ�������ȡ
@Target(ElementType.METHOD) // Ŀ���Ƿ���
public @interface LogAnn {
	/**
	 * ģ������
	 */
	String module() default "";

	/**
	 * ��������
	 */
	String methods() default "";
}
