package fr.upmc.rivercityransom.services;

import fr.upmc.rivercityransom.utils.Type;

/**
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public interface BlockService {

  /** Returns the type of the block : EMPTY, PIT */
  public Type getType();

  /**
   * Returns the length of the block
   */
  public int getLength();

  /**
   * Returns the breadth of the block
   */
  public int getBreadth();

  /**
   * Returns the height of the block
   */
  public int getHeight();

  /**
   * Returns <b>true</b> if the block contains a treasure, <b>false</b> otherwise
   */
  // \pre: type() == VIDE
  public boolean hasTreasure();

  /**
   * Returns the Item the block contains
   */
  // \pre: hasTreasure()
  public ItemService getItem();

  /* Invariants */
  // No invariants

  /**
   * Initializes a block with its dimensions and an Enum Type. This block contains no Item
   * 
   * @param type - an Enum Type to describe the type of the block
   */
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

  /**
   * Initializes a block with its dimensions, an enum TYPE and an ItemService. This block type is
   * definitely of Type.EMPTY
   * 
   * @param type - the type of the block. This type must be TYPE.EMPTY
   * @param item - the item the block contains
   */
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
