package fr.upmc.rivercityransom.services;

/**
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public interface TerrainService {

  public void getLength();

  public void getBreadth();

  public void getDepth();

  // \pre: 1 < length < getLength()
  // \pre: 1 < breadth < getBreadth()
  // \pre: 1 < depth < getDepth()
  public BlockService getBlock(int length, int breadth, int depth);

  /* Invariants */
  // No invariants

  /* Constructors */

  // \pre: length > 1
  // \pre: breadth > 1
  // \pre: depth > 1
  // \post: getLength() = length
  // \post: getBreadth() = breadth
  // \post: getDepth() = depth
  // \post: getBlock(length, breadth, depth) != NULL
  public void init(int length, int breadth, int depth);

  // \pre: block is not null
  public void editBlock(BlockService block);
}
