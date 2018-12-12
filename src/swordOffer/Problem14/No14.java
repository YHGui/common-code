package swordOffer.Problem14;

public class No14 {
    public static void main(String[] args) {
        int[] array={3,7,4,8,23,56,77,89,46,11,66,77};
        reorder(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void reorder(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while (left < right && (arr[right] & 1) == 0) {
                right -= 1;
            }

            while (left < right && (arr[left] & 1) == 1) {
                left += 1;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }
}
