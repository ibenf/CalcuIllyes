import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class calculatrice extends JFrame {
	private JPanel container = new JPanel();


	String[] tableaucalcul = {"1","2","3","4","5","6","7","8","9","0",".","=","C","+","-","*","/","racine"};
	JButton[] tableaudebouton = new JButton[17];

	private JLabel ecran = new JLabel();
	private double premierchiffre;
	private boolean clicOperateur = false, update = false;
	private String operateur = "";

// méthode permettant l'initialisation des differents élements de l'interface //

	private void initialiserInterface(){
		ecran = new JLabel("0");
		ecran.setFont(new Font("Arial",Font.BOLD,25));
		ecran.setForeground(Color.RED);
		ecran.setHorizontalAlignment(JLabel.RIGHT);
		ecran.setPreferredSize(new Dimension(220, 20));
		JPanel operateur = new JPanel();      
		operateur.setPreferredSize(new Dimension(175,186));
		JPanel chiffre = new JPanel();
		chiffre.setPreferredSize(new Dimension(165, 185));
		JPanel panEcran = new JPanel();
		panEcran.setPreferredSize(new Dimension(220, 30));

//boucle permettant d'afficher les differents boutons 

		for(int i = 0;i<=16;i++)
		{
			tableaudebouton[i] = new JButton(tableaucalcul[i]);
			tableaudebouton[i].setPreferredSize(new Dimension(50, 41));

			if(i == 11)
			{
				tableaudebouton[i].addActionListener(new Egalite());
				chiffre.add(tableaudebouton[i]);
			}
			else if (i== 12)
			{
				tableaudebouton[i].setForeground(Color.darkGray);
				tableaudebouton[i].addActionListener(new Annulation());
				tableaudebouton[i].setPreferredSize(new Dimension(50, 61));
				operateur.add(tableaudebouton[i]);

			}
			else if( i == 13)
			{
				tableaudebouton[i].setForeground(Color.RED);
				tableaudebouton[i].addActionListener(new Addition());
				tableaudebouton[i].setPreferredSize(new Dimension(50, 61));
				operateur.add(tableaudebouton[i]);
			}
			else if(i == 14)
			{
				tableaudebouton[i].setForeground(Color.RED);
				tableaudebouton[i].addActionListener(new Soustraction());
				tableaudebouton[i].setPreferredSize(new Dimension(50, 61));
				operateur.add(tableaudebouton[i]);
			}	
			else if (i == 15 ){	
				tableaudebouton[i].setForeground(Color.RED);
				tableaudebouton[i].addActionListener(new Multiplication());
				tableaudebouton[i].setPreferredSize(new Dimension(50, 61));
				operateur.add(tableaudebouton[i]);
			}
			else if (i == 16) {
				tableaudebouton[i].setForeground(Color.RED);
				tableaudebouton[i].addActionListener(new Division());
				tableaudebouton[i].setPreferredSize(new Dimension(50,61));
				operateur.add(tableaudebouton[i]);
			}
			else
			{
				chiffre.add(tableaudebouton[i]);
				tableaudebouton[i].addActionListener(new AfficherChiffre());

			}
		}

		panEcran.add(ecran);
		container.add(panEcran);
		container.add(chiffre);
		container.add(operateur);

	}

	public calculatrice(){
		this.setSize(360,300);
		this.setResizable(false);
		this.setTitle("Calculatrice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(container);
		this.setVisible(true);
		initialiserInterface();
	}


	private void calcul(){
		if(operateur == "+"){
			premierchiffre = premierchiffre + 
					Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(premierchiffre));
		}
		if(operateur == "-" ){
			premierchiffre = premierchiffre - 
					Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(premierchiffre));
		}          
		if(operateur == "*" ){
			premierchiffre = premierchiffre * 
					Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(premierchiffre));
		}     
		if(operateur == "/" ){
			try{
				premierchiffre = premierchiffre / 
						Double.valueOf(ecran.getText()).doubleValue();
				ecran.setText(String.valueOf(premierchiffre));
			} catch(ArithmeticException e) {
				ecran.setText("0");
			}
		}
	}



	//classe permettant les actions sur les boutons  

	public class AfficherChiffre implements ActionListener {
		public void actionPerformed(ActionEvent e){

			String str = ((JButton)e.getSource()).getText();
			if(update){
				update = false;
			}
			else{
				if(!ecran.getText().equals("Ecrivez un Chiffre"))
					str = ecran.getText() + str;
			}
			ecran.setText(str);
		}
	}


	public class Egalite implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			calcul();
			update = true;
			clicOperateur = false;
		}
	}


	public class Addition implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(premierchiffre));
			}
			else{
				premierchiffre = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "+";
			update = true;
		}
	}


	public class Soustraction implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(premierchiffre));
			}
			else{
				premierchiffre = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "-";
			update = true;
		}
	}


	public class Multiplication implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(premierchiffre));
			}
			else{
				premierchiffre = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "*";
			update = true;
		}
	}


	public class Division implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			if(clicOperateur){
				calcul();
				ecran.setText(String.valueOf(premierchiffre));
			}
			else{
				premierchiffre = Double.valueOf(ecran.getText()).doubleValue();
				clicOperateur = true;
			}
			operateur = "/";
			update = true;
		}
	}

	public class Annulation implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			clicOperateur = false;
			update = true;
			premierchiffre = 0;
			operateur = "";
			ecran.setText("0");
		}
	}      
}
