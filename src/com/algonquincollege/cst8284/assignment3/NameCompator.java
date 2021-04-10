/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Salih Ensarioglu
 * Lab Section:311
 * Lab Professor: Leanne Seaward
 */
package com.algonquincollege.cst8284.assignment3;

import java.util.Comparator;

/**
 * This class implements Comparator&lt;Friend&gt; to provide support for sorting
 * using the Java Collections Framework based on the Friend class lastName
 * field.
 * @author salih
 * @see java.util.Comparator
 */
public class NameCompator implements Comparator<CharacterRecord>   {
	/**
	 * Compares Name of each Friend object (o1 and o2), result is based
	 * on using String.compareTo(String)
	 * @see java.lang.String#compareTo(String)
	 */
	@Override
	public int compare(CharacterRecord o1, CharacterRecord o2) {
		
		return o1.getName().compareTo(o2.getName());
	}
}
