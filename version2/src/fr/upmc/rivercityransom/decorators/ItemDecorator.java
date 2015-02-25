package fr.upmc.rivercityransom.decorators;

import fr.upmc.rivercityransom.services.ItemService;
import fr.upmc.rivercityransom.utils.Treasure;

/**
 * The decorator class for ItemService
 * 
 * @author Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public class ItemDecorator implements ItemService {

  private ItemService delegate;

  /**
   * Default constructor for ItemDecorator
   * 
   * @param delegate - an ItemService
   */
  public ItemDecorator(ItemService delegate) {
    this.delegate = delegate;
  }

  @Override
  public boolean isSellable() {
    return delegate.isSellable();
  }

  @Override
  public boolean isReusable() {
    return delegate.isReusable();
  }

  @Override
  public int value() {
    return delegate.value();
  }

  @Override
  public Treasure name() {
    return delegate.name();
  }

  @Override
  public void init(Treasure name, boolean reusable, boolean sellable, int value) {
    delegate.init(name, reusable, sellable, value);
  }

}
