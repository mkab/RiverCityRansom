package fr.upmc.rivercityransom.services;

/**
 * Interface describing the possible objects that can be found in the game
 * 
 * @author mkab
 * @version 1.0
 */
public interface ItemService {

  public Treasure name();

  public boolean isSellable();

  public boolean isReusable();

  public int value();

  /* Invariants */
  // No invariants

  /* Constructors */

  /**
   * name() != ""
   * pre: reusable != sellable
   * pre: value > 0
   * post: name() = treasure
   * post: isReusable() = reusable
   * post: isSellable() = sellable
   * post: value() = value;
   */
  public void init(Treasure treasure, boolean reusable, boolean sellable, int value);

}
