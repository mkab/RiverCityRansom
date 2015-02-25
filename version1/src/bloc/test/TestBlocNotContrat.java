package bloc.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bloc.BlocImpl;


public class TestBlocNotContrat extends TestBloc{

	@Before
	public void initilisation(){
		bloc =new BlocImpl();
	}

}
