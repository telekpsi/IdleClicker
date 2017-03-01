/*
 David Evander
 
-start screen that comes up when game runs asking hero's name
-implement items that boost stats
-monster stats are somewhat random within range of hero
-set up attack action
-update health method for hero and monster
-timer based attack by monster
-possible speed implementation for monster
-if hero's health hits 0, death screen, offer to start over
-when monster dies, hero gets exp(check for level up), 1/10 chance of item drop
-hero and monster images
-monster name and picture relation (randomized) 

*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IdleClicker extends JFrame{
	
	private Hero hero;
	private Monster monster;
	
	public static void main(String[] args) {
		IdleClicker game = new IdleClicker();
		game.setSize(600,350);
		game.setVisible(true);
		
	}	
	
	private JLabel lblLvlCnt, lblAttCnt, lblDefCnt, lblHltCnt, lblExpCnt, lblName;
	private JLabel lblMLvlCnt, lblMAttCnt, lblMDefCnt, lblMHltCnt, lblMExpCnt, lblMName;
	
	public IdleClicker() {
		Hero you = new Hero();
		hero=you;
		Monster him = new Monster();
		monster=him;
		System.out.println(hero.att);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Click for Greatness!");
		lblTitle.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(197, 5, 190, 23);
		panel.add(lblTitle);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLevel.setBounds(481, 60, 50, 14);
		panel.add(lblLevel);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHealth.setBounds(481, 100, 50, 14);
		panel.add(lblHealth);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAttack.setBounds(481, 140, 50, 14);
		panel.add(lblAttack);
		
		JLabel lblDefense = new JLabel("Defense:");
		lblDefense.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDefense.setBounds(481, 180, 50, 14);
		panel.add(lblDefense);
		
		JLabel lblExp = new JLabel("EXP:");
		lblExp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExp.setBounds(481, 220, 50, 14);
		panel.add(lblExp);
		
		lblName = new JLabel("Hero");
		lblName.setBounds(481, 30, 90, 14);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblName);
		
		lblLvlCnt = new JLabel("1");
		lblLvlCnt.setBounds(537, 60, 46, 14);
		panel.add(lblLvlCnt);
		
		lblHltCnt = new JLabel("5/5");
		lblHltCnt.setBounds(537, 100, 46, 14);
		panel.add(lblHltCnt);
		
		lblAttCnt = new JLabel("1");
		lblAttCnt.setBounds(537, 140, 46, 14);
		panel.add(lblAttCnt);
		
		lblDefCnt = new JLabel("0");
		lblDefCnt.setBounds(537, 180, 46, 14);
		panel.add(lblDefCnt);
		
		lblExpCnt = new JLabel("0/5");
		lblExpCnt.setBounds(537, 220, 46, 14);
		panel.add(lblExpCnt);
		
		JButton btnAttack = new JButton("Attack!");
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAttack.setBounds(247, 263, 89, 23);
		panel.add(btnAttack);
		
		JLabel lblMExp = new JLabel("EXP:");
		lblMExp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMExp.setBounds(10, 220, 50, 14);
		panel.add(lblMExp);
		
		lblMExpCnt = new JLabel("1");
		lblMExpCnt.setBounds(66, 220, 46, 14);
		panel.add(lblMExpCnt);
		
		JLabel lblMDef = new JLabel("Defense:");
		lblMDef.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMDef.setBounds(10, 180, 50, 14);
		panel.add(lblMDef);
		
		lblMDefCnt = new JLabel("0");
		lblMDefCnt.setBounds(66, 180, 46, 14);
		panel.add(lblMDefCnt);
		
		JLabel lblMAtt = new JLabel("Attack:");
		lblMAtt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMAtt.setBounds(10, 140, 50, 14);
		panel.add(lblMAtt);
		
		lblMAttCnt = new JLabel("1");
		lblMAttCnt.setBounds(66, 140, 46, 14);
		panel.add(lblMAttCnt);
		
		JLabel lblMHlt = new JLabel("Health:");
		lblMHlt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMHlt.setBounds(10, 100, 50, 14);
		panel.add(lblMHlt);
		
		lblMHltCnt = new JLabel("5/5");
		lblMHltCnt.setBounds(66, 100, 46, 14);
		panel.add(lblMHltCnt);
		
		JLabel lblMLevel = new JLabel("Level:");
		lblLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLevel.setBounds(10, 60, 50, 14);
		panel.add(lblLevel);
		
		lblMLvlCnt = new JLabel("1");
		lblMLvlCnt.setBounds(66, 60, 46, 14);
		panel.add(lblMLvlCnt);
		
		lblMName = new JLabel("Monster");
		lblMName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMName.setBounds(10, 30, 90, 14);
		panel.add(lblMName);
	}

	//maybe should make private
	public class Hero {
		//initialize stats
		private int expNow, expNext, att, def, lvl, hltNow, hltMax;
		private String name;
		//constructor
		public Hero(){
			expNow = 0;
			expNext = 5;
			att = 1;
			def = 0;
			lvl = 1;
			hltNow=5;
			hltMax=5;
			name = "Hero";
		}

		public String getName() {
			return name;
		}
		public void setName(String name){
			this.name=name;
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
	
	public class Monster {
		//initialize stats
		private int att, def, lvl, hltNow, hltMax, expVal;
		private String name;	
		
			//constructor
		public Monster(){
				att = 0;
				def = 0;
				lvl = 0;
				hltNow=0;
				hltMax=0;
				expVal=0;
				name="Monster";
				//maybe a speed stat?
		}
		
		//getters and setters
		public int getExpVal() {
			return expVal;
		}
		public void setExpVal(int expVal) {
			this.expVal = expVal;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
	
	public void MakeMon(int level){
		
	}
	
	//once expNow==expNext, hero's stats get a boost
	public void LvlUp(Hero hero){
		hero.setAtt(hero.getAtt()+2);
		hero.setDef(hero.getDef()+1);
		hero.setExpNow(0);
		hero.setExpNext(hero.getExpNext()*2);
		hero.setHltMax((int)Math.ceil((double)hero.getHltMax()*1.2));
		hero.setHltNow(hero.getHltMax());
		hero.setLvl(hero.getLvl()+1);
		updateHStats();
	}
	
	//tells JFrame to update the stats
	public void updateHStats(){
		
	}
	
}
