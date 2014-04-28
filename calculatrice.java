import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class calculette implements ActionListener 
{ 

JTextArea affichage; 

public calculette() 
{ 

JFrame all = new JFrame("Calculatrice" ); 

JPanel back = new JPanel(); 
JPanel clavier = new JPanel(); 
JPanel operation = new JPanel(); 
JPanel clavscien= new JPanel(); 
JPanel egal=new JPanel(); 

egal.setLayout(new BorderLayout()); 
back.setLayout(new BorderLayout()); 
operation.setLayout(new GridLayout(4,1)); 
clavscien.setLayout(new GridLayout(2,1)); 
clavier.setLayout(new GridLayout(4,3)); 

JButton t1 = new JButton("1" ); 
t1.addActionListener(this); 
JButton t2 = new JButton("2" ); 
t2.addActionListener(this); 
JButton t3 = new JButton("3" ); 
t3.addActionListener(this); 
JButton t4 = new JButton("4" ); 
t4.addActionListener(this); 
JButton t5 = new JButton("5" ); 
t5.addActionListener(this); 
JButton t6 = new JButton("6" ); 
t6.addActionListener(this); 
JButton t7 = new JButton("7" ); 
t7.addActionListener(this); 
JButton t8 = new JButton("8" ); 
t8.addActionListener(this); 
JButton t9 = new JButton("9" ); 
t9.addActionListener(this); 
JButton t10 = new JButton("0" ); 
t10.addActionListener(this); 
JButton t11 = new JButton("," ); 
t11.addActionListener(this); 
JButton t12 = new JButton("-" ); 
t12.addActionListener(this); 
JButton plus = new JButton("+" ); 
plus.addActionListener(this); 
JButton moins = new JButton("-" ); 
moins.addActionListener(this); 
JButton fois = new JButton("*" ); 
fois.addActionListener(this); 
JButton divise = new JButton("/" ); 
divise.addActionListener(this); 
JButton carre = new JButton("²" ); 
carre.addActionListener(this); 
JButton cube = new JButton("³" ); 
cube.addActionListener(this); 
JButton tegal = new JButton("=" ); 
tegal.addActionListener(this); 

clavier.add(t1); clavier.add(t2); clavier.add(t3); 
clavier.add(t4); clavier.add(t5); clavier.add(t6); 
clavier.add(t7); clavier.add(t8); clavier.add(t9); 
clavier.add(t10); clavier.add(t11); clavier.add(t12); 

clavscien.add(carre); 
clavscien.add(cube); 
operation.add(plus); 
operation.add(moins); 
operation.add(divise); 
operation.add(fois); 
affichage= new JTextArea(); 
affichage.setLayout(new BorderLayout()); 
egal.add(tegal); 
back.add(affichage,BorderLayout.NORTH); 
back.add(operation,BorderLayout.WEST); 
back.add(clavier,BorderLayout.CENTER); 
back.add(clavscien,BorderLayout.EAST); 
back.add(egal,BorderLayout.SOUTH); 
all.setContentPane(back); 
all.setVisible(true); 
all.pack(); 
} 

public void actionPerformed(ActionEvent evt) 
{ 
String a = evt.getActionCommand(); 
affichage.setText(a); 
} 

} 
