package gestionCombat;

import gangster.GangsterImpl;
import gangster.GangsterService;

import java.util.ArrayList;
import java.util.Random;

import moteurJeu.COMMANDE;
import personnage.Objet;
import personnage.ObjetService;
import personnage.PersonnageImpl;
import personnage.PersonnageService;
import terrain.TerrainImpl;
import terrain.TerrainService;
import bloc.BlocService;
import bloc.Tresor;
import bloc.Type;

public class GestionCombatImpl implements GestionCombatService {

  int largeur, hauteur, profondeur;
  PersonnageService alex, ryan;
  GangsterService slick;
  ArrayList<GangsterService> gangsters;
  TerrainService terrain;
  int gangsterMax = 1;
  COMMANDE cA;
  COMMANDE cR;
  boolean ryanEstGele, alexEstGele, slickEstGele;
  int ToursGeleAlex, ToursGeleRyan, ToursGeleSlick;
  ArrayList<Boolean> gangsterEstGele = new ArrayList<Boolean>();
  ArrayList<Integer> ToursGeleGangster = new ArrayList<Integer>();

  int wqa = 0;

  public void init(int largeur, int hauteur, int profondeur) {
    this.largeur = largeur;
    this.hauteur = hauteur;
    this.profondeur = profondeur;

    terrain = new TerrainImpl();
    terrain.init(largeur, hauteur);

    alex = new PersonnageImpl();
    alex.init("alex", 1, 2, 3, 20, 100);
    alex.setPosition(0, terrain().hauteur() - 1);

    ryan = new PersonnageImpl();
    ryan.init("ryan", 1, 2, 3, 20, 100);
    ryan.setPosition(0, terrain().hauteur() - 3);

    slick = new GangsterImpl();
    slick.init("slick", 1, 2, 3, 5, 100);
    slick.setPosition(largeur - 1, hauteur - 2);

    gangsters = new ArrayList<GangsterService>();
  }

  public ArrayList<GangsterService> listeGangsters() {
    return gangsters;
  }

  public TerrainService terrain() {
    return terrain;
  }

  public PersonnageService alex() {
    return alex;
  }

  public PersonnageService ryan() {
    return ryan;
  }

  public GangsterService slick() {
    return slick;
  }

  public GangsterService gangster(int id) {
    return gangsters.get(id);
  }

  public boolean estFrappe(String nom, int id) {
    if (nom.equals("slick")) {
      if (estGele("alex", 0) && alex().estPositionFrappe()
          && collisionEntrePersos("alex", "slick", 0)) { // S'IL EST FRAPPE PAR ALEX
        return true;
      }
      if (estGele("ryan", 0) && ryan().estPositionFrappe()
          && collisionEntrePersos("ryan", "slick", 0)) { // S'IL EST FRAPPE PAR RYAN
        return true;
      }
    }
    if (nom.equals("gangster")) {
      if (estGele("alex", 0) && alex().estPositionFrappe()
          && collisionEntrePersos("alex", "gangster", id)) { // S'IL EST FRAPPE PAR ALEX
        return true;
      }
      if (estGele("ryan", 0) && ryan().estPositionFrappe()
          && collisionEntrePersos("ryan", "gangster", id)) { // S'IL EST FRAPPE PAR RYAN
        return true;
      }
    }
    if (nom.equals("alex")) {

      if (estGele("slick", 0) && slick().estPositionFrappe()
          && collisionEntrePersos("alex", "slick", id)) {// SI ALEX SE FAIT FRAPPER PAR SLICK
        return true;
      }
      for (int i = 0; i < nombreGangsters(); i++) {
        if (estGele("gangster", i) && gangster(i).estPositionFrappe()
            && collisionEntrePersos("alex", "gangster", i)) {// SI ALEX SE FAIT FRAPPER PAR UN
                                                             // GANGSTER
          return true;
        }
      }
    }

    if (nom.equals("ryan")) {

      if (estGele("slick", 0) && slick().estPositionFrappe()
          && collisionEntrePersos("ryan", "slick", id)) {// SI RYAN SE FAIT FRAPPER PAR SLICK
        return true;
      }
      for (int i = 0; i < nombreGangsters(); i++) {
        if (estGele("gangster", i) && gangster(i).estPositionFrappe()
            && collisionEntrePersos("ryan", "gangster", i)) {// SI RYAN SE FAIT FRAPPER PAR UN
                                                             // GANGSTER
          return true;
        }
      }
    }
    return false;
  }

  public boolean estGele(String nom, int id) {
    if (nom.equals("slick")) {
      return slickEstGele; // SI SLICK FRAPPE

    }
    if (nom.equals("gangster")) {
      return gangsterEstGele.get(id); // SI LE GANGSTER FRAPPE
    }
    if (nom.equals("alex")) {
      return alexEstGele;
    }
    if (nom.equals("ryan")) {
      return ryanEstGele;
    }
    return false;
  }

  public int positionX(String nom, int id) {
    if (nom.equals("slick")) {
      return slick().positionX();
    }
    if (nom.equals("gangster")) {
      return gangster(id).positionX();
    }
    if (nom.equals("alex")) {
      return alex().positionX();
    }
    if (nom.equals("ryan")) {
      return ryan().positionX();
    }
    return 0;
  }

  public int positionY(String nom, int id) {
    if (nom.equals("slick")) {
      return slick().positionY();
    }
    if (nom.equals("gangster")) {
      return gangster(id).positionY();
    }
    if (nom.equals("alex")) {
      return alex().positionY();
    }
    if (nom.equals("ryan")) {
      return ryan().positionY();
    }
    return 0;
  }

  public boolean dansIntervalle(int x, int min, int max) {
    return x <= max && x >= min;
  }

  public boolean collisionEntrePersos(String nom1, String nom2, int id) {
    PersonnageService perso1 = null, perso2 = null;

    if (nom1.equals("alex"))
      perso1 = alex();
    if (nom1.equals("ryan"))
      perso1 = ryan();
    if (nom1.equals("slick"))
      perso1 = slick();
    if (nom1.equals("gangster"))
      perso1 = gangster(id);

    if (nom2.equals("alex"))
      perso2 = alex();
    if (nom2.equals("ryan"))
      perso2 = ryan();
    if (nom2.equals("slick"))
      perso2 = slick();
    if (nom2.equals("gangster"))
      perso2 = gangster(id);

    int positionXperso1 = perso1.positionX();
    int positionXperso2 = perso2.positionX();
    int positionYperso1 = perso1.positionY();
    int positionYperso2 = perso2.positionY();

    if (perso1.estPositionSaut() || perso2.estPositionSaut())
      return false;
    if (perso1.estVaincu() || perso2.estVaincu())
      return false;

    if (perso1.equals(alex()) || perso1.equals(ryan())) {
      if ((positionXperso1 == positionXperso2 || positionXperso2 == positionXperso1 + 1)
          && positionYperso1 == positionYperso2) {
        return true;
      }
    } else if ((positionXperso2 == positionXperso1 || positionXperso2 == positionXperso1 + 1)
        && positionYperso1 == positionYperso2) {
      return true;
    }

    return false;
  }

  @Override
  public boolean collision() {
    return false;
  }

  public int nombreGangsters() {
    return gangsters.size();
  }

  public void gerer(COMMANDE ca, COMMANDE cr) {
    reinit();
    cA = ca;
    cR = cr;

    // COMMANDE CA
    if (ToursGeleAlex < 1) {
      ToursGeleAlex++;
    } else {
      alexEstGele = false;
    }
    if (cA == COMMANDE.FRAPPER) {
      alex().setPositionFrappe(true);
      if (collisionEntrePersos("alex", "slick", 0)) {
        slick().retraitPV(slick(), alex().force());
        if (slick.positionX() < largeur - 1)
          slick.setPosition(slick.positionX() + 1, slick.positionY());
        slickEstGele = true;
        ToursGeleSlick = 0;
      }
      for (int i = 0; i < nombreGangsters(); i++) {
        if (collisionEntrePersos("alex", "gangster", i)) {
          gangster(i).retraitPV(gangster(i), alex().force());
          if (gangster(i).estVaincu()) {
            AjoutTresorMort(gangster(i).positionX(), gangster(i).positionY());
          }
          if (gangster(i).positionX() < largeur - 1)
            gangster(i).setPosition(gangster(i).positionX() + 1, gangster(i).positionY());
          gangsterEstGele.set(i, true);
          ToursGeleGangster.set(i, 0);
        }
      }
      alexEstGele = true;
      ToursGeleAlex = 0;
    }
    if (cA == COMMANDE.GAUCHE) {
      int x = alex().positionX();
      int y = alex().positionY();
      x--;
      if (x <= 0)
        x = 0;
      alex().setPosition(x, y);
    }
    if (cA == COMMANDE.DROITE) {
      int x = alex().positionX();
      int y = alex().positionY();
      x++;
      if (x > largeur - 1)
        x = largeur - 1;
      alex().setPosition(x, y);
    }
    if (cA == COMMANDE.HAUT) {
      int x = alex().positionX();
      int y = alex().positionY();
      y--;
      if (y == -1)
        y = 0;
      alex().setPosition(x, y);
    }
    if (cA == COMMANDE.BAS) {
      int x = alex().positionX();
      int y = alex().positionY();
      y++;
      if (y >= hauteur)
        y--;
      alex().setPosition(x, y);
    }
    if (cA == COMMANDE.RAMASSER) {
      int x = alex().positionX();
      int y = alex().positionY();
      Tresor tresor = terrain.getBloc(x, y).getTresor();
      ObjetService objetBarre = null;
      if (tresor == Tresor.BARRE) {
        objetBarre = new ObjetService("barre", 10, true);
      }
      if (tresor == Tresor.UNDOLLAR) {
        objetBarre = new ObjetService("unDollar", 100, false);
      }
      if (tresor == Tresor.CINQUANTECENTIMES) {
        objetBarre = new ObjetService("cinquanteCentimes", 50, false);
      }
      if (tresor == Tresor.CHAINE) {
        objetBarre = new ObjetService("chaine", 5, true);
      }
      if (tresor == Tresor.POUBELLE) {
        objetBarre = new ObjetService("poubelle", 15, true);
      }
      if (tresor == Tresor.RIEN) {
        objetBarre = new ObjetService("rien", 0, false);
      }
      if (alex().estEquipe()) {
        if (alex().choseEquipee().estUtilisable()) {

          Objet o = alex().choseEquipee();
          alex().ramasser(alex(), objetBarre);
          String nom = o.nom();
          switch (nom) {
            case "barre":
              terrain().getBloc(x, y).setTresor(Tresor.BARRE);
              break;
            case "chaine":
              terrain().getBloc(x, y).setTresor(Tresor.CHAINE);
              break;
            case "poubelle":
              terrain().getBloc(x, y).setTresor(Tresor.POUBELLE);
              break;
          }
        }
      } else {
        alex().ramasser(alex(), objetBarre); // ALEX RAMASSE L'OBJET
        terrain().getBloc(x, y).setTresor(Tresor.RIEN);
      }
    }

    if (cA == COMMANDE.JETER) {
      alex().jeter(alex(), alex().choseEquipee());
    }
    if (cA == COMMANDE.SAUT) {
      alex().sauter(alex());
      alexEstGele = true;
      ToursGeleAlex = 0;
    }
    int xFosse = alex().positionX();
    int yFosse = alex().positionY();
    if (terrain().getBloc(xFosse, yFosse).getType() == Type.FOSSE) {
      alex.retraitPV(alex, alex.pointsDeVie());
    }

    // COMMANDE CR

    if (ToursGeleRyan < 1) {
      ToursGeleRyan++;
    } else {
      ryanEstGele = false;
    }
    if (cR == COMMANDE.FRAPPER) {
      ryan().setPositionFrappe(true);
      if (collisionEntrePersos("ryan", "slick", 0)) {
        slick().retraitPV(slick(), ryan().force());
        if (slick.positionX() < largeur - 1)
          slick.setPosition(slick.positionX() + 1, slick.positionY());
        slickEstGele = true;
        ToursGeleSlick = 0;
      }
      for (int i = 0; i < nombreGangsters(); i++) {
        if (collisionEntrePersos("ryan", "gangster", i)) {
          gangster(i).retraitPV(gangster(i), ryan().force());
          if (gangster(i).estVaincu()) {
            AjoutTresorMort(gangster(i).positionX(), gangster(i).positionY());
          }
          if (gangster(i).positionX() < largeur - 1)
            gangster(i).setPosition(gangster(i).positionX() + 1, gangster(i).positionY());
          gangsterEstGele.set(i, true);
          ToursGeleGangster.set(i, 0);
        }
      }
      ryanEstGele = true;
      ToursGeleRyan = 0;

    }
    if (cR == COMMANDE.GAUCHE) {
      int x = ryan().positionX();
      int y = ryan().positionY();
      x--;
      if (x <= 0)
        x = 0;
      ryan().setPosition(x, y);
    }
    if (cR == COMMANDE.DROITE) {
      int x = ryan().positionX();
      int y = ryan().positionY();
      x++;
      if (x > largeur - 1)
        x = largeur - 1;
      ryan().setPosition(x, y);
    }
    if (cR == COMMANDE.HAUT) {
      int x = ryan().positionX();
      int y = ryan().positionY();
      y--;
      if (y == -1)
        y = 0;
      ryan().setPosition(x, y);
    }
    if (cR == COMMANDE.BAS) {
      int x = ryan().positionX();
      int y = ryan().positionY();
      y++;
      if (y >= hauteur)
        y--;
      ryan().setPosition(x, y);
    }
    if (cR == COMMANDE.RAMASSER) {
      int x = ryan().positionX();
      int y = ryan().positionY();
      Tresor tresor = terrain.getBloc(x, y).getTresor();
      ObjetService objetBarre = null;
      if (tresor == Tresor.BARRE) {
        objetBarre = new ObjetService("barre", 10, true);
      }
      if (tresor == Tresor.UNDOLLAR) {
        objetBarre = new ObjetService("unDollar", 100, false);
      }
      if (tresor == Tresor.CINQUANTECENTIMES) {
        objetBarre = new ObjetService("cinquanteCentimes", 50, false);
      }
      if (tresor == Tresor.CHAINE) {
        objetBarre = new ObjetService("chaine", 5, true);
      }
      if (tresor == Tresor.POUBELLE) {
        objetBarre = new ObjetService("poubelle", 15, true);
      }
      if (tresor == Tresor.RIEN) {
        objetBarre = new ObjetService("rien", 0, false);
      }

      if (ryan.estEquipe()) {
        if (ryan().choseEquipee().estUtilisable()) {

          Objet o = ryan().choseEquipee();
          ryan().ramasser(ryan(), objetBarre);
          String nom = o.nom();
          switch (nom) {
            case "barre":
              terrain().getBloc(x, y).setTresor(Tresor.BARRE);
              break;
            case "chaine":
              terrain().getBloc(x, y).setTresor(Tresor.CHAINE);
              break;
            case "poubelle":
              terrain().getBloc(x, y).setTresor(Tresor.POUBELLE);
              break;
          }
        }
      } else {
        ryan().ramasser(ryan(), objetBarre); // ALEX RAMASSE L'OBJET
        terrain().getBloc(x, y).setTresor(Tresor.RIEN);
      }

    }
    xFosse = ryan().positionX();
    yFosse = ryan().positionY();
    if (terrain().getBloc(xFosse, yFosse).getType() == Type.FOSSE) {
      ryan.retraitPV(ryan, ryan.pointsDeVie());
    }

    if (cR == COMMANDE.JETER) {
      ryan().jeter(ryan(), ryan().choseEquipee());
    }
    if (cR == COMMANDE.SAUT) {
      ryan().sauter(ryan());
      ryanEstGele = true;
      ToursGeleRyan = 0;
    }

    int creerGangster = (int) Math.random() * 10;
    if (creerGangster <= 3) { // 30% DE CHANCES DE CREATION DE GANGSTER
      GangsterService gangster = new GangsterImpl();
      gangster.init("gangster", 1, 2, 2, 5, 30);

      Random rand = new Random();

      gangster.setPosition(terrain().largeur() - 1, rand.nextInt(terrain().hauteur()));
      if (gangsters.size() < gangsterMax) { // MAX GANGSTER
        gangsters.add(gangster);
        ToursGeleGangster.add(3);
        gangsterEstGele.add(false);
      }
    }

    // VERIFIER SI UN GANGSTER EST VAINCU ET LE SORTIR DE LA LISTE
    for (int i = 0; i < gangsters.size(); i++) {
      if (terrain.getBloc(gangster(i).positionX(), gangster(i).positionY()).getType() == Type.FOSSE) {
        gangster(i).retraitPV(gangster(i), gangster(i).pointsDeVie());
      }
      if (gangsters.get(i).estVaincu()) {
        gangsters.remove(i);
        gangsterEstGele.remove(i);
        ToursGeleGangster.remove(i);
        i--;
      }
    }

    // GERER LE MOUVEMENT D'UN GANGSTER
    boolean avance = false, recule = false, monte = false, descend = false, rien = false; // si
                                                                                          // false
                                                                                          // ->
                                                                                          // frappe
    Random rand = new Random();

    for (int i = 0; i < gangsters.size(); i++) {
      int r = rand.nextInt(5);

      if (r == 0)
        avance = true;
      if (r == 1)
        descend = true;
      if (r == 2)
        monte = true;
      if (r == 3)
        recule = true;
      if (r == 4)
        rien = true;

      if ((collisionEntrePersos("ryan", "gangster", i) || (collisionEntrePersos("alex", "gangster",
          i)))) {
        avance = false;
        descend = false;
        monte = false;
        recule = false;
        rien = false;
      }
      if (ToursGeleGangster.get(i) <= 1) {
        int a = ToursGeleGangster.get(i) + 1;
        ToursGeleGangster.set(i, a);
        avance = false;
        descend = false;
        monte = false;
        recule = false;
        rien = true;
      } else {
        gangsterEstGele.set(i, false);
      }
      int x;
      int y;
      do {
        x = gangsters.get(i).positionX();
        y = gangsters.get(i).positionY();
        if (avance) { // IL AVANCE
          x--;
          if (x <= 0)
            x = 0;

        } else if (descend) { // IL DESCEND
          y++;
          if (y > hauteur - 1)
            y--;

        } else if (monte) {
          y--;
          if (y < 0)
            y++;

        } else if (rien) {

        } else if (recule) {
          x++;
          if (x > largeur - 1)
            x--;

        } else { // SINON IL FRAPPE
          if (collisionEntrePersos("alex", "gangster", i)) {
            alex().retraitPV(alex(), gangster(i).force());
            if (alex().estEquipe() && alex.choseEquipee().estUtilisable()) {
              Objet o = alex().choseEquipee();
              alex.jeter(alex, o);
              String nom = o.nom();
              x = alex.positionX();
              y = alex.positionY();
              switch (nom) {
                case "barre":
                  terrain().getBloc(x, y).setTresor(Tresor.BARRE);
                  break;
                case "chaine":
                  terrain().getBloc(x, y).setTresor(Tresor.CHAINE);
                  break;
                case "poubelle":
                  terrain().getBloc(x, y).setTresor(Tresor.POUBELLE);
                  break;
              }
            }
            if (alex().positionX() > 0)
              alex().setPosition(alex().positionX() - 1, alex().positionY());
            alexEstGele = true;
            ToursGeleAlex = 0;
          }
          if (collisionEntrePersos("ryan", "gangster", i)) {
            ryan().retraitPV(ryan(), gangster(i).force());
            if (ryan().estEquipe() && ryan.choseEquipee().estUtilisable()) {
              Objet o = ryan().choseEquipee();
              ryan.jeter(ryan, o);
              String nom = o.nom();
              x = ryan.positionX();
              y = ryan.positionY();
              switch (nom) {
                case "barre":
                  terrain().getBloc(x, y).setTresor(Tresor.BARRE);
                  break;
                case "chaine":
                  terrain().getBloc(x, y).setTresor(Tresor.CHAINE);
                  break;
                case "poubelle":
                  terrain().getBloc(x, y).setTresor(Tresor.POUBELLE);
                  break;
              }
            }
            if (ryan().positionX() > 0)
              ryan().setPosition(ryan().positionX() - 1, ryan().positionY());
            ryanEstGele = true;
            ToursGeleRyan = 0;
          }
          gangster(i).setPositionFrappe(true);
          gangsterEstGele.set(i, true);
          ToursGeleGangster.set(i, 0);
        }
        r = rand.nextInt(5);
        if (r == 0)
          avance = true;
        else
          avance = false;
        if (r == 1)
          descend = true;
        else
          descend = false;
        if (r == 2)
          monte = true;
        else
          monte = false;
        if (r == 3)
          recule = true;
        else
          recule = false;
        if (r == 4)
          rien = true;
        else
          rien = false;

      } while (terrain().getBloc(x, y).getType() == Type.FOSSE);
      gangsters.get(i).setPosition(x, y);

    }

    // GERER LE MOUVEMENT DE SLICK
    if (terrain.getBloc(slick.positionX(), slick.positionY()).getType() == Type.FOSSE) {
      slick.retraitPV(slick, slick.pointsDeVie());
    }
    if (!slick.estVaincu()) {
      avance = false;
      recule = false;
      monte = false;
      descend = false;
      rien = false;

      int r = rand.nextInt(5);
      if (r == 0)
        avance = true;
      if (r == 1)
        descend = true;
      if (r == 2)
        monte = true;
      if (r == 3)
        recule = true;
      if (r == 4)
        rien = true;

      if ((collisionEntrePersos("ryan", "slick", 0) || (collisionEntrePersos("alex", "slick", 0)))) {
        avance = false;
        descend = false;
        monte = false;
        recule = false;
        rien = false;
      }

      if (ToursGeleSlick <= 1) {
        avance = false;
        descend = false;
        monte = false;
        recule = false;
        rien = true;
        ToursGeleSlick++;
      } else {
        slickEstGele = false;
      }
      int x, y;
      do {
        x = slick().positionX();
        y = slick().positionY();
        if (avance) { // IL AVANCE

          x--;
          if (x <= 0)
            x = 0;

          if (terrain().getBloc(x, y).getType() == Type.FOSSE) { // SI LE BLOC SUR LEQUEL ON AVANCE
                                                                 // EST UN FOSSE
            if (y <= 0)
              y++; // IL DESCEND
            else
              y--; // SINON IL MONTE

          }

        } else if (descend) { // IL DESCEND
          y++;
          if (y > hauteur - 1)
            y--;

        } else if (monte) {
          y--;
          if (y < 0)
            y++;

        } else if (rien) {

        } else if (recule) {
          x++;
          if (x > largeur - 1)
            x--;

        } else { // SINON IL FRAPPE

          if (collisionEntrePersos("alex", "slick", 0)) {
            alex().retraitPV(alex(), slick.force());
            alex();
            if (alex().estEquipe() && alex.choseEquipee().estUtilisable()) {
              Objet o = alex().choseEquipee();
              alex.jeter(alex, o);
              String nom = o.nom();
              x = alex.positionX();
              y = alex.positionY();
              switch (nom) {
                case "barre":
                  terrain().getBloc(x, y).setTresor(Tresor.BARRE);
                  break;
                case "chaine":
                  terrain().getBloc(x, y).setTresor(Tresor.CHAINE);
                  break;
                case "poubelle":
                  terrain().getBloc(x, y).setTresor(Tresor.POUBELLE);
                  break;
              }
            }
            if (alex().positionX() > 0)
              alex().setPosition(alex().positionX() - 1, alex().positionY());
            alexEstGele = true;
            ToursGeleAlex = 0;
          }
          if (collisionEntrePersos("ryan", "slick", 0)) {
            ryan().retraitPV(ryan(), slick().force());
            if (ryan().estEquipe() && ryan.choseEquipee().estUtilisable()) {
              Objet o = ryan().choseEquipee();
              ryan.jeter(ryan, o);
              String nom = o.nom();
              x = ryan.positionX();
              y = ryan.positionY();
              switch (nom) {
                case "barre":
                  terrain().getBloc(x, y).setTresor(Tresor.BARRE);
                  break;
                case "chaine":
                  terrain().getBloc(x, y).setTresor(Tresor.CHAINE);
                  break;
                case "poubelle":
                  terrain().getBloc(x, y).setTresor(Tresor.POUBELLE);
                  break;
              }
            }
            if (ryan().positionX() > 0)
              ryan().setPosition(ryan().positionX() - 1, ryan().positionY());
            ryanEstGele = true;
            ToursGeleRyan = 0;
          }
          slick.setPositionFrappe(true);
          slickEstGele = true;
          ToursGeleSlick = 0;
        }
        r = rand.nextInt(6);
        if (r == 0)
          avance = true;
        else
          avance = false;
        if (r == 1)
          descend = true;
        else
          descend = false;
        if (r == 2)
          monte = true;
        else
          monte = false;
        if (r == 3)
          recule = true;
        else
          recule = false;
        if (r == 4)
          rien = true;
        else
          rien = false;
      } while (terrain().getBloc(x, y).getType() == Type.FOSSE);
      slick().setPosition(x, y);
    }

  }

  public void AjoutTresorMort(int x, int y) {
    // CREER UN TRESOR
    boolean cinquanteOu1Dollar = false;
    int r = (int) (Math.random() * 10) % 2;
    if (r == 0)
      cinquanteOu1Dollar = true;
    BlocService blocDuGangster = terrain().getBloc(x, y);
    if (cinquanteOu1Dollar)
      blocDuGangster.setTresor(Tresor.CINQUANTECENTIMES);
    else
      blocDuGangster.setTresor(Tresor.UNDOLLAR);
  }

  public void reinit() {
    for (int i = 0; i < nombreGangsters(); i++) {
      gangster(i).setPositionFrappe(false);
    }
    alex().setPositionFrappe(false);
    ryan().setPositionFrappe(false);
    slick().setPositionFrappe(false);
  }

  public int nombreGangsterMax() {

    return gangsterMax;
  }

  @Override
  public boolean EstGeleAlex() {
    return alexEstGele;
  }

  public boolean EstGeleRyan() {
    return ryanEstGele;
  }

  @Override
  public boolean EstGeleSlick() {
    return slickEstGele;
  }

  @Override
  public ArrayList<Boolean> GangsterGele() {
    return gangsterEstGele;
  }

}
