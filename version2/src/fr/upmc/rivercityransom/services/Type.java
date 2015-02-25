package fr.upmc.rivercityransom.services;

/**
 * This enum contains the possible type of blocks in the game: either EMPTY that contains no items
 * or PIT which when fallen into kills a character (PersonnageService)
 * 
 * @authors Mohammad Kabir Abdulsalam, Pape Malal Diagne
 * @version 1.0
 */
public enum Type {
  EMPTY, // empty block - a block that contains no items
  PIT // pit - this block is a pit and falling inside costs the life of the characte
}
