package personnage;

public class InvariantError extends Error {

  /**
   * 
   */
  private static final long serialVersionUID = 6153283791980003012L;

  public InvariantError(String string) {
    System.out.println(string);
  }

}
