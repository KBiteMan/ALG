package sort;

import utils.Performance;
import utils.Printer;

public class Test {
    public static void main(String[] args) {
        Sort bubble = new Sort();
//        System.out.println("冒泡排序：");
//        for (int[] arr : Data.INT_ARRS) {
//            Performance.startMem();
//            Printer.print(bubble.bubbleSort(arr));
//            Performance.endMem();
//        }
//        System.out.println("选择排序：");
//        for (int[] intArr : Data.INT_ARRS) {
//            Performance.startMem();
//            Printer.print(bubble.selectSort(intArr));
//            Performance.endMem();
//        }
//        System.out.println("插入排序：");
//        for (int[] intArr : Data.INT_ARRS) {
//            Performance.startMem();
//            Printer.print(bubble.insertSort(intArr));
//            Performance.endMem();
//        }
        System.out.println("快速排序：");
        for (int[] intArr : Data.INT_ARRS) {
            Performance.startMem();
            bubble.quickSort(intArr,0,intArr.length-1);
            Printer.print(intArr);
            Performance.endMem();
        }
    }
}
