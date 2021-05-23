package tp4;

public class Contact {
	String nom,prenom,pseudo;

	public Contact(String nom, String prenom, String pseudo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + "]";
	}

}
