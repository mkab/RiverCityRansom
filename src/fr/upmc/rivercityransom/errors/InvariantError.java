package fr.upmc.rivercityransom.errors;

/**
 * This class manages the Invariant Error
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */

public class InvariantError extends ContractError {

  /**
   * 
   */
  private static final long serialVersionUID = -963796054558283362L;

  public InvariantError(String message) {
    super("Invariant failed: " + message);
  }
}
