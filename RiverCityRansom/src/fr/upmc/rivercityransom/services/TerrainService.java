package fr.upmc.rivercityransom.services;

public interface TerrainService {

  public void length();

  public void breadth();

  public void depth();

  // \pre: 1 < length < length()
  // \pre: 1 < breadth < breadth()
  // \pre: 1 < depth < depth()
  public BlockService getBlock(int length, int breadth, int depth);

  /* Invariants */
  // No invariants

  /* Constructors */

  /**
   * pre: length > 1 pre: breadth > 1 pre: depth > 1 post: length() = length post: breadth() =
   * breadth post: depth() = depth post: getBlock(length, breadth, depth) != NULL
   */
  public void init(int length, int breadth, int depth);

}
