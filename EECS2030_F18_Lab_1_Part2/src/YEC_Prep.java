import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;

public class YEC_Prep {

	public static void main(String[] args) throws FileNotFoundException {

		try {
			Scanner in = new Scanner(new File("input.txt"));
			while (in.hasNext()) {
				System.out.println(in.nextLine());
			}

			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");

		}

	}// end main

}// end class
