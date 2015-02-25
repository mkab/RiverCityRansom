package terrain.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bloc.BlocContract;
import bloc.BlocImpl;
import bloc.BlocService;
import bloc.Tresor;
import bloc.Type;
import error.InvariantError;
import error.PostconditionError;
import error.PreconditionError;
import personnage.PersonnageContrat;
import personnage.PersonnageImpl;
import terrain.TerrainContract;
import terrain.TerrainImpl;
import terrain.TerrainService;

public class TestTerrain {

	TerrainService terrain ;

	@Before
	public void initialisation(){
		terrain = new TerrainContract(new TerrainImpl());
	}

	@org.junit.Test
	public void testLargeurIncorrecte(){
		try{
			terrain.init(-8,8);
			Assert.assertTrue("precondition non catchee, ",true);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " bien catch�e ");
			Assert.assertTrue(true);
		}catch(PostconditionError e){
			Assert.assertTrue("Postcondition :" + e + "catch�e"+ "False", false);
		}catch(InvariantError e){
			Assert.assertTrue("Invariant : " + e + "catch�e"+ "False", false);
		}catch(NegativeArraySizeException e){
			System.out.println("NegativeArraySizeException catcher ");
			Assert.assertTrue(true);
		}
	}


	@org.junit.Test
	public void testHauteurIncorrecte(){
		try{
			terrain.init(8,-8);
			Assert.assertTrue("precondition non catchee, ",true);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " bien catch�e ");
			Assert.assertTrue(true);
		}catch(PostconditionError e){
			Assert.assertTrue("Postcondition :" + e + "catch�e"+ "False", false);
		}catch(InvariantError e){
			Assert.assertTrue("Invariant : " + e + "catch�e"+ "False", false);
		}catch(NegativeArraySizeException e){
			System.out.println("NegativeArraySizeException catcher ");
			Assert.assertTrue(true);
		}
	}


	@org.junit.Test
	public void getBlocTest(){
		terrain.init(8, 8);
		try{
			terrain.getBloc(8, 5);
			Assert.assertTrue(false);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " catcher");
			Assert.assertTrue(true);
		}catch(PostconditionError e){
			System.out.println("Postcondition :" + e + "catcher");
			Assert.assertTrue(false);
		}catch(InvariantError e){
			System.out.println("Invariant : " + e + "catcher");
			Assert.assertTrue(false);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException catcher ");
			Assert.assertTrue(true);
		}
	}

	@org.junit.Test
	public void getBlocTest2(){
		terrain.init(10,8);
		try{
			terrain.getBloc(7, 1);
			Assert.assertTrue(true);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " catcher");
			Assert.assertTrue(false);
		}catch(PostconditionError e){
			System.out.println("Postcondition :" + e + "catcher");
			Assert.assertTrue(false);
		}catch(InvariantError e){
			System.out.println("Invariant : " + e + "catcher");
			Assert.assertTrue(false);
		}
	}
	@org.junit.Test
	public void getBlocTest3(){
		terrain.init(10,8);
		try{
			terrain.getBloc(7, 8);
			Assert.assertTrue(false);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " catcher");
			Assert.assertTrue(true);
		}catch(PostconditionError e){
			System.out.println("Postcondition :" + e + "catcher");
			Assert.assertTrue(false);
		}catch(InvariantError e){
			System.out.println("Invariant : " + e + "catcher");
			Assert.assertTrue(false);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException catcher ");
			Assert.assertTrue(true);
		}
	}
	
	@org.junit.Test
	public void setBloc1Test(){
		terrain.init(8, 8);
		try{
			BlocService B = new BlocContract(new BlocImpl());
			B.init(Type.VIDE, Tresor.RIEN);
			terrain.setBloc(B, 1, 1);
			Assert.assertTrue(true);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " catcher");
			Assert.assertTrue(false);
		}catch(PostconditionError e){
			System.out.println("Postcondition :" + e + "catcher");
			Assert.assertTrue(false);
		}catch(InvariantError e){
			System.out.println("Invariant : " + e + "catcher");
			Assert.assertTrue(false);
		}
	}
	
	@org.junit.Test
	public void setBloc2Test(){
		terrain.init(11, 9);
		try{
			BlocService B = new BlocContract(new BlocImpl());
			B.init(Type.VIDE, Tresor.RIEN);
			terrain.setBloc(B, -1, 1);
			Assert.assertTrue(false);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " catcher");
			Assert.assertTrue(true);
		}catch(PostconditionError e){
			System.out.println("Postcondition :" + e + "catcher");
			Assert.assertTrue(false);
		}catch(InvariantError e){
			System.out.println("Invariant : " + e + "catcher");
			Assert.assertTrue(false);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException catcher ");
			Assert.assertTrue(true);
		}
	}
	@org.junit.Test
	public void setBloc3Test(){
		terrain.init(11, 9);
		try{
			terrain.setBloc(null, 1, 1);
			Assert.assertTrue(false);
		}catch(PreconditionError e){
			System.out.println("Precondition : " + e + " catcher");
			Assert.assertTrue(true);
		}catch(PostconditionError e){
			System.out.println("Postcondition :" + e + "catcher");
			Assert.assertTrue(false);
		}catch(InvariantError e){
			System.out.println("Invariant : " + e + "catcher");
			Assert.assertTrue(false);
		}
	}





}
