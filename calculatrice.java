import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

  
public class calculatrice extends JFrame {
  private JPanel container = new JPanel();
  
  String[] tableau = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0","=", "effacer", "+", "-", "*", "/"};

  JButton[] tableau_bouton = new JButton[16];
  private JLabel ecran = new JLabel();
  
  private double chiffre1; 
  private boolean clicOperateur = false, update = false;
  private String operateur = "";
  
  public calculatrice(){
    this.setSize(300,250);
    this.setTitle("Calculette");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    initialiserInterface();
	this.setContentPane(container);
	this.setVisible(true);
  }
      
  private void initialiserInterface(){
    
	  Font police = new Font("Arial", Font.BOLD, 20);
	    ecran = new JLabel("0");
	    ecran.setFont(police);
   
	  ecran.setHorizontalAlignment(JLabel.RIGHT);
	    ecran.setPreferredSize(new Dimension(220, 20));
	    JPanel operateur = new JPanel();      
	    operateur.setPreferredSize(new Dimension(55, 225));
	    JPanel chiffre = new JPanel();
	    chiffre.setPreferredSize(new Dimension(165, 225));
	    JPanel panEcran = new JPanel();
	    panEcran.setPreferredSize(new Dimension(220, 30));

   
    for(int i = 0; i < 16; i++){
    	tableau_bouton[i] = new JButton(tableau[i]);
       
      switch(i){
        
        case 10 :
        	tableau_bouton[i].addActionListener(new Egalite());
          chiffre.add(tableau_bouton[i]);
          break;
        case 11 :
        	tableau_bouton[i].setForeground(Color.red);
        	tableau_bouton[i].addActionListener(new Annulation());
          operateur.add(tableau_bouton[i]);
          break;
        case 12 :
        	tableau_bouton[i].addActionListener(new Addition());
          
          operateur.add(tableau_bouton[i]);
          break;
        case 13 :
        	tableau_bouton[i].addActionListener(new Soustraction());
          
          operateur.add(tableau_bouton[i]);
          break;	
        case 14 :	
        	tableau_bouton[i].addActionListener(new Multiplication());
          
          operateur.add(tableau_bouton[i]);
          break;
        case 15 :
        	tableau_bouton[i].addActionListener(new Division());
          
          operateur.add(tableau_bouton[i]);
          break;
        default :
          
          chiffre.add(tableau_bouton[i]);
          tableau_bouton[i].addActionListener(new AfficherChiffre());
          break;
      }
    }
    panEcran.add(ecran);
    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
    panEcran.setSize(10,10);
    container.add(panEcran, BorderLayout.CENTER);
    container.add(chiffre, BorderLayout.NORTH);
    container.add(operateur, BorderLayout.EAST);
  }

  
  private void calcul(){
    if(operateur.equals("+")){
      chiffre1 = chiffre1 + 
            Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(chiffre1));
    }
    if(operateur.equals("-")){
      chiffre1 = chiffre1 - 
            Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(chiffre1));
    }          
    if(operateur.equals("*")){
      chiffre1 = chiffre1 * 
            Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(chiffre1));
    }     
    if(operateur.equals("/")){
      try{
        chiffre1 = chiffre1 / 
              Double.valueOf(ecran.getText()).doubleValue();
        ecran.setText(String.valueOf(chiffre1));
      } catch(ArithmeticException e) {
        ecran.setText("0");
      }
    }
  }


  
  class AfficherChiffre implements ActionListener {
    public void actionPerformed(ActionEvent e){
     
      String str = ((JButton)e.getSource()).getText();
      if(update){
        update = false;
      }
      else{
        if(!ecran.getText().equals("0"))
          str = ecran.getText() + str;
      }
      ecran.setText(str);
    }
  }


  class Egalite implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      calcul();
      update = true;
      clicOperateur = false;
    }
  }


  class Addition implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "+";
      update = true;
    }
  }


  class Soustraction implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
     else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "-";
      update = true;
    }
  }

  class Multiplication implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "*";
      update = true;
    }
  }


  class Division implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "/";
      update = true;
    }
  }

  class Annulation implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      clicOperateur = false;
      update = true;
      chiffre1 = 0;
      operateur = "";
      ecran.setText("");
    }
  }
}
