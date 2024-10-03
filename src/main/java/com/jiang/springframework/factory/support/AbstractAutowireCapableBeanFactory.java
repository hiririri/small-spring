package com.jiang.springframework.factory.support;

import com.jiang.springframework.BeansException;
import com.jiang.springframework.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new BeansException("Failed to instantiate bean: " + beanName, e);
        } catch (IllegalAccessException e) {
            throw new BeansException("Illegal access while instantiating bean: " + beanName, e);
        } catch (NoSuchMethodException e) {
            throw new BeansException("No default constructor found for bean: " + beanName, e);
        } catch (InvocationTargetException e) {
            throw new BeansException("Constructor threw an exception for bean: " + beanName, e);
        }


        addSingleton(beanName, bean);
        return bean;
    }
}
