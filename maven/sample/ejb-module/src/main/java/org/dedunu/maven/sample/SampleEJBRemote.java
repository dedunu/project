package org.dedunu.maven.sample;

import javax.ejb.Remote;

@Remote
public interface SampleEJBRemote {
    public String doSomething();
}
