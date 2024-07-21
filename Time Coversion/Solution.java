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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
          // Extract parts from the input string
        int hh = Integer.parseInt(s.substring(0, 2));
        String mmss = s.substring(2, 8);
        String period = s.substring(8, 10);
        
        // Logic to convert 12-hour format to 24-hour format
        if (period.equals("AM")) {
            if (hh == 12) {
                hh = 0;
            }
        } else {
            if (hh != 12) {
                hh = hh + 12;
            }
        }
        
        // Format the hour part to always have two digits
        String hourFormatted = String.format("%02d", hh);
        
        // Construct the result string in 24-hour format
        String result = hourFormatted + mmss;
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
