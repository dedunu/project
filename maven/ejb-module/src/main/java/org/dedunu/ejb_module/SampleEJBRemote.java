package org.dedunu.ejb_module;

import javax.ejb.Remote;

/**
 * Created by dedunu on 11/18/14.
 */
@Remote
public interface SampleEJBRemote {
    public String doSomething();
}
