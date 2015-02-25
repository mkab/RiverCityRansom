package bloc.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bloc.BlocContract;
import bloc.BlocImplErr;

public class TestBlocErr extends TestBloc{

	@Before
	public void initilisation(){
		bloc = new BlocContract(new BlocImplErr());
	}
}
