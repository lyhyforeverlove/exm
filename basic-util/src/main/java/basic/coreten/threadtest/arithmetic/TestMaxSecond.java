package basic.coreten.threadtest.arithmetic;

public class TestMaxSecond {

    //排序获取
    public static int  secondMax2(int a[]){
        for(int i = 0;i<a.length-1;i++) {
            for(int j=0;j<a.length-1-i;j++) {
                if(a[j]>a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
        //System.out.println(a[]);
        System.out.println(a[a.length-2]);
        return a[a.length-2];
    }


    public static void main(String[] args) {
        int[] b={3,5,1,10,7,10,8,8,11,11};
        int secondMax2 = secondMax2(b);
//        int second = maxSecond(b);
        System.out.println(secondMax2);

    }

    public static int maxSecond(int[] arr){
        if (arr.length <= 0) {
            return 0;
        }
        int max1,max2;
        max1 = max2 = arr[0];
        int zk;
        for (int i = 0; i < arr.length; i++) {
            zk = arr[i];
            if (zk >= max2) {
                if (zk > max1) {
                    max2 = max1;
                    max1 = zk;
                } else if (zk == max1) {
                    max1 = zk;
                } else {
                    max2 = zk;
                }
            }
        }
        System.out.println("max1 = " + max1);
        System.out.println("max2 = " + max2);
        return max2;
    }

}
