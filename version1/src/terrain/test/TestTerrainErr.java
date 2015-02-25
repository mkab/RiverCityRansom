package terrain.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import terrain.TerrainContract;
import terrain.TerrainImplErr;
import bloc.BlocContract;
import bloc.BlocImplErr;

public class TestTerrainErr extends TestTerrain{

	@Before
	public void initilisation(){
		terrain = new TerrainContract(new TerrainImplErr());
	}

}
