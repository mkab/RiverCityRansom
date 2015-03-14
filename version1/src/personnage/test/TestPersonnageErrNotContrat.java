package personnage.test;

import org.junit.Before;

import personnage.PersonnageImplErr;

public class TestPersonnageErrNotContrat extends TestPersonnage {

  @Before
  public void initilisation() {
    personnage = new PersonnageImplErr();
  }

}
