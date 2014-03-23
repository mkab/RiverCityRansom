package fr.upmc.rivercityransom.services;

/**
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public interface BlockService {

  public Type getType();

  public int getLength();

  public int getBreadth();

  public int getHeight();

  // \pre: type() == VIDE
  public boolean hasTreasure();

  // \pre: hasTreasure()
  public ItemService getItem();

  /* Invariants */
  // No invariants

  // \pre: length > 0
  // \pre: breadth > 0
  // \pre: height > 0
  // \pre: type == EMPTY
  // \post: getLength() == length
  // \post: getBreadth() == breadth
  // \post: getHeight() == height
  // \post: getType() == type
  // \post: hasTreasure() == false
  public void init(int length, int breadth, int height, Type type);

  // \pre: length > 0
  // \pre: breadth > 0
  // \pre: height > 0
  // \pre: type == EMPTY
  // \post: getLength() == length
  // \post: getBreadth() == breadth
  // \post: getHeight() == height
  // \post: getType() == type
  // \post: hasTreasure() == true
  // \post: getItem() == item
  public void init(int length, int breadth, int height, Type type, ItemService item);

}
