package fr.upmc.rivercityransom.test;

import fr.upmc.rivercityransom.contracts.ItemContract;
import fr.upmc.rivercityransom.contracts.PersonnageContract;
import fr.upmc.rivercityransom.impl.Item;
import fr.upmc.rivercityransom.impl.Personnage;
import fr.upmc.rivercityransom.services.PersonnageService;
import fr.upmc.rivercityransom.services.Treasure;

/**
 * Main class to test PersonnageContract
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public class PersonnageTest {

  public static void main(String[] args) {

    // initialization
    PersonnageService personnage = new Personnage();

    // decoration
    PersonnageContract personnageContract = new PersonnageContract(personnage);

    // initialization du test
    int amount1 = 100, amount2 = 50;
    int hp1 = 10, hp2 = 50;

    personnageContract.init("Ryan", 11, 155, 5, 101, 1000);

    personnageContract.checkInvariant();

    personnageContract.depositMoney(amount1);
    personnageContract.withdrawMoney(amount2);

    personnageContract.gainHealthPoints(hp1);
    personnageContract.loseHealthPoints(hp2);

    personnageContract.checkInvariant();

    System.out.println("characters money : " + personnageContract.getMoneyBalance());
    System.out.println("Before Force : " + personnageContract.getForce());

    Item item1 = new Item();
    Item item2 = new Item();
    Item item3 = new Item();

    ItemContract itemContract1 = new ItemContract(item1);
    ItemContract itemContract2 = new ItemContract(item2);
    ItemContract itemContract3 = new ItemContract(item3);

    itemContract1.init(Treasure.METALBIN, true, false, 60);
    itemContract2.init(Treasure.BIKECHAIN, true, false, 30);
    itemContract3.init(Treasure.FIFYCENTS, false, true, 50);

    // personne picks up a reusable item
    personnageContract.pickUpItem(itemContract1);
    System.out.println("After Force : " + personnageContract.getForce()); // Check force

    // personne attempts to pickup another reusable item
    // personnageContract.pickUpItem(itemContract2);

    // personne attempts to pickup a sellable item
    personnageContract.pickUpItem(itemContract3);

  }
}