package exercise1;

//  Player, Weapon 클래스를 테스트하는 Java 프로그램

public class Main {

	public static void main(String[] args) {
		Weapon weapon = new Knife();
		
		Player player = new Player(weapon);
		
		player.usePlayerWeapon();
	}
}