package personnage.test;

import org.junit.Before;

import personnage.PersonnageContrat;
import personnage.PersonnageImplErr;

public class TestPersonnageErr extends TestPersonnage {

  @Before
  public void initilisation() {
    personnage = new PersonnageContrat(new PersonnageImplErr());
  }

}
