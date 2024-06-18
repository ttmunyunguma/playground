package defaultt.interviews;

/**
 * The chessboard bellow has 64 squares, 8 rows and 8 columns. Each row is labeled from 1 to 8 and each column is labeled
 * from a to h (lowercase). A square is located at the intersection of a row and of a column, like square 2C it's the
 * intersection of the row 2 and column C.
 *
 * Positioning a pawn to a starting square, you need to find out where it will be the end square after moving it R times
 * (rows) vertically to the top and C times (columns) horizontally to the right. If during the moves the pawn reaches the
 * end of the board, it will start again from the opposite direction like in the examples below.
 *
 * INPUT
 * string    StartPosition
 * number    R
 * number    C
 *
 * OUTPUT
 * string    EndPosition
 *
 * EXAMPLE 1
 * Input
 * StartPosition: 2b, R: 3, C: 2
 *
 * Output
 * 5d
 *
 * EXAMPLE 2
 * Input
 * StartPosition: 5h, R: 11, C: 25
 *
 * Output
 * 8a
 */
public class SainburyOne {
    public static String run(String startPosition, int R, int C) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */

        // Parse startPosition to extract row and column
        int startRow = Character.getNumericValue(startPosition.charAt(0));
        char startColChar = startPosition.charAt(1);
        int startCol = startColChar - 'a' + 1;

        // Calculate new row and column with wrapping
        int newRow = (startRow - 1 + R) % 8 + 1;
        int newCol = (startCol - 1 + C) % 8 + 1;

        // Convert new column back to a character
        char newColChar = (char) ('a' + newCol - 1);

        // Form the new position string
        return newRow + String.valueOf(newColChar);
    }

    public static String findEndPosition(String startPosition, int R, int C) {
        // Parse startPosition to extract row and column
        int startRow = Character.getNumericValue(startPosition.charAt(0));
        char startColChar = startPosition.charAt(1);
        int startCol = startColChar - 'a' + 1;

        // Calculate new row and column with wrapping
        int newRow = (startRow - 1 + R) % 8 + 1;
        int newCol = (startCol - 1 + C) % 8 + 1;

        // Convert new column back to a character
        char newColChar = (char) ('a' + newCol - 1);

        // Form the new position string
        return newRow + String.valueOf(newColChar);
    }
//    public static void main(String[] args) {
//        System.out.println(findEndPosition("2b", 3, 2)); // Output: 5d
//        System.out.println(findEndPosition("5h", 11, 25)); // Output: 8a
//    }



    /**
     * 1. From the last digit moving backwards, double every second digit
     * 2. If the doubled number is greater than 9, add it's two digits together
     * 3. Sum all card digits together
     * 4. If the total ends in zero, then the number is a valid credit card
     */
    public static void main(String[] args) {
        System.out.println(new SainburyOne().isValid("4242424242426742"));
    }
    public boolean isValid(String cardNumber) {

        char[] cardNumsCharArray = cardNumber.toCharArray();

        int[] cardNumIntArray = new int[cardNumsCharArray.length];

        for (int i = 0; i < cardNumsCharArray.length; i++){
            cardNumIntArray[i] = Integer.parseInt(String.valueOf(cardNumsCharArray[i]));
        }
        //[4242424242,4,2,6,7,4,2]
        for (int i = cardNumIntArray.length - 1; i >= 0; i = i-3){
            int temp = i * 2;
            if(temp > 9){
                int digit, sum = 0;
                while(temp > 0)
                {
                    digit = temp % 10;
                    sum = sum + digit;
                    temp = temp / 10;
                }
                cardNumIntArray[i] = sum;
            }
            cardNumIntArray[i] = temp;
        }

        int sum = 0;
        for (int digit : cardNumIntArray) {
            sum = sum + digit;
        }
        return sum == 0;
    }
}
