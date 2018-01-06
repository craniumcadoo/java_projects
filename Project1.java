// Much of this class is copied and adjusted from previous PowerPoints

// This imports the StringTokenizer class for use in this class
import java.util.StringTokenizer;

// This creates a new public class called Project1
public class Project1
{
	// This creates a new main method
	public static void main(String[] args)
	{
		// This creates a new TextFileInput using the first command-line argument as the file name
		TextFileInput tfi = new TextFileInput(args[0]);
		// This initializes an arbitrarily large String array to store the dates
		String[] dates = new String[1000];
		// This uses the readLine method from TextFileInput to store the first String in the file, which is null if the file is empty
		String line = tfi.readLine();
		// This creates a new unitialized StringTokenizer
		StringTokenizer st;
		// This sets the initial value for the index of the array to 0
		int index = 0;
		// This creates an uninitialized String to store each day temporarily before testing and either accepting and storing or rejecting and printing them
		String day;
		// This performs the actions within as long as the line does not equal null (file has more lines) and index of the array is less than the length of the arbitraily long String array
		while(line != null && index < dates.length)
		{
			// Each time the loop is performed, this creates a initializes the StringTokenizer with the line from the File and "," as parameters
			st = new StringTokenizer(line, ",");
			// This performs the actions within as long as the StringTokenizer hasMoreTokens in it
			while(st.hasMoreTokens())
			{
				// This temporarily stores the next Token in the StringTokenizer
				day = st.nextToken();
				// This uses the isValidDate method to make sure the Token has 8 digits
				if(isValidDate(day))
				{
					// If isValidDate is true, the day is stored at the index of the array, and the index increases by 1;
					dates[index] = day;
					index++;
				}
				else
				{
					// If isValidDate is false, the day is printed to the console and not stored in the array
					System.out.println(day + " is not a valid date, and was not put in the array.");
				}
			}
			// This gets the next line of the file and stores it
			line = tfi.readLine();
		}
		// If this test is true, it means the exit condition for the while loop was index was not less than the length of the array, which means not all dates were stored in the array
		if(line != null)
		{
			System.out.println("There were more dates than space in the array.");
			System.out.println("The array can only store " + dates.length + " dates.");
			System.exit(1);
		}
		String[] sortedDates = new String[index];
		for(int i = 0; i < index; i++)
		{
			sortedDates[i] = dates[i];
		}
		selectionSort(sortedDates);
		createAndDisplayGUI(dates, sortedDates);
	}
	public static boolean isValidDate(String date)
	{
		if(date.length() != 8) return false;
		for(int i = 0; i < 8; i++)
		{
			if(!Character.isDigit(date.charAt(i))) return false;
		}
		return true;
	}
	private static void selectionSort(String[] array)
	{
		for(int i = 0; i < array.length - 1; i++)
		{
			int indexLowest = i;
			for(int j = i + 1; j < array.length; j++)
			{
				if(array[j].compareTo(array[indexLowest]) < 0)
					indexLowest = j;
			}
			if(!array[indexLowest].equals(array[i]))
			{
				String temp = array[indexLowest];
				array[indexLowest] = array[i];
				array[i] = temp;
			}
		}
	}
	private static void createAndDisplayGUI(String[] array1, String[] array2)
	{
		DateGUI mainGUI = new DateGUI(array1, array2);
	}
}