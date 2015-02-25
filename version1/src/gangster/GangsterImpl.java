package gangster;

import personnage.Objet;
import personnage.PersonnageService;

public class GangsterImpl implements GangsterService {

  protected String nom;
  protected int largeur, hauteur, profondeur;
  protected int force, pointsDeVie, argentRamasse;
  protected boolean estVaincu, estPositionSaut, estPositionFrappe;
  protected Objet choseEquipee;
  protected int pvMax;
  protected int positionX, positionY;

  public void init(String nom, int largeur, int hauteur, int profondeur, int force, int pointsDeVie) {
    this.nom = nom;
    this.largeur = largeur;
    this.hauteur = hauteur;
    this.profondeur = profondeur;
    this.pvMax = pointsDeVie;
    this.pointsDeVie = pointsDeVie;
    this.force = force;
    this.argentRamasse = 0;
    this.estVaincu = false;
    this.estPositionSaut = false;
    this.choseEquipee = null;
  }

  public boolean estUtilisable() {

    return true;
  }

  public int valeur() {

    return 5;
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

  public int ArgentRamasse() {

    return 0;
  }

  public boolean estVaincu() {

    return pointsDeVie <= 0;
  }

  public boolean estEquipe() {

    return false;
  }

  public Objet choseEquipee() {

    return null;
  }

  public boolean estPositionSaut() {

    return false;
  }

  public GangsterService depotPV(PersonnageService p, int pv) {

    return this;

  }

  public GangsterService retraitPV(PersonnageService p, int pv) {
    this.pointsDeVie -= pv;
    if (pointsDeVie <= 0)
      estVaincu = true;
    return this;
  }

  public GangsterService depotArgent(PersonnageService p, int a) {
    return this;
  }

  public PersonnageService retraitArgent(PersonnageService p, int a) {

    return this;
  }

  public GangsterService ramasser(PersonnageService p, Objet o) {

    return this;
  }

  public GangsterService jeter(PersonnageService p, Objet o) {
    return this;
  }

  public GangsterService sauter(PersonnageService p) {

    return this;
  }

  public int pvMax() {

    return pvMax;
  }

  public int positionX() {
    return positionX;
  }

  public int positionY() {
    return positionY;
  }

  public GangsterService setPosition(int x, int y) {
    this.positionX = x;
    this.positionY = y;
    return this;
  }

  public boolean estPositionFrappe() {
    return estPositionFrappe;
  }

  public PersonnageService setPositionFrappe(boolean pos) {
    estPositionFrappe = pos;
    return this;
  }

}
