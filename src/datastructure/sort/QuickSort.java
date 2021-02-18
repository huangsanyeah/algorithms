package datastructure.sort;

import java.util.Arrays;

/**
 * O(nlogn)
 * 1.从数列中挑出一个元素，称为"基准"（pivot），
 * 2.重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。
 *  在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 3.递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 动图：
 * https://www.xuebuyuan.com/2109322.html
 * B站视频（秒懂算法）：
 * https://www.bilibili.com/video/BV1at411T75o?from=search&seid=16489477606521879804
 */
public class QuickSort {

    public static void main(String[] args) {
        //int[] arr = {-9, 78, 0, -23, -567, 70, -1, 30, 200};
        int[] arr = {-1, 2, 0, -9, -6, 3};
        System.out.println("排序前的数组是=" + Arrays.toString(arr));
        //quickSort(arr, 0, arr.length - 1);
        qsort(arr, 0, arr.length - 1);
        System.out.println("排序后的数组是=" + Arrays.toString(arr));

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }
//
//        System.out.println("排序前");
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);
//
//        quickSort(arr, 0, arr.length - 1);
//
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);
        //System.out.println("arr=" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边,比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }


    /**
     * 快速排序练习
     * @param arr
     * @param low
     * @param high
     */
    private static void qsort(int[] arr, int low, int high){
        if (low >= high) {
            return;
        }
        //pivot 中轴的意思
        int pivot = partition(arr, low, high);        //将数组分为两部分
        qsort(arr, low, pivot-1);                   //递归排序左子数组
        qsort(arr, pivot+1, high);                  //递归排序右子数组
    }

    //  int[] arr = {-1, 2, 0, -9, -6, 3};
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //基准
        while (low < high){
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low]=arr[high];             //交换比基准大的记录到左端
            System.out.println("………………" );
            System.out.println("数组是=" + Arrays.toString(arr));
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];           //交换比基准小的记录到右端
            System.out.println("数组是=" + Arrays.toString(arr));
            System.out.println("………………" );
        }
        //扫描完成，基准到位
        arr[low] = pivot;
        //返回的是基准的位置
        return low;
    }

}


