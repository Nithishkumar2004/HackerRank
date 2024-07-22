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
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        int r = grid.size();
        int c = grid.get(0).length();

        // If no time has passed, return the initial grid
        if (n == 1) {
            return new ArrayList<>(grid);
        }

        // If time is even, return a full grid of 'O'
        if (n % 2 == 0) {
            return generateFullGrid(r, c);
        }

        // Convert the grid to a 2D char array
        char[][] initialGrid = convertToGrid(grid, r, c);
        char[][] firstDetonation = createGrid(r, c, initialGrid);
        char[][] secondDetonation = createGrid(r, c, firstDetonation);

        // Determine which grid to return based on the number of seconds
        if (n % 4 == 1) {
            return convertToList(secondDetonation);
        } else {
            return convertToList(firstDetonation);
        }
    }

    private static List<String> generateFullGrid(int r, int c) {
        List<String> fullGrid = new ArrayList<>();
        String row = createRepeatedString('O', c);
        for (int i = 0; i < r; i++) {
            fullGrid.add(row);
        }
        return fullGrid;
    }

    private static String createRepeatedString(char ch, int times) {
        StringBuilder sb = new StringBuilder(times);
        for (int i = 0; i < times; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private static char[][] convertToGrid(List<String> grid, int r, int c) {
        char[][] charGrid = new char[r][c];
        for (int i = 0; i < r; i++) {
            charGrid[i] = grid.get(i).toCharArray();
        }
        return charGrid;
    }

    private static List<String> convertToList(char[][] grid) {
        List<String> result = new ArrayList<>();
        for (char[] row : grid) {
            result.add(new String(row));
        }
        return result;
    }

    private static char[][] createGrid(int r, int c, char[][] gridAtPreviousStep) {
        char[][] gridAtNextStep = new char[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(gridAtNextStep[i], 'O');
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (gridAtPreviousStep[i][j] == 'O') {
                    gridAtNextStep[i][j] = '.';
                    if (i - 1 >= 0) gridAtNextStep[i - 1][j] = '.';
                    if (i + 1 < r) gridAtNextStep[i + 1][j] = '.';
                    if (j - 1 >= 0) gridAtNextStep[i][j - 1] = '.';
                    if (j + 1 < c) gridAtNextStep[i][j + 1] = '.';
                }
            }
        }

        return gridAtNextStep;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);
        int c = Integer.parseInt(firstMultipleInput[1]);
        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
