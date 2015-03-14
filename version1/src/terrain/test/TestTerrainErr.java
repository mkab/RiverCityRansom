package terrain.test;

import org.junit.Before;

import terrain.TerrainContract;
import terrain.TerrainImplErr;

public class TestTerrainErr extends TestTerrain {

  @Before
  public void initilisation() {
    terrain = new TerrainContract(new TerrainImplErr());
  }

}
