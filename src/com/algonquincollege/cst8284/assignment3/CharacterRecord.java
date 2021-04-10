/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Salih Ensarioglu
 * Lab Section: 311
 * Lab Professor:Leanne Seaward
 */


package com.algonquincollege.cst8284.assignment3;
/**
 * <p>This class contains the data for a CharacterRecord. The fields have
 * basic data validation in each of the mutator methods (setters).</p>
 * <p>
 * - Every set method validates the data passed into it.<br />
 *   - throws an IllegalArgumentException with a message containing
 *     the field name, and reason for the exception being thrown.<br />
 *   - None of the String fields should be set with text containing a comma
 *     character e.g. ','<br />
 *   - The field named "name" cannot exceed 50 characters in length.
 *     (The other String fields do not have any limits to length.)<br />
 *   - attackChance1, and attackChance2 cannot be negative, cannot exceed
 *     100. Note: The sum of attackChance1 and attackChance2 can exceed 100,
 *     but each separate field cannot.<br />
 */
public class CharacterRecord {
	/** contains the name of the character */
	private String name;
	
	/** contains a description of how health is calculated */
	private String health;
	
	/** contains a description of how strength is calculated */
	private String strength;
	
	/** contains a description of how attack damage is calculated */
	private String attackDamage;
	
	/** contains the percent chance for attack1 to be generated */
	private int attackChance1;
	
	/** contains the percent chance for attack2 to be generated */
	private int attackChance2;
	
	/** contains the name of the type of attack1 */
	private String attackType1;
	
	/** contains the name of the type of attack2 */
	private String attackType2;
	
	/** contains a description of how this character defends from attack */
	private String defense;
	/** Max length permitted for String fields. Value is {@value}. */
	private static final int STRING_MAX_LENGTH = 50;

	
	/**
	 * The no parameter constructor does not set any values.
	 */
	public CharacterRecord() {
		super();
	}
	
	/**
	 * This constructor sets each parameter into the respective field, and can
	 * throw an IllegalArgumentException if any data validation rules are 
	 * broken by the arguments passed.
	 * @param name name of this Character
	 * @param health health of this Character
	 * @param strength strength of this Character
	 * @param attackDamage attackDamage of this Character
	 * @param attackChance1 attackChance1 of this Character
	 * @param attackChance2 attackChance2 of this Character
	 * @param attackType1 attackType1 of this Character
	 * @param attackType2 attackType2 of this Character
	 * @throws java.lang.IllegalArgumentException If any of the arguments
	 *                                            break the validation rules
	 *                                            for the fields of class
	 *                                            Friend.
	 */
	public CharacterRecord(String name, String health, String strength, String attackDamage, int attackChance1, int attackChance2, String attackType1, String attackType2) throws
	IllegalArgumentException{
		setName(name); 
		setHealth(health); 
		setStrength(strength); 
		setAttackDamage(attackDamage); 
		setAttackChance1(attackChance1); 
		setAttackChance2(attackChance2); 
		setAttackType1(attackType1); 
		setAttackType2(attackType2); 
	}
	
	/**
	 * Returns the name field
	 * @return the name field
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name field with the value passed
	 * @param name a reference to a String for name field
	 * @param name can not exceeds 50 characters
	 * @param name cannot contain comma
	 */
	public void setName(String name) {
		name = cleanString(name);
	if(name.length() > STRING_MAX_LENGTH) {
		throw new IllegalArgumentException("name exceeds 50 characters");
	}
	else if(name.contains(",")) {
		throw new IllegalArgumentException("name cannot contain comma");
	}
	this.name = name; 
}


	/**
	 * Returns the health field
	 * @return the health field
	 */
	
	public String getHealth() {
		return health;
	}

	/**
	 * Sets the health field with the value passed
	 * @param name a reference to a String for health field
	 * @param health cannot contain comma
	 */
	public void setHealth(String health) {
		health = cleanString(health);
		if(health.contains(",")) {
			throw new IllegalArgumentException("health cannot contain comma");
		}
		this.health = health; // not reached if exception is thrown
	}

	/**
	 * Returns the strength field
	 * @return   the strength field
	 */
	public String getStrength() {
		return strength;
	}

	/**
	 * Sets the strength field with the value passed
	 * @param name a reference to a String for strength field
	 * @param strength cannot contain comma
	 */
	public void setStrength(String strength) {
		strength = cleanString(strength);
		if(strength.contains(",")) {
			throw new IllegalArgumentException("strength cannot contain comma");
		}
		this.strength = strength; // not reached if exception is thrown
	}

	/**
	 * Returns the attackDamage field
	 * @return the attackDamage field
	 */
	public String getAttackDamage() {
		return attackDamage;
	}

	/**
	 * Sets the attackDamage field with the value passed
	 * @param name a reference to a String for attackDamage field
	 * @param attackDamage cannot contain comma
	 */
	public void setAttackDamage(String attackDamage) {
		attackDamage = cleanString(attackDamage);
		if(attackDamage.contains(",")) {
			throw new IllegalArgumentException("attackDamage cannot contain comma");
		}
		this.attackDamage = attackDamage; // not reached if exception is thrown
	}

	/**
	 * Returns the attackChance1 field
	 * @return the attackChance1 field
	 */
	public int getAttackChance1() {
		return attackChance1;
	}

	/**
	 * Sets the attackChance1 field with the value passed
	 * @param name an integer for attackChance1
	 * @throws java.lang.IllegalArgumentException If the argument is more than 100 and not negative.
	 */
	public void setAttackChance1(int attackChance1) {
		if(attackChance1 < 0) {
			throw new IllegalArgumentException("Distance cannot be negative");
		}
		else if(attackChance1 > 100) {
			throw new IllegalArgumentException("attackChance1 Should be less than 100");
		}
		this.attackChance1 = attackChance1;
	}

	/**
	 * Returns the attackChance2 field
	 * @return the attackChance2 field
	 */
	public int getAttackChance2() {
		return attackChance2;
	}

	/**
	 * Sets the attackChance2 field with the value passed
	 * @param name an integer for attackChance2
	 * @throws java.lang.IllegalArgumentException If the argument is more than 100 and not negative.
	 */
	public void setAttackChance2(int attackChance2) {
		if(attackChance2 < 0) {
			throw new IllegalArgumentException("Distance cannot be negative");
		}
		else if(attackChance2 > 100) {
			throw new IllegalArgumentException("attackChance1 Should be less than 100");
		}
		this.attackChance2 = attackChance2;
	}


	/**
	 * Returns the attackType1 field
	 * @return the attackType1 field
	 */
	public String getAttackType1() {
		return attackType1;
	}

	/**
	 * Sets the attackType1 field with the value passed
	 * @param name a reference to a String for attackType1 field
	 * @param attackType1 cannot contain comma
	 */
	public void setAttackType1(String attackType1) {
		attackType1 = cleanString(attackType1);
		if(attackType1.contains(",")) {
			throw new IllegalArgumentException("attackType1 cannot contain comma");
		}
		this.attackType1 = attackType1; // not reached if exception is thrown
	}

	/**
	 * Returns the attackType2 field
	 * @return the attackType2 field
	 */
	public String getAttackType2() {
		return attackType2;
	}

	/**
	 * Sets the attackType2 field with the value passed
	 * @param name a reference to a String for attackType2 field
	 * @param attackType2 cannot contain comma
	 */
	public void setAttackType2(String attackType2) {
		attackType2 = cleanString(attackType2);
		if(attackType2.contains(",")) {
			throw new IllegalArgumentException("attackType2 cannot contain comma");
		}
		this.attackType2 = attackType2; // not reached if exception is thrown
	}

	/**
	 * Returns the defense field
	 * @return the defense field
	 */
	public String getDefense() {
		return defense;
	}

	/**
	 * Sets the defense field with the value passed
	 * @param name a reference to a String for defense field
	 * @param dfense cannot contain comma
	 */
	public void setDefense(String defense) {
		defense = cleanString(defense);
		if(defense.contains(",")) {
			throw new IllegalArgumentException("defense cannot contain comma");
		}
		this.defense = defense; // not reached if exception is thrown
	}
	
	/**
	 * Returns a comma-separated-value representation of this object as
	 * one line of text. Note that a new-line / line-terminator character
	 * is not added to the end of the String.
	 * @return a comma-separated-value representation of this object as String
	 */
	@Override
	public String toString() {
		String format = "%s,%s,%s,%s,%d,%d,%s,%s,%s";
		return String.format(format,
				getName(), getHealth(), getStrength(), getAttackDamage(),
				getAttackChance1(), getAttackChance2(), getAttackType1(),
				getAttackType2(), getDefense());
		
	}
	
	/**
	 * This is a utility method that detects null values and returns an empty
	 * String instead. Or if the argument passed is a String then String method
	 * trim() is used to return a trimmed String instance.
	 * @param data the String to be cleaned
	 * @return Cleaned String
	 */
	private String cleanString(String data) {
		if(data == null) { // null is converted to empty String ""
			data = "";
		}
		else { // otherwise trim leading and trailing whitespace
			data = data.trim(); 
		}
		return data;
	}
}
