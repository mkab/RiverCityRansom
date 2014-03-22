package fr.upmc.rivercityransom.decorators;

import fr.upmc.rivercityransom.services.ItemService;
import fr.upmc.rivercityransom.services.PersonnageService;

public abstract class PersonnageDecorator implements PersonnageService {

  private final PersonnageService delegate;

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

  @Override
  public boolean isDefeated() {
    return delegate.isDefeated();
  }

  @Override
  public boolean isEquipped() {
    return delegate.isEquipped();
  }

  @Override
  public ItemService itemEquipped() {
    return delegate.itemEquipped();
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
  public void pickUpItem(ItemService item) {
    delegate.pickUpItem(item);
  }

  @Override
  public void throwItem() {
    delegate.throwItem();
  }

}
