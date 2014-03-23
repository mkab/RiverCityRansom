package fr.upmc.rivercityransom.test;

import fr.upmc.rivercityransom.contracts.PersonnageContract;
import fr.upmc.rivercityransom.impl.PersonnageImpl;
import fr.upmc.rivercityransom.services.PersonnageService;

/**
 * Main class to test PersonnageContract
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public class PersonnageTest {

  public static void main(String[] args) {

    // initialization
    PersonnageService personnage = new PersonnageImpl();

    // decoration
    PersonnageContract contract = new PersonnageContract(personnage);

    // initialization du test
    int amount1 = 100, amount2 = 50;
    int hp1 = 10, hp2 = 50;

    contract.init("Ryan", 11, 155, 5, 101, 1000);

    contract.checkInvariant();

    contract.depositMoney(amount1);
    contract.withdrawMoney(amount2);

    contract.gainHealthPoints(hp1);
    contract.loseHealthPoints(hp2);

    contract.checkInvariant();

    System.out.println("characters money = " + contract.getMoneyBalance());
    System.out.println(contract.getHealthPoints());
  }
}