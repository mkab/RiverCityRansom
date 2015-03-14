package bloc.test;

import org.junit.Before;

import bloc.BlocImpl;

public class TestBlocNotContrat extends TestBloc {

  @Before
  public void initilisation() {
    bloc = new BlocImpl();
  }

}
