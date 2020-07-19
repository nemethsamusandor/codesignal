package at.general;

import at.general.interfaces.ListNode;

public class Utils
{
    public static boolean compareArrays(int[][] array1, int[][] array2) {
        if (array1 != null && array2 != null)
        {
            if (array1.length != array2.length)
            {
                return false;
            }
            else
            {
                for (int i = 0; i < array2.length; i++)
                {
                    for (int j = 0; j < array2.length; j++)
                    {
                        if (array2[i][j] != array1[i][j])
                        {
                            return false;
                        }
                    }
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    public static <T> ListNode<T> buildListNode(T[] data)
    {
        if (data == null || data.length == 0)
        {
            return null;
        }

        ListNode<T> result = new ListNode(data[0]);

        ListNode<T> helper = result;

        for(int i = 1; i < data.length; i++)
        {
            helper.next = new ListNode<>(data[i]);
            ListNode<T> next = helper.next;
            helper = next;
        }

        return result;
    }

    public static <T> boolean compareListNodes(ListNode<T> listNode1, ListNode<T> listNode2)
    {
        if (listNode1 == null && listNode2 == null)
        {
            return true;
        }
        if (listNode1 == null || listNode2 == null)
        {
            return false;
        }

        ListNode<T> helper1 = listNode1;
        ListNode<T> helper2 = listNode2;

        while(helper1.next != null || helper2.next != null)
        {
            ListNode<T> next1 = helper1.next;
            ListNode<T> next2 = helper2.next;

            if (next1 == null || next2 == null)
            {
                return false;
            }

            if (!helper1.value.equals(helper2.value))
            {
                return false;
            }

            helper1 = next1;
            helper2 = next2;
        }

        return true;
    }

    public static <T> String listNodeToString(ListNode<T> listNode)
    {
        StringBuilder result = new StringBuilder("[");

        if (listNode != null && listNode.value != null)
        {
            ListNode<T> helper = listNode;
            while (helper.next != null)
            {
                ListNode<T> next = helper.next;
                result.append(helper.value).append(", ");
                helper = next;
            }
            result.append(helper.value);
        }
        return result.append("]").toString();
    }

    public static <T> ListNode<T> copyListNode(ListNode<T> orig)
    {
        if (orig == null)
        {
            return null;
        }

        ListNode<T> newListNode = new ListNode(orig.value);

        ListNode<T> helperOrig = orig;
        ListNode<T> helperNew = newListNode;
        while(helperOrig.next != null)
        {
            ListNode<T> nextOrig = helperOrig.next;

            helperNew.next = new ListNode<>(helperOrig.next.value);
            ListNode<T> nextNew = helperNew.next;

            helperOrig = nextOrig;
            helperNew = nextNew;
        }

        return newListNode;
    }
}
