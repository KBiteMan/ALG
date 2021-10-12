package nowcoder;

import data.Constants;
import data.DoubleLinkNode;
import utils.Printer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 k ，并有如下两个功能
 * <p>1. set(key, value)：将记录(key, value)插入该结构
 * <p>2. get(key)：返回key对应的value值
 *
 * <p>提示:
 * <p>1.某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的，然后都会刷新缓存。
 * <p>2.当缓存的大小超过k时，移除最不经常使用的记录。
 * <p>3.输入一个二维数组与k，二维数组每一维有2个或者3个数字，第1个数字为opt，第2，3个数字为key，value
 * <p>若opt=1，接下来两个整数key, value，表示set(key, value)
 * <p>若opt=2，接下来一个整数key，表示get(key)，若key未出现过或已被移除，则返回-1
 * <p>对于每个opt=2，输出一个答案
 * <p>4.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
 *
 * <p>要求：set和get操作复杂度均为
 *
 * <p>示例1
 * <p>输入：
 * <p>[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 * <p>返回值：
 * <p>[1,-1]
 * <p>说明：
 * <p>[1,1,1]，第一个1表示opt=1，要set(1,1)，即将(1,1)插入缓存，缓存是{"1"=1}
 * <p>[1,2,2]，第一个1表示opt=1，要set(2,2)，即将(2,2)插入缓存，缓存是{"1"=1,"2"=2}
 * <p>[1,3,2]，第一个1表示opt=1，要set(3,2)，即将(3,2)插入缓存，缓存是{"1"=1,"2"=2,"3"=2}
 * <p>[2,1]，第一个2表示opt=2，要get(1)，返回是[1]，因为get(1)操作，缓存更新，缓存是{"2"=2,"3"=2,"1"=1}
 * <p>[1,4,4]，第一个1表示opt=1，要set(4,4)，即将(4,4)插入缓存，但是缓存已经达到最大容量3，移除最不经常使用的{"2"=2}，插入{"4"=4}，缓存是{"3"=2,"1"=1,"4"=4}
 * <p>[2,2]，第一个2表示opt=2，要get(2)，查找不到，返回是[1,-1]
 */
public class NC93 {
    private static DoubleLinkNode<Integer> header, tail;
    private static HashMap<Integer, DoubleLinkNode<Integer>> keys = new HashMap<>();
    private static int MAX_SIZE = 3;
    private static int mSize = 0;

    public static void main(String[] args) {
        header = new DoubleLinkNode(null, -1, -1, null);
        tail = new DoubleLinkNode(null, -1, -1, null);
        header.next = tail;
        tail.pre = header;

        int[][] lruData = Constants.LRU_DATA;
        for (int i = 0; i < lruData.length; i++) {
            int[] itemArrs = lruData[i];
            DoubleLinkNode<Integer> node = keys.get(itemArrs[1]);
            if (itemArrs[0] == 1) {
                if (node != null) {
                    node.value = itemArrs[2];
                    moveToHead(node);
                } else {
                    ++mSize;
                    if (mSize > MAX_SIZE) {
                        DoubleLinkNode<Integer> tail = removeTail();
                        keys.remove(tail.key);
                        --mSize;
                    }
                    DoubleLinkNode<Integer> newNode = new DoubleLinkNode<>(itemArrs[1], itemArrs[2]);
                    keys.put(itemArrs[1], newNode);
                    addToHead(newNode);
                }
            } else {
                if (node != null) {
                    moveToHead(node);
                    System.out.println("获得数据：" + node.value);
                } else {
                    System.out.println(-1);
                }
            }
        }
        Printer.printDoubleLink(header);
    }

    private static void addToHead(DoubleLinkNode<Integer> node) {
        node.pre = header;
        node.next = header.next;
        header.next.pre = node;
        header.next = node;
    }

    private static void removeNode(DoubleLinkNode<Integer> node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private static void moveToHead(DoubleLinkNode<Integer> node) {
        removeNode(node);
        addToHead(node);
    }

    private static DoubleLinkNode<Integer> removeTail() {
        DoubleLinkNode<Integer> node = tail.pre;
        removeNode(node);
        return node;
    }


}
