package fr.upmc.rivercityransom.services;

import fr.upmc.rivercityransom.utils.Carriable;
import fr.upmc.rivercityransom.utils.Treasure;

/**
 * Interface describing the possible objects that can be found in the game
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public interface ItemService extends Carriable {

  /** Returns the name of the item */
  public Treasure name();

  /* Invariants */
  // No invariants

  /* Constructors */

  /**
   * Initializes a new item. Note that an ItemService cannot be reusable and sellable at the same
   * time <b>reusable != sellable</b>
   * 
   * @param treasure - the treasure
   * @param reusable - use <b>true</b> if the item is reusable, <b>false</b> otherwise
   * @param sellable - use <b>true</b> if the item is reusable, <b>false</b> otherwise
   * @param value - the value of the item
   */
  // \name() != "" (&& name is instanceOf Treasure)
  // \pre: reusable != sellable
  // \pre: value > 0
  // \post: name() = treasure
  // \post: isReusable() = reusable
  // \post: isSellable() = sellable
  // \post: value() = value
  public void init(Treasure name, boolean reusable, boolean sellable, int value);
  // public void init(Treasure treasure, boolean reusable, boolean sellable, int value);

}
