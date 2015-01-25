package org.dedunu.spring.ioc.sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Device device = (Device) applicationContext.getBean("device");
        device.turnOn();
    }
}