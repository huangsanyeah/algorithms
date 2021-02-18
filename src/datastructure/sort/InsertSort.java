package datastructure.sort;

import java.util.Arrays;

/**
 * 看下MD中的动图
 * 插入排序是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * 1.把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
 * 2.从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
 * 3.重复上述过程直到最后一个元素被插入有序子数组中。
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        // 创建要给80000个的随机的数组
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }
//
//        System.out.println("插入排序前");
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);
//
//        insertSort(arr); //调用插入排序算法
//
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);

        //System.out.println(Arrays.toString(arr));


        //testInsertSort();

        insertionSort(arr);
//        System.out.println(Arrays.toString(arr));

    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            //System.out.println("第"+i+"轮插入");
            //System.out.println(Arrays.toString(arr));
        }


		/*


		//使用逐步推导的方式来讲解，便利理解
		//第1轮 {101, 34, 119, 1};  => {34, 101, 119, 1}


		//{101, 34, 119, 1}; => {101,101,119,1}
		//定义待插入的数
		int insertVal = arr[1];
		int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标

		//给insertVal 找到插入的位置
		//说明
		//1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
		//2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
		//3. 就需要将 arr[insertIndex] 后移
		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}
		//当退出while循环时，说明插入的位置找到, insertIndex + 1
		//举例：理解不了，我们一会 debug
		arr[insertIndex + 1] = insertVal;

		System.out.println("第1轮插入");
		System.out.println(Arrays.toString(arr));

		//第2轮
		insertVal = arr[2];
		insertIndex = 2 - 1;

		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}

		arr[insertIndex + 1] = insertVal;
		System.out.println("第2轮插入");
		System.out.println(Arrays.toString(arr));


		//第3轮
		insertVal = arr[3];
		insertIndex = 3 - 1;

		while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}

		arr[insertIndex + 1] = insertVal;
		System.out.println("第3轮插入");
		System.out.println(Arrays.toString(arr)); */

    }

    /**
     * 插入排序（从小到大）练习
     * 理解：每次循环都是拿一个元素与之前插入好的元素进行大小比较，跳出循环找到待插入的值后，赋值
     * debug代码 理解流程
     */
    private static void testInsertSort() {
        int[] arr = {101, 34, 99, 1};
        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标

        //给insertVal 找到插入的位置
        //说明
        //1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
        //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3. 就需要将 arr[insertIndex] 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到, insertIndex + 1
        //举例：理解不了，我们一会 debug
        arr[insertIndex + 1] = insertVal;

        System.out.println("第1轮插入");
        System.out.println(Arrays.toString(arr));


        //第2轮
        insertVal = arr[2];
        insertIndex = 2 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;
        System.out.println("第2轮插入");
        System.out.println(Arrays.toString(arr));


        insertVal = arr[3];
        insertIndex = 3 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;
        System.out.println("第3轮插入");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序练习
     * TODO debug 查看每一步
     */
    public static void insertionSort(int[] arr) {
        System.out.println("入参未排序前：" + Arrays.toString(arr));
        for (int i = 1; i < arr.length; ++i) {
            int value = arr[i];
            int position = i;
            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = value;
        }
        System.out.println("排序前后：" + Arrays.toString(arr));
    }

}
