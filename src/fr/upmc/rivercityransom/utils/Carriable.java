package fr.upmc.rivercityransom.utils;

/**
 * Interface to reperesent a Carriable object.
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public interface Carriable {

  /**
   * Returns <b>true</b> if the character can sell the Carriable , <b>false</b> otherwise
   */
  public boolean isSellable();

  /**
   * Returns <b>true</b> if the Carriable is reusable , <b>false</b> otherwise
   */
  public boolean isReusable();

  /**
   * Returns the value of the Carriable
   */
  public int value();

}
