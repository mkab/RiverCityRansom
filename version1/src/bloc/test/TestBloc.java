package bloc.test;

import org.junit.Assert;
import org.junit.Before;
import error.InvariantError;
import error.PostconditionError;
import error.PreconditionError;
import bloc.BlocContract;
import bloc.BlocImpl;
import bloc.BlocService;
import bloc.Tresor;
import bloc.Type;

public class TestBloc {

	BlocService bloc;

	@Before
	public void initialisation(){
		bloc = new BlocContract(new BlocImpl());
	}

	
	
	@org.junit.Test
	public void testTypeIncorrect(){
		try{
			bloc.init(null,null);
			Assert.assertTrue("precondition non catchee, ",false);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " bien catch�e ");
			Assert.assertTrue(true);

		}catch(PostconditionError e){
			Assert.assertTrue("Postcondition :" + e + "catch�e"+ "False", false);
		}catch(InvariantError e){
			Assert.assertTrue("Invariant : " + e + "catch�e"+ "False", false);
		}
	}
	
	
	@org.junit.Test
	public void testTresorIncorrect(){
		try{
			bloc.init(Type.VIDE,null);
			Assert.assertTrue("precondition non catchee, ",false);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " bien catch�e ");
			Assert.assertTrue(true);

		}catch(PostconditionError e){
			Assert.assertTrue("Postcondition :" + e + "catch�e"+ "False", false);
		}catch(InvariantError e){
			Assert.assertTrue("Invariant : " + e + "catch�e"+ "False", false);
		}
	}
	
	
	@org.junit.Test
	public void testsetTypeIncorrect(){
		try{
			bloc.init(Type.VIDE,Tresor.RIEN);

		}catch(Error e ){
			Assert.assertFalse(e.toString() + "False", false);
		}

		try{
			bloc.setTYPE(null);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " bien catch�e ");
			Assert.assertTrue(true);
		}catch(PostconditionError e){
			Assert.assertTrue("Postcondition :" + e + "catch�e"+ "False", false);
		}catch(InvariantError e){
			Assert.assertTrue("Invariant : " + e + "catch�e"+ "False", false);
		}
	}

	

	@org.junit.Test
	public void testsetTresorIncorrect(){
		try{
			bloc.init(Type.VIDE,Tresor.RIEN);

		}catch(Error e ){
			Assert.assertFalse(e.toString() + "False", false);
		}

		try{
			bloc.setTresor(null);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " bien catch�e ");
			Assert.assertTrue(true);
		}catch(PostconditionError e){
			Assert.assertTrue("Postcondition :" + e + "catch�e"+ "False", false);
		}catch(InvariantError e){
			Assert.assertTrue("Invariant : " + e + "catch�e"+ "False", false);
		}
	}

	
	
	
	
}
