package sort;

import utils.Printer;

public class Sort {
    /**
     * 冒泡排序
     *
     * @param arrs
     * @return
     */
    public int[] bubbleSort(int[] arrs) {
        int length = arrs.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
        }
        return arrs;
    }

    /**
     * 选择排序
     *
     * @param arrs
     * @return
     */
    public int[] selectSort(int[] arrs) {
        int length = arrs.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (arrs[minIndex] > arrs[j]) {
                    minIndex = j;
                }
            }
            int temp = arrs[minIndex];
            arrs[minIndex] = arrs[i];
            arrs[i] = temp;
        }
        return arrs;
    }

    /**
     * 插入排序
     *
     * @param arrs
     * @return
     */
    public int[] insertSort(int[] arrs) {
        int length = arrs.length;
        for (int i = 0; i < length - 1; i++) {
            int current = arrs[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arrs[preIndex]) {
                arrs[preIndex + 1] = arrs[preIndex];
                preIndex--;
            }
            arrs[preIndex + 1] = current;
        }
        return arrs;
    }

    public void quickSort(int[] arrs, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        int key = arrs[left];
        while (left < right) {
            while (left < right && arrs[right] >= key) {
                right--;
            }
            arrs[left] = arrs[right];
            while (left < right && arrs[left] <= key) {
                left++;
            }
            arrs[right] = arrs[left];
        }
        arrs[left] = key;
        quickSort(arrs, leftIndex, left - 1);
        quickSort(arrs, right + 1, rightIndex);
    }

}
