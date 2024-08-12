import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

      public static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for (int s = i; s <= j; s++) {
            if (isBeautiful(s, k)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isBeautiful(int num, int div) {
        // Calculate the reverse of the number
        int reversedNum = reverse(num);
        // Check if the difference is divisible by div
        return (num - reversedNum) % div == 0;
    }

    private static int reverse(int n) {
        int reversed = 0;
        while (n > 0) {
            int remainder = n % 10;
            reversed = reversed * 10 + remainder;
            n = n / 10;
        }
        return reversed;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
