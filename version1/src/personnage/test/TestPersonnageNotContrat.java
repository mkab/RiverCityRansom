package personnage.test;

import org.junit.Before;

import personnage.PersonnageImpl;

public class TestPersonnageNotContrat extends TestPersonnage {

  @Before
  public void initilisation() {
    personnage = new PersonnageImpl();
  }

}
