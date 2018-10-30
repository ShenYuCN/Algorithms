/**
 * Created by happiness on 17/12/4.



 1	boolean empty()
 测试堆栈是否为空。


 2	Object peek( )
 查看堆栈顶部的对象，但不从堆栈中移除它。

 3	Object pop( )
 移除堆栈顶部的对象，并作为此函数的值返回该对象。

 4	Object push(Object element)
 把项压入堆栈顶部。

 5	int search(Object element)
 返回对象在堆栈中的位置，以 1 为基数。

 */
package grammer;

import java.util.Stack;

public class Stack_Rule {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("stack: " +  stack);

        System.out.println("peek：" + stack.peek());
        System.out.println("stack：" +  stack);

        System.out.println("pop:" + stack.pop());
        System.out.println("pop:" + stack.pop());

        System.out.println("stack: " +  stack);

//        stack: [1, 2, 3, 4]
//        peek：4
//        stack：[1, 2, 3, 4]
//        pop:4
//        pop:3
//        stack: [1, 2]
    }
}
