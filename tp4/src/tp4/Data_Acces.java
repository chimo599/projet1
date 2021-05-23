package tp4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Data_Acces {

    Connection con = null;
    Statement st = null;

    public Data_Acces() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //charger le driver
            System.out.println("Chargement");
            
            
            String url = "jdbc:mysql://127.0.0.1/projet"; //acces au base de donnes
            String login = "root";
            String pwd = "";
            
            
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connecté");
        } catch (Exception e) {

        }}
        int inserer(String pseudo, String nom, String prenom, String difficulté ,String categorie, String option) {
            int res = 0;
            if (con != null) {
                try {
                    st = con.createStatement();
                    //creation des requetes
                    res = st.executeUpdate("insert into personne values ('" + pseudo + "','" + nom + "','" + prenom + "','" + difficulté +"','"+categorie+ "','" + option + "')");
                    JOptionPane.showMessageDialog(null, "insertion avec succes ");
                } catch (Exception e) {
                	System.out.println(e.getMessage());
                }
            }
            return res;

        }
        public ResultSet getAllPersonne() {
            ResultSet rs = null;
            
            try {
				st = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            if (st != null) {
                try {
                    rs = st.executeQuery("select * from personne; ");
                    
                    return rs;
                } catch (Exception e) {
                	System.out.println("erreur selection"+e.getMessage());
                    
                }

            }
          return rs;

}
        public int suppimerSelonpseudo(String psd)
    	{
    		int a=-1;
    		if(st!= null)
    		{
    			String requete = "delete from personne where pseudo='"+psd+"'";
    			try
    			{
    				PreparedStatement ps= con.prepareStatement(requete);
    				//ps.setString(1,psd);
    				a= ps.executeUpdate();
    				System.out.println("execute avec sucess");
    				return a;
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    				System.out.println("erreur execution requete de suppression");
    			}
    		}
    		return a;
        
}

        public int suppimertt()
    	{
    		int a=-1;
    		if(st!= null)
    		{
    			String requete = "delete from personne ";
    			try
    			{
    				PreparedStatement ps= con.prepareStatement(requete);
    				
    				a= ps.executeUpdate();
    				System.out.println("execute avec sucess");
    				return a;
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    				System.out.println("erreur execution requete de suppression");
    			}
    		}
    		return a;        
}
        public int renommer(String nvpsd,String psd) {
        	int a=-1;
    		if(st!= null)
    		{
    			String requete ="UPDATE personne SET Pseudo='"+nvpsd+"' WHERE Pseudo='"+psd+"'";
    			try
    			{
    				PreparedStatement ps= con.prepareStatement(requete);
    				
    				a= ps.executeUpdate();
    				System.out.println("execute avec sucess");
    				return a;
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    				System.out.println("erreur execution requete de renommer");
    			}
    		}
    		return a;        
        }

}