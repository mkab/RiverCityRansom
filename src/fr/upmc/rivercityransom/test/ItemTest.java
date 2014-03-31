package fr.upmc.rivercityransom.test;

import fr.upmc.rivercityransom.contracts.ItemContract;
import fr.upmc.rivercityransom.impl.Item;
import fr.upmc.rivercityransom.utils.Treasure;

public class ItemTest {

  public static void main(String[] args) {

    Item item = new Item();
    ItemContract contract = new ItemContract(item);

    contract.checkInvariant();
    contract.init(Treasure.METALBIN, false, true, 50);
  }

}
