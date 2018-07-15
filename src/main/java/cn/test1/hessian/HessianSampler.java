package cn.test1.hessian;

import java.util.Map;

import org.apache.jmeter.config.Argument;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.property.JMeterProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HessianSampler extends AbstractSampler {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(HessianSampler.class);
	public static final String ARGUMENTS = "arguments";
	
	@Override
	public SampleResult sample(Entry arg0) {
		SampleResult sr = new SampleResult();
		sr.setSampleLabel(getName());
		sr.sampleStart();
		
		Arguments args = (Arguments) this.getProperty(HessianSampler.ARGUMENTS).getObjectValue();
		if (args instanceof Arguments) {
            for (JMeterProperty jMeterProperty : (Arguments) args) {
                Argument arg = (Argument) jMeterProperty.getObjectValue();
                log.info("key={}, value={}",arg.getName(),arg.getValue());
            }
        }
		log.info("");
		try {


			sr.setResponseCodeOK();
			sr.setResponseMessageOK();
			sr.setResponseData("".getBytes());
			sr.setSuccessful(true);
		} catch (Exception e1) {

		} finally {

		}
		return sr;
	}

	public static String getArguments() {
		return ARGUMENTS;
	}

}
