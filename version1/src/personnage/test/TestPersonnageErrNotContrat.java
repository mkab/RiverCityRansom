package personnage.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personnage.PersonnageImpl;
import personnage.PersonnageImplErr;

public class TestPersonnageErrNotContrat extends TestPersonnage{

	@Before
	public void initilisation(){
		personnage = new PersonnageImplErr();
	}

}
