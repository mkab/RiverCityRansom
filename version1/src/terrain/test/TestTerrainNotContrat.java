package terrain.test;

import org.junit.Before;

import terrain.TerrainImpl;

public class TestTerrainNotContrat extends TestTerrain {

  @Before
  public void initialisation() {
    terrain = new TerrainImpl();
  }

}
