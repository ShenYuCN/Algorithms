def quick_sort_standord(array,low,high):
    ''' realize from book "data struct" of author 严蔚敏
    '''
    if low < high:
        key_index = my_partion(array,low,high)
        quick_sort_standord(array,low,key_index)
        quick_sort_standord(array,key_index+1,high)
def my_partion(array,low,high):
    key = array[low]
    while low < high:
        while low < high and array[high] >= key:
            high -= 1

        array[low] = array[high]


        while low < high and array[low] < key:
            low += 1

        array[high] = array[low]

    array[low] = key
    return low

def partion(array,low,high):

    print("low:" + str(low) + " high:" + str(high))

    key = array[low]    # 刚开始以第一个数为基准值
    print("key:" + str(key))

    while low < high:

        print("*"*30)
        while low < high and array[high] >= key:  #从后面开始找，找到比key值小的数为止。 如果后面的数比key大，那么继续从后往前找
            high -= 1
        print("array[low]:" + str(low) + "  " + str(array[low]) + " array[high]:" +str(high) + "  " +  str(array[high]))
        array[low] = array[high]     # 将该数放到key值的左边
        # print(array)


        while low < high and array[low] < key:  # 从前面开始找，找到比key值大的数为止。 如果前面的数比key小，那么继续从前往后找
            low += 1

        print("array[low]:" + str(low) + "  " + str(array[low]) + " array[high]:" +str(high) + "  " +  str(array[high]))
        array[high] = array[low]
        print(array)

    array[low] = key   # 把key值填充到low位置，下次重新找key值
    return low

if __name__ == '__main__':
    array = [5,8,2,1,4,3,7,0,6]
    print(array)
    quick_sort_standord(array,0,len(array)-1)
    print(array)
















