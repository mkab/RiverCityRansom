package personnage;

import java.util.ArrayList;

public class PersonnageImplErr implements PersonnageService{


	protected String nom;
	protected int largeur,hauteur,profondeur;
	protected  int force,pointsDeVie,argentRamasse,valeur;
	protected  boolean estVaincu,estPositionSaut,estPositionFrappe,estGele;
	protected  Objet choseEquipee;
	protected  int pvMax;
	int positionX,positionY;
	protected  ArrayList<Objet> objets = new ArrayList<Objet>();

	public boolean estUtilisable() {

		return true;  //Un personnage est toujours utilisable
	}


	public int valeur() {
		return valeur;
	}


	public String nom() {
		return nom;
	}


	public int largeur() {
		return largeur;
	}

	public int hauteur() {
		return hauteur;
	}

	public int profondeur() {
		return profondeur;
	}

	public int force() {
		return force;
	}

	public int pointsDeVie() {
		return pointsDeVie;
	}

	public int pvMax() {
		return pvMax;
	}
	public int ArgentRamasse() {
		return argentRamasse;
	}
	public boolean estVaincu() {
		return pointsDeVie<=0;
	}
	public boolean estEquipe() {
		return choseEquipee!=null;
	}
	public Objet choseEquipee() {
		return choseEquipee;
	}
	public boolean estPositionSaut() {
		return estPositionSaut;
	}
	public void init(String nom, int largeur, int hauteur, int profondeur,
			int force, int pointsDeVie) {
		this.nom=nom;
		this.largeur=largeur;
		this.hauteur=hauteur;
		this.profondeur=profondeur;
		this.force=force;
		this.pointsDeVie=pointsDeVie;
		this.argentRamasse=0;
		this.valeur=10;
		this.estVaincu=false;
		this.estPositionSaut=false;
		this.pvMax=pointsDeVie;


	}

	public PersonnageService depotPV(PersonnageService p, int pv)
	{
		this.pointsDeVie+=pv;
		if(pointsDeVie>pvMax()) pointsDeVie=pvMax();
		return this;
	}

	public PersonnageService retraitPV(PersonnageService p, int pv)
	{
		this.pointsDeVie-=pv;
		if(pointsDeVie<0) pointsDeVie=0;
		return this;
	}
	public PersonnageService depotArgent(PersonnageService p, int a)
	{
		this.argentRamasse+=a;
		return this;
	}
	public PersonnageService retraitArgent(PersonnageService p, int a)
	{
		this.argentRamasse-=a;
		return this;
	}
	public PersonnageService ramasser(PersonnageService p, Objet o)
	{

		if(o.estUtilisable())
			this.choseEquipee=o;
		else this.argentRamasse+=o.valeur();
		return this;
	}
	public PersonnageService jeter(PersonnageService p, Objet o)
	{

		this.force-= this.choseEquipee.valeur();
		this.choseEquipee=null;
		return this;
	}
	public PersonnageService sauter(PersonnageService p)
	{
		this.estPositionSaut=true;
		return this;
	}

	public int positionX() {

		return positionX;
	}

	public int positionY() {
		return positionY;
	}

	public PersonnageService setPosition(int x, int y) {

		this.positionX=x;
		this.positionY=y;
		return this;
	}

	public boolean estPositionFrappe() {
		return estPositionFrappe;
	}
	
	public PersonnageService setPositionFrappe(boolean pos) {
		this.estPositionFrappe=pos;
		return this;
	}

	

}
