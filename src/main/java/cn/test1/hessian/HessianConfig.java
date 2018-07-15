package cn.test1.hessian;

import java.io.Serializable;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.testelement.property.TestElementProperty;

public class HessianConfig extends ConfigTestElement implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public HessianConfig() {
		 setArguments(new Arguments());
	}
	public void addArgument(String name, String value) {
        Arguments args = this.getArguments();
        args.addArgument(name, value);
    }

	public void removeArguments() {
        setProperty(new TestElementProperty(HessianSampler.ARGUMENTS, new Arguments()));
    }

    public void setArguments(Arguments args) {
        setProperty(new TestElementProperty(HessianSampler.ARGUMENTS, args));
    }

    public Arguments getArguments() {
        return (Arguments) getProperty(HessianSampler.ARGUMENTS).getObjectValue();
    }
}
