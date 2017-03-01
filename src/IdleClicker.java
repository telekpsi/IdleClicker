/*
 David Evander
 
-implement items that boost stats
-monster stats should be somewhat random within range of hero
-set up attack button actions
--update health method for hero and monster
-timer based attack by monster
--possible speed implementation for monster
-if hero's health hits 0, death screen, offer to start over
-when monster dies, hero gets exp(check for level up), 1/10 chance of item drop
-maybe a separate method that updates the scattered instances of name/strength/etc.
-make start question Fancy
*/
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class IdleClicker extends JFrame{
	
	private Hero hero;
	private Boolean isHeroDead = false;
	private Monster monster;
	
	public static void main(String[] args) {
		IdleClicker game = new IdleClicker();
		game.setSize(600,350);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
	}	
	
	private JLabel lblLvlCnt, lblAttCnt, lblDefCnt, lblHltCnt, lblExpCnt, lblName;
	private JLabel lblMLvlCnt, lblMAttCnt, lblMDefCnt, lblMHltCnt, lblMExpCnt, lblMName;
	private JLabel picLabelMonster;
	private BufferedImage hisPicture = null;
	
	public IdleClicker() {
		//use constructors and sync to privates
		Hero you = new Hero();
		hero=you;
		Monster him = new Monster();
		monster=him;
		
				
		//gui
		setTitle("Click for Greatness");
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
		
		
		//show off the handsome hero
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("hero.jpg"));
		} catch (IOException e) {
			System.out.println("MY BEAUTIFUL PORTRAIT IS MISSING!");
		}
		JLabel picLabelHero = new JLabel(new ImageIcon(myPicture));
		picLabelHero.setBounds(310, 40, 160, 200);
		panel.add(picLabelHero);
		
		//get hero's name
		Component p=panel;
		Object message="What is your name?";
		Object name2=JOptionPane.showInputDialog(p, message, "who dis?", JOptionPane.QUESTION_MESSAGE,null ,null,"Hero");
		if (name2==null){
			
		}else{
			hero.name=name2.toString();
			you.name=hero.name;
			lblName.setText(hero.name);
		}
		
		//initial monster will always be a goblin
		try {
			hisPicture = ImageIO.read(new File("goblin.jpg"));
		} catch (IOException e) {
			System.out.println("The goblin must be underfoot somewhere");;
		}
		picLabelMonster = new JLabel(new ImageIcon(hisPicture));
		picLabelMonster.setBounds(140, 40, 160, 200);
		panel.add(picLabelMonster);
		
		
		//attack button uses hero's attack and monster's defense to calculate loss of monster's health
		JButton btnAttack = new JButton("Attack!");
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAttack.setBounds(247, 263, 89, 23);
		panel.add(btnAttack);
		
		
		//gonna need some loops to keep everything going
		//set the jlabels for names and stats and delete/add of portraits after every call of RollMonster
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
				att = 1;
				def = 0;
				lvl = 1;
				hltNow=3;
				hltMax=3;
				expVal=1;
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
	
	//randomized stats based on hero's level (or maybe his stats)
	//switch statement off randomizer to pick monster name and portrait
	//later on could individualize stat ranges for individual monsters based on initial roll
	public void RollMonster() {
		//stats go here
		
		//rand and switch
		int randMonster=(((int)(Math.random()*100)%10)+1);
		switch (randMonster) {
			case 1:
				try {
					hisPicture = ImageIO.read(new File("goblin.jpg"));
				} catch (IOException e) {
					System.out.println("The goblin must be underfoot somewhere");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Goblin";
				return;
			case 2:
				try {
					hisPicture = ImageIO.read(new File("Bodak.jpg"));
				} catch (IOException e) {
					System.out.println("I want to believe");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Bodak";
				return;
			case 3:
				try {
					hisPicture = ImageIO.read(new File("kaiju.jpg"));
				} catch (IOException e) {
					System.out.println("FISHSTICKS");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Kaiju";
				return;
			case 4:
				try {
					hisPicture = ImageIO.read(new File("skeleton.jpg"));
				} catch (IOException e) {
					System.out.println("Have we checked in the closet yet?");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Skeleton";
				return;
			case 5:
				try {
					hisPicture = ImageIO.read(new File("hunch.jpg"));
				} catch (IOException e) {
					System.out.println("He can't have shuffled far!");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Hunchback";
				return;
			case 6:
				try {
					hisPicture = ImageIO.read(new File("gir.jpg"));
				} catch (IOException e) {
					System.out.println("Doom doom doom doom doom doom doom");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Gir";
				return;
			case 7:
				try {
					hisPicture = ImageIO.read(new File("creeper.jpg"));
				} catch (IOException e) {
					System.out.println("C'mon gang, let's split up and look for clues!");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Creeper";
				return;
			case 8:
				try {
					hisPicture = ImageIO.read(new File("bear.jpg"));
				} catch (IOException e) {
					System.out.println("LeoDC was here");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Bear";
				return;
			case 9:
				try {
					hisPicture = ImageIO.read(new File("vampire.jpg"));
				} catch (IOException e) {
					System.out.println("He doesn't show up well in photos anyway");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Vampire";
				return;
			case 10:
				try {
					hisPicture = ImageIO.read(new File("dragon.jpg"));
				} catch (IOException e) {
					System.out.println("WHERE ARE MY DRAGONS");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Dragon";
				return;
			default:
				try {
					hisPicture = ImageIO.read(new File("goblin.jpg"));
				} catch (IOException e) {
					System.out.println("The goblin must be underfoot somewhere");
				}
				picLabelMonster = new JLabel(new ImageIcon(hisPicture));
				picLabelMonster.setBounds(140, 40, 160, 200);
				monster.name="Goblin";
				return;
		}
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
