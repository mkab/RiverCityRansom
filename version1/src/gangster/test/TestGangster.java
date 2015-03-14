package gangster.test;

import error.InvariantError;
import error.PostconditionError;
import error.PreconditionError;
import gangster.GangsterContrat;
import gangster.GangsterImpl;
import gangster.GangsterService;

import org.junit.Assert;
import org.junit.Before;

public class TestGangster {

  GangsterService gangster;

  @Before
  public void initialisation() {
    gangster = new GangsterContrat(new GangsterImpl());
  }

  @org.junit.Test
  public void testNomIncorrect() {
    try {
      gangster.init("niGangsterNiSlick", 2, 3, 5, 10, 100);
      Assert.assertTrue("precondition non catchee, ", false);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);

    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testNomVide() {
    try {
      gangster.init("", 2, 3, 5, 10, 100);
      Assert.assertTrue("precondition non catchee, ", false);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);

    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testLargeurNegative() {
    try {
      gangster.init("slick", -2, 3, 5, 10, 100);
      Assert.assertTrue("precondition non catchee, ", false);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);

    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testHauteurNegative() {
    try {
      gangster.init("slick", 2, -3, 5, 10, 100);
      Assert.assertTrue("precondition non catchee, ", false);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);

    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testProfondeurNegative() {
    try {
      gangster.init("slick", 2, 3, -5, 10, 100);
      Assert.assertTrue("precondition non catchee, ", false);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);

    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testForceNegative() {
    try {
      gangster.init("slick", 2, 3, 5, -10, 100);
      Assert.assertTrue("precondition non catchee, ", false);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);

    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testPVNegatifs() {
    try {
      gangster.init("slick", 2, 3, 5, 10, -100);
      Assert.assertTrue("precondition non catchee, ", false);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);

    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testDepotPVNegatifs() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);

    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      gangster.depotPV(gangster, -5);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testRetraitPVNegatifs() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);

    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      gangster.retraitPV(gangster, -5);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testDepotArgentNegatif() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);

    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      gangster.depotArgent(gangster, -5);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testRetraitArgentNegatif() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);

    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      gangster.retraitArgent(gangster, -5);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testRamasserAlorsQueDejaEquipe() {
    try {
      gangster.init("gangster", 2, 3, 5, 10, 100);
      personnage.ObjetService objet = new personnage.ObjetService("barre", 5, true);
      gangster.ramasser(gangster, objet);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.ObjetService objet = new personnage.ObjetService("barre", 5, true);
      gangster.ramasser(gangster, objet);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", true);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testJeterAlorsQuePasEquipe() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);
      // Objet objet = new ObjetService("barre", 5, true);
      // gangster.ramasser(gangster, objet);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.ObjetService objet = new personnage.ObjetService("barre", 5, true);
      // gangster.ramasser(gangster, objet);
      //
      // gangster.jeter(gangster, objet);
      gangster.jeter(gangster, objet);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testJeter2fois() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);
      // Objet objet = new ObjetService("barre", 5, true);
      // gangster.ramasser(gangster, objet);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.ObjetService objet = new personnage.ObjetService("barre", 5, true);
      gangster.ramasser(gangster, objet);
      gangster.jeter(gangster, objet);
      gangster.jeter(gangster, objet);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", true);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testSauter() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      gangster.sauter(gangster);

    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", true);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testSauter2fois() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      gangster.sauter(gangster);
      gangster.sauter(gangster);

    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", true);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testFrapper() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      gangster.setPositionFrappe(true);

    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testFrapper2FoisAuMemeTour() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      gangster.setPositionFrappe(true);
      gangster.setPositionFrappe(true);

    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

  @org.junit.Test
  public void testSetPositionXnegative() {
    try {
      gangster.init("slick", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      gangster.setPosition(-2, 3);

    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    }
  }

}
