package com.jiang.springframework;

import com.jiang.springframework.factory.config.BeanDefinition;
import com.jiang.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

class BeanFactoryTest {
    @Test
    public void shouldRegisterUserServiceBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}