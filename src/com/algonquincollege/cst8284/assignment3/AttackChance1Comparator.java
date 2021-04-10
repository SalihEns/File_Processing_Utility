/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Salih Ensarioglu
 * Lab Section:311
 * Lab Professor: Leanne Seaward
 */
package com.algonquincollege.cst8284.assignment3;

import java.util.Comparator;

/**
 * This class implements Comparator CharacterRecord to provide support for sorting
 * using the Java Collections Framework based on the CharacterRecord class AttackChance1
 * field.
 * @see java.util.Comparator
 */
public class AttackChance1Comparator implements Comparator<CharacterRecord> {
	/**
	 * Compares AttackChance1 of each CharacterRecord object (o1 and o2), result is based
	 * on using String.compareTo(String)
	 * @see java.lang.String#compareTo(String)
	 */
	@Override
	public int compare(CharacterRecord o1, CharacterRecord o2) {
		
		return Integer.compare(o1.getAttackChance1(), o2.getAttackChance1());
	}

}
