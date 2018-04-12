import java.util.ArrayList;
//I had a dream these would be used....
//enum classType {ARMORED, FLYING, CAVALRY, INFANTRY};
//enum weaponType {BLUE_LANCE, BLUE_TOME, BLUE_BREATH, RED_SWORD, RED_TOME, RED_BREATH, GREEN_AXE, GREEN_TOME, GREEN_BREATH, COLORLESS_BOW, COLORLESS_DAGGER, COLORLESS_BREATH, COLORLESS_STAFF};
public class Hero {
	
	static int heroNum = 1;
	private int unitNum;
	//Stats
	private String name;
	private String classType;
	private String weaponType;
	private int health;
	private int attack;
	private int speed;
	private int defense;
	private int resistance;
	private int totalStats;
	
	//Skills, etc
	private String weapon;
	private String supportSkill;
	private String skillA;
	private String skillB;
	private String skillC;
	private String sealS;
	
	//	private String image; //for later use
	
	public Hero() {
		name = "Placeholder Hero " + heroNum;
		classType = "N/A";
		weaponType = "N/A";
		health = 0;
		attack = 0;
		speed = 0;
		defense = 0;
		resistance = 0;
		totalStats = 0;
		
		weapon = "N/A";
		supportSkill = "N/A";
		skillA = "N/A";
		skillB = "N/A";
		skillC = "N/A";
		sealS = "N/A";
		
		this.unitNum = heroNum;
		heroNum++;
	}
	public Hero(String name, String classType, String weaponType, int health, int attack, int speed, int defense,
			int resistance, String weapon, String supportSkill, String skillA, String skillB,
			String skillC, String sealS) {
		this.name = name;
		this.classType = classType;
		this.weaponType = weaponType;
		this.health = health;
		this.attack = attack;
		this.speed = speed;
		this.defense = defense;
		this.resistance = resistance;
		this.totalStats = health+attack+speed+defense+resistance;
		this.weapon = weapon;
		this.supportSkill = supportSkill;
		this.skillA = skillA;
		this.skillB = skillB;
		this.skillC = skillC;
		this.sealS = sealS;
		this.unitNum = heroNum;
		heroNum++;
	}
	
	//Getters and Setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getClassType() { return classType; }
	public void setClassType(String classType) { this.classType = classType; }
	
	public String getWeaponType() { return weaponType; }
	public void setWeaponType(String weaponType) { this.weaponType = weaponType; }
	
	public int getHealth() { return health; }
	public void setHealth(int health) { this.health = health; }
	
	public int getAttack() { return attack; }
	public void setAttack(int attack) {	this.attack = attack; }
	
	public int getSpeed() {	return speed; }
	public void setSpeed(int speed) { this.speed = speed; }
	
	public int getDefense() { return defense; }
	public void setDefense(int defense) { this.defense = defense; }
	
	public int getResistance() { return resistance; }
	public void setResistance(int resistance) { this.resistance = resistance; }
	
	public int getTotalStats() { return totalStats; }
	public void setTotalStats(int totalStats) { this.totalStats = totalStats; }
	
	public String getWeapon() { return weapon; }
	public void setWeapon(String weapon) { this.weapon = weapon; }
	
	public String getSupportSkill() { return supportSkill; }
	public void setSupportSkill(String supportSkill) { this.supportSkill = supportSkill; }
	
	public String getSkillA() { return skillA; }
	public void setSkillA(String skillA) { this.skillA = skillA; }
	
	public String getSkillB() {	return skillB; }
	public void setSkillB(String skillB) { this.skillB = skillB; }
	
	public String getSkillC() { return skillC; }
	public void setSkillC(String skillC) { this.skillC = skillC; }
	
	public String getSealS() { return sealS; }
	public void setSealS(String sealS) { this.sealS = sealS; }
	
	
	public String toString() {
		String s = "";
		s += "Unit Name: " + name;
		s += "\nClass Type: " + classType;
		s += "\nWeapon Type: " + weaponType;
		s += "\nHealth: " + health;
		s += "\nAttack: " + attack;
		s += "\nSpeed: " + speed;
		s += "\nDefense: " + defense;
		s += "\nResistance: " + resistance;
		s += "\nTotal Stats: " + totalStats;
		
		//Make sure to add skills here
		
		return s;
		
	}
	

	
}
