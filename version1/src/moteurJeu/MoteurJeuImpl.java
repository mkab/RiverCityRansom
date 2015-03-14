package moteurJeu;

import gestionCombat.GestionCombatContrat;
import gestionCombat.GestionCombatImpl;
import gestionCombat.GestionCombatService;

public class MoteurJeuImpl implements MoteurJeuService {

  protected int maxPasJeu, pasJeuCourant;
  protected int largeur, hauteur, profondeur;
  protected boolean estFini;
  protected RESULTAT resultatFinal;
  protected GestionCombatService combat;

  public void init(int largeur, int hauteur, int profondeur, int maxPas) {
    this.largeur = largeur;
    this.hauteur = hauteur;
    this.profondeur = profondeur;
    this.maxPasJeu = maxPas;
    combat = new GestionCombatContrat(new GestionCombatImpl());
    combat.init(largeur, hauteur, profondeur);
    estFini = false;
  }

  public int maxPasJeu() {
    return maxPasJeu;
  }

  public int pasJeuCourant() {
    return pasJeuCourant;
  }

  public boolean estFini() {
    return estFini;
  }

  public RESULTAT resultatFinal() {
    if (combat.slick().estVaincu() && !(combat.ryan().estVaincu()))
      return RESULTAT.RYAN_WINS_YOU_WIN;
    if (combat.slick().estVaincu() && combat.ryan().estVaincu())
      return RESULTAT.ALEX_WINS_YOU_WIN;
    if (combat.alex().estVaincu() && combat.ryan().estVaincu())
      return RESULTAT.SLICK_WINS_YOU_LOSE;
    if (combat.alex().estVaincu() && combat.ryan().estVaincu() && combat.slick().estVaincu())
      return RESULTAT.PARTIENULLE_DRAW_GAME;
    if ((!combat.alex().estVaincu() || !combat.ryan().estVaincu()) && !combat.slick().estVaincu()
        && pasJeuCourant == maxPasJeu)
      return RESULTAT.PARTIENULLE_DRAW_GAME;

    return RESULTAT.CONTINUE;
  }

  public GestionCombatService combat() {
    return combat;
  }

  public MoteurJeuService pasJeu(MoteurJeuService m, COMMANDE cA, COMMANDE cR) {
    if (!estFini) {
      combat().gerer(cA, cR);
      pasJeuCourant++;
      checkFini();
    }
    return this;
  }

  private void checkFini() {
    if ((combat.alex().estVaincu() && combat().ryan().estVaincu()) || combat.slick().estVaincu()
        || maxPasJeu == pasJeuCourant) {
      estFini = true;
    }

  }

  @Override
  public void setFini(boolean fini) {
    estFini = fini;

  }

}
