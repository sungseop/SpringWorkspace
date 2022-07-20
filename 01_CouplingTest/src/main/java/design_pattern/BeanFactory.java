package design_pattern;

public class BeanFactory {
	
	// �Ű�����: beanName - ��û�ϴ� ��ü��(samsung, lg)
	public Object getBean(String beanName) {
		
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		
		return null;
	}
}