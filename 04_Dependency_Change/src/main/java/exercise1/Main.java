package exercise1;

//  Player, Weapon Ŭ������ �׽�Ʈ�ϴ� Java ���α׷�

public class Main {

	public static void main(String[] args) {
		Weapon weapon = new Knife();
		
		Player player = new Player(weapon);
		
		player.usePlayerWeapon();
	}
}