package at.general.interfaces;

public class ListNode<T>
{
   public ListNode(T x)
   {
     value = x;
   }

   public T value;

   public ListNode<T> next;
}
