package org.dedunu.spring.spring_ioc;

/**
 * Created by dedunu on 11/18/14.
 */
public class Device {

    private String deviceType;
    private int buttonCount;

    public Device(String deviceType) {
        this.deviceType = deviceType;
    }

    public Device(String deviceType, int buttonCount) {
        this.deviceType = deviceType;
        this.buttonCount = buttonCount;
    }

    public int getButtonCount() {
        return buttonCount;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void turnOn() {
        System.out.println(getDeviceType() + " is turned on. And it has " + getButtonCount() + "(s).");
    }
}
