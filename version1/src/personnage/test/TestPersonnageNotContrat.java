package personnage.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import error.InvariantError;
import error.PostconditionError;
import error.PreconditionError;
import personnage.Objet;
import personnage.ObjetService;
import personnage.PersonnageContrat;
import personnage.PersonnageImpl;
import personnage.PersonnageImplErr;

public class TestPersonnageNotContrat extends TestPersonnage{

	@Before
	public void initilisation(){
		personnage = new PersonnageImpl();
	}

}
