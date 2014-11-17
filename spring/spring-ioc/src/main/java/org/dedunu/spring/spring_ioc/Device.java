package org.dedunu.spring.spring_ioc;

/**
 * Created by dedunu on 11/18/14.
 */
public class Device {

    private String deviceType;

    public Device(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void turnOn() {
        System.out.println(getDeviceType() + " is turned on.");
    }
}
