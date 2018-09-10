
package grammer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by happiness on 17/12/4.
 *
 *
 *
 1、add()和offer()区别:
 add()和offer()都是向队列中添加一个元素。一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，
 调用 add() 方法就会抛出一个 unchecked 异常，而调用 offer() 方法会返回 false。因此就可以在程序中进行有效的判断！

  2、poll()和remove()区别：
 remove() 和 poll() 方法都是从队列中 删除 第一个元素。如果队列元素为空，
 调用remove() 的行为与 Collection 接口的版本相似会抛出异常，但是新的 poll() 方法在用空集合调用时只是返回 null。
 因此新的方法更适合容易出现异常条件的情况。
  
 3、element() 和 peek() 区别：
 element() 和 peek() 用于在队列的头部 查询 元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。

 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
 LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。

 */
public class Queue_Rule {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");




        System.out.println("queue" + queue);
        System.out.println("queue.remove:" + queue.remove());
        System.out.println("queue" + queue);


        System.out.println("queue.peek:" + queue.peek());
        System.out.println("queue" + queue);


        System.out.println("queue.poll:" + queue.poll());
        System.out.println("queue.poll:" + queue.poll());
        System.out.println("queue.poll:" + queue.poll());

        System.out.println("queue.peek:" + queue.peek());


    }
}
