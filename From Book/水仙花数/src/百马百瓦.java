/**
 * Created by happiness on 2017/3/13.
 */

/**
 * 一共100匹马，100匹瓦
 * 大马 一驼3
 * 中马 一驼2
 * 小马 二驼1
 * 所有马都用
 */
public class 百马百瓦 {
    public  static  void  main(String args[]){

        int[] ss = {1,12,-5,-6,50,3};
        System.out.println(ss.length);
        for (int i = 1; i < 33; ++i){
            for (int j = 1; j < 50; ++j){
                for (int x = 2; x < 100; x++){
                    if ((i + j + x == 100) && i * 3 + j * 2 + x / 2 ==100){
                        System.out.println("大："+ i + "  中：" + j + "  小" + x);
                    }
                    x++;
                }
            }
        }
    }
}
