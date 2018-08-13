package grammer;
import java.util.*;


/**
 * Created by happiness on 17/10/15.
 *
 * 以下实例演示了如何遍历从Collection接口延伸出的List、Set和以键值对形式作存储的Map类型的集合，
 * 以下我们分别使用了普通for，增强型的 for ，iterator 等方式来遍历集合：
 *
 *
 *
 Set和List的区别
 1. Set 接口实例存储的是无序的，不重复的数据。List 接口实例存储的是有序的，可以重复的元素。
 2. Set检索效率低下，删除和插入效率高，插入和删除不会引起元素位置改变 <实现类有HashSet,TreeSet>。
 3. List和数组类似，可以动态增长，根据实际存储的数据的长度自动增长List的长度。
 查找元素效率高，插入删除效率低，因为会引起其他元素位置改变 <实现类有ArrayList,LinkedList,Vector> 。
 */
public class Traversal_List {
    public static void main(String[] args) {
        // List集合的遍历
        listTest();

        // Set集合的遍历
        setTest();
    }

    private static void setTest() {
        Set<String> set = new HashSet<String>();
        set.add("JAVA");
        set.add("C");
        set.add("C++");
        // 重复数据添加失败
        set.add("JAVA");
        set.add("JAVASCRIPT");

        // 使用iterator遍历set集合
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println(value);
        }

        // 使用增强for循环遍历set集合
        for(String s: set){
            System.out.println(s);
        }
    }

    // 遍历list集合
    private static void listTest() {
        List<String> list = new ArrayList<String>();
        list.add("菜");
        list.add("鸟");
        list.add("教");
        list.add("程");
        list.add("www.w3cschool.cc");


        System.out.print("使用传统for循环进行遍历\n");

        // 使用传统for循环进行遍历
        for (int i = 0; i <  list.size(); i++) {
            String value = list.get(i);
            System.out.println(value);
        }

        System.out.print("使用增强for循环进行遍历\n");
        // 使用增强for循环进行遍历
        for (String value : list) {
            System.out.println(value);
        }

        System.out.print("使用iterator遍历\n");
        // 使用iterator遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println(value);
        }

        System.out.print("把链表变为数组相关的内容进行遍历\n");
        // 把链表变为数组相关的内容进行遍历
        String[] arr=new String[list.size()];
        list.toArray(arr);
        for(int i=0;i<arr.length;i++) //这里也可以改写为  foreach(String str:strArray)这种形式
        {
            System.out.println(arr[i]);
        }

        System.out.print("\n");
    }
}
