package fr.upmc.rivercityransom.contracts;

import fr.upmc.rivercityransom.errors.ContractError;

public class InvariantError extends ContractError {

  /**
   * 
   */
  private static final long serialVersionUID = -963796054558283362L;

  public InvariantError(String message) {
    super("Invariant failed: " + message);
  }
}
