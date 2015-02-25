package gangster.test;

import static org.junit.Assert.*;
import gangster.GangsterContrat;
import gangster.GangsterImplErr;

import org.junit.Before;
import org.junit.Test;

public class TestGangsterErrNotContrat extends TestGangster{

	@Before
	public void initilisation(){
		gangster = new GangsterImplErr();
	}

}
