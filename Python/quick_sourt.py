"""

 * 快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要Ο(n log n)次比较。
 * 在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。
 * 事实上，快速排序通常明显比其他Ο(n log n) 算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来，
 * 且在大部分真实世界的数据，可以决定设计的选择，减少所需时间的二次方项之可能性。

 步骤：

 1。从数列中挑出一个元素，称为 “基准”（pivot），
 2。重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 3。递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序

"""
def quick_sort(array, l, r):
    if l < r:
        q = partition(array, l, r)
        # quick_sort(array, l, q - 1)
        # quick_sort(array, q + 1, r)
 
def partition(array, l, r):
    print("l:" + str(l) + " r:" + str(r))


    x = array[r]   # 刚开始以最后一个数为基准值
    print("x:" + str(x))


    i = l - 1
    print("i:" + str(i))

    for j in range(l, r):   #range 语法，包括l，不包括r
        print("j:" + str(j))

        if array[j] <= x:   #从第一个数开始和基准值比较
            i += 1
            print("arrary[i]: " + str(i) + "  " +str(array[i]) + "   arrary[j]: " + str(j) + "  " +str(array[j]) )
            array[i], array[j] = array[j], array[i]
            print(array)



    print("arrary[i + 1]: " + str(i+1) + "  " +str(array[i + 1]) + "   arrary[r]: " + str(r) + "  " +str(array[r]) )
    array[i + 1], array[r] = array[r], array[i+1]
    return i + 1

if __name__ == '__main__':
    array = [8,3,2,1,4,6,7,0,5]
    print(array)
    quick_sort(array,0,len(array)-1)
    print(array)
