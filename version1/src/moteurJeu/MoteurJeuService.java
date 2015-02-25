package moteurJeu;

import gestionCombat.GestionCombatService;

public interface MoteurJeuService {

	public int maxPasJeu();
	public int pasJeuCourant();
	public boolean estFini();
	public RESULTAT resultatFinal();
	public void setFini(boolean fini);
	public GestionCombatService combat();
	public void init(int largeur,int hauteur,int profondeur,int maxPas);
	public MoteurJeuService pasJeu(MoteurJeuService m,COMMANDE cA,COMMANDE cR);
	
}
