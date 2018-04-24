import com.sun.tools.doclets.internal.toolkit.util.DocFinder;
import sun.print.SunMinMaxPage;

import javax.lang.model.util.ElementScanner6;
import javax.print.DocFlavor;
import java.awt.*;
import java.util.Map;

/**
 * Created by happiness on 2018/2/14.
 */
public class Test {

    public static void main(String args[]) {

        递归方法
	int binarySearch1(int a[] , int low , int high , int findNum)
        {   
      int mid = ( low + high ) / 2;     
      if (low > high)       
            return -1; 
     else 
     {       
              if (a[mid] > findNum)         
                    return binarySearch1(a, low, mid - 1, findNum);       
              else if (a[mid] < findNum)           
                    return binarySearch1(a, mid + 1, high, findNum);                   
              else           
                    return mid; 
    }
        }
        非递归方法int binarySearch2(int a[] , int low , int high , int findNum)
        {   
       while (low <= high)
      {
            int mid = ( low + high) / 2;   //此处一定要放在while里面
            if (a[mid] < findNum)         
                low = mid + 1;       
            else if (a[mid] > findNum)           
                high = mid - 1;     
             else         
                return mid;   
    }     
    return  -1;
        }
        冒泡排序   θ(n^2)

void bubble_sort(int a[], int n)
        {
    int i, j, temp;
    for (j = 0; j < n - 1; j++)
        for (i = 0; i < n - 1 - j; i++) //外层循环每循环一次就能确定出一个泡泡（最大或者最小），所以内层循环不用再计算已经排好的部分
        {
            if(a[i] > a[i + 1])
            {
                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        }
        快速排序  调用方法  quickSort(a,0,n);  θ(nlogn)

void quickSort (int a[] , int low , int high)
        {
    if (high < low + 2)
        return;
    int start = low;
    int end = high;
    int temp;
    while (start < end)
    {
        while ( ++start < high && a[start] <= a[low]);//找到第一个比a[low]数值大的位子start
        while ( --end  > low  && a[end]  >= a[low]);//找到第一个比a[low]数值小的位子end
        //进行到此，a[end] < a[low] < a[start],但是物理位置上还是low < start < end，因此接下来交换a[start]和a[end],于是[low,start]这个区间里面全部比a[low]小的，[end,hight]这个区间里面全部都是比a[low]大的
        if (start < end)
        {
            temp = a[start];
            a[start]=a[end];
            a[end]=temp;
        }
        //在GCC编译器下，该写法无法达到交换的目的，a[start] ^= a[end] ^= a[start] ^= a[end];编译器的问题
    }
    //进行到此，[low,end]区间里面的数都比a[low]小的,[end,higt]区间里面都是比a[low]大的，把a[low]放到中间即可
    //在GCC编译器下，该写法无法达到交换的目的，a[low] ^= a[end] ^= a[low] ^= a[end];编译器的问题
    temp = a[low];
    a[low]=a[end];
    a[end]=temp;
    //现在就分成了3段了，由最初的a[low]枢纽分开的
    quickSort(a, low, end);
    quickSort(a, start, high);

        }
}