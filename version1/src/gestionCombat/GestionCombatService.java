package gestionCombat;

import java.util.ArrayList;

import moteurJeu.COMMANDE;
import gangster.GangsterService;
import personnage.PersonnageService;
import terrain.TerrainService;

public interface GestionCombatService {

	public void init(int largeur,int hauteur,int profondeur);
	
	public TerrainService terrain();
	public PersonnageService alex();
	public PersonnageService ryan();
	public GangsterService slick();
	public GangsterService gangster(int id);
	public boolean estFrappe(String nom,int id);
	public boolean estGele(String nom,int id);
	public int positionX(String nom,int id);
	public int positionY(String nom,int id);
	public boolean collisionEntrePersos(String nom1,String nom2,int id);
	public boolean collision();
	public boolean EstGeleAlex();
	public boolean EstGeleRyan();
	public boolean EstGeleSlick();
	public ArrayList<Boolean> GangsterGele();
	public int nombreGangsters();
	public int nombreGangsterMax();
	public ArrayList<GangsterService> listeGangsters();
	public void gerer(COMMANDE cA, COMMANDE cR);

	
}
