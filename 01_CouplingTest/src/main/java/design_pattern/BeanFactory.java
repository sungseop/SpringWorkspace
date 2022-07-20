package design_pattern;

public class BeanFactory {
	
	// 매개변수: beanName - 요청하는 객체명(samsung, lg)
	public Object getBean(String beanName) {
		
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		
		return null;
	}
}