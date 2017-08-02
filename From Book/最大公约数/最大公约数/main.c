//
//  main.c
//  最大公约数
//
//  Created by ShenYu on 2017/3/31.
//  Copyright © 2017年 ShenYu. All rights reserved.
//


//题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
//程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。

#include <stdio.h>
/* 函数声明 */
//int max(int num1, int num2);

int main() {
    printf("nnnn");

    printf("\n");
    int num = 0;
    for (int i = 1; i < 5; i++) {
        for (int j = 1; j < 5; j++) {
            for (int k = 1; k < 5; k++) {
                if (i != j && i != k && j != k) {
                    num++;
                    printf("%d,%d,%d\n",i,j,k);
                    
                }
            }
        }
    }
    
    
//    for(i=1;i<5;i++) { // 以下为三重循环
//        for(j=1;j<5;j++) {
//            for (k=1;k<5;k++) { // 确保i、j、k三位互不相同
//                if (i!=k&&i!=j&&j!=k) {
//                    printf("%d,%d,%d\n",i,j,k);
//                }
//            }
//        }
//    }
    return 0;
}

//int max(int num1, int num2){
//    /* 局部变量声明 */
//    int result;
//    
//    if (num1 > num2)
//        result = num1;
//    else
//        result = num2;
//    
//    return result;
//}
