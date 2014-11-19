package org.dedunu.maven.sample;

import javax.ejb.Stateless;

@Stateless
public class SampleEJB implements SampleEJBRemote {
    @Override
    public String doSomething() {
        Sample sample = new Sample();
        return  sample.doSomething();
    }
}
