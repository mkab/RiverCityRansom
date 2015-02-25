package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import moteurJeu.COMMANDE;
import moteurJeu.MoteurJeuContrat;
import moteurJeu.MoteurJeuImpl;
import moteurJeu.MoteurJeuService;
import bloc.Tresor;

public class Main extends JFrame {

  private static final long serialVersionUID = 1L;
  PanelInfo info;
  PanelTerrain terrain;
  int largeur, profondeur;
  MoteurJeuService moteur;
  COMMANDE cA, cR;

  private GridBagConstraints gbc;

  public Main() {
    cA = COMMANDE.RIEN;
    cR = COMMANDE.RIEN;
    setFocusable(true);
    setTitle(" CPS : River City Ransom");
    moteur = new MoteurJeuContrat(new MoteurJeuImpl());
    moteur.init(8, 5, 10, 999999);
    largeur = moteur.combat().terrain().largeur();
    profondeur = moteur.combat().terrain().hauteur();
    setLayout(new GridBagLayout());
    gbc = new GridBagConstraints();
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        int reponse =
            JOptionPane.showConfirmDialog(new JFrame(), "Voulez-vous quitter ?", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (reponse == JOptionPane.YES_OPTION) {
          System.exit(0);
        }
      }
    });

    MiseEnPlacePanel();
    pack();
    setResizable(false);
    setVisible(true);
    AddEcouteur();
    new Partie(getMoteur(), this).start();
  }

  public MoteurJeuService getMoteur() {
    return moteur;
  }

  public COMMANDE getcA() {
    if (moteur.combat().EstGeleAlex() || moteur.combat().alex().estVaincu()) {
      return COMMANDE.RIEN;
    } else
      return cA;
  }

  public COMMANDE getcR() {
    if (moteur.combat().EstGeleRyan() || moteur.combat().ryan().estVaincu()) {
      return COMMANDE.RIEN;
    } else
      return cR;
  }

  public void NewPas() {
    getMoteur().pasJeu(getMoteur(), getcA(), getcR());
    cA = COMMANDE.RIEN;
    cR = COMMANDE.RIEN;
    UpdateGraphics();
  }

  @SuppressWarnings("serial")
  private void AddEcouteur() {

    // ALEX
    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "HautAlex");
    getRootPane().getActionMap().put("HautAlex", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cA = COMMANDE.HAUT;;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "BasAlex");
    getRootPane().getActionMap().put("BasAlex", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cA = COMMANDE.BAS;;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "DroiteAlex");
    getRootPane().getActionMap().put("DroiteAlex", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cA = COMMANDE.DROITE;;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "GaucheAlex");
    getRootPane().getActionMap().put("GaucheAlex", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cA = COMMANDE.GAUCHE;;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "FrappeAlex");
    getRootPane().getActionMap().put("FrappeAlex", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cA = COMMANDE.FRAPPER;;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_M, 0), "RamasseAlex");
    getRootPane().getActionMap().put("RamasseAlex", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cA = COMMANDE.RAMASSER;;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "SautAlex");
    getRootPane().getActionMap().put("SautAlex", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cA = COMMANDE.SAUT;
      }
    });

    // RYAN
    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "HautRyan");
    getRootPane().getActionMap().put("HautRyan", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cR = COMMANDE.HAUT;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "BasRyan");
    getRootPane().getActionMap().put("BasRyan", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cR = COMMANDE.BAS;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "DroiteRyan");
    getRootPane().getActionMap().put("DroiteRyan", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cR = COMMANDE.DROITE;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "GaucheRyan");
    getRootPane().getActionMap().put("GaucheRyan", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cR = COMMANDE.GAUCHE;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_T, 0), "FrappeRyan");
    getRootPane().getActionMap().put("FrappeRyan", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cR = COMMANDE.FRAPPER;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), "RamasseRyan");
    getRootPane().getActionMap().put("RamasseRyan", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cR = COMMANDE.RAMASSER;
      }
    });

    getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "SautRyan");
    getRootPane().getActionMap().put("SautRyan", new AbstractAction() {
      public void actionPerformed(ActionEvent arg0) {
        cR = COMMANDE.SAUT;
      }
    });

  }

  private void MiseEnPlacePanel() {
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0, 0, 0, 0);

    info =
        new PanelInfo(moteur.combat().terrain().largeur(), moteur.combat().alex().pvMax(), moteur
            .combat().ryan().pvMax(), moteur.combat().slick().pvMax(), moteur.maxPasJeu(), moteur
            .combat().nombreGangsterMax());
    add(info, gbc);

    // gbc.gridy = 1;
    // fond = new PanelFond(moteur.combat().terrain().largeur());
    // add(fond, gbc);

    gbc.gridy = 1;
    terrain =
        new PanelTerrain(moteur.combat().terrain().largeur(), moteur.combat().terrain().hauteur());
    add(terrain, gbc);

  }

  public void UpdateGraphics() {
    // terrain.Nettoyer();

    info.SetPasJeu(moteur.maxPasJeu() - moteur.pasJeuCourant());
    info.SetPvAlex(moteur.combat().alex().pointsDeVie());
    info.SetPvSlick(moteur.combat().slick().pointsDeVie());
    info.SetPvRyan(moteur.combat().ryan().pointsDeVie());
    info.SetPvGangsters(moteur.combat().listeGangsters());
    info.setTune(moteur.combat().alex().ArgentRamasse(), moteur.combat().ryan().ArgentRamasse());
    pack();

    // Tresor et fosse

    // Gangster
    if (moteur.combat().nombreGangsters() > 0) {
      ArrayList<Boolean> n = moteur.combat().GangsterGele();
      for (int i = 0; i < moteur.combat().listeGangsters().size(); i++) {
        int XGangster = moteur.combat().listeGangsters().get(i).positionX();
        int yGangster = moteur.combat().listeGangsters().get(i).positionY();

        if (!moteur.combat().listeGangsters().get(i).estPositionFrappe()) {
          if (n.get(i)) {
            terrain.getCase(XGangster, yGangster).Dessine("GangsterBasGele");
            terrain.getCase(XGangster, yGangster - 1).Dessine("GangsterHautGele");
          } else {
            terrain.getCase(XGangster, yGangster).Dessine("GangsterBas");
            terrain.getCase(XGangster, yGangster - 1).Dessine("GangsterHaut");
          }

        } else {
          if (XGangster - 1 >= 0) {
            terrain.getCase(XGangster - 1, yGangster - 1).Dessine("GangsterFrappeBras");
          }
          terrain.getCase(XGangster, yGangster - 1).Dessine("GangsterFrappeHaut");
          terrain.getCase(XGangster, yGangster).Dessine("GangsterFrappeBas");
        }
      }
    }

    // Slick
    int XSlick = moteur.combat().slick().positionX();
    int YSlick = moteur.combat().slick().positionY();

    if (moteur.combat().slick().estPositionFrappe()) {
      terrain.getCase(XSlick, YSlick).Dessine("SlickFrappeBas");
      terrain.getCase(XSlick, YSlick - 1).Dessine("SlickFrappeHaut");
      terrain.getCase(XSlick - 1, YSlick - 1).Dessine("SlickFrappeBras");
    } else {
      if (moteur.combat().EstGeleSlick()) {
        terrain.getCase(XSlick, YSlick).Dessine("SlickBasGele");
        terrain.getCase(XSlick, YSlick - 1).Dessine("SlickHautGele");
      } else {
        terrain.getCase(XSlick, YSlick).Dessine("SlickBas");
        terrain.getCase(XSlick, YSlick - 1).Dessine("SlickHaut");
      }
    }

    // Ryan

    int XRyan = moteur.combat().ryan().positionX();
    int YRyan = moteur.combat().ryan().positionY();

    if (moteur.combat().ryan().estVaincu()) {
      terrain.getCase(XRyan, YRyan).Dessine("AlexHautGeleMort");
    } else {
      if (cR == COMMANDE.RAMASSER) {

        terrain.getCase(XRyan, YRyan).Dessine("RyanRamasse");
      }

      else if (moteur.combat().ryan().estEquipe()) {
        if (moteur.combat().ryan().choseEquipee().nom().equals("chaine")) {
          if (moteur.combat().ryan().estPositionFrappe()) {
            terrain.getCase(XRyan, YRyan).Dessine("RyanFrappeBarreBas");
            terrain.getCase(XRyan, YRyan - 1).Dessine("RyanFrappeBarreHaut");
            terrain.getCase(XRyan + 1, YRyan).Dessine("RyanFrappeChaine");
          } else {
            if (moteur.combat().EstGeleRyan()) {
              terrain.getCase(XRyan, YRyan).Dessine("AlexFrappeChaineBasGele");
              terrain.getCase(XRyan, YRyan - 1).Dessine("AlexFrappeChaineHautGele");
            } else {
              terrain.getCase(XRyan, YRyan).Dessine("RyanFrappeChaineBas");
              terrain.getCase(XRyan, YRyan - 1).Dessine("RyanFrappeChaineHaut");
            }
          }
        } else if (moteur.combat().ryan().choseEquipee().nom().equals("poubelle")) {
          if (moteur.combat().ryan().estPositionFrappe()) {
            terrain.getCase(XRyan, YRyan).Dessine("RyanFrappeBas");
            terrain.getCase(XRyan, YRyan - 1).Dessine("RyanFrappeHaut");
            terrain.getCase(XRyan + 1, YRyan - 1).Dessine("RyanFrappeBrasPoubelle");
          } else {
            if (moteur.combat().EstGeleRyan()) {
              terrain.getCase(XRyan, YRyan).Dessine("AlexBasGele");
              terrain.getCase(XRyan, YRyan - 1).Dessine("AlexHautPoubelleGele");
            } else {
              terrain.getCase(XRyan, YRyan).Dessine("RyanBas");
              terrain.getCase(XRyan, YRyan - 1).Dessine("RyanHautPoubelle");
            }
          }
        } else {
          if (moteur.combat().ryan().estPositionFrappe()) {
            terrain.getCase(XRyan, YRyan).Dessine("RyanFrappeBarreBas");
            terrain.getCase(XRyan, YRyan - 1).Dessine("RyanFrappeBarreHaut");
            terrain.getCase(XRyan + 1, YRyan).Dessine("RyanFrappeBarre");
          } else {
            if (moteur.combat().EstGeleRyan()) {
              terrain.getCase(XRyan, YRyan).Dessine("AlexBarreBasGele");
              terrain.getCase(XRyan, YRyan - 1).Dessine("AlexBarreHautGele");
              terrain.getCase(XRyan - 1, YRyan - 1).Dessine("AlexBarre2Gele");
              terrain.getCase(XRyan - 1, YRyan - 2).Dessine("AlexBarre1Gele");
            } else {
              terrain.getCase(XRyan, YRyan).Dessine("RyanBarreBas");
              terrain.getCase(XRyan, YRyan - 1).Dessine("RyanBarreHaut");
              terrain.getCase(XRyan - 1, YRyan - 1).Dessine("RyanBarre2");
              terrain.getCase(XRyan - 1, YRyan - 2).Dessine("RyanBarre1");
            }
          }
        }

      } else if (moteur.combat().ryan().estPositionFrappe()) {
        terrain.getCase(XRyan, YRyan).Dessine("RyanFrappeBas");
        terrain.getCase(XRyan, YRyan - 1).Dessine("RyanFrappeHaut");
        terrain.getCase(XRyan + 1, YRyan - 1).Dessine("RyanFrappeBras");
      }

      else if (moteur.combat().ryan().estPositionSaut()) {
        terrain.getCase(XRyan, YRyan).Dessine("OmbreSaut");
        terrain.getCase(XRyan, YRyan - 1).Dessine("RyanSautBas");
        terrain.getCase(XRyan, YRyan - 2).Dessine("RyanSautHaut");
      } else if (moteur.combat().EstGeleRyan()) {
        terrain.getCase(XRyan, YRyan).Dessine("AlexBasGele");
        terrain.getCase(XRyan, YRyan - 1).Dessine("AlexHautGele");
      } else {
        terrain.getCase(XRyan, YRyan).Dessine("RyanBas");
        terrain.getCase(XRyan, YRyan - 1).Dessine("RyanHaut");
      }
    }

    // affichage Alex

    int XAlex = moteur.combat().alex().positionX();
    int YAlex = moteur.combat().alex().positionY();

    if (moteur.combat().alex().estVaincu()) {
      terrain.getCase(XAlex, YAlex).Dessine("AlexHautGeleMort");
    } else {
      if (cA == COMMANDE.RAMASSER) {

        terrain.getCase(XAlex, YAlex).Dessine("AlexRamasse");
      }

      else if (moteur.combat().alex().estEquipe()) {
        if (moteur.combat().alex().choseEquipee().nom().equals("chaine")) {
          if (moteur.combat().alex().estPositionFrappe()) {
            terrain.getCase(XAlex, YAlex).Dessine("AlexFrappeBarreBas");
            terrain.getCase(XAlex, YAlex - 1).Dessine("AlexFrappeBarreHaut");
            terrain.getCase(XAlex + 1, YAlex).Dessine("AlexFrappeChaine");
          } else {
            if (moteur.combat().EstGeleAlex()) {
              terrain.getCase(XAlex, YAlex).Dessine("AlexFrappeChaineBasGele");
              terrain.getCase(XAlex, YAlex - 1).Dessine("AlexFrappeChaineHautGele");
            } else {
              terrain.getCase(XAlex, YAlex).Dessine("AlexFrappeChaineBas");
              terrain.getCase(XAlex, YAlex - 1).Dessine("AlexFrappeChaineHaut");
            }
          }
        } else if (moteur.combat().alex().choseEquipee().nom().equals("poubelle")) {
          if (moteur.combat().alex().estPositionFrappe()) {
            terrain.getCase(XAlex, YAlex).Dessine("AlexFrappeBas");
            terrain.getCase(XAlex, YAlex - 1).Dessine("AlexFrappeHaut");
            terrain.getCase(XAlex + 1, YAlex - 1).Dessine("AlexFrappeBrasPoubelle");
          } else {
            if (moteur.combat().EstGeleAlex()) {
              terrain.getCase(XAlex, YAlex).Dessine("AlexBasGele");
              terrain.getCase(XAlex, YAlex - 1).Dessine("AlexHautPoubelleGele");
            } else {
              terrain.getCase(XAlex, YAlex).Dessine("AlexBas");
              terrain.getCase(XAlex, YAlex - 1).Dessine("AlexHautPoubelle");
            }
          }
        } else {
          if (moteur.combat().alex().estPositionFrappe()) {
            terrain.getCase(XAlex, YAlex).Dessine("AlexFrappeBarreBas");
            terrain.getCase(XAlex, YAlex - 1).Dessine("AlexFrappeBarreHaut");
            terrain.getCase(XAlex + 1, YAlex).Dessine("AlexFrappeBarre");
          } else {
            if (moteur.combat().EstGeleAlex()) {
              terrain.getCase(XAlex, YAlex).Dessine("AlexBarreBasGele");
              terrain.getCase(XAlex, YAlex - 1).Dessine("AlexBarreHautGele");
              terrain.getCase(XAlex - 1, YAlex - 1).Dessine("AlexBarre2Gele");
              terrain.getCase(XAlex - 1, YAlex - 2).Dessine("AlexBarre1Gele");
            } else {
              terrain.getCase(XAlex, YAlex).Dessine("AlexBarreBas");
              terrain.getCase(XAlex, YAlex - 1).Dessine("AlexBarreHaut");
              terrain.getCase(XAlex - 1, YAlex - 1).Dessine("AlexBarre2");
              terrain.getCase(XAlex - 1, YAlex - 2).Dessine("AlexBarre1");
            }
          }
        }

      } else if (moteur.combat().alex().estPositionFrappe()) {
        terrain.getCase(XAlex, YAlex).Dessine("AlexFrappeBas");
        terrain.getCase(XAlex, YAlex - 1).Dessine("AlexFrappeHaut");
        terrain.getCase(XAlex + 1, YAlex - 1).Dessine("AlexFrappeBras");
      }

      else if (moteur.combat().alex().estPositionSaut()) {
        terrain.getCase(XAlex, YAlex).Dessine("OmbreSaut");
        terrain.getCase(XAlex, YAlex - 1).Dessine("AlexSautBas");
        terrain.getCase(XAlex, YAlex - 2).Dessine("AlexSautHaut");
      } else if (moteur.combat().EstGeleAlex()) {
        terrain.getCase(XAlex, YAlex).Dessine("AlexBasGele");
        terrain.getCase(XAlex, YAlex - 1).Dessine("AlexHautGele");
      } else {
        terrain.getCase(XAlex, YAlex).Dessine("AlexBas");
        terrain.getCase(XAlex, YAlex - 1).Dessine("AlexHaut");
      }
    }
    bloc.Type a = bloc.Type.FOSSE;
    for (int i = 0; i < moteur.combat().terrain().hauteur(); i++) {
      for (int j = 0; j < moteur.combat().terrain().largeur(); j++) {
        if (moteur.combat().terrain().getBloc(j, i).getType() == bloc.Type.FOSSE) {
          terrain.getCase(j, i).Dessine("FOSSE");
        }
        if (moteur.combat().terrain().getBloc(j, i).getTresor() != Tresor.RIEN) {

          if (moteur.combat().terrain().getBloc(j, i).getTresor() == Tresor.UNDOLLAR) {
            terrain.getCase(j, i).Dessine("UnDollar");
          }
          if (moteur.combat().terrain().getBloc(j, i).getTresor() == Tresor.CINQUANTECENTIMES) {
            terrain.getCase(j, i).Dessine("50Cent");
          }
          if (moteur.combat().terrain().getBloc(j, i).getTresor() == Tresor.BARRE) {
            terrain.getCase(j, i).Dessine("BARRE");
          }
          if (moteur.combat().terrain().getBloc(j, i).getTresor() == Tresor.CHAINE) {
            terrain.getCase(j, i).Dessine("CHAINE");
          }
          if (moteur.combat().terrain().getBloc(j, i).getTresor() == Tresor.POUBELLE) {
            terrain.getCase(j, i).Dessine("POUBELLE");
          }
        }
      }
    }

    cA = COMMANDE.RIEN;
    cR = COMMANDE.RIEN;
    terrain.Update();

  }

  public static void main(String[] args) {
    new Main();
  }
}
