/**
 * Created by happiness on 17/9/18.
 *
 *
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

 Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

 Example 1:
 Input: flowerbed = [1,0,0,0,1], n = 1
 Output: True
 Example 2:
 Input: flowerbed = [1,0,0,0,1], n = 2
 Output: False


 The input array won't violate no-adjacent-flowers rule.
 The input array size is in the range of [1, 20000].
 n is a non-negative integer which won't exceed the input array size.


 */
public class A03_Can_Place_Flowers {


    public static void main(String args[]) {

//        int[] ss = {1,0,0,0,1,0,0};
//        int[] ss = {1,0,0,0,1};
        int[] ss = {0, 0, 1, 0, 1};


//        System.out.println(canPlaceFlowers(ss, 1));
        System.out.println(canPlaceFlowers_Great(ss, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed.length == 1 && flowerbed[0] == 0 && n <= 1) {

            return true;
        }

        int x = 0;
        for (int i = 0; i < flowerbed.length; i++) {

            if (
                    (i != flowerbed.length - 1 && i != 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0)
                            || (flowerbed[i] == 0 && i == 0 && flowerbed[i + 1] == 0)
                            || (flowerbed[i] == 0 && i == flowerbed.length - 1 && flowerbed[i - 1] == 0)) {
                flowerbed[i] = 1;
                i++;
                x++;

            }
        }

        return x >= n;
    }


    public static boolean canPlaceFlowers_Great(int[] flowered, int n) {


        if (flowered.length == 1 && flowered[0] == 0 && n <= 1) {
            return true;
        }

        int i = 0, count = 0;
        while (i < flowered.length) {
            if (flowered[i] == 0 && (i == flowered.length - 1 || flowered[i + 1] == 0) && (i == 0 || flowered[i - 1] == 0)) {

                flowered[i] = 1;
                count++;
            }
            if (count >= n) return true;
            i++;
        }

        return count >= n;

    }
}