package datastructure.search;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 时间复杂度为O(log n)。（n代表集合中元素的个数）
 * 二分查找的思路分析
 * 1. 首先确定该数组的中间的下标
 * mid = (left + right) / 2
 * 2. 然后让需要查找的数 findVal 和 arr[mid] 比较
 * 2. 1 findVal > arr[mid] ,  说明你要查找的数在mid 的右边, 因此需要递归的向右查找
 * 2.2 findVal < arr[mid], 说明你要查找的数在mid 的左边, 因此需要递归的向左查找
 * 2.3  findVal == arr[mid] 说明找到，就返回
 * 什么时候我们需要结束递归.
 * 1) 找到就结束递归
 * 2) 递归完整个数组，仍然没有找到findVal ，也需要结束递归  当 left > right 就需要退出
 * TODO 注意：使用二分查找的前提是 该数组是有序的 即有从小到大或者从大到小的顺序.
 * FIXME 注意:  mid的取值 int mid = low + (high - low) / 2;
 * 参考：https://leomalik.github.io/
 */
public class BinarySearch {

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int[] arr = {1, 8, 10, 89, 1000, 1200, 1234};
        //递归方式
        int index = binarysearch(arr, 0, arr.length - 1, 1200);
        //非递归方式
        //int index = bsearchWithoutRecursion(arr, 1200);
        //JDK工具类实现
        //int index = testJdkBinarySearch();
        //JDK工具类源码实现
        //int index = indexedBinarySearch(1200);
        System.out.println("index:" + index);


//		int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
//		System.out.println("resIndex=" + resIndex);

//        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1);
//        System.out.println("resIndexList=" + resIndexList);
    }

    // 二分查找算法

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {


        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向 右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {

            return mid;
        }

    }

    //完成一个课后思考题:
    /*
     * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
     * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
     *
     * 思路分析
     * 1. 在找到mid 索引值，不要马上返回
     * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
     * 4. 将Arraylist返回
     */

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        System.out.println("hello~");
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向 右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
//			 * 思路分析
//			 * 1. 在找到mid 索引值，不要马上返回
//			 * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 4. 将Arraylist返回

            List<Integer> resIndexlist = new ArrayList<Integer>();
            //向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {//退出
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp -= 1; //temp左移
            }
            resIndexlist.add(mid);  //

            //向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {//退出
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp += 1; //temp右移
            }

            return resIndexlist;
        }

    }


    /**
     * 二分查找练习 递归方式实现
     */
    private static int binarysearch(int[] array, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        //FIXME !!! left + ((right -left) >> 1) 其实和 (left + right) / 2是等价的，这样写的目的一个是为了防止 (left + right)出现溢出，一个是用右移操作替代除法提升性能
        int mid = low + (high - low) / 2;
        if (array[mid] > target) {
            return binarysearch(array, low, mid - 1, target);
        }
        if (array[mid] < target) {
            return binarysearch(array, mid + 1, high, target);
        }
        return mid;
    }


    /**
     * 二分查找练习 非递归
     */
    private static int bsearchWithoutRecursion(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * JDK工具类中的二分法
     */
    public static int testJdkBinarySearch() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(2);
        return Collections.binarySearch(list, 7);
    }


    /**
     * Collections.binarySearch内部实现，copy自其源码
     */
    public static int indexedBinarySearch(Integer key) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(5);
        list.add(2);
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Integer midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -(low + 1);  // key not found
    }

}
