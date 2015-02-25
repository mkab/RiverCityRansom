package personnage;

public interface PersonnageService extends Objet {

	
	public String nom();
	public int largeur();
	public int hauteur();
	public int profondeur();
	public int force();
	public int pointsDeVie();
	public int pvMax();
	public int ArgentRamasse();
	public boolean estVaincu();
	public boolean estEquipe();
	public Objet choseEquipee();
	public boolean estPositionSaut();
	public boolean estPositionFrappe();
	public void init(String nom, int largeur, int hauteur, int profondeur,
			int force, int pointsDeVie);
	public int positionX();
	public int positionY();
	
	public PersonnageService depotPV(PersonnageService p,int pv);
	public PersonnageService retraitPV(PersonnageService p,int pv);
	public PersonnageService depotArgent(PersonnageService p,int a);
	public PersonnageService retraitArgent(PersonnageService p,int a);
	public PersonnageService ramasser(PersonnageService p,Objet o);
	public PersonnageService jeter(PersonnageService p,Objet o);
	public PersonnageService sauter(PersonnageService p);
	public PersonnageService setPosition(int x,int y);
	public PersonnageService setPositionFrappe(boolean pos);
	
	
}
