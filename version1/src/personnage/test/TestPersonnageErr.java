package personnage.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personnage.PersonnageContrat;
import personnage.PersonnageImplErr;

public class TestPersonnageErr extends TestPersonnage{

	@Before
	public void initilisation(){
		personnage = new PersonnageContrat(new PersonnageImplErr());
	}

}
