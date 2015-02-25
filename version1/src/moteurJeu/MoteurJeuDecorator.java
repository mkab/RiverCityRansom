package moteurJeu;

import gestionCombat.GestionCombatService;

public class MoteurJeuDecorator implements MoteurJeuService{

	MoteurJeuService delegate;
	
	public MoteurJeuDecorator(MoteurJeuService mjs){
		this.delegate=mjs;
	}
	public int maxPasJeu() {
		return delegate.maxPasJeu();
	}

	public int pasJeuCourant() {

		return delegate.pasJeuCourant();
	}

	@Override
	public boolean estFini() {
		// TODO Auto-generated method stub
		return delegate.estFini();
	}

	@Override
	public RESULTAT resultatFinal() {
		// TODO Auto-generated method stub
		return delegate.resultatFinal();
	}

	@Override
	public GestionCombatService combat() {
		// TODO Auto-generated method stub
		return delegate.combat();
	}

	@Override
	public MoteurJeuService pasJeu(MoteurJeuService m, COMMANDE cA, COMMANDE cR) {
		// TODO Auto-generated method stub
		return delegate.pasJeu(m, cA, cR);
	}

	@Override
	public void init(int largeur, int hauteur,int profondeur, int maxPas) {
		// TODO Auto-generated method stub
		delegate.init(largeur,hauteur,profondeur,maxPas);
		
	}
	@Override
	public void setFini(boolean fini) {
		delegate.estFini();
		
	}

}
