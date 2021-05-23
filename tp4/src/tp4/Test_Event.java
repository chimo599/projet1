package tp4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.proteanit.sql.DbUtils;




public class Test_Event extends JFrame implements MouseListener,ActionListener{
	
	public static  ArrayList<Contact> data=new ArrayList <Contact>();
	
	
	private JPanel pn_1;
	private JLabel lbl_nom;
	private JTextField txt_nom;
	private JLabel lbl_prn;
	private JTextField txt_prn;
	private JLabel lbl_psd;
	private JTextField txt_psd;
	private JButton btn_val;
	private JPanel pn_2;
	private JLabel lbl_help;
	private JPanel pn_list;
	private DefaultListModel model;
	private JList jl;
	public static JList list_psd;
	private JSplitPane pn_split;
	private JLabel lbl_etoile;
	private JLabel lbl_etoile2;
	private JLabel lbl_etoile3;
	private JPanel pn_on;
	private JTabbedPane tabs;

	private JPopupMenu pop;

	private JMenuItem item_sup;

	private JMenuItem item_suptt;

	private JMenuItem item_ren;

	private JPopupMenu pop_tab;

	private JMenuItem item_fermer;

	private JMenuItem item_fermertt;

	private JScrollPane list_scrl;


	public static JTable list_jtable;

	

	

	private JButton btn_aff;


	private JPanel pn_dessous;


	public static Data_Acces pm;


	private ResultSet rs;


	
	

	public Test_Event() {
		 pm= new Data_Acces();
		 rs= pm.getAllPersonne();
		 
		
		
		this.setTitle("Test Evenement");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		tabs=new JTabbedPane();
		tabs.setPreferredSize(new Dimension(600,700));
		
		
		pn_1=new JPanel();
		pn_2=new JPanel();
		pn_on=new JPanel();
		pn_on.add(tabs);
		
		
		lbl_nom=new JLabel("Nom");
		lbl_nom.setHorizontalAlignment(JLabel.CENTER);
		txt_nom=new JTextField();
		lbl_etoile=new JLabel("*");
		lbl_etoile.setForeground(Color.RED);
		txt_nom.setText("  Tapper votre nom");
		txt_nom.setPreferredSize(new Dimension(150,20));
		pn_1.add(lbl_nom);
		pn_1.add(txt_nom);
		pn_1.add(lbl_etoile);
		
		
		lbl_prn=new JLabel("Prénom");
		lbl_prn.setHorizontalAlignment(JLabel.CENTER);
		txt_prn=new JTextField();
		lbl_etoile2=new JLabel("*");
		lbl_etoile2.setForeground(Color.RED);
		txt_prn.setText("  Tapper votre prenom");
		txt_prn.setPreferredSize(new Dimension(150,20));
		pn_1.add(lbl_prn);
		pn_1.add(txt_prn);
		pn_1.add(lbl_etoile2);
		

		
		lbl_psd=new JLabel("Pseudo");
		lbl_psd.setHorizontalAlignment(JLabel.CENTER);
		txt_psd=new JTextField();
		lbl_etoile3=new JLabel("*");
		lbl_etoile3.setForeground(Color.RED);
		txt_psd.setText("  Tapper votre pseudo");
		txt_psd.setPreferredSize(new Dimension(150,20));
		pn_1.add(lbl_psd);
		pn_1.add(txt_psd);
		pn_1.add(lbl_etoile3);

		
		pn_list=new JPanel();
	    
	   
		
		btn_val=new JButton("Valider");
		pn_1.add(btn_val);
	
		
		lbl_help=new JLabel ("Help:");
		btn_aff=new JButton("Afficher tous les données");
		pn_dessous =new JPanel(new BorderLayout());
		pn_dessous.add(lbl_help,BorderLayout.WEST);
		pn_dessous.add(btn_aff,BorderLayout.EAST);
		
		
		
		model=new DefaultListModel();
		
		
		
		list_psd=new Mylist();
		list_psd.setModel(model);
		list_psd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_psd.setSelectionForeground(Color.blue);
		
		
		
		
	    
		
		pn_split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,list_psd,pn_on);
		pn_split.setOneTouchExpandable(true);
		pn_split.setDividerLocation(170);
		pn_split.setDividerSize(10);
				
		this.add(pn_dessous,BorderLayout.SOUTH);
		this.add(pn_1,BorderLayout.NORTH);
		this.add(pn_split,BorderLayout.CENTER);
		
		
		
		//events sur pn1
		txt_nom.addMouseListener(this);
		txt_prn.addMouseListener(this);
		txt_psd.addMouseListener(this);
		
		txt_nom.setToolTipText( "tapper votre nom,prenom et le pseudo et presser valider pour ajouter un nouveau candidat" );
		txt_prn.setToolTipText( "tapper votre nom,prenom et le pseudo et presser valider pour ajouter un nouveau candidat" );
		txt_psd.setToolTipText( "tapper votre nom,prenom et le pseudo et presser valider pour ajouter un nouveau candidat" );
		//event sur jlabes
		lbl_nom.addMouseListener(this);
		lbl_prn.addMouseListener(this);
		lbl_psd.addMouseListener(this);
	     //event sur btn valider 
		btn_val.addMouseListener(this);
		list_psd.addMouseListener(new ecouteur_list()); 
		
		//event sur btn_affichage de jtable
		btn_aff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 updatetable();
					
			
			}
		});
		
		
		 pop=new JPopupMenu();
		 
		item_sup=new JMenuItem("Supprimer");
		pop.add(item_sup);
		item_sup.addActionListener(this);
		item_suptt=new JMenuItem("Supprimer tout");
		pop.add(item_suptt);
		item_suptt.addActionListener(this);
		 item_ren=new JMenuItem("Renommer");
		pop.add(item_ren);
		item_ren.addActionListener(this);

		
		
		pop_tab=new JPopupMenu();
		item_fermer= new JMenuItem("Fermer");
		pop_tab.add(item_fermer);
		item_fermer.addActionListener(this);
		
		item_fermertt= new JMenuItem("Fermer tout");
		pop_tab.add(item_fermertt);
		
		item_fermertt.addActionListener(this);
		
		
		tabs.addMouseListener(new ecout_tab());
		
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg="";
		int ind=-1 ;
		if(e.getSource()==item_sup) {
			int n=list_psd.getSelectedIndex();
			if(n>=0)
		         ind=JOptionPane.showConfirmDialog(null, "Voulez-vous continuer ?");
			      if (ind==0) {
			    	 pm.suppimerSelonpseudo(data.get(n).pseudo);
			      	 tabs.remove(n);
			         model.remove(n);
			        
			         data.remove(n);}
			        
			    
			
		}
		if(e.getSource()==item_suptt) {
			ind=JOptionPane.showConfirmDialog(null, "Voulez-vous continuer ?");
			if (ind==0) {
			  model.removeAllElements();
			  pm.suppimertt();
			  data.clear();
			  tabs.removeAll();
			  JOptionPane.showMessageDialog(null, "liste est vidée");
			  
		}}
		if(e.getSource()==item_ren) {
			int n=list_psd.getSelectedIndex();
			if(n>=0)
			 msg=JOptionPane.showInputDialog(null, "entrer le nouveau pseudo"); 
			  if (msg!=null) {
			   pm.renommer(msg,data.get(n).pseudo );
			   model.setElementAt(msg, n);
			   data.get(n).pseudo=msg;
			   
			   tabs.remove(n);
			   tabs.addTab(" "+n+model.getElementAt(n), new Onglet(data.get(n).nom,data.get(n).prenom,data.get(n).pseudo));
			   
			 
		}}
		if(e.getSource()==item_fermer) {
			
				tabs.remove(tabs.getSelectedIndex());
			
			}
		
			
			
			
	if(e.getSource()==item_fermertt) {
		tabs.removeAll();
				 
				
				 
			 
			 
	
}
	
		
	}
	class ecout_tab extends MouseAdapter{
		
	
		public void mouseClicked(MouseEvent e) {
			if (e.getButton()==e.BUTTON3) {
				pop_tab.show(tabs, e.getX(), e.getY());
			}
			
		
	}}
	
	          
	          class ecouteur_list extends MouseAdapter{
	        	

				@Override
	        	public void mouseClicked(MouseEvent e) {
	        	
	        		      
	        		
	        		
	        		if (e.getButton()==e.BUTTON3) {
	        			int n=list_psd.getSelectedIndex();
	        			if(n>=0)
	        				{ 
	        				
	        				
	        				pop.show(list_psd, e.getX(), e.getY());
	        				
	        				}
	        			
	        		}
	        		if (e.getButton()==e.BUTTON1){
	        			int n=list_psd.getSelectedIndex();
	        			if(n>=0)
							try {
								tabs.setSelectedIndex(n);
							} catch (Exception e1) {
								tabs.addTab(" "+n+model.getElementAt(n), new Onglet(data.get(n).nom,data.get(n).prenom,data.get(n).pseudo));
							}
	        					
	        			
	        		}
	        	}}
	          
	        
	
	        	  
	        	  public static void main(String[] args) {
		 Test_Event t=new Test_Event();

	}
	String s=null;


	private JFrame frame_Aff;


	private modelPersonne model1;


	private JPanel pn_jtab;

	public void updatetable() {//jtable
		rs= pm.getAllPersonne();
		
		frame_Aff=new JFrame();
		frame_Aff.setTitle("Affichage");
		frame_Aff.setSize(400,400);
		frame_Aff.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame_Aff.setVisible(true);
		pn_jtab=new JPanel();
		model1 =new modelPersonne(rs);
		list_jtable =new JTable(model1);
		list_scrl =new JScrollPane(list_jtable);
		
		
		
		pn_jtab.add(list_scrl);
		frame_Aff.add(pn_jtab);
		frame_Aff.setVisible(true);
		list_jtable.repaint();
		
		list_jtable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    if (e.getButton() == e.BUTTON3) {
			    	pop.show(list_jtable,e.getX(), e.getY());
			    	
		};
	}});}
	
          
	

	@Override
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==txt_nom) {
			txt_nom.setText("");
		}
		if (e.getSource()==txt_prn) {
			txt_prn.setText("");
		}
		if (e.getSource()==txt_psd) {
			txt_psd.setText("");
			
		}
		if (e.getSource()==btn_val) {
			if (txt_nom.getText().isEmpty())
			  {
			   JOptionPane.showMessageDialog(null,"entrer votre nom !!", "Error", JOptionPane.ERROR_MESSAGE);
		}
			if (txt_prn.getText().isEmpty())
			  {
			   JOptionPane.showMessageDialog(null,"entrer votre prenom !!", "Error", JOptionPane.ERROR_MESSAGE);
		}
			if (txt_psd.getText().isEmpty())
			  {
			   JOptionPane.showMessageDialog(null,"entrer votre pseudo !!", "Error", JOptionPane.ERROR_MESSAGE);
		}
			if(txt_nom.getText().isEmpty()==false&&txt_prn.getText().isEmpty()==false&&txt_psd.getText().isEmpty()==false) {
				
             
                int a=0;
				int i=0;
				Contact c=new Contact (txt_nom.getText(),txt_prn.getText(),txt_psd.getText());
				boolean existe=false;
				
				if(data.isEmpty()==true) {
					data.add(c);
			        model.addElement(txt_psd.getText());
			      
					
			        existe=true;}
				if(data.isEmpty()==false) {
				      while ( i<data.size()&&existe==false)
						{
							if (data.get(i).pseudo.equals(txt_psd.getText())) {
								
								JOptionPane.showMessageDialog(this," ce pseudo existe deja !!", " Error", JOptionPane.ERROR_MESSAGE);
								existe=true;}
								           
							 i++;}
					
				      if(existe==false) {
					data.add(c);
				    model.addElement(txt_psd.getText());
				      
			}}}}
			}
				
			
			
		
	
		

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		 if (e.getSource()==lbl_nom)
             
             lbl_nom.setForeground(new Color(95,158,160));
          
		if (e.getSource()==lbl_prn)
         
			lbl_prn.setForeground(new Color(95,158,160));
      
 		if (e.getSource()==lbl_psd)
    
 			lbl_psd.setForeground(new Color(95,158,160));
	}
   
		
	

	@Override
	public void mouseExited(MouseEvent e) {
 if (e.getSource()==lbl_nom)
             
             lbl_nom.setForeground(Color.black);
          
		if (e.getSource()==lbl_prn)
         
			lbl_prn.setForeground(Color.black);
      
 		if (e.getSource()==lbl_psd)
    
 			lbl_psd.setForeground(Color.black);
	}
}






	

