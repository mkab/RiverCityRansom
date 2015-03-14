package gangster.test;

import gangster.GangsterImpl;

import org.junit.Before;

public class TestGangsterNotContrat extends TestGangster {

  @Before
  public void initilisation() {
    gangster = new GangsterImpl();
  }

}
