package fr.upmc.rivercityransom.decorators;

import fr.upmc.rivercityransom.services.ItemService;
import fr.upmc.rivercityransom.services.PersonnageService;

/**
 * The decorator class for PersonnageService
 * 
 * @author Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public abstract class PersonnageDecorator implements PersonnageService {

  private final PersonnageService delegate;

  /**
   * Default constructor for PersonnageDecorator
   * 
   * @param delegate - a PersonnageService
   */
  public PersonnageDecorator(PersonnageService delegate) {
    this.delegate = delegate;
  }

  /**
   * Get the name of the character
   */
  @Override
  public String getName() {
    return delegate.getName();
  }

  /**
   * Get the length of the character
   */
  @Override
  public int getLength() {
    return delegate.getLength();
  }

  /**
   * Get the height of the character
   */
  @Override
  public int getHeight() {
    return delegate.getHeight();
  }

  /**
   * Get the width of the character
   */
  @Override
  public int getWidth() {
    return delegate.getWidth();
  }

  /**
   * Get the force of the character
   */
  @Override
  public int getForce() {
    return delegate.getForce();
  }

  /**
   * Get the health points of the character
   */
  @Override
  public int getHealthPoints() {
    return delegate.getHealthPoints();
  }

  /**
   * Get the money of the character
   */
  @Override
  public int getMoneyBalance() {
    return delegate.getMoneyBalance();
  }

  /**
   * Returns <b>true</b> if the character's health points is less than 0, <b>false</b> otherwise
   */
  @Override
  public boolean isDefeated() {
    return delegate.isDefeated();
  }

  /**
   * Returns <b>true</b> if the character is equipped with an item, <b>false</b> otherwise
   */
  @Override
  public boolean isEquipped() {
    return delegate.isEquipped();
  }

  /**
   * Returns the item equipped by the character
   */
  @Override
  public ItemService itemEquipped() {
    return delegate.itemEquipped();
  }

  /**
   * Initializes the default values for the character. It would be preferable not to call this
   * method directly but to use the default constructor <b>PersonnageImpl()</b>.Or use
   * PersonnageContract()
   */
  @Override
  public void init(String name, int length, int height, int width, int force, int health_points) {
    delegate.init(name, length, height, width, force, health_points);
  }

  /**
   * Increases the health points of the character by hp
   * 
   * @param hp - the amount the health points is increased by
   */
  @Override
  public void gainHealthPoints(int hp) {
    delegate.gainHealthPoints(hp);
  }

  /**
   * Decreases the health points of the character by hp
   * 
   * @param hp - the amount the health points is decreased by
   */
  @Override
  public void loseHealthPoints(int hp) {
    delegate.loseHealthPoints(hp);
  }

  /**
   * Increases the character's money
   * 
   * @param amount - the amount the character's money is increased by
   */
  @Override
  public void depositMoney(int amount) {
    delegate.depositMoney(amount);
  }

  /**
   * Decreases the character's money
   * 
   * @param amount - the amount the character's money is decreased by
   */
  @Override
  public void withdrawMoney(int amount) {
    delegate.withdrawMoney(amount);
  }

  /**
   * Picks up an item and updates the force or the money balance of the character depending on the
   * item's type
   * 
   * @param item - the item picked up the character
   */
  @Override
  public void pickUpItem(ItemService item) {
    delegate.pickUpItem(item);
  }

  /**
   * Throws an item and updates the force of the character
   * 
   * @param item - the item thrown by the character
   */
  @Override
  public void throwItem() {
    delegate.throwItem();
  }

}
