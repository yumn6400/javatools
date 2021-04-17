import com.thinking.machines.util.*;
class TMLinkedListTestCase
{
public static void main(String gg[])
{
TMLinkedList list1=new TMLinkedList();
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
list1.add(50);
for(int i=0;i<list1.size();i++)System.out.println(list1.get(i));
System.out.println("**********************");
TMLinkedList list2=new TMLinkedList();
list2.add(2);
list2.appendFrom(list1);
for(int i=0;i<list2.size();i++)System.out.println(list2.get(i));

}
}