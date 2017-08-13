package week4.proj1b.katsura;

/**
 * Created by Katsura on 2017/3/1.
 */
public class OffByN implements CharacterComparator {
    int num;

    public OffByN(int num) {
        this.num = num;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == num) {
            return true;
        }

        return false;
    }
}
