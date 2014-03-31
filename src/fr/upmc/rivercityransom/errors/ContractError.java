package fr.upmc.rivercityransom.errors;

/**
 * Super class that takes care of errors in the contract
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public class ContractError extends Error {

  /**
   * 
   */
  private static final long serialVersionUID = -2250524238697891370L;

  /**
   * Constructs an ContractError with the specified detail message.
   * 
   * @param message - the detail message.
   */
  public ContractError(String message) {
    super(message);
  }
}
