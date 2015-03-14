package personnage;


public abstract class PersonnageDecorator implements PersonnageService {

  PersonnageService delegate;

  public PersonnageDecorator(PersonnageService ps) {
    this.delegate = ps;
  }

  public boolean estUtilisable() {

    return delegate.estUtilisable(); // UN PERSO EST TOUJOURS UTILISABLE , ON PEUT LE RAMASSER
  }

  public int valeur() {

    return delegate.valeur();
  }

  public String nom() {

    return delegate.nom();
  }

  public int largeur() {

    return delegate.largeur();
  }

  public int hauteur() {

    return delegate.hauteur();
  }

  public int profondeur() {

    return delegate.profondeur();
  }

  public int force() {

    return delegate.force();
  }

  public int pointsDeVie() {

    return delegate.pointsDeVie();
  }

  public int ArgentRamasse() {

    return delegate.ArgentRamasse();
  }

  public boolean estVaincu() {

    return delegate.estVaincu();
  }

  public boolean estEquipe() {

    return delegate.estEquipe();
  }

  public Objet choseEquipee() {
    return delegate.choseEquipee();
  }

  public boolean estPositionSaut() {
    return delegate.estPositionSaut();
  }

  public PersonnageService depotPV(PersonnageService p, int pv) {
    return delegate.depotPV(p, pv);
  }

  public PersonnageService retraitPV(PersonnageService p, int pv) {
    return delegate.retraitPV(p, pv);
  }

  public PersonnageService depotArgent(PersonnageService p, int a) {
    return delegate.depotArgent(p, a);
  }

  public PersonnageService retraitArgent(PersonnageService p, int a) {
    return delegate.retraitArgent(p, a);
  }

  public PersonnageService ramasser(PersonnageService p, Objet o) {
    return delegate.ramasser(p, o);
  }

  public PersonnageService jeter(PersonnageService p, Objet o) {
    return delegate.jeter(p, o);
  }

  public PersonnageService sauter(PersonnageService p) {
    return delegate.sauter(p);
  }

  public int pvMax() {
    return delegate.pvMax();
  }

  public void init(String nom2, int largeur2, int hauteur2, int profondeur2, int force2,
      int pointsDeVie2) {
    delegate.init(nom2, largeur2, hauteur2, profondeur2, force2, pointsDeVie2);

  }

  public int positionX() {
    return delegate.positionX();
  }

  public int positionY() {
    return delegate.positionY();
  }

  public PersonnageService setPosition(int x, int y) {
    return delegate.setPosition(x, y);
  }

  public boolean estPositionFrappe() {
    return delegate.estPositionFrappe();
  }

  public PersonnageService setPositionFrappe(boolean pos) {
    delegate.setPositionFrappe(pos);
    return this;
  }

  /*
   * public void init(String nom, int largeur, int hauteur, int profondeur, int force, int
   * pointsDeVie) { this.nom=nom; this.largeur=largeur; this.hauteur=hauteur;
   * this.profondeur=profondeur; this.pvMax=pointsDeVie; this.pointsDeVie=pointsDeVie;
   * this.force=force; this.argentRamasse=0; this.estVaincu=false; this.estPositionSaut=false;
   * this.choseEquipee=null;
   * 
   * }
   */

}
