package fr.upmc.rivercityransom.impl;

import fr.upmc.rivercityransom.services.PersonnageService;
import fr.upmc.rivercityransom.utils.Carriable;

/**
 * This class implements the functionalities of PersonnageService
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public class Personnage implements PersonnageService {

  /** The character's name: Ryan, Alex, Slick, Gangster name and perhaps Cindy */
  private String name;

  /** The character's length */
  private int length;

  /** The character's height */
  private int height;

  /**
   * The character's width - profondeur in French. It's either the position of the character in the
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
   * A boolean to determine if the character is defeated
   */
  private boolean isDefeated;

  /** The character's x-coordinate */
  private int x;

  /** The character's y-coordinate */
  private int y;

  /** The character's z-coordinate */
  private int z;

  /** The item picked up by the character */
  private Carriable item;

  /**
   * Default constructor for Personnage
   */
  public Personnage() {
    init(name, length, height, width, force, health_points);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getLength() {
    return length;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getHeight() {
    return height;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getWidth() {
    return width;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getForce() {
    return force;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getHealthPoints() {
    return health_points;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getMoneyBalance() {
    return moneyBalance;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isDefeated() {
    return isDefeated;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isEquipped() {
    return isEquipped;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Carriable itemEquipped() {
    return item;
  }

  @Override
  public int positionX() {
    return x;
  }

  @Override
  public int positionY() {
    return y;
  }

  @Override
  public int positionZ() {
    return z;
  }

  /**
   * {@inheritDoc}
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
    x = y = z = 0;
    isDefeated = false;
    isEquipped = false;
    item = null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void gainHealthPoints(int hp) {
    health_points += hp;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void loseHealthPoints(int hp) {
    health_points -= hp;
    if (health_points <= 0)
      isDefeated = true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void depositMoney(int amount) {
    moneyBalance += amount;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void withdrawMoney(int amount) {
    moneyBalance -= amount;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void pickUpItem(Carriable item) {
    this.item = item;

    // update character's attributes (force and money balance)
    if (item.isSellable()) {
      moneyBalance += item.value();
      item = null;
    } else if (item.isReusable()) {
      // System.out.println(item.value());
      force += item.value();
      // System.out.println(getForce());
      // Set is equipped to true
      isEquipped = true;
    }

  }

  /**
   * {@inheritDoc}
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

  /**
   * {@inheritDoc}
   */
  @Override
  public void move(int dx, int dy, int dz) {
    x += dx;
    y += dy;
    z += dz;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isSellable() {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isReusable() {
    return true;
  }

  /**
   * {@inheritDoc}. The value returned here is either the force of the item or the value in terms of
   * money depending on the <b>Carriable</b> equipped by the character
   */
  @Override
  public int value() {
    return getForce();
  }
}
