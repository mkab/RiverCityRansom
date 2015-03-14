package gangster.test;

import gangster.GangsterImplErr;

import org.junit.Before;

public class TestGangsterErrNotContrat extends TestGangster {

  @Before
  public void initilisation() {
    gangster = new GangsterImplErr();
  }

}
