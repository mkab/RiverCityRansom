package moteurJeu;

import error.InvariantError;
import error.PostconditionError;
import error.PreconditionError;

public class MoteurJeuContrat extends MoteurJeuDecorator {

  public MoteurJeuContrat(MoteurJeuService delegate) {
    super(delegate);

  }

  public void checkInvariants() {
    // \inv 0<=pasJeuCourant(M) && pasJeuCourant(M) <= maxPasJeu
    if (!(0 <= pasJeuCourant() && pasJeuCourant() <= maxPasJeu())) {
      throw new InvariantError("Les pas de jeu ne sont pas corrects");
    }
    // \inv estFini() = (PersonnageService:: estVaincu(GestionCombat::alex(combat(M))
    // && (PersonnageService:: estVaincu(GestionCombat::ryan(combat(M)))))
    // || PersonnageService:: estVaincu(GestionCombat::slick(combat(M)))
    // || pasJeuCourant() = maxPasJeu()
    if (!(estFini() == (combat().alex().estVaincu() && combat().ryan().estVaincu())
        || (estFini() == combat().slick().estVaincu()) || (pasJeuCourant() == maxPasJeu()))) {
      throw new InvariantError("La partie devrait Ãªtre finie maintenant");
    }

    // \inv resultatFinal() = RYANGAGNANT si PersonnageService::
    // estVaincu(GestionCombat::slick(combat(M))
    // || ALEXGAGNANT si PersonnageService:: estVaincu(GestionCombat::slick(combat(M))
    // && PersonnageService:: estVaincu(GestionCombat::ryan(combat(M))
    // || SLICKGAGNANT si PersonnageService:: estVaincu(GestionCombat::alex(combat(M))
    // && PersonnageService:: estVaincu(GestionCombat::ryan(combat(M))
    // || PARTIENULLE si PersonnageService:: estVaincu(GestionCombat::alex(combat(M))
    // && PersonnageService:: estVaincu(GestionCombat::ryan(combat(M))
    // && PersonnageService:: estVaincu(GestionCombat::slick(combat(M))
    // || ! PersonnageService:: estVaincu(GestionCombat::alex(combat(M))
    // && ! PersonnageService:: estVaincu(GestionCombat::ryan(combat(M))
    // && ! PersonnageService:: estVaincu(GestionCombat::slick(combat(M))
    // && pasJeuCourant()=maxPasJeu()

    if (resultatFinal() == RESULTAT.RYANGAGNANT) {
      if (!combat().slick().estVaincu()) {
        throw new InvariantError("ryan devrait etre le gagnant maintenant");
      }
    }
    if (resultatFinal() == RESULTAT.ALEXGAGNANT) {
      if (!(combat().slick().estVaincu() && (combat().ryan().estVaincu()))) {
        throw new InvariantError("alex devrait etre le gagnant maintenant");
      }
    }
    if (resultatFinal() == RESULTAT.SLICKGAGNANT) {
      if (!(combat().alex().estVaincu() && (combat().ryan().estVaincu()))) {
        throw new InvariantError("slick devrait etre le gagnant maintenant");
      }
    }
    if (resultatFinal() == RESULTAT.PARTIENULLE) {
      if (!((combat().alex().estVaincu() && combat().ryan().estVaincu() && combat().slick()
          .estVaincu()) // TOUS SONTVAINCUS
      || ((!combat().alex().estVaincu() && !combat().ryan().estVaincu() && !combat().slick()
          .estVaincu())) // AUCUN N'EST VAINCU
          && (pasJeuCourant() == maxPasJeu()) // ET PAS MAX ATTEINT

      )) {
        throw new InvariantError("La partie devrait Ãªtre nulle maitenant");
      }
    }

  }

  public RESULTAT resultatFinal() {

    // \ pre resultatFinal() require estFini()
    if (!estFini()) {
      throw new PreconditionError("La partie n'est pas encore finie");
    }
    RESULTAT resultat = super.resultatFinal();

    // post : resultatFinal = RESULTAT.RYANGAGNANT && (combat.slick().estVaincu() &&
    // !(combat.ryan().estVaincu()))
    // || resultatFinal = RESULTAT.ALEXGAGNANT && (combat.slick().estVaincu() &&
    // combat.ryan().estVaincu())
    // || resultatFinal = RESULTAT.SLICKGAGNANT && (combat.alex().estVaincu() &&
    // combat.ryan().estVaincu())
    // || resultatFinal = RESULTAT.PARTIENULLE && (combat.alex().estVaincu() &&
    // combat.ryan().estVaincu() && combat.slick().estVaincu())
    // || resultatFinal = RESULTAT.PARTIENULLE && (!combat.alex().estVaincu() &&
    // !combat.ryan().estVaincu() && !combat.slick().estVaincu() && pasJeuCourant==maxPasJeu)
    // || resultatFinal = RESULTAT.CONTINUE;

    if (!((resultat == RESULTAT.RYANGAGNANT && (combat().slick().estVaincu() && !(combat().ryan()
        .estVaincu())))
        || (resultat == RESULTAT.ALEXGAGNANT && (combat().slick().estVaincu() && combat().ryan()
            .estVaincu()))
        || (resultat == RESULTAT.SLICKGAGNANT && (combat().alex().estVaincu() && combat().ryan()
            .estVaincu()))
        || (resultat == RESULTAT.PARTIENULLE && (combat().alex().estVaincu()
            && combat().ryan().estVaincu() && combat().slick().estVaincu()))
        || (resultat == RESULTAT.PARTIENULLE && (!combat().alex().estVaincu()
            && !combat().ryan().estVaincu() && !combat().slick().estVaincu() && pasJeuCourant() == maxPasJeu()))
        || (resultat == RESULTAT.PARTIENULLE && (combat().alex().estVaincu()
            && !combat().ryan().estVaincu() && !combat().slick().estVaincu() && pasJeuCourant() == maxPasJeu()))
        || (resultat == RESULTAT.PARTIENULLE && (!combat().alex().estVaincu()
            && combat().ryan().estVaincu() && !combat().slick().estVaincu() && pasJeuCourant() == maxPasJeu())) || (resultat == RESULTAT.CONTINUE))) {
      throw new PostconditionError("Le resultat du pas de jeu est incorrect");
    }

    return resultat;
  }

  public MoteurJeuService pasJeu(MoteurJeuService m, COMMANDE cA, COMMANDE cR) {

    // \pre pasJeu(m,cA,cR) require ! estFini()
    if (estFini()) {
      throw new PreconditionError(
          "La partie est finie , on n'autorise plus de pas de jeu supplémentaire");
    }
    // pasJeuCourant()@pre
    int tmpPasJeuCourant = pasJeuCourant();
    super.pasJeu(m, cA, cR);
    // \post pasJeuCourant(pasJeu(M,cA,cR)) = pasJeuCourant()+1
    if (!(pasJeuCourant() == tmpPasJeuCourant + 1)) {
      throw new PostconditionError(
          "Le nombre de pas de jeu courant n'a pas été correctement mis-Ã -jour");
    }

    return this;

  }

  @Override
  public void init(int largeur, int hauteur, int profondeur, int maxPas) {
    // \pre init(largeur,hauteur,profondeur,maxPas) require largeur>0
    if (!(largeur > 0)) {
      throw new PreconditionError("La largeur n'est pas correcte");
    }
    // \pre init(largeur,hauteur,profondeur,maxPas) require hauteur>0
    if (!(hauteur > 0)) {
      throw new PreconditionError("La hauteur n'est pas correcte");
    }
    // \pre init(largeur,hauteur,profondeur,maxPas) require profondeur>0
    if (!(profondeur > 0)) {
      throw new PreconditionError("La profondeur n'est pas correcte");
    }
    // \pre init(largeur,hauteur,profondeur,maxPas) require maxPas>0
    if (!(maxPas > 0)) {
      throw new PreconditionError("Le nombre de pas maximum n'est pas correct");
    }
    super.init(largeur, hauteur, profondeur, maxPas);

    // \post maxPasJeu(init(l,h,m)) = m
    if (!(maxPasJeu() == maxPas)) {
      throw new PostconditionError("Le nombre de max pas de jeu n'est pas correctement initialisé");
    }
    // \post : pasJeuCourant(init(l,h,m)) = 0
    if (!(pasJeuCourant() == 0)) {
      throw new PostconditionError("Le pas de jeu courant Ã  l'init est différent de 0");
    }

  }

}
