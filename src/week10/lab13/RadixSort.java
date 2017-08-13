package week10.lab13;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra
 * @version 1.4 - April 14, 2016
 *
 **/
public class RadixSort
{

    /**
     * Does Radix sort on the passed in array with the following restrictions:
     *  The array can only have ASCII Strings (sequence of 1 byte characters)
     *  The sorting is stable and non-destructive
     *  The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     **/
    public static String[] sort(String[] asciis)
    {
        int len = asciis.length;
        String[] copy = new String[len];
        for (int i = 0; i < len; i++) {
            copy[i] = asciis[i];
        }
        sortHelper(copy, 0, len, 0);
        return copy;
    }

    /**
     * Radix sort helper function that recursively calls itself to achieve the sorted array
     *  destructive method that changes the passed in array, asciis
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelper(String[] asciis, int start, int end, int index) {
        int[] count = new int[256];
        int num =  end - start + 1;
        String[] temp = new String[num];
        for (int i = start; i <= end; i++) {
            count[asciis[start].charAt(index)]++;
        }
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < num; i++) {
            temp[count[asciis[i].charAt(index)]++] = asciis[i];
        }
        for (int i = 0; i < num; i++) {
            asciis[i] = temp[i];
        }
        for (int i = 0; i < 255; i++) {
            sortHelper(asciis, count[i], count[i + 1], index + 1);
        }
    }
}
