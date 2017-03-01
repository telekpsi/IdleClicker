
public class Monster {
	//initialize stats
	private int att, def, lvl, hltNow, hltMax;
		
		//constructor
	public Monster(){
			att = 0;
			def = 0;
			lvl = 0;
			hltNow=0;
			hltMax=0;
	}
		
	//getters and setters
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getHltNow() {
		return hltNow;
	}
	public void setHltNow(int hltNow) {
		this.hltNow = hltNow;
	}
	public int getHltMax() {
		return hltMax;
	}
	public void setHltMax(int hltMax) {
		this.hltMax = hltMax;
	}
}
