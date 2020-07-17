package at.general;

import java.math.BigDecimal;

/**
 * Write to output formatted
 */
public class WriteConsole
{
    public static void writeConsole(String expectedValue, String output, String testValues,
        boolean isSuccess, Long timeElapsed)
    {
        String actualColor = (isSuccess) ? ConsoleColor.CYAN : ConsoleColor.RED;

        System.out.println(
            actualColor +
            String.format("Result: %s; Expected output: %s; Output: %s; Test data set: [%s]; Run time: %sms",
                (isSuccess)?"SUCCESS":"FAILED ", expectedValue, output, testValues,
                new BigDecimal(timeElapsed).divide(new BigDecimal(1000*1000), 4, 2) ) +
            ConsoleColor.RESET);
    }

    public static void writeConsoleTitle(String title)
    {
        System.out.println(ConsoleColor.BLUE_BACKGROUND + ConsoleColor.WHITE_BRIGHT + "*** " + title + " ***"
            + ConsoleColor.RESET);
    }

}
