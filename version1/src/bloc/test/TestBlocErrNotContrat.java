package bloc.test;

import org.junit.Before;

import bloc.BlocImplErr;

public class TestBlocErrNotContrat extends TestBloc {

  @Before
  public void initilisation() {
    bloc = new BlocImplErr();
  }

}
