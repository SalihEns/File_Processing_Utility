/*
 * Assessment: CST8284 Assignment 03 (21W)
 * Modified by Student: Salih Ensarioglu
 * Lab Section:311
 * Lab Professor: Leanne Seaward
 */
package com.algonquincollege.cst8284.assignment3;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class CharacterRecordUtility {
	/*
	 * Stores column names as String
	 */
	private String columnNames = ("name , heatlh, stregnh, attackDamage, attackChance1, attackChance2, attackType1, attackType2, defense\n");
	/**
	 * Used in sortByname()
	 * 
	 * @see #sortByname()
	 */
	Comparator<CharacterRecord> nameComparator = new NameCompator();
	/**
	 * Used in sortByattackChance1()
	 * 
	 * @see #sortByattackChance1()
	 */
	Comparator<CharacterRecord> attackChance1 = new AttackChance1Comparator();

	/**
	 * Used internally to organize the references-to-CharacterRecord objects in a
	 * linear manner.
	 */
	private List<CharacterRecord> records = new ArrayList<CharacterRecord>();

	/**
	 * This is the core logic of the Character record. It loads the file then calls
	 * sortName method then save file as SortbyName.csv. Then sort attackChance1 by
	 * saving the file as SortedByAttackChance1.csv finally writes the data to the
	 * csv file and finishes. Try and multiple catch block applied.
	 */
	public void processFile() {

		try {
			System.out.println("Attempting to open CharacterRecordsUnsorted.csv ...");
			loadFile();

			System.out.println("Sorting by name ...");
			sortName();

			System.out.println("Saving to SortedByName.csv ...");
			System.out.println("(Will overwrite any file with same name)");
			saveFile("SortedByName.csv");

			System.out.println("Sorting by attackChance1 ...");
			sortAttackChance1();

			System.out.println("Saving to SortedByAttackChance1.csv ...");
			System.out.println("(Will overwrite any file with same name)");
			saveFile("SortedByAttackChance1.csv");

			System.out.println("Character Data Sorted and Saved.");
			System.out.println("Program by Salih Ensarioglu");
		} catch (IllegalArgumentException | NoSuchElementException | IllegalStateException | SecurityException
				| IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Loads records from a file with relative path from where the program started
	 * from, and file name "CharacterRecordsUnsorted.csv" to create a new list.
	 * skips the first row and sets datas to the array of record and assign newlist
	 * to the records variable
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws IllegalArgumentException
	 * @throws NoSuchElementException
	 * @throws IllegalStateException
	 */
	private void loadFile() throws IOException, NumberFormatException, IllegalArgumentException, NoSuchElementException,
			IllegalStateException {

		List<CharacterRecord> newList = new ArrayList<CharacterRecord>();
		int count = 0;
		Scanner input = new Scanner(Paths.get("CharacterRecordsUnsorted.csv"));
		input.nextLine();
		newList.clear();
		while (input.hasNextLine()) {
			count++; // count the records
			String[] data = input.nextLine().split(","); // parse

			CharacterRecord record = new CharacterRecord(); // instantiate
			record.setName(data[0]);
			record.setHealth(data[1]);
			record.setStrength(data[2]);
			record.setAttackDamage(data[3]);
			record.setAttackChance1(Integer.parseInt(data[4]));
			record.setAttackChance2(Integer.parseInt(data[5]));
			record.setAttackType1(data[6]);
			record.setAttackType2(data[7]);
			record.setDefense(data[8]);
			newList.add(record);
		}
		records = newList;
	}

	/**
	 * Sorts the list by name of the referenced CharacterRecord objects and writes a
	 * message to the console to warn the user that indexes previously printed for
	 * records will have changed. If the list is empty outputs a message to the
	 * console that sorting cannot be performed.
	 * 
	 * @see NameComparator
	 */
	private void sortName() {
		if (!records.isEmpty()) {

			Collections.sort(records, nameComparator);
			System.out.println("Names sorted, caution indexes have changed");
		} else {
			System.out.println("Names list is empty, nothing to sort");
		}
	}

	/**
	 * Sorts the list by AttackChance1 of the referenced CharacterRecord objects and
	 * writes a message to the console to warn the user that indexes previously
	 * printed for records will have changed. If the list is empty outputs a message
	 * to the console that sorting cannot be performed.
	 * 
	 * @see AttackChance1Comparator
	 */
	private void sortAttackChance1() {
		if (!records.isEmpty()) {
			Collections.sort(records, attackChance1);
			System.out.println("attackChance1 sorted, caution indexes have changed");
		} else {
			System.out.println("attackChance1 list is empty, nothing to sort");
		}
	}

	/*
	 * create a FileWriter object and append the column names as firtst row then
	 * append the data by using for loop and calls flush method and finally closes
	 * from OS
	 */
	private void saveFile(String fileName)
			throws FileNotFoundException, SecurityException, IOException, FormatterClosedException {
		
		try (FileWriter output = new FileWriter(fileName, false)) {
			output.append(columnNames);
			for (CharacterRecord record : records) {
				output.append(record.toString() + "\n");
			}
			
			output.flush();
			output.close();

		}

	}
}
