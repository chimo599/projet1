package tp4;

public class Donnes_final {
   String pseudo,nom,prenom,difficulté,categorie,option;

public Donnes_final(String pseudo, String nom, String prenom, String difficulté, String categorie, String option) {
	super();
	this.pseudo = pseudo;
	this.nom = nom;
	this.prenom = prenom;
	this.difficulté = difficulté;
	this.categorie = categorie;
	this.option = option;
}

public String getPseudo() {
	return pseudo;
}

public void setPseudo(String pseudo) {
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

public String getDifficulté() {
	return difficulté;
}

public void setDifficulté(String difficulté) {
	this.difficulté = difficulté;
}

public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}

public String getOption() {
	return option;
}

public void setOption(String option) {
	this.option = option;
}

}
