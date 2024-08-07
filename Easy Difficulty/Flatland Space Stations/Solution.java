import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
           int m = c.length;
    if (n == m) {
        return 0; // All cities have a space station
    }
    
    // Sort the space stations array
    Arrays.sort(c);

    // Initialize the maximum distance to the maximum of the distances
    int maxDistance = 0;

    // Calculate distance from the first city to the first space station
    maxDistance = c[0] - 0;

    // Calculate the maximum distance between consecutive space stations
    for (int i = 1; i < m; i++) {
        int distanceBetweenStations = (c[i] - c[i - 1]) / 2;
        if (distanceBetweenStations > maxDistance) {
            maxDistance = distanceBetweenStations;
        }
    }

    // Calculate distance from the last space station to the last city
    int distanceToLastCity = (n - 1) - c[m - 1];
    if (distanceToLastCity > maxDistance) {
        maxDistance = distanceToLastCity;
    }

    return maxDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

