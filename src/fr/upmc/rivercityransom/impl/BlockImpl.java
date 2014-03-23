package fr.upmc.rivercityransom.impl;

import fr.upmc.rivercityransom.services.BlockService;
import fr.upmc.rivercityransom.services.ItemService;
import fr.upmc.rivercityransom.services.Type;

/**
 * This class implements the functionalities of BlockService
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */

public class BlockImpl implements BlockService {

  /** The block's length */
  private int length;

  /** The block's breadth */
  private int breadth;

  /**
   * The block's height
   */
  private int height;

  /** The block type */
  private Type type;

  /** The item the block contains */
  private ItemService item;

  /**
   * Default constructor for PersonnageImpl. Creates block without item.
   */
  public BlockImpl() {
    init(length, breadth, height, type);
  }

  /**
   * Returns the type of the block : EMPTY, PIT
   */
  @Override
  public Type getType() {
    // TODO Auto-generated method stub
    return type;
  }

  /**
   * Returns the length of the block
   */
  @Override
  public int getLength() {
    return length;
  }

  /**
   * Returns the breadth of the block
   */
  @Override
  public int getBreadth() {
    return breadth;
  }

  /**
   * Returns the height of the block
   */
  @Override
  public int getHeight() {
    return height;
  }

  /**
   * Returns <b>true</b> if the block contains a treasure, <b>false</b> otherwise
   */
  @Override
  public boolean hasTreasure() {
    return (item != null);
  }

  /**
   * Returns the Item the block contains
   */
  @Override
  public ItemService getItem() {
    return item;
  }

  /**
   * Initializes a block with its dimensions and an Enum Type. This block contains no Item
   * 
   * @param type - an Enum Type to describe the type of the block
   */
  @Override
  public void init(int length, int breadth, int height, Type type) {
    this.length = length;
    this.breadth = breadth;
    this.height = height;
    this.type = type;
    this.item = null;
  }

  /**
   * Initializes a block with its dimensions, an enum TYPE and an ItemService. This block type is
   * definitely of Type.EMPTY
   * 
   * @param type - the type of the block. This type must be TYPE.EMPTY
   * @param item - the item the block contains
   */
  @Override
  public void init(int length, int breadth, int height, Type type, ItemService item) {
    this.length = length;
    this.breadth = breadth;
    this.height = height;
    this.type = type;
    this.item = item;
  }

}
