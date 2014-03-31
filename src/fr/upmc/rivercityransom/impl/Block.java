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

public class Block implements BlockService {

  /** The block's length */
  private int length;

  /** The block's breadth */
  private int breadth;

  /** The block's height */
  private int height;

  /** The block type */
  private Type type;

  /** The item the block contains */
  private ItemService item;

  /**
   * Default constructor for PersonnageImpl. Creates block without item.
   */
  public Block() {
    init(length, breadth, height, type);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Type getType() {
    return type;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getLength() {
    return length;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getBreadth() {
    return breadth;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getHeight() {
    return height;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean hasTreasure() {
    return (item != null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ItemService getItem() {
    return item;
  }

  /**
   * {@inheritDoc}
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
   * {@inheritDoc}
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
