package gangster.test;

import gangster.GangsterContrat;
import gangster.GangsterImplErr;

import org.junit.Before;

public class TestGangsterErr extends TestGangster {

  @Before
  public void initilisation() {
    gangster = new GangsterContrat(new GangsterImplErr());
  }

}
