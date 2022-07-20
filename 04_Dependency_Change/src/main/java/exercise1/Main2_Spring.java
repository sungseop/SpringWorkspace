package exercise1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2_Spring {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext2.xml");
		
		Player player = (Player)container.getBean("player");
		player.usePlayerWeapon();
		
		container.close();
	}
}