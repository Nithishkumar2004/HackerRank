import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
    // Write your code here

      int[] frequency = new int[6]; // index 0 is unused, types 1-5 use indices 1-5
        
        // Count the frequency of each bird type
        for (int birdType : arr) {
            frequency[birdType]++;
        }
        
        int maxFrequency = -1;
        int birdTypeWithMaxFrequency = -1;

        // Determine the bird type with the maximum frequency
        for (int i = 1; i <= 5; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                birdTypeWithMaxFrequency = i;
            }
        }
        
        return birdTypeWithMaxFrequency;
    
        
    }

    }


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
