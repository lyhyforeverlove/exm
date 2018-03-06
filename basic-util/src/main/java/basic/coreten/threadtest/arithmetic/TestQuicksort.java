package basic.coreten.threadtest.arithmetic;

import java.util.Arrays;

public class TestQuicksort {

    /**一次性快速排序
     * @param array 要排序的数组
     * @param lo 数组的前下标
     * @param hi 数组的后下标
     * @return key的下标index，也就是分片的间隔点
     */
    public static int partition1(int[] array,int lo,int hi){
        //固定的切分方式
        //选取了基准点
        int key = array[lo];
        while (lo < hi) {
            //从后半部分向前扫描
            while (array[hi] >= key && hi > lo) {
                hi--;
            }
            array[lo] = array[hi];
            //从前半部分向后扫描
            while (array[lo] <= key && hi > lo){
                lo++;
            }
            array[hi] = array[lo];
        }
        //最后把基准存入
        array[hi] = key;
        return hi;
    }

    /**快速排序
     * @param array
     * @return
     */
    public static void quickSort(int[] array,int lo,int hi){
        if(lo >= hi){
            return ;
        }
        //进行第一轮排序获取分割点
        int index = partition1(array, lo, hi);
        //排序前半部分
        quickSort(array,lo,index - 1);
        //排序后半部分
        quickSort(array,index + 1,hi);

    }
/*----------------------------------------------------------------------------------------------*/

    public static int partition(int []array,int lo,int hi){
        //三数取中
        int mid=lo+(hi-lo)/2;
        if(array[mid]>array[hi]){
            swap(array[mid],array[hi]);
        }
        if(array[lo]>array[hi]){
            swap(array[lo],array[hi]);
        }
        if(array[mid]>array[lo]){
            swap(array[mid],array[lo]);
        }
        int key=array[lo];

        while(lo < hi){
            while(array[hi] >= key && hi > lo){
                hi--;
            }
            array[lo] = array[hi];
            while(array[lo] <= key && hi > lo){
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
    public static void sort(int[] array,int lo ,int hi){
        if(lo >= hi){
            return ;
        }
        int index = partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }



    public static void main(String[] args) {
        int[] arr = {1,9,3,12,7,8,3,4,65,22};

//        quickSort(arr,0,arr.length - 1);
        sort(arr,0,arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);


    }


}
