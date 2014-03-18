package fr.upmc.rivercityransom.services;

/**
 * Interface describing the observators, constructors and operations of a character
 * 
 * @author mkab
 * @version 1.0
 */
public interface PersonnageService {

  /* Observators */

  public String name();

  public int length();

  public int height();

  public int width();

  public int force();

  public int healthPoints();

  public int money();

  public boolean isDefeated();

  public boolean isEquipped();

  // \pre: isEquipped()
  public ItemService itemEquipped();

  /* Constructors */
  // \pre: (nom != "") && (length > 0) && (height > 0) && (width > 0) && (0 < force < health_points)
  /**
   * pre: nom != "" pre: length > 0 pre: height > 0 pre: width > 0 pre: force > 0 pre: force <
   * health_points post: length() = length post: height() = height post: width() = width post:
   * force() = force post: healthPoints() = health_points post: money() = 0 post: isDefeated() =
   * false post: isEquipped() = false
   * 
   */
  public void init(String name, int length, int height, int width, int force, int health_points);

  /* Invariants */
  // isDefeated() = (healthPoints() > 0)

  /* Operators */

  // \pre: hp > 0
  // \post: healthPoints() = healthPoints()@pre + hp
  public void gainHealthPoints(int hp);

  // \pre: hp > 0
  // \post: healthPoints() = healthPoints()@pre - hp
  public void loseHealthPoints(int hp);

  // \pre: amount > 0
  // \post: money() = money()@pre + amount
  public void depositMoney(int amount);

  // \pre: amount > 0
  // \post: money() = money()@pre - amount
  public void withdrawMoney(int amount);

  // \pre: isEquipped() = false
  // \post: isEquiped() = true
  // \post: itemEquipped() = item
  // \post: if Item::isReusable(item) then
  // force() = force() + Item::value(item)
  // \post: if Item::isSellable(item) then
  // money() = money() + Item::value(item)
  public void pickUpItem(ItemService item);

  // \pre: isEquipped()
  // \post: isEquipped() = false
  // \post: if Item::isReusable(item) then force() = force() - Item::value(item)
  // \post: money() = money() - no change in money
  public void throwItem();

}
