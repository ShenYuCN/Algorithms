package grammer;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by happiness on 2018/8/13.
 *
 *
     For-Each循环
 　　For-Each循环也叫增强型的for循环，或者叫foreach循环。

 　　For-Each循环是JDK5.0的新特性（其他新特性比如泛型、自动装箱等）。

 　　For-Each循环的加入简化了集合的遍历。


    for(type element: array)
 　　{

 　　System.out.println(element);

 　　}

 　
 For-Each循环的缺点：丢掉了索引信息。

 　　当遍历集合或数组时，如果需要访问集合或数组的下标，那么最好使用旧式的方式来实现循环或遍历，
    而不要使用增强的for循环，因为它丢失了下标信息。
 */
public class For_Each {
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("----------旧方式遍历------------");
        //旧式方式
        for(int i=0; i<arr.length; i++)
        {
            System.out.println(arr[i]);
        }

        System.out.println("---------新方式遍历-------------");

        //新式写法,增强的for循环
        for(int element:arr)
        {
            System.out.println(element);
        }

        System.out.println("---------遍历二维数组-------------");

        //遍历二维数组

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}} ;

        for(int[] row : arr2)
        {
            for(int element : row)
            {
                System.out.println(element);
            }
        }

        //以三种方式遍历集合List

        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("----------方式1-----------");
        //第一种方式，普通for循环
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));

        }

        System.out.println("----------方式2-----------");
        //第二种方式，使用迭代器
        for(Iterator<String> iter = list.iterator(); iter.hasNext();)
        {
            System.out.println(iter.next());
        }
        System.out.println("----------方式3-----------");
        //第三种方式，使用增强型的for循环
        for(String str: list)
        {
            System.out.println(str);

        }
    }
}

