package org.dedunu.spring.spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dedunu on 11/18/14.
 */
public class App {
    public static void main(String args[]) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Device device = (Device) applicationContext.getBean("device");
        device.turnOn();
    }
}
