package com.xugu;

import com.xugu.dao.UserDao;
import com.xugu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //获取spring上下文环境
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        UserService us=(UserService) ac.getBean("userService");
        us.test();

        UserDao ud=(UserDao) ac.getBean("userDao");
        ud.test();
    }
}
