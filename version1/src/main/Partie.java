package main;

import javax.swing.JOptionPane;

import moteurJeu.MoteurJeuService;
import moteurJeu.RESULTAT;

public class Partie extends Thread {

  private MoteurJeuService jeu;
  private Main fenetre;
  private RESULTAT res;

  public Partie(MoteurJeuService jeu, Main fenetre) {
    this.jeu = jeu;
    this.fenetre = fenetre;
    // setDaemon(true);
  }

  @Override
  public void run() {
    do {
      try {

        Thread.sleep(300);
        fenetre.getMoteur().pasJeu(fenetre.getMoteur(), fenetre.getcA(), fenetre.getcR());
        fenetre.UpdateGraphics();
        // System.out.println("max pas =" + fenetre.getMoteur().maxPasJeu() + " pas jeu courant = "
        // + fenetre.getMoteur().pasJeuCourant());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (!fenetre.getMoteur().estFini());
    JOptionPane jop1 = new JOptionPane();
    res = fenetre.getMoteur().resultatFinal();
    jop1.showMessageDialog(null, res.toString(), "Resultat de la partie",
        JOptionPane.INFORMATION_MESSAGE);
  }
}
