package fr.upmc.rivercityransom.errors;

/**
 * This class manages the Precondition Error
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */

public class PreconditionError extends ContractError {
  private static final long serialVersionUID = 1989924888153266862L;

  /**
   * Constructs an PreconditionError with the specified detail message.
   * 
   * @param message - the detail message.
   */
  public PreconditionError(String message) {
    super("Precondition failed: " + message);
  }
}
