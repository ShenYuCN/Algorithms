/**
 * Created by happiness on 2017/3/13.
 */
//题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
//例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
public class 水仙花数 {
    public static void  main(String args[]){

        for (int i = 100;i<1000;i++){
            if (Math.pow(i/100,3)+Math.pow(i/10%10,3)+Math.pow(i%10,3) == i){
                System.out.println(i);
            }

        }

        for(int i=1;i<10;i++){
			for(int j=0;j<10;j++){
				for (int k = 0; k < 10; k++) {
					if((double)(100*i+10*j+k)==(Math.pow(i, 3)+Math.pow(j, 3)+Math.pow(k, 3))){
						System.out.println(100*i+10*j+k);
					}
				}
			}
		}

    }
}
