package gangster.test;

import static org.junit.Assert.*;
import gangster.GangsterContrat;
import gangster.GangsterImpl;
import gangster.GangsterImplErr;

import org.junit.Before;
import org.junit.Test;

public class TestGangsterNotContrat extends TestGangster{

	@Before
	public void initilisation(){
		gangster = new GangsterImpl();
	}

}
