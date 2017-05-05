package miniprojekti;

import org.junit.rules.ExternalResource;

/**
 * Created by markovai on 25.4.2017.
 */
public class ServerRule extends ExternalResource{

    public ServerRule() {
    }

    @Override
    protected void before() throws Throwable {
    }

    @Override
    protected void after() {
        Stepdefs.driver.quit();
    }
}
