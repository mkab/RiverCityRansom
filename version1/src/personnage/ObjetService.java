package personnage;

public class ObjetService implements Objet{

	private boolean estUtilisable;
	private int valeur;
	private String nom;
	
	
	public ObjetService(String nom,int valeur,boolean estUtilisable){
		this.valeur=valeur;
		this.estUtilisable=estUtilisable;
		this.nom=nom;
	}
	
	public boolean estUtilisable() {
		
		return estUtilisable;
	}

	
	public int valeur() {
	
		return valeur;
	}

	public String nom() {

		return nom;
	}

}
