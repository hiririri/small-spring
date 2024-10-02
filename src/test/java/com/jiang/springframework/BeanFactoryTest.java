package com.jiang.springframework;

import org.junit.jupiter.api.Test;

class BeanFactoryTest {
    @Test
    public void shouldRegisterUserServiceBean() {
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    static class UserService {
        public void queryUserInfo(){
            System.out.println("Check user info.");
        }
    }
}