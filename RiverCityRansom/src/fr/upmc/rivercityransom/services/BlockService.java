package fr.upmc.rivercityransom.services;

public interface BlockService {

  public Type type();

  // \pre: type() = VIDE
  public boolean hasTreasure();

  // \pre: hasTreasure()
  public ItemService getTreasure();

  /* Invariants */
  // No invariants

  
  /**
   * post: type() = type
   * post: hasTreasure() = false
   */
  public void init(Type type);

  /**
   * post: type() = type
   * post: hasTreasure() = true
   * post: getTreasure() = item
   */
  public void init(Type type, ItemService item);

}
