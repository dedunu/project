package org.dedunu.spring.spring_ioc;

/**
 * Created by dedunu on 11/18/14.
 */
public class Button {
    private String buttonText;
    private boolean toggled;

    public String getButtonText() {
        return buttonText;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void printButton(){
        if (isToggled()) {
            System.out.println(getButtonText() + " is toggled.");
        } else {
            System.out.println(getButtonText() + " is not toggled.");
        }
    }
}
