/*
import java.util.*;

*/
package Senior;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Chase on 2016-02-17.
 */

public class S4B implements Senior.CCCSolution {
	Scanner scanner;
	ArrayList<Integer> riceBallSize;
	int numRiceBalls;

	public void run(Scanner scanner) {
		this.scanner = scanner;
		readInput();
		printSolution();
	}

	@Override
	public void readInput() {
		numRiceBalls = Integer.parseInt(scanner.nextLine());
		riceBallSize = new ArrayList<>(numRiceBalls);

		String line = scanner.nextLine();
		String[] sizes = line.split(" ");

		for (String size : sizes) {
			riceBallSize.add(Integer.valueOf(size));
		}
	}

	@Override
	public void printSolution() {
		int[] size;
		for (int j = 0; j < numRiceBalls * numRiceBalls; j++) {
			size = new int[numRiceBalls];

			for (int i = 0; i < riceBallSize.size() - 1; i++) {
				if (riceBallSize.get(i).equals(riceBallSize.get(i + 1))) {
					size[i] = 2 * riceBallSize.get(i);
				}
				if (i + 2 < riceBallSize.size() && riceBallSize.get(i).equals(riceBallSize.get(i + 2))) {
					size[i] = (2 * riceBallSize.get(i) + riceBallSize.get(i + 1));
				}
			}
			int largest = 0;

			for (int curSize = 0; curSize < numRiceBalls; curSize++) {
				if (size[curSize] > size[largest]) {
					largest = curSize;
				}
			}

			if (riceBallSize.get(largest).equals(riceBallSize.get(largest + 1))) {
				riceBallSize.remove(largest);
				riceBallSize.remove(largest);
				riceBallSize.add(largest, size[largest]);
			} else if (largest + 2 < riceBallSize.size() && riceBallSize.get(largest).equals(riceBallSize.get(largest + 2))) {
				riceBallSize.remove(largest);
				riceBallSize.remove(largest);
				riceBallSize.remove(largest);
				riceBallSize.add(largest, size[largest]);
			}
		}

		int largest = riceBallSize.get(0);
		for (int ballSize : riceBallSize) {
			if (ballSize > largest) {
				largest = ballSize;
			}
		}

		System.out.println(largest);
	}

	void printArray(ArrayList<?> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}
}
