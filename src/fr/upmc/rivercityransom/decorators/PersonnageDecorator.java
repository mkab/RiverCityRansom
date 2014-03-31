package fr.upmc.rivercityransom.decorators;

import fr.upmc.rivercityransom.services.PersonnageService;
import fr.upmc.rivercityransom.utils.Carriable;

/**
 * The decorator class for PersonnageService
 * 
 * @author Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public class PersonnageDecorator implements PersonnageService {

  private final PersonnageService delegate;

  /**
   * Default constructor for PersonnageDecorator
   * 
   * @param delegate - a PersonnageService
   */
  public PersonnageDecorator(PersonnageService delegate) {
    this.delegate = delegate;
  }

  @Override
  public String getName() {
    return delegate.getName();
  }

  @Override
  public int getLength() {
    return delegate.getLength();
  }

  @Override
  public int getHeight() {
    return delegate.getHeight();
  }

  @Override
  public int getWidth() {
    return delegate.getWidth();
  }

  @Override
  public int getForce() {
    return delegate.getForce();
  }

  @Override
  public int getHealthPoints() {
    return delegate.getHealthPoints();
  }

  @Override
  public int getMoneyBalance() {
    return delegate.getMoneyBalance();
  }

  public boolean isDefeated() {
    return delegate.isDefeated();
  }

  @Override
  public boolean isEquipped() {
    return delegate.isEquipped();
  }

  @Override
  public Carriable itemEquipped() {
    return delegate.itemEquipped();
  }

  @Override
  public int positionX() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int positionY() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int positionZ() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void init(String name, int length, int height, int width, int force, int health_points) {
    delegate.init(name, length, height, width, force, health_points);
  }

  @Override
  public void gainHealthPoints(int hp) {
    delegate.gainHealthPoints(hp);
  }

  @Override
  public void loseHealthPoints(int hp) {
    delegate.loseHealthPoints(hp);
  }

  @Override
  public void depositMoney(int amount) {
    delegate.depositMoney(amount);
  }

  @Override
  public void withdrawMoney(int amount) {
    delegate.withdrawMoney(amount);
  }

  @Override
  public void pickUpItem(Carriable item) {
    delegate.pickUpItem(item);
  }

  @Override
  public void throwItem() {
    delegate.throwItem();
  }

  @Override
  public void move(int x, int y, int z) {
    delegate.move(x, y, z);
  }

  @Override
  public boolean isSellable() {
    return delegate.isSellable();
  }

  @Override
  public boolean isReusable() {
    return delegate.isReusable();
  }

  @Override
  public int value() {
    return delegate.value();
  }

}
