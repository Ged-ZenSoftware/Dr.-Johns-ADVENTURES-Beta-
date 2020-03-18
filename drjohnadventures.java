import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Game {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton, choice1, choice2, choice3, choice4, choice5;
	JTextArea mainTextArea;
	int playerHP, maxPlayerHP, monsterHP, position, silverRing;
	String weapon;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	

	
	
	public static void main(String[] args) {

		new Game();
	}

	public Game() {
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Dr. Johns\n ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START >");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
		
	}
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area. This game is going to be great! I am sure of it."); //mainTextArea not JTextArea written twice
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice One");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice Two");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice Three");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice Four");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 50, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		
		hpLabel = new JLabel("Heath:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetup();

	} //End of public void createGameScreen();
	
	public void playerSetup() {
		playerHP = 25;
		maxPlayerHP = 25;
		monsterHP = 15;
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		townGate();
	} //End of public void playerSetup();
	
	public void townGate(){
		position = 11;
		mainTextArea.setText("Your at the front door of your office..\n Your manager is standing next to the\ndoor Waiting to talk to you.\n What do you do?");
		choice1.setText("Talk to your manager");
		choice2.setText("Fight the manager");
		choice3.setText("Ingore the manager");
		choice4.setText("");
	} //End of public void townGate();
	
	public void talkManager(){
		position = 12;
		mainTextArea.setText("Guard: \nHello, Dr. John. We have seen \nreports of you doing Suspicous things\n on your computer.\n");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} //End of public void talkGuard();
	

	public void attactManager() {
		position = 13;
		mainTextArea.setText("Manager: Hey!! Dont be stupid!");
		playerHP = playerHP - 3;
		if(playerHP < 1) {
			playerHP = 0;
			hpLabelNumber.setText("" + playerHP);
			lose();
		}
		hpLabelNumber.setText("" + playerHP);
		choice1.setText("Continue");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	} //End of public void attackGuard();
	
	public void crossRoad() {
		position = 14;
		mainTextArea.setText("You went to your friends office \n(37 offices right of yours). \nWhat do you do?");
		choice1.setText("Go inside");
		choice2.setText("Knock on his office");
		choice3.setText("Go back");
		choice4.setText("");
		
	} //End of public void crossRoad();
	
	public void north() {
		position = 15;
		mainTextArea.setText("");
		playerHP = playerHP + 2;
		if(playerHP>maxPlayerHP) {
			playerHP = maxPlayerHP;
		}
		hpLabelNumber.setText("" + playerHP);
		choice1.setText("Go South");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} //End of public void north();
	
	public void east() {
		position = 16;
		mainTextArea.setText("You have reached the weapon area!\n\n(You obtained a long sword!)");
		weapon = "Long Sword";
		weaponLabelName.setText("Long Sword");
		choice1.setText("Go West");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} //End of public void east();
	
	public void west() {
		position = 17;
		
		if(silverRing == 0) {
		mainTextArea.setText("You encounter a guard while walking out of the armery!!\n\n What will you do?");
		choice1.setText("Fight");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
		} //End of if(silverRing == 0)
		else {
			defeatedMonster();
		}
	} //End of public void west();
	
	public void fight() {
		position = 18;
		mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	} //End of public void fight();
	
	public void playerAttack() {
		position = 19;
		
		int playerDamage = 0;
		
		if(weapon.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(3);
		} //End of if(weapon.equals("knife"))
		
		else if (weapon.equals("Long Sword")) {
			playerDamage = new java.util.Random().nextInt(8);
		} //End of else if (weapon.equals("long sword"))
		
		mainTextArea.setText("You attacked the monster and\ndealt " + playerDamage + " damage points!");
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} //End of public void playerAttack();
	
	public void monsterAttack() {
		position = 20;
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(6);
		mainTextArea.setText("The monster attacked you and dealt you " + monsterDamage + " damage!");
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText("" + playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		if(playerHP<1) {
			playerHP = 0;
			hpLabelNumber.setText("" + playerHP);
		}
		
	} //End of public void monsterAttack();
	
	public void win() {
		position = 21;
		
		mainTextArea.setText("You defeated the monster!\nThe monster dropped a silver ring.\n\n(You obtained a Silver Ring.)");
		
		silverRing = 1;
		
		choice1.setText("Go East");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} //End of public void win();
	
	public void lose() {
		position = 22;
		mainTextArea.setText("You are dead!\n\nGAME OVER!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		

	} //End of public void lose();
	
	public void ending() {
		position = 23;
		
		mainTextArea.setText("Guard:\nOh, so you killed that goblin!?\nThank you so much! You are a true hero.\nPlease enter and welcome to our town!\nTHE END\n\n Thanks for playing my game Loose Or Gain!! Hope you enjoyed!");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	} //End of public void ending();
	
	public void defeatedMonster() {
		position = 24;
		mainTextArea.setText("A defeated goblin lies in the path.\nThere is nothing left to see here.\nExept for a dead goblin.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} //End of public void defeatedMonster();
	
	public void beginNewGame() {
		mainTextPanel.setVisible(false);
		choiceButtonPanel.setVisible(false);
		playerPanel.setVisible(false);
		titleNamePanel.setVisible(true);
		startButtonPanel.setVisible(true);
	} //End of public void newGame();
	
	
	
	
	
	
	public class TitleScreenHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		} //End of public class TitleScreenHandler implements ActionListener
	} //End of public void createGameScreen()
	public class ChoiceHandler implements ActionListener {
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
	
			/* Position Variable Settings
			 * 11 = townGate();
			 * 12 = talkGuard();
			 * 13 = attackGuard();
			 * 14 = crossRoad();
			 * 15 = north();
			 * 16 = east();
			 * 17 = west();
			 * 18 = fight();
			 * 19 = playerAttack();
			 * 20 = monsterAttack();
			 * 21 = win();
			 * 22 = lose();
			 * 23 = ending();
			 * 24 = defeatedMonster();
			 * 25 = beginNewGame();
			 * The numbers begin at 11 instead of 01 because variables 08 and 09 cause errors.
			 */
			
			
			switch(position){
			case 11:
				switch(yourChoice){
				case "c1": if(silverRing ==1) {
					ending(); break;
				} //End of if(silverRing ==1)
				else {
					talkManager(); break;
				} //End of else
				case "c2": attactManager(); break;
				case "c3": crossRoad(); break;
				} //End of switch(yourChoice)
				break;
				
			case 12:
				switch(yourChoice) {
				case "c1": townGate(); break;
				} // End of switch(yourChoice)
				break;
				
			case 13:
				switch(yourChoice) {
				case "c1": townGate(); break;
				} // End of switch(yourChoice)
				break;
			case 14:
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2": east(); break;
				case "c3": townGate(); break; //townGate(); is south
				case "c4": west(); break;
				} // End of switch(yourChoice)
				break;
			case 15:
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				} // End of switch(yourChoice)
				break;
			case 16:
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				} // End of switch(yourChoice)
				break;
			case 17:
				switch(yourChoice) {
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				} // End of switch(yourChoice)
				break;
			case 18:
				switch(yourChoice) {
				case "c1": playerAttack(); break;
				case "c2": crossRoad(); break;
				} // End of switch(yourChoice)
				break;
			case 19:
				switch(yourChoice) {
				case "c1": 
					if(monsterHP<1) {
						win();
					} //End of if(monsterHP<1)
					else {
						monsterAttack(); break;
					} //End of else					
				} // End of switch(yourChoice)
				break;
			case 20:
				switch(yourChoice) {
				case "c1":
					if(playerHP<1) {
						lose();
					} //End of if(playerHP<1)
					else {
						fight();
					} //End of else
					break;
				} // End of switch(yourChoice)
				break;
			case 21:
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				} // End of switch(yourChoice)
				break;
			case 24:
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				} // End of switch(yourChoice)
				break;
			case 22:
				switch(yourChoice) {
				case "c1": beginNewGame(); break;
				} // End of switch(yourChoice)
				break;
			case 23:
				switch(yourChoice) {
				case "c1": beginNewGame(); break;
				} // End of switch(yourChoice)
				break;
			} //End of switch(position)
			
		} //End of public void actionPerformed(ActionEvent event)
	} //End of public class ChoiceHandler implements ActionListener
} //End of public class Game();
