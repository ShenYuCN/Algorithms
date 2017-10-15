import java.util.*;

/**
 * Created by happiness on 17/10/15.
 *
 * 以下实例演示了如何遍历从Collection接口延伸出的List、Set和以键值对形式作存储的Map类型的集合，
 * 以下我们分别使用了普通for，增强型的 for ，iterator 等方式来遍历集合：
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

        // 使用iterator遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println(value);
        }

        // 使用传统for循环进行遍历
        for (int i = 0; i <  list.size(); i++) {
            String value = list.get(i);
            System.out.println(value);
        }

        // 使用增强for循环进行遍历
        for (String value : list) {
            System.out.println(value);
        }

        System.out.print("\n");
    }
}
