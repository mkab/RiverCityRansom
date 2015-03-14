package main;

import gangster.GangsterService;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PanelInfo extends JPanel {

  /**
   * 
   */
  private static final long serialVersionUID = -1924933195891937786L;
  private GridBagConstraints gbc;
  private int largeurPanel;
  private int largeurModule;
  private int pvA, pvR, pvS;
  private Case Pas1, Pas2;
  private JProgressBar pbarA, pbarR, pbarS;
  private int maxPas;
  private JLabel argentR, argentA;
  private PVganster pvG;

  public PanelInfo(int x, int pvAlex, int pvRyan, int pvSlick, int pas, int GangsterMax) {
    pvA = pvAlex;
    pvR = pvRyan;
    pvS = pvSlick;
    maxPas = pas;
    largeurPanel = x * 150;
    largeurModule = largeurPanel / 6;
    setLayout(new GridBagLayout());
    gbc = new GridBagConstraints();
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0, 0, 0, 0);

    gbc.gridx = 0;
    add(Alex(), gbc);

    gbc.gridx = 1;
    add(Argent(), gbc);
    gbc.gridy = 1;
    argentA = new JLabel("0 $");
    argentA.setForeground(Color.WHITE);
    argentA.setFont(new Font("Serif", Font.BOLD, 38));
    add(argentA, gbc);

    gbc.gridx = 4;
    argentR = new JLabel("0 $");
    argentR.setForeground(Color.WHITE);
    argentR.setFont(new Font("Serif", Font.BOLD, 38));
    add(argentR, gbc);

    gbc.gridy = 0;
    gbc.gridx = 4;
    add(Argent(), gbc);
    gbc.gridx = 5;
    add(Ryan(), gbc);

    Vie();
    PasDeJeu();

    gbc.gridy = 2;
    gbc.gridx = 0;
    add(Gangsters(), gbc);

    gbc.gridx = 5;
    add(Slick(), gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 3;
    pvG = new PVganster(GangsterMax, largeurModule);
    add(pvG, gbc);

    gbc.gridy = 4;
    gbc.gridwidth = 1;
    for (int j = 0; j < 6; j++) {
      gbc.gridx = j;
      add(new Case(new Dimension(largeurModule, 10), "Terrain/blanc.png"), gbc);
    }

  }

  public Case Alex() {
    ArrayList<BufferedImage> l = new ArrayList<BufferedImage>();
    l.add(ChargeImage("images/Alphabet/Alphabet_01.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_12.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_05.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_24.png"));

    Case Al = new Case(new Dimension(largeurModule, 32), "Terrain/fond.png");
    Al.setText(l);
    return Al;
  }

  public Case Argent() {
    ArrayList<BufferedImage> l = new ArrayList<BufferedImage>();
    l.add(ChargeImage("images/Alphabet/Alphabet_01.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_18.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_07.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_05.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_14.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_20.png"));

    Case Al = new Case(new Dimension(largeurModule, 32), "Terrain/fond.png");
    Al.setText(l);
    return Al;
  }

  public Case Slick() {
    ArrayList<BufferedImage> l = new ArrayList<BufferedImage>();
    l.add(ChargeImage("images/Alphabet/Alphabet_19.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_12.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_09.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_03.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_11.png"));

    Case Al = new Case(new Dimension(largeurModule, 32), "Terrain/fond.png");
    Al.setText(l);
    return Al;
  }

  public Case Gangsters() {
    ArrayList<BufferedImage> l = new ArrayList<BufferedImage>();
    l.add(ChargeImage("images/Alphabet/Alphabet_07.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_01.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_14.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_07.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_19.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_20.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_05.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_18.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_19.png"));

    Case Al = new Case(new Dimension(largeurModule, 32), "Terrain/fond.png");
    Al.setText(l);
    return Al;
  }

  public Case Ryan() {
    ArrayList<BufferedImage> l = new ArrayList<BufferedImage>();
    l.add(ChargeImage("images/Alphabet/Alphabet_18.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_25.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_01.png"));
    l.add(ChargeImage("images/Alphabet/Alphabet_14.png"));

    Case Al = new Case(new Dimension(largeurModule, 32), "Terrain/fond.png");
    Al.setText(l);
    return Al;
  }

  public void PasDeJeu() {

    gbc.gridy = 1;
    gbc.gridx = 2;
    gbc.anchor = GridBagConstraints.LINE_END;
    Pas1 = new Case(new Dimension(44, 52), "Alphabet/Temps_2.png");
    add(Pas1, gbc);

    gbc.gridy = 0;
    Case Al1 = new Case(new Dimension(164, 30), "Alphabet/PasJeu_01.png");
    add(Al1, gbc);

    gbc.anchor = GridBagConstraints.LINE_START;
    gbc.gridx = 3;
    Case Al3 = new Case(new Dimension(164, 30), "Alphabet/PasJeu_02.png");
    add(Al3, gbc);

    gbc.gridy = 1;
    Pas2 = new Case(new Dimension(44, 52), "Alphabet/Temps_5.png");
    add(Pas2, gbc);
    SetPasJeu(maxPas);
  }

  public void Vie() {
    gbc.gridx = 0;
    gbc.gridy = 1;

    pbarA = new JProgressBar(0, pvA);
    pbarA.setPreferredSize(new Dimension(largeurModule - 20, 30));
    pbarA.setBackground(Color.RED);
    pbarA.setForeground(Color.GREEN);
    pbarA.setBorderPainted(false);

    gbc.insets = new Insets(0, 10, 0, 00);
    add(pbarA, gbc);
    pbarA.setValue(pvA);

    gbc.gridx = 5;
    pbarR = new JProgressBar(0, pvR);
    pbarR.setPreferredSize(new Dimension(largeurModule - 20, 30));
    pbarR.setBackground(Color.RED);
    pbarR.setForeground(Color.GREEN);
    pbarR.setBorderPainted(false);
    gbc.insets = new Insets(0, 0, 0, 0);
    add(pbarR, gbc);
    pbarR.setValue(pvR);

    gbc.gridx = 5;
    gbc.gridy = 3;
    pbarS = new JProgressBar(0, pvS);
    pbarS.setPreferredSize(new Dimension(largeurModule - 20, 15));
    pbarS.setBackground(Color.RED);
    pbarS.setForeground(Color.GREEN);
    pbarS.setBorderPainted(false);
    gbc.insets = new Insets(0, 0, 0, 0);
    add(pbarS, gbc);
    pbarS.setValue(pvS);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(ChargeImage("images/Terrain/metal.png"), 0, 0, null);
  }

  public void SetPvAlex(int pv) {
    pbarA.setValue(pv);
    pvA = pv;
  }

  public void SetPvGangsters(ArrayList<GangsterService> liste) {
    pvG.affichage(liste);
  }

  public void SetPvRyan(int pv) {
    pbarR.setValue(pv);
    pvR = pv;
  }

  public void SetPvSlick(int pv) {
    pbarS.setValue(pv);
    pvS = pv;
  }

  public void setTune(int Alex, int Ryan) {
    argentA.setText((double) Alex / 100 + " $");
    argentR.setText((double) Ryan / 100 + " $");
  }

  public void SetPasJeu(int NbPas) {
    int unite = NbPas % 10;
    int dizaine = NbPas / 10 % 10;
    remove(Pas1);
    remove(Pas2);
    gbc.gridy = 1;
    gbc.gridx = 2;
    gbc.anchor = GridBagConstraints.LINE_END;
    Pas1 = new Case(new Dimension(44, 52), "Alphabet/Temps_" + dizaine + ".png");
    add(Pas1, gbc);

    gbc.anchor = GridBagConstraints.LINE_START;
    gbc.gridx = 3;
    gbc.gridy = 1;
    Pas2 = new Case(new Dimension(44, 52), "Alphabet/Temps_" + unite + ".png");
    add(Pas2, gbc);
  }

  public BufferedImage ChargeImage(String image) {

    try {
      return ImageIO
          .read(Thread.currentThread().getContextClassLoader().getResourceAsStream(image));
    } catch (IOException e) {
      e.printStackTrace();
      return null;

    }
  }
}
