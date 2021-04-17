import com.thinking.machines.util.*;
class forEachTestCase
{
public static void main(String gg[])
{
TMList<String> list1=new TMArrayList<String>();
list1.add("India");
list1.add("Pakistan");
list1.add("Bhopal");
list1.add("Goa");
list1.forEach((p)->{System.out.println(p);});
System.out.println("*****************");
TMList<Integer> list2=new TMLinkedList<Integer>();
list2.add(500);
list2.add(600);
list2.add(700);
list2.add(800);
list2.forEach((p)->{System.out.println(p);});
}
}