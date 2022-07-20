package exercise1;

public class Player {
	private Weapon weapon;
	
	public Player() {}
	
	public Player(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void usePlayerWeapon() {
		weapon.useWeapon();
	}
}