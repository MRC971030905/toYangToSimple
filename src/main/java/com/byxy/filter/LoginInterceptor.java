package com.byxy.filter;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String actionName = arg0.getProxy().getActionName();
		System.out.println("actionName=" + actionName);
		if ("login".equals(actionName) || "studentZC".equals(actionName)) {
			return arg0.invoke();
		} else {
			Map session = arg0.getInvocationContext().getSession();
			Object login = session.get("name");
			if (login != null) {
				return arg0.invoke();
			} else {

				return "error";
			}
		}
	}

}
