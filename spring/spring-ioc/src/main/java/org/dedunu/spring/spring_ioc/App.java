package org.dedunu.spring.spring_ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by dedunu on 11/18/14.
 */
public class App {
    public static void main(String args[]) {
        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        Device device = (Device) beanFactory.getBean("device");
        device.turnOn();
    }
}
