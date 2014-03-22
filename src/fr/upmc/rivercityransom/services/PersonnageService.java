package fr.upmc.rivercityransom.services;

/**
 * Interface describing the observators, constructors and operations of a character
 * 
 * @author mkab
 * @version 1.0
 */
public interface PersonnageService {

  /* Observators */

  public String getName();

  public int getLength();

  public int getHeight();

  public int getWidth();

  public int getForce();

  public int getHealthPoints();

  public int getMoneyBalance();

  public boolean isDefeated();

  public boolean isEquipped();

  // \pre: isEquipped()
  public ItemService itemEquipped();

  /* Constructors */
  // \pre: (nom != "") && (length > 0) && (height > 0) && (width > 0) && (0 < force < health_points)
  /**
   * pre: name != "" pre: length > 0 pre: height > 0 pre: width > 0 pre: force > 0 pre: force <
   * health_points post: getLength() = length post: getHeight() = height post: getWidth() = width
   * post: force() = getForce post: geHealthPoints() = health_points post: getMoneyBalance() = 0
   * post: isDefeated() = false post: isEquipped() = false
   * 
   */
  public void init(String name, int length, int height, int width, int force, int health_points);

  /* Invariants */
  // isDefeated() = (healthPoints() > 0)

  /* Operators */

  // \pre: hp > 0
  // \post: geHealthPoints() = getHealthPoints()@pre + hp
  public void gainHealthPoints(int hp);

  // \pre: hp > 0
  // \post: getHealthPoints() = getHealthPoints()@pre - hp
  public void loseHealthPoints(int hp);

  // \pre: amount > 0
  // \post: getMoneyBalance() = getMoneyBalance()@pre + amount
  public void depositMoney(int amount);

  // \pre: amount > 0
  // \pre: amount < getMoneyBalance()
  // \post: moneyBalance() = getMoneyBalance()@pre - amount
  public void withdrawMoney(int amount);

  // \pre: isEquipped() = false
  // \post: isEquiped() = true
  // \post: itemEquipped() = item
  // \post: if Item::isReusable(item) then
  // \post: if Item::isReusable(item) then getForce() = getForce()@pre + Item::value(item)
  // \post: if Item::isSellable(item) then getMoneyBalance() = getMoneyBalance()@pre +
  // Item::value(item)
  public void pickUpItem(ItemService item);

  // \pre: isEquipped()
  // \post: isEquipped() = false
  // \post: if Item::isReusable(item) then force() = force() - Item::value(item)
  // \post: getMoneyBalance() = getMoneyBalance()@pre - no change in moneyBalance
  public void throwItem();

}
