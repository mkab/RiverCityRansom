package fr.upmc.rivercityransom.contracts;

import fr.upmc.rivercityransom.decorators.PersonnageDecorator;
import fr.upmc.rivercityransom.errors.InvariantError;
import fr.upmc.rivercityransom.errors.PostconditionError;
import fr.upmc.rivercityransom.errors.PreconditionError;
import fr.upmc.rivercityransom.services.ItemService;
import fr.upmc.rivercityransom.services.PersonnageService;

/**
 * 
 * @author Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */

public class PersonnageContract extends PersonnageDecorator {

  public PersonnageContract(PersonnageService delegate) {
    super(delegate);
  }

  public void checkInvariant() {
    // inv: isDefeated() = (healthPoint() <= 0)
    if (isDefeated() != (getHealthPoints() <= 0)) {
      throw new InvariantError(
          "The character is not defeated when its health points is less than or equal to 0");
    }
  }

  @Override
  public void init(String name, int length, int height, int width, int force, int health_points) {
    // pre: name != ""
    if (name.equals(""))
      throw new PreconditionError("Character's name is empty");

    // pre: length > 0
    if (!(length > 0))
      throw new PreconditionError("Character's length is not positive");

    // pre: height > 0
    if (!(height > 0))
      throw new PreconditionError("Character's height is not positive");

    // pre: width > 0
    if (!(width > 0))
      throw new PreconditionError("Character's width is not positive");

    // pre: force > 0
    if (!(force > 0))
      throw new PreconditionError("Character's force is not positive");

    // pre: force < health_points
    if (!(force < health_points))
      throw new PreconditionError("Force is greater than health_points");

    // pre: health_points > 0
    if (!(health_points > 0))
      throw new PreconditionError("Character's length is not positive");

    // run
    super.init(name, length, height, width, force, health_points);

    // inv post
    checkInvariant();

    // post: getName() == name
    if (!(getName().equals(name)))
      throw new PostconditionError("Character's name is incorrectly initialized");

    // post: getLength() == length
    if (!(getLength() == length))
      throw new PostconditionError("Character's length is incorrectly initialized");

    // post: getHeight() == height
    if (!(getHeight() == height))
      throw new PostconditionError("Character's height is incorrectly initialized");

    // post: getWidth() == width
    if (!(getWidth() == width))
      throw new PostconditionError("Character's width is incorrectly initialized");

    // post: getForce() == force
    if (!(getForce() == force))
      throw new PostconditionError("Character's force is incorrectly initialized");

    // post: getHealthPoints() = health_points
    if (!(getHealthPoints() == health_points))
      throw new PostconditionError("Character's health points is incorrectly initialized");

    // post: getMoneyBalance() == 0
    if (!(getMoneyBalance() == 0))
      throw new PostconditionError(
          "Character's money balance should be equal to 0 at initialization");

    // post: isDefeated() == false
    if (!(isDefeated() == false))
      throw new PostconditionError(
          "Character cannot be defeated at initialization. Should be set to false");

    // post: isEquipped() == false
    if (!(isEquipped() == false))
      throw new PostconditionError(
          "Character cannot be equipped with an item at initialization. Should be set to false");

  }

  @Override
  public void gainHealthPoints(int hp) {
    // getHealthPoints()@pre
    int health_points = getHealthPoints();

    // pre : hp > 0
    if (!(hp > 0))
      throw new PreconditionError("The hp to add to the character's health points is negative");

    // run
    super.gainHealthPoints(hp);

    // post: getHealthPoints()@pre == getHealthPoints + hp
    if (!(getHealthPoints() == (health_points + hp)))
      throw new PostconditionError(
          "Health points not correctly updated after gaining health points");
  }

  @Override
  public void loseHealthPoints(int hp) {
    // getHealthPoints@pre
    int health_points = getHealthPoints();

    // pre : hp > 0
    if (!(hp > 0))
      throw new PreconditionError(
          "The hp to subtract from the character's health points is negative");

    // run
    super.loseHealthPoints(hp);

    // post: getHealthPoints()@pre == getHealthPoints()@pre - hp
    if (!(getHealthPoints() == (health_points - hp)))
      throw new PostconditionError("Health points not correctly updated after losing health points");
  }

  @Override
  public void depositMoney(int amount) {
    // getMoneyBalance()@pre
    int money = getMoneyBalance();

    // pre: amount > 0
    if (!(amount > 0))
      throw new PreconditionError("At depositMoney() : The amount of money to add must be positive");

    // run
    super.depositMoney(amount);

    // post: getMoneyBalance() == getMoneyBalance()@pre + amount
    if (!(getMoneyBalance() == (money + amount)))
      throw new PostconditionError(
          "At depositMoney(): Character's money balance not correctly updated after deposit");
  }

  @Override
  public void withdrawMoney(int amount) {
    // getMoneyBalance()@pre
    int money = getMoneyBalance();

    // pre: amount > 0
    if (!(amount > 0))
      throw new PreconditionError(
          "At withdrawMoney() : The amount of money to withdraw must be positive");

    // \pre: amount < getMoneyBalance()
    if (!(amount < money))
      throw new PreconditionError(
          "At withdrawMoney() : The amount of money to withdraw must be less than character's current money balance");
    // run
    super.withdrawMoney(amount);

    // post: getMoneyBalance() == getMoneyBalance()@pre - amount
    if (!(getMoneyBalance() == (money - amount)))
      throw new PostconditionError(
          "At withdrawMoney(): Character's money balance not correctly updated after withdrawal");
  }

  @Override
  public void pickUpItem(ItemService item) {
    // pre: isEquipped() == false
    if (isEquipped())
      throw new PreconditionError("Character should not be equipped to pick up an item");

    // run
    super.pickUpItem(item);

    // post: isEquiped() == true
    if (!isEquipped())
      throw new PostconditionError("isEquipped should be true since character has equipped an item");

    // post: itemEquipped() == item
    if (!(itemEquipped().equals(item)))
      throw new PostconditionError(
          "Character's equipped item is different from the item given in parameter");

    // getForce()@pre
    int force = getForce();

    // post: if Item::isReusable(item) then force() == force() + Item::value(item)
    if (item.isReusable()) {
      if (!(getForce() == (force + item.value()))) {
        throw new PostconditionError(
            "Character's force not correctly updated (increased) after picking up a reusable item");
      }
    }

    // getMoneyBalance()@pre
    int money = getMoneyBalance();

    // post: if Item::isSellable(item) then moneyBalance() == moneyBalance() + Item::value(item)
    if (item.isSellable()) {
      if (!(getMoneyBalance() == (money + item.value()))) {
        throw new PostconditionError(
            "Character's money balance not correctly updated (increased) after picking up a sellable item");
      }
    }

  }

  @Override
  public void throwItem() {
    // pre: isEquipped() == true
    if (!isEquipped())
      throw new PreconditionError("Character be equipped to throw an item");

    // run
    super.throwItem();

    // post: isEquiped() == false
    if (!isEquipped())
      throw new PostconditionError(
          "Character should not be equipped after throwing an item. isEquipped should be set to false");

    // post: itemEquipped() == item - TO BE VERIFIED
    if (!(itemEquipped().equals(null)))
      throw new PostconditionError("Character's equipped item after throwing it should be null");

    // getForce()@pre
    int force = getForce();

    // post: if Item::isReusable(item) then getForce() == getForce()@pre - Item::value(item)
    if (!(getForce() == (force + itemEquipped().value()))) {
      throw new PostconditionError(
          "Character's force not correctly updated (decreased) after throwing a reusable item");
    }

    // getMoneyBalance()@pre
    int money = getMoneyBalance();

    // post: getMoneyBalance() == getMoneyBalance()@pre - no change in moneyBalance
    if (!(getMoneyBalance() == money))
      throw new PostconditionError(
          "Character's money balance should not change after throwing a reusable item");

  }

}
