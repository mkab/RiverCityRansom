package fr.upmc.rivercityransom.test;

import fr.upmc.rivercityransom.contracts.PersonnageContract;
import fr.upmc.rivercityransom.impl.PersonnageImpl;
import fr.upmc.rivercityransom.services.PersonnageService;

public class PersonnageTest {

  public static void main(String[] args) {

    // initialization
    PersonnageService personnage = new PersonnageImpl();

    // decoration
    PersonnageContract contract = new PersonnageContract(personnage);

    // initialization du test
    int amount1 = 100, amount2 = 50;
    int hp1 = 10, hp2 = 50;

    contract.init("Ryan", 11, 155, 5, 100, 1000);

    contract.checkInvariant();

    contract.depositMoney(amount1);
    contract.withdrawMoney(amount2);

    contract.gainHealthPoints(hp1);
    contract.loseHealthPoints(hp2);

    contract.checkInvariant();

    System.out.println("characters money = " + personnage.getMoneyBalance());
  }
}