package com.kishan.example.demonew;


import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class AutowiringSpringBeanJobFactory implements
	ApplicationContextAware{

	private transient AutowireCapableBeanFactory beanFactory;

	@Override
	public void setApplicationContext(final ApplicationContext context) {
		beanFactory = context.getAutowireCapableBeanFactory();
	}
}
