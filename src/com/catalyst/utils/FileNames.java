package com.catalyst.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FileNames {

	public static void main() {
		List<String> list = selectRandomfiles();
		System.out.println(list);
	}

	
	/**
	 * Load file names to be distributed among nodes
	 */
	public static final String[] FILENAMES = { "Adventures of Tintin",
			"Jack and Jill", "Glee", "The Vampire Diarie", "King Arthur",
			"Windows XP", "Harry Potter", "Kung Fu Panda", "Lady Gaga",
			"Twilight", "Windows 8", "Mission Impossible", "Turn Up The Music",
			"Super Mario", "American Pickers", "Microsoft Office 2010",
			"Happy Feet", "Modern Family", "American Idol",
			"Hacking for Dummies" };

	
	/**
	 * Select 3-5 random file names
	 * @return list of random file names between 3 - 5
	 */
	public static final List<String> selectRandomfiles() {

		// get random number files between 3,5 for node
		final int numberOfFilesInNode = randInt(3, 5);

		Set<Integer> rnindexes = getRandomNumberIndexes(numberOfFilesInNode);
		List<Integer> rnindexesList = new ArrayList<Integer>();
		rnindexesList.addAll(rnindexes);
		List<String> randomfiles = new ArrayList<String>();
		for (int i = 0; i < numberOfFilesInNode; i++) {
			randomfiles.add(FILENAMES[rnindexesList.get(i)]);
		}
		return randomfiles;
	}

	/**
	 * select random sample of indexes in range
	 * @param numberOfFilesInNode Number of files to be selected
	 * @return random indexes of file array 
	 */
	private static Set<Integer> getRandomNumberIndexes(int numberOfFilesInNode) {
		Set<Integer> rnindexes = new HashSet<Integer>();
		while (rnindexes.size() != numberOfFilesInNode) {
			rnindexes.add(randInt(0, FILENAMES.length));
		}
		return rnindexes;
	}

	/**
	 * Generate random integer in the given range
	 * @param min minimum value for random number
	 * @param max maximum value for random number
	 * @return random integer between min and max
	 */
	public static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}
