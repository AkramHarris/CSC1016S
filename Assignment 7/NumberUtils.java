//HRRAKR001
//25/09/2024
//Akram Harris

public class NumberUtils {
   private NumberUtils() { //NumberUtil empty constructor and its private for security
   }
   public static int[] toArray(int number) { // This method takes a int as an argument and converts it to an array such that each digit is an element
      String digitsString = String.valueOf(number); // First convert number to String
      int[] digits = new int[digitsString.length()]; // Now make an int array with the length of the string
      for (int i=0; i<digits.length;i++) {
         digits[i] = Character.getNumericValue(digitsString.charAt(i)); // Loop through array and take each char, assign it to a position and convert it to an int
      }
      return digits;
      
   }
   public static int countMatches(int numberA, int numberB) { // This method checks how many digits are in common between 2 ints (position matters)
      String numberAString = String.valueOf(numberA); //Converts the ints to strings
      String numberBString = String.valueOf(numberB);
      int count = 0;
      for (int c=0; c<numberBString.length();c++) { // Loops the chars and checks for equality, if true then add 1 to count and return count when done
         if (numberAString.charAt(c)==numberBString.charAt(c)) {
            count ++;
         }
      }
      return count;
   }
   public static int countIntersect(int numberA, int numberB) { // This method checks how many digits are in common between 2 ints (position doesnt matter)
      String numberAString = String.valueOf(numberA); // Same logic as countMatches
      String numberBString = String.valueOf(numberB);
      int count = 0;
       boolean[] countedA = new boolean[numberAString.length()]; // This prevents the double counting of digits
       boolean[] countedB = new boolean[numberBString.length()];
    for (int i = 0; i < numberAString.length(); i++) { // I use 2 loops to compare a single char to all the chars in numberB
        for (int j = 0; j < numberBString.length(); j++) {
            if (numberAString.charAt(i) == numberBString.charAt(j) && !countedA[i] && !countedB[j]) {
                count++;
                countedA[i] = true;
                countedB[j] = true;
                break;
         }
      }
   }
   return count;

   }
}
   

