package cn.test1.hessian;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.AbstractConfigGui;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.util.JMeterUtils;

public class HessianConfigGui extends AbstractConfigGui implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private ArgumentsPanel argsPanel;

	public HessianConfigGui() {
		super();
		init();
	}

	private void init() {
		setLayout(new BorderLayout(0, 5)); // 设置布局为JMeter内置的BorderLayout
		setBorder(makeBorder()); // 设置边框为默认边框
		add(makeTitlePanel(), BorderLayout.NORTH); // 添加JMeter内置的第一栏名称、注解部分
		JPanel panel = new JPanel(new BorderLayout(0, 5));
		argsPanel = new ArgumentsPanel(JMeterUtils.getResString("paramtable"));
		panel.add(argsPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER); // 添加参数Panel
	}

	@Override
	public String getLabelResource() {
		// TODO Auto-generated method stub
		return "java_request_defaults";
	}

	@Override
	public TestElement createTestElement() {
		HessianConfig config = new HessianConfig();
		modifyTestElement(config);
		return config;
	}

	@Override
	public void modifyTestElement(TestElement element) {
		configureTestElement(element);
		((HessianConfig) element).setArguments((Arguments) argsPanel.createTestElement());
	}

	@Override
	public void configure(TestElement config) {
		super.configure(config);
		argsPanel.configure((Arguments) config.getProperty(HessianSampler.ARGUMENTS).getObjectValue());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearGui() {
		super.clearGui();
		argsPanel.clearGui();
	}

}
