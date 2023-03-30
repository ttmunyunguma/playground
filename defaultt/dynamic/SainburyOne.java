package defaultt.dynamic;

import java.util.Arrays;

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

        int rowPosition = startPosition.charAt(0);
        char columnPosition = startPosition.charAt(1);

        String endPosition = "";
        return endPosition;
    }

    /**
     * 1. From the last digit moving backwards, double every second digit
     * 2. If the doubled number is greater than 9, add it's two digits together
     * 3. Sum all card digits together
     * 4. If the total ends in zero, then the number is a valid credit card
     */
    public static void main(String[] args) {
        new SainburyOne().isValid("4242424242426742");
    }
    public boolean isValid(String cardNumber) {

        char[] cardNumsCharArray = cardNumber.toCharArray();
        System.out.println(Arrays.toString(cardNumsCharArray));

        int[] cardNumIntArray = new int[cardNumsCharArray.length];
        System.out.println(Arrays.toString(cardNumIntArray));

        for (int i = 0; i < cardNumsCharArray.length; i++){
            cardNumIntArray[i] = Integer.parseInt(String.valueOf(cardNumsCharArray[i]));
        }
        System.out.println(Arrays.toString(cardNumIntArray));
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
        System.out.println(Arrays.toString(cardNumIntArray));

        int sum = 0;
        for (int digit : cardNumIntArray) {
            sum = sum + digit;
        }
        System.out.println(sum);
        return sum == 0;
    }
}
