package tp4;

import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

public class Onglet extends JPanel implements ActionListener  {
	public static  ArrayList<Donnes_final> data_final=new ArrayList <Donnes_final>();
	private JLabel lbl_nom;
	private JPanel pn_diff;
	private JComboBox cm_niv_diff;
	private JLabel lbl_nv;
	private JPanel pn_op;
	private JCheckBox nv1;
	private JCheckBox nv2;
	private JCheckBox nv3;
	private JCheckBox nv5;
	private JCheckBox nv4;
	private JCheckBox nv6;
	private JPanel pn_all;
	private JCheckBox op1;
	private JCheckBox op2;
	private JCheckBox op3;
	private JCheckBox op4;
	public static JButton btn_val;
	private JPanel pn_btn;
	private JPanel pn_cm;
	private TitledBorder border_1;
	private TitledBorder border_2;
	private JPanel pn_all_on;
	private DefaultListModel model;
	private JList jl;
	private JPanel pn_list;
	private String cat8;
	private String cat9;
	private String cat10;
	private String cat11;
	private String cat3;
	private String cat4;
	private String cat7;
	private String cat6;
	private String cat5;
	private JCheckBox nv7;
	private String cat1;
	private String cat2;
	

	public Onglet(String nom,String prenom,String pseudo) {
    this.setPreferredSize(new Dimension(700,600));
    this.setVisible(true);

    pn_all=new JPanel();
    pn_all.setPreferredSize(new Dimension(600,500));
    this.setLayout(new BorderLayout());
    this.add(pn_all);
    
    
    
    lbl_nom=new JLabel("Bienvenue "+nom+" "+prenom);
    lbl_nom.setForeground(Color.BLACK);
	lbl_nom.setBackground(new Color(95,158,160));
	lbl_nom.setOpaque(true);
	lbl_nom.setHorizontalAlignment(JLabel.CENTER);
	lbl_nom.setFont(new Font("Arial",Font.PLAIN, 25));
	lbl_nom.setPreferredSize(new Dimension(700, 60));
	
    pn_all.add(lbl_nom);
    
    pn_diff=new JPanel();
    pn_diff.setPreferredSize(new Dimension(500,120));
    pn_diff.setLayout(new FlowLayout());
    border_1 = new TitledBorder("Difficulté");
    pn_diff.setBorder(border_1);
	String[] niv_diff=new String[] {"Facile","Intermédiaire","Diffiçile"};
    cm_niv_diff=new JComboBox<>(niv_diff);
    

    pn_cm=new JPanel();
    pn_cm.setPreferredSize(new Dimension(400,50));
    pn_cm.add(cm_niv_diff);
    pn_diff.add(pn_cm);
    
    lbl_nv=new JLabel("Choisir la/les categories:");
    pn_diff.add(lbl_nv);
    
    
    nv1=new JCheckBox("1");
    pn_diff.add(nv1);
    nv2=new JCheckBox("2");
    pn_diff.add(nv2);
    nv3=new JCheckBox("3");
    pn_diff.add(nv3);
    nv4=new JCheckBox("4");
    pn_diff.add(nv4);
    nv5=new JCheckBox("5");
    pn_diff.add(nv5);
    nv6=new JCheckBox("6");
    pn_diff.add(nv6);
    nv7=new JCheckBox("7");
    pn_diff.add(nv7);
    
    nv5.setEnabled(false);
	nv6.setEnabled(false);
	nv3.setEnabled(false);
	nv4.setEnabled(false);
	nv1.setEnabled(false);
	nv2.setEnabled(false);
	nv7.setEnabled(false);
    
    pn_all.add(pn_diff);
    
    pn_op=new JPanel();
    
    border_2 = new TitledBorder("Options :");
    pn_op.setBorder(border_2);
    op1=new JCheckBox("Emettre son");
    
    pn_op.add(op1);
    
    op2=new JCheckBox("Affiche score");
    pn_op.add(op2);
    op3=new JCheckBox("Plein ecran");
    pn_op.add(op3);
    op4=new JCheckBox("Ombre");
    pn_op.add(op4);
    pn_all.add(pn_op);
    
    
    op1.addActionListener(this);
    op2.addActionListener(this);
    op3.addActionListener(this);
    op4.addActionListener(this);
    
    btn_val=new JButton("Valider");
    btn_val.addActionListener(this);
    pn_btn=new JPanel();
    pn_btn.add(btn_val);
    
    
    this.add(pn_btn,BorderLayout.SOUTH);
    
    
    cm_niv_diff.addActionListener(new ActionListener() {     
        

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if (cm_niv_diff.getSelectedItem().toString().compareTo("Diffiçile")==0 ){
				
				
				
				ButtonGroup group = new ButtonGroup();
				group.add(nv5);
				group.add(nv6);
				group.add(nv7);
				
				
				
				nv7.setEnabled(true);
				nv5.setEnabled(true);
				nv6.setEnabled(true);
				nv3.setEnabled(false);
				nv4.setEnabled(false);
				nv1.setEnabled(false);
				nv2.setEnabled(false);
				
			
			}
			if (cm_niv_diff.getSelectedItem().toString().compareTo("Intermédiaire")==0) {
				
				ButtonGroup group = new ButtonGroup();
				group.add(nv3);
				group.add(nv4);
				
				nv3.setEnabled(true);
				nv4.setEnabled(true);
				nv1.setEnabled(false);
				nv2.setEnabled(false);
				nv5.setEnabled(false);
				nv6.setEnabled(false);
				nv7.setEnabled(false);
			}
			if (cm_niv_diff.getSelectedItem().toString()=="Facile") {
				
				ButtonGroup group = new ButtonGroup();
				group.add(nv1);
				group.add(nv2);
				
				
				nv7.setEnabled(false);
				nv1.setEnabled(true);
				nv2.setEnabled(true);
				nv5.setEnabled(false);
				nv6.setEnabled(false);
				nv4.setEnabled(false);
				nv3.setEnabled(false);
			
			}
			
		}});}
    String get_nv() {
    	String c="";
    	if (cm_niv_diff.getSelectedItem().toString()=="Facile") {
    	  if (nv1.isSelected())
				c=c+nv1.getText();
		  if (nv2.isSelected())
			c=c+nv2.getText();}
		if (  cm_niv_diff.getSelectedItem().toString().compareTo("Intermédiaire")==0  ) {
			if (nv3.isSelected())
				c=c+nv3.getText();
			if (nv4.isSelected())
				c=c+nv4.getText();}
		if (cm_niv_diff.getSelectedItem().toString().compareTo("Diffiçile")==0 ) {	
			if (nv5.isSelected())
				c=c+nv5.getText();
			if (nv6.isSelected())
				c=c+nv6.getText();}
			if (nv7.isSelected())
				c=c+nv7.getText();
	  return c;	
    }
    	      
    String get_op() {
    	String a="";
		
		
		if(op1.isSelected()) {
			if(a.length()==0)
				a=op1.getText();
			else 
			a=a+","+op1.getText();}
		if(op2.isSelected()) {
			if(a.length()==0)
				a=op2.getText();
			else 
			a=a+","+op2.getText();}
		if(op3.isSelected()) {
			if(a.length()==0)
				a=op3.getText();
			else 
			a=a+","+op3.getText();}
		if(op4.isSelected()) {
			if(a.length()==0)
				a=op4.getText();
			else 
			a=a+","+op4.getText();}
		return a;
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==op1) {
			border_2 = new TitledBorder("Options :1");
		    pn_op.setBorder(border_2);
			
		}
		if (e.getSource()==op2) {
			border_2 = new TitledBorder("Options :2");
		    pn_op.setBorder(border_2);
			
		}
		if (e.getSource()==op3) {
			border_2 = new TitledBorder("Options :3");
		    pn_op.setBorder(border_2);
			
		}
		if (e.getSource()==op4) {
			border_2 = new TitledBorder("Options :4");
		    pn_op.setBorder(border_2);
			
		}
		if(e.getSource()==btn_val) {
			
			
		
			int n=Test_Event.list_psd.getSelectedIndex();
			Test_Event.pm.inserer(Test_Event.data.get(n).pseudo, Test_Event.data.get(n).nom, Test_Event.data.get(n).prenom, cm_niv_diff.getSelectedItem().toString(),get_nv(),get_op());
			
			if (op1.isSelected()==true) {//option
				cat8 = "Son : True";
				}
				else {
				cat8 = "Son : False";
				}
				if (op2.isSelected()==true) {
				cat9 = "Affichage score : true";
				}
				else {
				cat9 ="Affichage score : False";
				}
				if (op3.isSelected()==true) {
				cat10 = "Plein ecron : true";
				}
				else {
				cat10 ="Plein ecron : False";
				}
				if (op4.isSelected()==true) {
				cat11 = "Ombre : true";
				}
				else {
				cat11 ="Ombre : False";
				}
				if(cm_niv_diff.getSelectedItem().toString().compareTo("Facile")==0){
				cat3="";
				cat4=" ";
				cat5=" ";
				cat6=" ";
				cat7 =" ";
				if(nv1.isSelected()==true) {

				cat1="Categorie 1";

				}
				if(nv1.isSelected()==false) {

				cat1="";

				}
				if(nv2.isSelected()==true) {

				cat2="Categorie 2";

				}
				if(nv2.isSelected()==false) {

				cat2="";

				} }
				if( cm_niv_diff.getSelectedItem().toString().compareTo("Intermédiaire")==0) {
				cat1="Categorie 1";
				cat2="Categorie 2";
				cat5=" ";
				cat6=" ";
				cat7 =" ";
				if(nv3.isSelected()==true) {
				cat3="Categorie 3";
				}
				if(nv3.isSelected()==false) {
				cat3="";
				}
				if(nv4.isSelected()==true) {
				cat4="Categorie 4";
				}
				if(nv4.isSelected()==false) {
				cat4="";
				}
				}
				if(cm_niv_diff.getSelectedItem().toString().compareTo("Diffiçile")==0) {
				cat1="Categorie 1";
				cat2="Categorie 2";
				cat3="Categorie 3";
				cat4="Categorie 4";
				if(nv5.isSelected()==true) {
				cat5="Categorie 5";
				}
				if(nv5.isSelected()==false) {
				cat5="";
				}

				if(nv6.isSelected()==true) {
				cat6="Categorie 6";
				}
				if(nv6.isSelected()==false) {
				cat6="";
				}

				if(nv7.isSelected()==true) {
				cat7="Categorie 7";
				}
				if(nv7.isSelected()==false) {
				cat7="";
				}
				}
				 BufferedWriter bw;
				 try {
				 bw = new BufferedWriter(new FileWriter("C:\\Users\\asus\\Desktop\\test\\"+Test_Event.data.get(n).pseudo+".html"));
				 bw.write("<html>"
				 + "<head>"
				 + "<title>"+Test_Event.data.get(n).nom+Test_Event.data.get(n).prenom+"</title>"
				 + "</head>"
				 + "<body>"
				 + "<form>"  
				   + "<fieldset>"  
				    + "<legend>Information personnelle:</legend>"  
				    +"<p> Nom :"+Test_Event.data.get(n).nom+"</p>"
				    +"<p> Prenom :"+Test_Event.data.get(n).prenom+"</p>"
				    +"<p> Pseudo :"+Test_Event.data.get(n).pseudo+"</p>"
				 +"</fieldset>"  
				 +"</form>"  

				 +"<form>"  
				   +"<fieldset>"  
				    +"<legend>Configuration:</legend>"  

				 +"<form>"  
				   +"<fieldset>"  
				    +"<legend>difficulté:"+cm_niv_diff.getSelectedItem().toString()+"</legend>"  
				 +"<p>"+cat1+"<br>"+cat2+"<br>"+cat3+"<br>"+cat4+"<br>"+cat5+"<br>"+cat6+"<br>"+cat7+"</p>"
				 +"</fieldset>"  
				 +"</form>"
				 +"<form>"  
				 +"<fieldset>"  
				 +"<legend>Options:</legend>"  
				 +"<p>"+cat8+"<br>"+cat9+"<br>"+cat10+"<br>"+cat11
				 +"</fieldset>"  
				 +"</form>"    
				 +"</fieldset>"  
				 +"</form>"

				 + "</body>"
				 + "</html>");
				   bw.close();
				 } catch (IOException e1) {
				 // TODO Auto-generated catch block
				 e1.printStackTrace();
				 }

				
				 }
				 } ;
		}
	
      



		
	
	 
