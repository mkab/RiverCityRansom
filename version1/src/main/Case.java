package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Case extends JButton {

  /**
   * 
   */
  private static final long serialVersionUID = 2235648230825003807L;
  boolean fosse;
  boolean Tresor;
  String fond;
  Dimension n;
  ArrayList<Img> UpdateGraphicsPerso, UpdateGraphicsTerrain;
  boolean Modif;
  ImageIcon Fond;
  BufferedImage BufFond;
  BufferedImage Avant;
  int t = -1;
  int p = -1;

  public Case(Dimension n, String img) {
    UpdateGraphicsPerso = new ArrayList<Img>();
    UpdateGraphicsTerrain = new ArrayList<Img>();
    Modif = false;
    this.n = n;
    fond = img;
    setPreferredSize(n);
    setContentAreaFilled(false);
    setOpaque(false);
    setFocusPainted(false);
    BufFond = ChargeImage("images/" + img);
    Avant = BufFond;
    Fond = new ImageIcon(BufFond.getScaledInstance(n.width, n.height, Image.SCALE_DEFAULT));
    setIcon(Fond);
    setMargin(new Insets(0, 0, 0, 0));
    setBorderPainted(false);
  }

  public BufferedImage ChargeImage(String image) {

    try {
      return ImageIO
          .read(Thread.currentThread().getContextClassLoader().getResourceAsStream(image));
    } catch (IOException e) {
      e.printStackTrace();
      return BufFond;

    }
  }

  public void setText(ArrayList<BufferedImage> img) {
    BufferedImage image = new BufferedImage(150, 100, BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();
    for (int i = 0; i < img.size(); i++) {
      g.drawImage(img.get(i), 17 * i, 39, null);
    }
    setIcon(new ImageIcon(image));
  }

  public void nettoyer() {

    setIcon(Fond);
    UpdateGraphicsPerso.clear();
  }

  public void Dessine(String a) {
    Img image;
    if (!Modif) {
      UpdateGraphicsPerso.clear();
      UpdateGraphicsTerrain.clear();
      Modif = true;
    }
    switch (a) {
    // Gele********************************************************//
      case "AlexHautGele":
        image = new Img(ChargeImage("images/Gele/AlexHaut.png"), 0, 0);
        UpdateGraphicsPerso.add(image);
      case "AlexHautGeleMort":
        image = new Img(ChargeImage("images/Gele/AlexHaut.png"), 0, 0);
        UpdateGraphicsPerso.add(0, image);
        break;
      case "AlexBasGele":
        image = new Img(ChargeImage("images/Gele/AlexBas.png"), 0, 0);
        UpdateGraphicsPerso.add(0, image);
        break;
      case "AlexBarreHautGele":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gele/AlexBarreHaut.png"), 0, 0));
        break;
      case "AlexBarreBasGele":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gele/AlexBarreBas.png"), 0, 0));
        break;
      case "AlexBarre1Gele":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gele/AlexBarre1.png"), 0, 0));
        break;
      case "AlexBarre2Gele":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gele/AlexBarre2.png"), 0, 0));
        break;
      case "AlexFrappeChaineBasGele":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gele/AlexFrappeChaineBas.png"), 0, 0));
        break;
      case "AlexFrappeChaineHautGele":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gele/AlexFrappeChaineHaut.png"), 0, 0));
        break;
      case "AlexHautPoubelleGele":
        image = new Img(ChargeImage("images/Gele/AlexHautPoubelle.png"), 0, 0);
        UpdateGraphicsPerso.add(image);
        break;

      // Alex ****************************************************** //

      case "AlexHaut":
        image = new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0);
        UpdateGraphicsPerso.add(image);
        break;
      case "AlexHautPoubelle":
        image = new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0);
        UpdateGraphicsPerso.add(image);
      case "AlexBas":
        image = new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0);
        UpdateGraphicsPerso.add(0, image);
        break;
      case "AlexRamasse":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexFrappeHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 14, 0));
        break;
      case "AlexFrappeBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 14, 0));
        break;
      case "AlexFrappeBras":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexFrappeBrasPoubelle":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexBarreHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexBarreBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexBarre1":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexBarre2":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexFrappeBarreHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexFrappeBarreBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexFrappeBarre":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexFrappeChaine":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexFrappeChaineBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexFrappeChaineHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexSautHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "AlexSautBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/" + a + ".png"), 0, 0));
        break;
      case "OmbreSautAlex":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Alex/OmbreSaut.png"), 0, 0));
        break;

      // Ryan ****************************************************** //
      case "RyanHaut":
        image = new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0);
        UpdateGraphicsPerso.add(image);
        break;
      case "RyanHautPoubelle":
        image = new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0);
        UpdateGraphicsPerso.add(image);
      case "RyanBas":
        image = new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0);
        UpdateGraphicsPerso.add(0, image);
        break;
      case "RyanRamasse":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanFrappeHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 14, 0));
        break;
      case "RyanFrappeBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 14, 0));
        break;
      case "RyanFrappeBras":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanFrappeBrasPoubelle":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanBarreHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanBarreBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanBarre1":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanBarre2":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanFrappeBarreHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanFrappeBarreBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanFrappeBarre":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanFrappeChaine":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanFrappeChaineBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanFrappeChaineHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanSautHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "RyanSautBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;
      case "OmbreSaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Ryan/" + a + ".png"), 0, 0));
        break;

      // Slick ****************************************************** //

      case "SlickHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Slick/" + a + ".png"), 0, 0));
        break;
      case "SlickBas":
        UpdateGraphicsPerso.add(0, new Img(ChargeImage("images/Slick/" + a + ".png"), 0, 0));
        break;
      case "SlickHautGele":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Slick/" + a + ".png"), 0, 0));
        break;
      case "SlickBasGele":
        UpdateGraphicsPerso.add(0, new Img(ChargeImage("images/Slick/" + a + ".png"), 0, 0));
        break;
      case "SlickFrappeHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Slick/" + a + ".png"), 0, 0));
        break;
      case "SlickFrappeBas":
        UpdateGraphicsPerso.add(0, new Img(ChargeImage("images/Slick/" + a + ".png"), 0, 0));
        break;
      case "SlickFrappeBras":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Slick/" + a + ".png"), 0, 0));
        break;

      // Gangster *********************************************************************//
      case "GangsterBas":
        UpdateGraphicsPerso.add(0, new Img(ChargeImage("images/Gangster/" + a + ".png"), 0, 0));
        break;
      case "GangsterHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gangster/" + a + ".png"), t, 0));
        break;
      case "GangsterBasGele":
        UpdateGraphicsPerso.add(0, new Img(ChargeImage("images/Gangster/" + a + ".png"), 0, 0));
        break;
      case "GangsterHautGele":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gangster/" + a + ".png"), t, 0));
        break;
      case "GangsterFrappeHaut":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gangster/" + a + ".png"), 0, 0));
        break;
      case "GangsterFrappeBas":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gangster/" + a + ".png"), 0, 0));
        break;
      case "GangsterFrappeBras":
        UpdateGraphicsPerso.add(new Img(ChargeImage("images/Gangster/" + a + ".png"), 0, 0));
        break;

      // Tresor-element terrain ****************************************************** //
      case "UnDollar":
        UpdateGraphicsTerrain.add(new Img(ChargeImage("images/Terrain/" + a + ".png"), 0, 0));
        break;

      case "50Cent":
        UpdateGraphicsTerrain.add(new Img(ChargeImage("images/Terrain/" + a + ".png"), 0, 0));
        break;

      case "FOSSE":
        UpdateGraphicsTerrain.add(new Img(ChargeImage("images/Terrain/" + a + ".png"), 0, 0));
        break;

      case "BARRE":
        UpdateGraphicsTerrain.add(new Img(ChargeImage("images/Terrain/" + a + ".png"), 0, 80));
        break;
      case "CHAINE":
        UpdateGraphicsTerrain.add(new Img(ChargeImage("images/Terrain/chaine.png"), 0, 0));
        break;
      case "POUBELLE":
        UpdateGraphicsTerrain.add(new Img(ChargeImage("images/Terrain/poubelle" + ".png"), 0, 0));
        break;
    }
  }

  public void UpdateG() {
    if (Modif) {
      BufferedImage Back = BufFond;
      BufferedImage image = new BufferedImage(150, 100, BufferedImage.TYPE_INT_ARGB);
      Graphics g = image.getGraphics();
      g.drawImage(Back, 0, 0, null);
      for (int i = 0; i < UpdateGraphicsTerrain.size(); i++) {
        g.drawImage(UpdateGraphicsTerrain.get(i).g, UpdateGraphicsTerrain.get(i).x,
            UpdateGraphicsTerrain.get(i).y, null);
      }
      for (int i = 0; i < UpdateGraphicsPerso.size(); i++) {
        g.drawImage(UpdateGraphicsPerso.get(i).g, UpdateGraphicsPerso.get(i).x, UpdateGraphicsPerso
            .get(i).y, null);
      }

      boolean test = true;
      for (int x = 0; x < Avant.getWidth(); x += 15) {
        for (int y = 0; y < Avant.getHeight(); y += 10) {
          if (Avant.getRGB(x, y) != image.getRGB(x, y))
            test = false;
        }
      }
      if (!test) {
        setIcon(new ImageIcon(image));
        Avant = image;
      }
      Modif = false;
    } else {
      Avant = BufFond;
      setIcon(Fond);
    }
  }

  public String getFond() {
    return fond;
  }
}
