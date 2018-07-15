package cn.test1.hessian;

import java.awt.BorderLayout;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HessianSamplerGui extends AbstractSamplerGui {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(HessianSamplerGui.class);
	private HessianConfigGui hessianConfigGui;

	public HessianSamplerGui() {
		super();
		init();
	}

	private void init() {
		setLayout(new BorderLayout(0, 5));
		setBorder(makeBorder());
		add(makeTitlePanel(), BorderLayout.NORTH);
		hessianConfigGui = new HessianConfigGui();
		add(hessianConfigGui, BorderLayout.CENTER);
	}

	@Override
	public String getLabelResource() {
		return "example_title";
	}

	//统计图里面的显示标签
	@Override
	public String getStaticLabel() {
		return "example_title";
	}
	
	@Override
	public TestElement createTestElement() {
		HessianSampler sampler = new HessianSampler();
		modifyTestElement(sampler);
		return sampler;
	}

	@Override
	public void modifyTestElement(TestElement sampler) {
		sampler.clear();
		HessianConfig config = (HessianConfig) hessianConfigGui.createTestElement();
		configureTestElement(sampler);
		sampler.addTestElement(config);
	}

	@Override
	public void configure(TestElement te) {
		super.configure(te); // 不可缺少，否则将会出现名字丢失
		hessianConfigGui.configure(te);
	}

	@Override
	public void clearGui() {
		super.clearGui();
		hessianConfigGui.clearGui();
	}

}
