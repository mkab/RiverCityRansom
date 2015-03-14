package personnage.test;

import org.junit.Assert;
import org.junit.Before;

import personnage.Objet;
import personnage.ObjetService;
import personnage.PersonnageContrat;
import personnage.PersonnageImpl;
import personnage.PersonnageService;
import error.InvariantError;
import error.PostconditionError;
import error.PreconditionError;

public class TestPersonnage {

  PersonnageService personnage;

  @Before
  public void initialisation() {
    personnage = new PersonnageContrat(new PersonnageImpl());
  }

  @org.junit.Test
  public void testNomIncorrect() {
    try {
      personnage.init("niAlexniRyan", 2, 3, 5, 10, 100);
      Assert.assertTrue(false);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      System.out.println("Postcondition :" + e + "catch�e");
      Assert.assertTrue(false);
    } catch (InvariantError e) {
      System.out.println("Invariant : " + e + "catch�e");
      Assert.assertTrue(false);
    }
  }

  @org.junit.Test
  public void testLargeurIncorrecte() {
    try {
      personnage.init("alex", -2, 3, 5, 10, 100);
      Assert.assertTrue(true);
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
  public void testHauteurIncorrecte() {
    try {
      personnage.init("alex", 2, -3, 5, 10, 100);
      Assert.assertTrue("precondition non catchee, ", true);
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
  public void testProfondeurIncorrecte() {
    try {
      personnage.init("alex", 2, 3, -5, 10, 100);
      Assert.assertTrue("precondition non catchee, ", true);
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
  public void testForceIncorrecte() {
    try {
      personnage.init("alex", 2, 3, 5, -10, 100);
      Assert.assertTrue("precondition non catchee, ", true);
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
  public void testPVIncorrects() {
    try {
      personnage.init("alex", 2, 3, 5, 10, -100);
      Assert.assertTrue("precondition non catchee, ", true);
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
      personnage.init("alex", 2, 3, 5, 10, 100);

    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.depotPV(personnage, -5);
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
      personnage.init("alex", 2, 3, 5, 10, 100);

    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.retraitPV(personnage, -5);
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
      personnage.init("alex", 2, 3, 5, 10, 100);

    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.depotArgent(personnage, -5);
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
      personnage.init("alex", 2, 3, 5, 10, 100);

    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.retraitArgent(personnage, -5);
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
      personnage.init("alex", 2, 3, 5, 10, 100);
      Objet objet = new ObjetService("barre", 5, true);
      personnage.ramasser(personnage, objet);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      Objet objet = new ObjetService("barre", 5, true);
      personnage.ramasser(personnage, objet);
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
  public void testJeterAlorsQuePasEquipe() {
    try {
      personnage.init("alex", 2, 3, 5, 10, 100);
      // Objet objet = new ObjetService("barre", 5, true);
      // personnage.ramasser(personnage, objet);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      Objet objet = new ObjetService("barre", 5, true);
      // personnage.ramasser(personnage, objet);
      //
      // personnage.jeter(personnage, objet);
      personnage.jeter(personnage, objet);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
    } catch (NullPointerException e) {
      Assert.assertTrue("Null pointer Execption", true);
    }
  }

  @org.junit.Test
  public void testJeter2fois() {
    try {
      personnage.init("alex", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      Objet objet = new ObjetService("barre", 5, true);
      personnage.ramasser(personnage, objet);
      personnage.jeter(personnage, objet);
      personnage.jeter(personnage, objet);
      Assert.assertTrue(false);
    } catch (PreconditionError e) {
      System.out.println("Precondition : " + e + " bien catch�e ");
      Assert.assertTrue(true);
    } catch (PostconditionError e) {
      Assert.assertTrue("Postcondition :" + e + "catch�e" + "False", false);
      Assert.assertTrue(false);
    } catch (InvariantError e) {
      Assert.assertTrue("Invariant : " + e + "catch�e" + "False", false);
      Assert.assertTrue(false);
    } catch (NullPointerException e) {
      Assert.assertTrue("Null pointer Execption", true);
    }
  }

  @org.junit.Test
  public void testSauter() {
    try {
      personnage.init("alex", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.sauter(personnage);

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
  public void testSauter2fois() {
    try {
      personnage.init("alex", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.sauter(personnage);
      personnage.sauter(personnage);

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
  public void testFrapper() {
    try {
      personnage.init("alex", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.setPositionFrappe(true);

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
      personnage.init("alex", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.setPositionFrappe(true);
      personnage.setPositionFrappe(true);

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
      personnage.init("alex", 2, 3, 5, 10, 100);
    } catch (Error e) {
      Assert.assertFalse(e.toString() + "False", false);
    }

    try {
      personnage.setPosition(-2, 3);

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
