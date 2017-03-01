
public class Hero {
	//initialize stats
	private int expNow, expNext, att, def, lvl, hltNow, hltMax;
	
	//constructor
	public Hero(){
		expNow = 0;
		expNext = 5;
		att = 1;
		def = 0;
		lvl = 1;
		hltNow=5;
		hltMax=5;
	}

	public int getExpNow() {
		return expNow;
	}

	public void setExpNow(int expNow) {
		this.expNow = expNow;
	}

	public int getExpNext() {
		return expNext;
	}

	public void setExpNext(int expNext) {
		this.expNext = expNext;
	}

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
