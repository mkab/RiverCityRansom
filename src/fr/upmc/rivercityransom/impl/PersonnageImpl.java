package fr.upmc.rivercityransom.impl;

import fr.upmc.rivercityransom.services.ItemService;
import fr.upmc.rivercityransom.services.PersonnageService;

/**
 * This class implements to functionalities of PersonnageService
 * 
 * @author Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public class PersonnageImpl implements PersonnageService {

  /** The character's name: Ryan, Alex, Slick, Gangster name and perhaps Cindy */
  private String name;

  /** The character's length */
  private int length;

  /** The character's height */
  private int height;

  /**
   * The character's width - profondeur in french. It's either the position of the character in the
   * depth of the field or the size of the character. To be determined.
   */
  private int width;

  /** The character's force/strength */
  private int force;

  /** The character's health points(life/hp) */
  private int health_points;

  /**
   * The amount of money owned by the character. This increases as the character collects coins from
   * fallen gangsters and decreases as the character spends this money in the market to buy goodies,
   * power-ups etc.
   */
  private int moneyBalance;

  /** A boolean to determine if the character is equipped with an Item */
  private boolean isEquipped;

  /**
   * A boolean to determine if the character is defeated;
   */
  private boolean isDefeated;

  /** The item picked up by the character */
  private ItemService item;

  /**
   * Default constructor for PersonnageImpl
   */
  public PersonnageImpl() {
    init(name, length, height, width, force, health_points);
  }

  /**
   * Get the name of the character
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Get the length of the character
   */
  @Override
  public int getLength() {
    return length;
  }

  /**
   * Get the height of the character
   */
  @Override
  public int getHeight() {
    return height;
  }

  /**
   * Get the width of the character
   */
  @Override
  public int getWidth() {
    return width;
  }

  /**
   * Get the force of the character
   */
  @Override
  public int getForce() {
    return force;
  }

  /**
   * Get the health points of the character
   */
  @Override
  public int getHealthPoints() {
    return health_points;
  }

  /**
   * Get the money of the character
   */
  @Override
  public int getMoneyBalance() {
    return moneyBalance;
  }

  /**
   * Returns <b>true</b> if the character's health points is less than 0, <b>false</b> otherwise
   */
  @Override
  public boolean isDefeated() {
    return isDefeated;
  }

  /**
   * Returns <b>true</b> if the character is equipped with an item, <b>false</b> otherwise
   */
  @Override
  public boolean isEquipped() {
    return isEquipped;
  }

  /**
   * Returns the item equipped by the character
   */
  @Override
  public ItemService itemEquipped() {
    return item;
  }

  /**
   * Initializes the default values for the character. It would be preferable not to call this
   * method directly but to use the default constructor <b>PersonnageImpl()</b>.Or use
   * PersonnageContract()
   */
  @Override
  public void init(String name, int length, int height, int width, int force, int health_points) {
    this.name = name;
    this.length = length;
    this.height = height;
    this.width = width;
    this.force = force;
    this.health_points = health_points;
    moneyBalance = 0;
    isDefeated = false;
    isEquipped = false;
    item = null;
  }

  /**
   * Increases the health points of the character by hp
   * 
   * @param hp - the amount the health points is increased by
   */
  @Override
  public void gainHealthPoints(int hp) {
    health_points += hp;
  }

  /**
   * Decreases the health points of the character by hp
   * 
   * @param hp - the amount the health points is decreased by
   */
  @Override
  public void loseHealthPoints(int hp) {
    health_points -= hp;
    if (health_points <= 0)
      isDefeated = true;
  }

  /**
   * Increases the character's money
   * 
   * @param amount - the amount the character's money is increased by
   */
  @Override
  public void depositMoney(int amount) {
    moneyBalance += amount;
  }

  /**
   * Decreases the character's money
   * 
   * @param amount - the amount the character's money is decreased by
   */
  @Override
  public void withdrawMoney(int amount) {
    moneyBalance -= amount;
  }

  /**
   * Picks up an item and updates the force or the money balance of the character depending on the
   * item's type
   * 
   * @param item - the item picked up the character
   */
  @Override
  public void pickUpItem(ItemService item) {
    this.item = item;

    // update character's attributes (force and money balance)
    if (item.isSellable())
      moneyBalance += item.value();
    if (item.isReusable())
      force += item.value();

    // Set is equipped to true
    isEquipped = true;
  }

  /**
   * Throws an item and updates the force of the character
   * 
   * @param item - the item thrown by the character
   */
  @Override
  public void throwItem() {
    // update character's attributes (force and money balance)

    if (item.isReusable())
      force -= item.value();

    // set item to null
    item = null;

    // set isEquipped to false
    isEquipped = false;
  }
}
