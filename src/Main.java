import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    /**
     * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
     */
    public static boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.add(i))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 3, 4, 5, 1, 7, 8, 9};
        int[] nums = {1, 0, 1, 1};

//        System.out.println(containsDuplicate(nums));
//        System.out.println(containsNearbyDuplicate(nums, 1));
        for (int i = 0; i < 100; i++) {
            System.out.println((i % 4) + 1);
        }
//        int one = 0;
//        int accumulation = 0;
//        int temp = 3 & one;
//        accumulation |= temp;
//        System.out.println(temp);
//        System.out.println(accumulation);
    }

    /**
     * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
     * and the difference between i and j is at most k.
     * 找到一个最小的去和K比，如果符合就返回
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                int preIndex = hashMap.get(nums[i]);
                int gap = i - preIndex;
                min = Math.min(gap, min);

            }
            hashMap.put(nums[i], i);
        }

        if (min <= k)
            return true;
        else return false;
    }

    /**
     * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
     * System.out.println("lower(\"P\"): " + treeSet.lower("P"));   //返回小于P的一个元素
     * System.out.println("higher(\"P\"): " + treeSet.higher("P"));  //大于P
     * System.out.println("floor(\"P\"): " + treeSet.floor("P"));    //小于等于P
     * System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));  //大于等于
     * System.out.println("pollFirst(): " + treeSet.pollFirst());    //删除treeSet中第一个
     * System.out.println("pollLast(): " + treeSet.pollLast());     //删除treeSet中最后一个
     * System.out.println("New tree set: " + treeSet);  //输出删除后的treeSet
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;

        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if ((set.floor(c) != null && c <= set.floor(c) + t) || (set.ceiling(c) != null && c >= set.ceiling(c) - t))
                return true;

            set.add(c);

            if (i >= k)
                set.remove(nums[i - k]);
        }

        return false;

    }

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     */

    public int singleNumber(int[] nums) {

        int i = 0;
        for (int temp : nums) {
            i = i ^ temp;
        }
        return i;
    }

    /**
     * Given an array of integers, every element appears three times except for one. Find that single one.
     * 看不懂！！！
     */
    public int singleNumber2(int[] nums) {
        int one = 0;
        // 出现一次的标志位
        int accumulation = 0;
        // 积累标志位
        for (int i = 0; i < nums.length; i++) {
            accumulation = accumulation | (nums[i] & one);
            // 只要第二次或者以上出现，就为1
            one = one ^ nums[i];
            // 出现奇数次保留，偶数次抛弃
            int t = one & accumulation;
            // 第三次的时候one和accumulation都保留了该位的值
            one = one & (~t);
            // 清零出现三次的该位的值
            accumulation = accumulation & (~t);
        }
        return one;
    }

    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
     */

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * remove all elements from a linked list of integers that have value val.
     * <p/>
     * Example
     * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     * Return: 1 --> 2 --> 3 --> 4 --> 5
     */


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return node.next;
    }

    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * <p/>
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     */

    public int singleNumber1(int[] nums) {
        int i = 0;
        for (int temp : nums) {
            i = i ^ temp;
        }
        return i;
    }

    /**
     * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     * Solve it without division and in O(n).
     * For example, given [1,2,3,4], return [24,12,8,6].
     * 如果数组里面有0，正常的全部乘起来除法不能过
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        if (len == 0) {
            return res;
        }
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int rearProduct = 1;
        for (int j = len - 1; j >= 0; j--) {
            res[j] = res[j] * rearProduct;
            rearProduct *= nums[j];
        }
        return res;
    }

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     * For example
     * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     *
     *
     * 求出最高点，然后从左到右扫，再从右到左扫。
     */

    public int trap(int[] height) {
        int currentMax = 0;
        int sumResult = 0;
        int maxHeightIndex = findHighestInded(height);
        for (int index = 0; index < maxHeightIndex; index++) {
            if (currentMax <= height[index]) {
                currentMax = height[index];
            }
            sumResult += (currentMax - height[index]);
        }
        currentMax = 0;
        for (int index = height.length - 1; index > maxHeightIndex; index--) {
            if (currentMax <= height[index]) {
                currentMax = height[index];
            }
            sumResult += (currentMax - height[index]);
        }
        return sumResult;
    }

    private int findHighestInded(int[] height) {
        int maxIndex = 0;
        for (int index = 0; index < height.length; index++) {
            if (height[maxIndex] < height[index]) {
                maxIndex = index;
            }
        }
        return maxIndex;
    }

    /**
     *
     *
     *
     */
}

