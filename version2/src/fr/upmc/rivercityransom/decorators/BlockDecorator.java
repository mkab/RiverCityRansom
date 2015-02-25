package fr.upmc.rivercityransom.decorators;

import fr.upmc.rivercityransom.services.BlockService;
import fr.upmc.rivercityransom.services.ItemService;
import fr.upmc.rivercityransom.utils.Type;

/**
 * The decorator class for BlockService
 * 
 * @author Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public class BlockDecorator implements BlockService {

  private final BlockService delegate;

  /**
   * Default constructor for BlockDecorator
   * 
   * @param delegate - a BlockService
   */
  public BlockDecorator(BlockService delegate) {
    this.delegate = delegate;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Type getType() {
    return delegate.getType();
  }

  /**
   * Returns the length of the block
   */
  @Override
  public int getLength() {
    return delegate.getLength();
  }

  /**
   * Returns the breadth of the block
   */
  @Override
  public int getBreadth() {
    return delegate.getBreadth();
  }

  /**
   * Returns the height of the block
   */
  @Override
  public int getHeight() {
    return delegate.getHeight();
  }

  /**
   * Returns <b>true</b> if the block contains a treasure, <b>false</b> otherwise
   */
  @Override
  public boolean hasTreasure() {
    return delegate.hasTreasure();
  }

  /**
   * Returns the Item the block contains
   */
  @Override
  public ItemService getItem() {
    return delegate.getItem();
  }

  /**
   * Initializes a block with its dimensions and an enum TYPE. This block contains no Item
   * 
   * @param type - an enum TYPE to describe the type of the block
   */
  @Override
  public void init(int length, int breadth, int height, Type type) {
    delegate.init(length, breadth, height, type);
  }

  /**
   * Initializes a block with its dimensions, an enum TYPE and an ItemService. This block type is
   * definitely Type.EMPTY
   * 
   * @param type - the type of the block. This type must be TYPE.EMPTY
   * @param item - the item the block contains
   */
  @Override
  public void init(int length, int breadth, int height, Type type, ItemService item) {
    delegate.init(length, breadth, height, type, item);
  }

}
