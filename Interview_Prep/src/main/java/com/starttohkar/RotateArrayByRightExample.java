package com.starttohkar;

/**
 * Example to rotate an array in Java right by k=2
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
public class RotateArrayByRightExample {
    public static void rotateArrayRightByK(int[] arr, int k){
        int n = arr.length;
        k = k % n; // Normalize k

        if (arr == null || k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        // Step 1: Reverse the entire array
        reverse(arr, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(arr, 0, k - 1);

        // Step 3: Reverse the remaining n - k elements
        reverse(arr, k, n - 1);
    }

    public static void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0 || left < 0 || right >= arr.length || left >= right) {
            return;
        }

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        System.out.println("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        rotateArrayRightByK(arr, k);

        System.out.println("\nArray after rotating right by " + k + " positions: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
