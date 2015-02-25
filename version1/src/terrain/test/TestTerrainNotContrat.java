package terrain.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import terrain.TerrainContract;
import terrain.TerrainImpl;

public class TestTerrainNotContrat extends TestTerrain {

	@Before
	public void initialisation(){
		terrain =new TerrainImpl();
	}

}
 