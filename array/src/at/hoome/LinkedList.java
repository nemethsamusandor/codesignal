package at.hoome;

import java.util.ArrayList;
import java.util.List;

import at.general.Utils;
import at.general.WriteConsole;
import at.general.interfaces.ListNode;

public class LinkedList
{
    public static void main(String[] args)
    {
        testRemoveKFromList();
    }

    private static void testRemoveKFromList()
    {
        List<Object[]> testCases = new ArrayList<>();

        testCases.add(new Object[]{Utils.buildListNode(new Integer[]{1, 2, 4, 5}),
            new Object[]{Utils.buildListNode(new Integer[]{3, 1, 2, 3, 4, 5}), 3}});
        testCases.add(new Object[]{Utils.buildListNode(new Integer[]{1, 2, 3, 4, 5, 6, 7}),
            new Object[]{Utils.buildListNode(new Integer[]{1, 2, 3, 4, 5, 6, 7}), 10}});
        testCases.add(new Object[]{Utils.buildListNode(new Integer[]{}),
            new Object[]{Utils.buildListNode(new Integer[]{1000, 1000}), 1000}});
        testCases.add(new Object[]{Utils.buildListNode(new Integer[]{}),
            new Object[]{null, -1000}});
        testCases.add(new Object[]{Utils.buildListNode(new Integer[]{123, 456, 789}),
            new Object[]{Utils.buildListNode(new Integer[]{123, 456, 789, 0}), 0}});
        WriteConsole.writeConsoleTitle("removeKFromList");

        for (Object[] actualCase : testCases)
        {
            ListNode<Integer> expectedValue = (ListNode<Integer>) actualCase[0];
            Object[] testValues = (Object[]) actualCase[1];

            ListNode<Integer> testInput = (ListNode<Integer>) testValues[0];
            ListNode<Integer> testInputToLog = Utils.copyListNode(testInput);
            int valueToRemove = (int) testValues[1];

            long start = System.nanoTime();
            ListNode<Integer> output = removeKFromList(testInput, valueToRemove);
            long timeElapsed = System.nanoTime() - start;

            WriteConsole.writeConsole(Utils.listNodeToString(expectedValue), Utils.listNodeToString(output),
                "Test values: " + Utils.listNodeToString(testInputToLog) + ", remove: " + valueToRemove,
                Utils.compareListNodes(expectedValue, output), timeElapsed);
        }
        System.out.println("\n\r");
    }

    private static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> result = new ListNode(null);
        result.next = l;
        ListNode<Integer> orig = result;

        while(orig.next != null)
        {
            if(orig.next.value == k)
            {
                ListNode next = orig.next;
                orig.next = next.next;
            }
            else
            {
                orig = orig.next;
            }
        }

        return result.next;
    }
}
