package at.hoome;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import at.general.Utils;
import at.general.WriteConsole;

/**
 * Array exercises
 *
 * @author  Sándor Németh
 * @date    17.07.2020
 */
public class Array
{
    public static void main(String[] args)
    {
        testFirstDuplicate();
        testFirstNotRepeatingCharacter();
        testRotateImage();
        testSudoku();
    }

    private static void testFirstDuplicate()
    {
        List<Object[]> testCases = new ArrayList<>();

        testCases.add(new Object[]{3, new int[]{2, 1, 3, 5, 3, 2}});
        testCases.add(new Object[]{2, new int[]{2, 2}});
        testCases.add(new Object[]{-1, new int[]{2, 4, 3, 5, 1}});
        testCases.add(new Object[]{-1, new int[]{1}});
        testCases.add(new Object[]{5, new int[]{5, 5, 5, 5, 5}});
        testCases.add(new Object[]{-1, new int[]{2, 1}});
        testCases.add(new Object[]{-1, new int[]{2, 1, 3}});
        testCases.add(new Object[]{3, new int[]{2, 3, 3}});
        testCases.add(new Object[]{3, new int[]{3, 3, 3}});
        testCases.add(new Object[]{6, new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8}});
        testCases.add(new Object[]{-1, new int[]{10, 6, 8, 4, 9, 1, 7, 2, 5, 3}});

        WriteConsole.writeConsoleTitle("firstDuplicate");

        for (Object[] actualCase : testCases)
        {
            int expectedValue = (int) actualCase[0];
            int [] testValues = (int[]) actualCase[1];

            long start = System.nanoTime();
            int output = firstDuplicate((int[]) actualCase[1]);
            long timeElapsed = System.nanoTime() - start;

            WriteConsole.writeConsole(String.valueOf(expectedValue), String.valueOf(output),
                Arrays.toString(testValues), (expectedValue == output), timeElapsed);
        }
        System.out.println("\n\r");
    }

    private static void testFirstNotRepeatingCharacter()
    {
        List<Object[]> testCases = new ArrayList<>();

        testCases.add(new Object[]{'c', "abacabad"});
        testCases.add(new Object[]{'_', "abacabaabacaba"});
        testCases.add(new Object[]{'z', "z"});
        testCases.add(new Object[]{'c', "bcb"});
        testCases.add(new Object[]{'_', "bcccccccb"});
        testCases.add(new Object[]{'d', "abcdefghijklmnopqrstuvwxyziflskecznslkjfabe"});
        testCases.add(new Object[]{'_', "zzz"});
        testCases.add(new Object[]{'y', "bcccccccccccccyb"});
        testCases.add(new Object[]{'d', "xdnxxlvupzuwgigeqjggosgljuhliybkjpibyatofcjbfxwtalc"});
        testCases.add(new Object[]{'g', "ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"});

        WriteConsole.writeConsoleTitle("firstNotRepeatingCharacter");

        for (Object[] actualCase : testCases)
        {
            char expectedValue = (char) actualCase[0];
            String testValues = (String) actualCase[1];

            long start = System.nanoTime();
            char output = firstNotRepeatingCharacter(testValues);
            long timeElapsed = System.nanoTime() - start;

            WriteConsole.writeConsole(String.valueOf(expectedValue), String.valueOf(output),
                testValues, (expectedValue == output), timeElapsed);
        }
        System.out.println("\n\r");
    }

    private static void testRotateImage()
    {
        List<Object[]> testCases = new ArrayList<>();

        testCases.add(new Object[]{new int[][]{{7,4,1}, {8,5,2}, {9,6,3}}, new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}});
        testCases.add(new Object[]{new int[][]{{1}}, new int[][]{{1}}});
        testCases.add(new Object[]{new int[][]{{6,8,7,6,10},
            {8,9,6,10,9},
            {6,7,3,2,6},
            {8,9,8,9,3},
            {2,9,2,7,7}}, new int[][]{{10,9,6,3,7},
            {6,10,2,9,7},
            {7,6,3,8,2},
            {8,9,7,9,9},
            {6,8,6,8,2}}});


        WriteConsole.writeConsoleTitle("rotateImage");

        for (Object[] actualCase : testCases)
        {
            int[][] expectedValue = (int[][]) actualCase[0];
            int[][] testValues = (int[][]) actualCase[1];

            long start = System.nanoTime();
            int[][] output = rotateImage(testValues);
            long timeElapsed = System.nanoTime() - start;

            WriteConsole.writeConsole(Arrays.deepToString(expectedValue), Arrays.deepToString(output),
                Arrays.deepToString(testValues), Utils.compareArrays(expectedValue, output), timeElapsed);
        }
        System.out.println("\n\r");
    }

    private static void testSudoku()
    {
        List<Object[]> testCases = new ArrayList<>();

        testCases.add(new Object[]{true, new char[][]{{'.','.','.','1','4','.','.','2','.'},
            {'.','.','6','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','1','.','.','.','.','.','.'},
            {'.','6','7','.','.','.','.','.','9'},
            {'.','.','.','.','.','.','8','1','.'},
            {'.','3','.','.','.','.','.','.','6'},
            {'.','.','.','.','.','7','.','.','.'},
            {'.','.','.','5','.','.','.','7','.'}}});

        testCases.add(new Object[]{false, new char[][]{{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
            {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
            {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
            {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
            {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
            {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
            {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
            {'.', '2', '.', '.', '3', '.', '.', '.', '.'}}});

        WriteConsole.writeConsoleTitle("sodoku");

        for (Object[] actualCase : testCases)
        {
            boolean expectedValue = (boolean) actualCase[0];
            char[][] testValues = (char[][]) actualCase[1];

            long start = System.nanoTime();
            boolean output = sudoku2(testValues);
            long timeElapsed = System.nanoTime() - start;

            WriteConsole.writeConsole(String.valueOf(expectedValue), String.valueOf(output),
                Arrays.deepToString(testValues), expectedValue == output, timeElapsed);
        }
        System.out.println("\n\r");
    }



    private static int firstDuplicate(int[] a) {

        Set<Integer> checkList = new HashSet<>();

        List<Integer> duplicates = java.util.Arrays.stream(a)
            .boxed().collect(Collectors.toList()).stream()
            .filter(n -> !checkList.add(n))
            .collect(Collectors.toList());

        if (duplicates.isEmpty())
        {
            return -1;
        }
        else
        {
            return duplicates.get(0);
        }
    }

    private static char firstNotRepeatingCharacter(String s) {
        List<String> availableChars = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));

        for (int i = 0; i < availableChars.size(); i++)
        {
            char currentChar = availableChars.get(i).charAt(0);
            if (s.chars().filter(ch -> ch == currentChar).count() > 1)
            {
                s = s.replace(availableChars.get(i), "");
            }
        }

        if (s.isEmpty())
        {
            return '_';
        }

        return s.split("")[0].charAt(0);
    }

    private static int[][] rotateImage(int[][] a)
    {
        int arrayLength = a.length;
        int[][] result = new int[arrayLength][arrayLength];
        for (int i = arrayLength-1; i >= 0; i--)
        {
            for (int j = 0; j < arrayLength; j++)
            {
                result[j][arrayLength - 1 - i] = a[i][j];
            }
        }
        return result;
    }

    // This is henry11 solution,  but I liked this more, because this is very cleaver and easy
    private static boolean sudoku2(char[][] grid)
    {
        int n = grid.length;

        Set<String> set = new HashSet<>();

        for (int row = 0; row < n ; row++)
        {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in row " + row))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in col " + col))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in square " + row/3 + " " + col/3))
                    return false;
            }
        }

        return true;
    }
}
