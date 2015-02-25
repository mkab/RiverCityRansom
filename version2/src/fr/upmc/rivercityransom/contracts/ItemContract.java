package fr.upmc.rivercityransom.contracts;

import fr.upmc.rivercityransom.decorators.ItemDecorator;
import fr.upmc.rivercityransom.errors.PreconditionError;
import fr.upmc.rivercityransom.services.ItemService;
import fr.upmc.rivercityransom.utils.Treasure;

public class ItemContract extends ItemDecorator {

  public ItemContract(ItemService delegate) {
    super(delegate);
  }

  public void checkInvariant() {

  }

  @Override
  public void init(Treasure name, boolean reusable, boolean sellable, int value) {
    // \name() != "" (&& name is instanceOf Treasure)
    if (!(name instanceof Treasure)) {
      throw new PreconditionError("name is not an instance of enum Treasure");
    }

    // \pre: reusable != sellable
    if (reusable == sellable) {
      throw new PreconditionError("boolean values for reusable and sellable must be different");
    }

    // \pre: value > 0
    if (!(value > 0)) {
      throw new PreconditionError("value must be positive");
    }

    super.init(name, reusable, sellable, value);

    // \post: name() = treasure
    if (!(name() == name)) {
      throw new PreconditionError("item's name is incorrectly initialized");
    }

    // \post: isReusable() = reusable
    if (!(isReusable() == reusable)) {
      throw new PreconditionError("isReusable is incorrectly initialized");
    }

    // \post: isSellable() = sellable
    if (!(isSellable() == sellable)) {
      throw new PreconditionError("isSellable is incorrectly initialized");
    }

    // \post: value() = value
    if (!(value() == value)) {
      throw new PreconditionError("item's value is incorrectly initialized");
    }

  }

}
