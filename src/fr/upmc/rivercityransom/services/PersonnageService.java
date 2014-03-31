package fr.upmc.rivercityransom.services;

import fr.upmc.rivercityransom.utils.Carriable;

/**
 * Interface describing the observators, constructors and operations of a character
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public interface PersonnageService extends Carriable {

  /* Observators */

  /** Returns the name of the character */
  public String getName();

  /**
   * Returns the length of the character
   */
  public int getLength();

  /**
   * Returns the height of the character
   */
  public int getHeight();

  /**
   * Returns the width of the character
   */
  public int getWidth();

  /**
   * Returns the force of the character
   */
  public int getForce();

  /**
   * Returns the health points of the character
   */
  public int getHealthPoints();

  /**
   * Returns the money of the character
   */
  public int getMoneyBalance();

  /**
   * Returns <b>true</b> if the character's health points is less than 0, <b>false</b> otherwise
   */
  public boolean isDefeated();

  /**
   * Returns <b>true</b> if the character is equipped with an item, <b>false</b> otherwise
   */
  public boolean isEquipped();

  /**
   * Returns the Carriable (ItemService or PersonnageService) equipped by the character
   */
  // \pre: isEquipped()
  public Carriable itemEquipped();

  /**
   * Returns the x coordinate of the character's position
   */
  public int positionX();

  /**
   * Returns the y coordinate of the character's position
   */
  public int positionY();

  /**
   * Returns the z coordinate of the character's position
   */
  public int positionZ();

  /**
   * Initializes the default values for the character. It would be preferable not to call this
   * method directly but to use the default constructor <b>Personnage()</b>.Or use
   * PersonnageContract()
   */
  /* Constructors */
  // \pre: name != ""
  // \pre: length > 0
  // \pre: height > 0
  // \pre: width > 0
  // \pre: force > 0
  // \pre: force < health_points
  // \post: positionX() = 0
  // \post: positionY() = 0
  // \post: positionZ() = 0
  // \post: getLength() == length
  // \post: getHeight() == height
  // \post: getWidth() == width
  // \post: force() == getForce
  // \post: geHealthPoints() == health_points
  // \post: getMoneyBalance() == 0
  // \post: isDefeated() == false
  // \post: isEquipped() == false
  // \post: isSellable() == false
  // \post: isReusable() == false
  public void init(String name, int length, int height, int width, int force, int health_points);

  /* Invariants */
  // isDefeated() = (healthPoints() > 0)

  /* Operators */

  /**
   * Increases the health points of the character by hp
   * 
   * @param hp - the amount the health points is increased by
   */
  // \pre: hp > 0
  // \pre: isDefeated() == false
  // \post: geHealthPoints() == getHealthPoints()@pre + hp
  // \post: getMoneyBalance()@pre == getMoneyBalance()
  // \post: itemEquipped()@pre == itemEquipped()
  // \post: getForce()@pre == getForce()
  public void gainHealthPoints(int hp);

  /**
   * Decreases the health points of the character by hp
   * 
   * @param hp - the amount the health points is decreased by
   */
  // \pre: hp > 0
  // \pre: isDefeated() == false
  // \post: getHealthPoints() == getHealthPoints()@pre - hp
  // \post: getMoneyBalance()@pre == getMoneyBalance()
  // \post: itemEquipped()@pre == itemEquipped()
  // \post: getForce()@pre == getForce() -- to be reconsidered (is the force the same if it loses
  // the item it equipped)
  public void loseHealthPoints(int hp);

  /**
   * Increases the character's money
   * 
   * @param amount - the amount the character's money is increased by
   */
  // \pre: amount > 0
  // \post: positionX()@pre = 0
  // \post: positionY()@pre = 0
  // \post: positionZ()@pre = 0
  // \post: getMoneyBalance() == getMoneyBalance()@pre + amount
  // \post: geHealthPoints() == getHealthPoints()@pre
  // \post: itemEquipped()@pre == itemEquipped()
  // \post: getForce()@pre == getForce()
  public void depositMoney(int amount);

  /**
   * Decreases the character's money
   * 
   * @param amount - the amount the character's money is decreased by
   */
  // \pre: amount > 0
  // \pre: amount < getMoneyBalance()
  // \post: positionX()@pre = 0
  // \post: positionY()@pre = 0
  // \post: positionZ()@pre = 0
  // \post: getMoneyBalance() = getMoneyBalance()@pre - amount
  // \post: geHealthPoints() == getHealthPoints()@pre
  // \post: itemEquipped()@pre == itemEquipped()
  // \post: getForce()@pre == getForce()
  public void withdrawMoney(int amount);

  /**
   * Picks up an item and updates the force or the money balance of the character depending on the
   * item's type
   * 
   * @param item - the item picked up the character
   */
  // \pre: isEquipped() == false
  // \post: isEquiped() == true
  // \post: itemEquipped() == item
  // \post: if Carriable::isReusable(item) then
  // \post: if Carriable::isReusable(item) then getForce() == getForce()@pre +
  // Carriable::value(item)
  // \post: if Carriable::isSellable(item) then getMoneyBalance() == getMoneyBalance()@pre +
  // Item::value(item)
  public void pickUpItem(Carriable item);

  /**
   * Throws an item and updates the force of the character
   * 
   * @param item - the item thrown by the character
   */
  // \pre: isEquipped()
  // \post: isEquipped() = false
  // \post: if Carriable::isReusable(item) then force() == force() - Carriable::value(item)
  // \post: getMoneyBalance() = getMoneyBalance()@pre
  public void throwItem();

  /**
   * Handles the movement of the character. Updates the x, y, and z coordinates of the character.
   * 
   * @param x - distance moved in the x-coordinate
   * @param y - distance moved in the y-coordinate (jumping)
   * @param z - distance moved in the z-coordinate
   */
  // \post: positionX() = positionX()@pre + x
  // \post: positionY() = positionX()@pre + y
  // \post: positionZ() = positionX()@pre + z
  // \post: getMoneyBalance() = getMoneyBalance()@pre
  // \post: geHealthPoints() == getHealthPoints()@pre
  // \post: itemEquipped() == itemEquipped()@pre
  // \post: getForce() == getForce()@pre
  public void move(int x, int y, int z);

}
