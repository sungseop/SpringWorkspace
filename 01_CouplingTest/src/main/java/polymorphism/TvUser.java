package polymorphism;

public class TvUser {

	public static void main(String[] args) {
		// TV tv = new SamsungTV();
		// SamsungTV ��ü ��� LgTV ��ü�� ����� ���
		TV tv = new LgTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}