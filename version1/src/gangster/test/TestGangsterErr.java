package gangster.test;

import static org.junit.Assert.*;
import gangster.GangsterContrat;
import gangster.GangsterImplErr;

import org.junit.Before;
import org.junit.Test;

import personnage.PersonnageContrat;
import personnage.PersonnageImplErr;

public class TestGangsterErr extends TestGangster{

	@Before
	public void initilisation(){
		gangster = new GangsterContrat(new GangsterImplErr());
	}

}
