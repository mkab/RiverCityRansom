package gestionCombat;

import java.util.ArrayList;

import gangster.GangsterService;
import moteurJeu.COMMANDE;
import personnage.PersonnageService;
import terrain.TerrainService;

public class GestionCombatDecorator implements GestionCombatService{

	GestionCombatService delegate;
	
	public GestionCombatDecorator(GestionCombatService gcs){
		this.delegate=gcs;
	}
	public void init(int largeur, int hauteur, int profondeur) {
		delegate.init(largeur, hauteur, profondeur);
	}

	public TerrainService terrain() {
		return delegate.terrain();
	}

	public PersonnageService alex() {
		return delegate.alex();
	}

	public PersonnageService ryan() {

		return delegate.ryan();
	}

	public GangsterService slick() {
		return delegate.slick();
	}

	public GangsterService gangster(int id) {
		return delegate.gangster(id);
	}

	public boolean estFrappe(String nom, int id) {
		return delegate.estFrappe(nom, id);
	}

	public boolean estGele(String nom, int id) {
		return delegate.estGele(nom, id);
	}
	public int positionX(String nom, int id) {
		return delegate.positionX(nom, id);
	}
	public int positionY(String nom, int id) {
		return delegate.positionY(nom, id);
	}
	public boolean collisionEntrePersos(String nom1, String nom2, int id) {
		return delegate.collisionEntrePersos(nom1, nom2, id);
	}
	public boolean collision() {
		return delegate.collision();
	}
	public void gerer(COMMANDE cA, COMMANDE cR) {
		delegate.gerer(cA, cR);
	}
	public int nombreGangsters() {
		return delegate.nombreGangsters();
	}
	public ArrayList<GangsterService> listeGangsters(){
		return delegate.listeGangsters();
	}
	public int nombreGangsterMax(){
		return delegate.nombreGangsterMax();
	}
	@Override
	public boolean EstGeleAlex() {
		return delegate.EstGeleAlex();
	}
	public boolean EstGeleRyan() {
		return delegate.EstGeleRyan();
	}
	@Override
	public boolean EstGeleSlick() {
		return delegate.EstGeleSlick();
	}
	@Override
	public ArrayList<Boolean> GangsterGele() {
		return delegate.GangsterGele();
	}


}
