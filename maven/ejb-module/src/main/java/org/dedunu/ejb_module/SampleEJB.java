package org.dedunu.ejb_module;

import org.dedunu.jar_module.Sample;

import javax.ejb.Stateless;

/**
 * Created by dedunu on 11/18/14.
 */
@Stateless
public class SampleEJB implements SampleEJBRemote {
    @Override
    public String doSomething() {
        Sample sample = new Sample();
        return  sample.doSomething();
    }
}
