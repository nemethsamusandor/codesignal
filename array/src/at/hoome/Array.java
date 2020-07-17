package at.hoome;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
}
