package tp4;



import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.colorchooser.ColorChooserComponentFactory;

public class Fenetre_1 extends JFrame implements ActionListener{
	private JLabel lbl_uti;
	private TextField txt_u;
	private JLabel lbl_mdp;
	private JPasswordField mdp_fdl;
	private JPanel pn_u;
	private JPanel pn_mdp;
	private JButton btn;
	private JPanel myPanel;
	private JPanel buttons_panel;
	private Test_Event t;
	
	 
	public Fenetre_1() {
		
		this.setTitle("Test Evenement");
		this.setSize(550, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		
		myPanel = new JPanel(new GridLayout(3,2,1,1));
		myPanel.setPreferredSize(new Dimension(500,100));
		
		this.add(myPanel);
		
		buttons_panel=new JPanel();
		this.add(buttons_panel);
		
		lbl_uti=new JLabel("BIENVENUE !");
		lbl_uti.setOpaque(true);
		lbl_uti.setHorizontalAlignment(JLabel.CENTER);
		lbl_uti.setPreferredSize(new Dimension(200, 70));
		
		lbl_uti.setBackground(new Color(95,158,160));
		lbl_uti.setForeground(new Color(51,51,51));
		lbl_uti.setFont(new Font("Arial", Font.ROMAN_BASELINE|Font.ITALIC, 25));
		


		
		
		lbl_mdp=new JLabel("mot de passe");
		lbl_mdp.setPreferredSize(new Dimension(100, 40));
		lbl_mdp.setToolTipText("tapper mot de pass pour acceder a l'application");
		
		
	    mdp_fdl=new JPasswordField();
	    mdp_fdl.setPreferredSize(new Dimension(200,30));
	    
	    
	    btn=new JButton("Valider");
	    btn.addActionListener(this);
	   
	    myPanel.add(lbl_uti);
	    
	    myPanel.add(lbl_mdp);
	    myPanel.add(mdp_fdl);
	    buttons_panel.add(btn);
	   

	    this.add(myPanel, BorderLayout.CENTER);
	    this.add(buttons_panel, BorderLayout.SOUTH);
		
	}
String s="issatso";
	public static void main(String[] args) {
		Fenetre_1 f=new Fenetre_1();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
	String s=mdp_fdl.getText();
			if (s.compareTo("issatso")!=0)
		  {
		   JOptionPane.showMessageDialog(this,"veuiller réessayer ", "mot de pass invalid!!", JOptionPane.ERROR_MESSAGE);
		  }
		 
		else if (s.compareTo("issatso")==0) {
			 
			Test_Event t1=new Test_Event();
			t1.setVisible(true);
			this.hide();
		    
			
		}}}}
		
	


