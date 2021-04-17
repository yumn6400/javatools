import com.thinking.machines.util.*;
class TMIteratorTestCase
{
public static void main(String gg[])
{
TMLinkedList list1=new TMLinkedList();
list1.add(101);
list1.add(102);
list1.add(103);
list1.add(104);
TMArrayList list2=new TMArrayList();
list2.add(1010);
list2.add(1020);
list2.add(1030);
list2.add(1040);
System.out.println("Iterating on linked list");
TMIterator iterator1=list1.iterator();
int x;
while(iterator1.hasNext())
{
x=iterator1.next();
System.out.println(x);
}
System.out.println("Iterating on Array list");
TMIterator iterator2=list2.iterator();
while(iterator2.hasNext())
{
x=iterator2.next();
System.out.println(x);
}
}
}