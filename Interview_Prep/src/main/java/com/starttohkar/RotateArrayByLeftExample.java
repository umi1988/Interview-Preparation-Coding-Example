package com.starttohkar;


/**
 * Example to rotate an array in Java left by k=2
 *
 *
 * Reversal algorithm
 * overall time complexity is O(n) and space complexity is O(1)
 *
 *
 * The 3-Step Core Logic
 *
 * To rotate an array of size n by k steps:
 *
 * 1. Normalize k: k = k % n (handles cases where k ≥ n).
 *
 * 2.Reverse the partitions:
 * 2.1 For Right Rotation (e.g., [1,2,3,4,5] by 2 → [4,5,1,2,3]):
 * Reverse the entire array.
 * Reverse the first k elements.
 * Reverse the remaining n - k elements.
 *
 * 2.2 For Left Rotation (e.g., [1,2,3,4,5] by 2 → [3,4,5,1,2]):
 * Reverse the first k elements.
 * Reverse the remaining n - k elements.
 * Reverse the entire array.
 *
 *
 */
public class RotateArrayByLeftExample {
    public static void rotateArrayLeftByK(int[] arr, int k){
        int len = arr.length;
        k = k % len;

        if(arr == null || k<0){
            throw new IllegalArgumentException("Illegal Arguments passed");
        }

        reverseLeft(arr, 0, k-1);

        reverseLeft(arr, k, len - 1);

        reverseLeft(arr, 0, len-1);


    }

    private static void reverseLeft(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start < 0 || end >= arr.length || start >= end) {
            return;
        }

        while(start<end){
            int tem = arr[start];
            arr[start] = arr[end];
            arr[end] = tem;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        System.out.println("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        rotateArrayLeftByK(arr, k);

        System.out.println("\nArray after left rotation by " + k + ": ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
