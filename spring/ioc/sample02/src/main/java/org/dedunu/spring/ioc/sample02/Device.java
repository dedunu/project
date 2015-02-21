package org.dedunu.spring.ioc.sample02;

public class Device {

    private Button powerButton;
    private Button silentButton;
    private Button lockButton;

    public void setPowerButton(Button powerButton) {
        this.powerButton = powerButton;
    }

    public void setSilentButton(Button silentButton) {
        this.silentButton = silentButton;
    }

    public void setLockButton(Button lockButton) {
        this.lockButton = lockButton;
    }

    public void turnOn() {
        powerButton.printButton();
        silentButton.printButton();
        lockButton.printButton();
    }
}