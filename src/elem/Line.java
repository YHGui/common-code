package elem;

/**
 * Created by Katsura on 2017/5/25.
 */
public class Line {
    private final Point START;
    private final Point END;
    private float a;
    private float b;
    private boolean _vertical = false;

    public Line(Point start, Point end) {
        this.START = start;
        this.END = end;
        if ((START.x - END.x) != 0) {
            a = (END.y - START.y) / (END.x - START.x);
            b = START.y - a * START.x;
        } else {
            _vertical = true;
        }
    }

    //判断是否在线段内
    public boolean isInside(Point point) {
        float maxX = START.x > END.x ? START.x : END.x;
        float minX = START.x < END.x ? START.x : END.x;
        float maxY = START.y > END.y ? START.y : END.y;
        float minY = START.y < END.y ? START.y : END.y;

        if ((point.x >= minX && point.x <= maxX) && (point.y >= minY && point.y <= maxY)) {
            return true;
        }
        return false;
    }

    public boolean isVertical() {
        return _vertical;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public Point getStart() {
        return START;
    }

    public Point getEnd() {
        return END;
    }
}
