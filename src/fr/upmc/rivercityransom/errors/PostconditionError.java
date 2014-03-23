package fr.upmc.rivercityransom.errors;

/**
 * This class manages the Postcondition Error
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */

public class PostconditionError extends ContractError {
  private static final long serialVersionUID = 9050050491786738283L;

  public PostconditionError(String message) {
    super("Postcondition failed: " + message);
  }
}
