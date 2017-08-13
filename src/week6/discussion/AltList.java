package week6.discussion;

/**
 * Created by Katsura on 2017/3/2.
 */
public class AltList<X, Y> {
    private X item;
    private AltList<Y, X> next;
    AltList(X item, AltList<Y, X> next) {
        this.item = item;
        this.next = next;
    }

    public AltList<Y, X> pairsSwapped() {
        AltList<Y, X> ret = new AltList<Y, X>(next.item, new AltList<X,
                Y>(item, null));
        if (next.next != null) {
            ret.next.next = next.next.pairsSwapped();
        }
        return ret;
    }

    public static void main(String[] args) {
        AltList<Integer, String> list =
                new AltList<>(5,
                        new AltList<String, Integer>("cat",
                                new AltList<Integer, String>(10,
                                        new AltList<String, Integer>("dog", null))));
    }
}
