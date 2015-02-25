package fr.upmc.rivercityransom.impl;

import fr.upmc.rivercityransom.services.ItemService;
import fr.upmc.rivercityransom.utils.Treasure;

public class Item implements ItemService {

  /** The treasure's or item's name */
  private Treasure name;

  /** The item's value (either force value or money value) */
  private int value;

  /** A boolean to determine if an item is sellable (e.g coins gotten from fallen enemies) */

  /** A boolean to determine if an item is reusable(e.g TRASHCAN, BIKECHAIN...) */
  private boolean sellable;

  private boolean reusable;

  /**
   * Default constructor for Item
   */
  public Item() {
    init(name, reusable, sellable, value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isSellable() {
    return sellable;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isReusable() {
    return reusable;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int value() {
    return value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Treasure name() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void init(Treasure name, boolean reusable, boolean sellable, int value) {
    this.name = name;
    this.reusable = reusable;
    this.sellable = sellable;
    this.value = value;
  }
}
