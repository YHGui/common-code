package week4.proj1b.katsura;

/**
 * Created by Katsura on 2017/3/1.
 */
public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == 1) {
            return true;
        }

        return false;
    }
}
