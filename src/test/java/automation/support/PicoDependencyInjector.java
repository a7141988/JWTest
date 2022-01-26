package automation.support;

import automation.ui.SharedDriver;
import io.cucumber.picocontainer.PicoFactory;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

public class PicoDependencyInjector implements ObjectFactory {

    private PicoFactory delegate = new PicoFactory();

    public PicoDependencyInjector() {
        delegate.addClass(SharedDriver.class);
    }


    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx,
                                    Hashtable<?,?> environment) {
        return new Object();
    }
}
