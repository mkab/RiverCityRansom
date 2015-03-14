package bloc.test;

import org.junit.Before;

import bloc.BlocContract;
import bloc.BlocImplErr;

public class TestBlocErr extends TestBloc {

  @Before
  public void initilisation() {
    bloc = new BlocContract(new BlocImplErr());
  }
}
