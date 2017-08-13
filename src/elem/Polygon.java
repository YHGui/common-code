package elem;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过射线法判断是否在多边形内部，统计交点个数，若为奇数，在多边形内部，为偶数则在外部，时间复杂度为O(n),n为边数
 * Created by Katsura on 2017/5/25.
 */
public class Polygon {
    private final Builder.BoundingBox _boundingBox;
    private final List<Line> _sides;

    private Polygon(List<Line> sides, Builder.BoundingBox boundingBox) {
        _sides = sides;
        _boundingBox = boundingBox;
    }

    public static Builder Builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Point> _vertexes = new ArrayList<Point>();
        private List<Line> _sides = new ArrayList<Line>();
        private BoundingBox _boundingBox = null;

        private boolean _firstPoint = true;
        private boolean _isClosed = false;

        /**
         * 逐个增加顶点
         * @param point
         * @return
         */
        public Builder addVertex(Point point)
        {
            if (_isClosed)
            {
                _vertexes = new ArrayList<Point>();
                _isClosed = false;
            }

            updateBoundingBox(point);
            _vertexes.add(point);

            // add line (edge) to the polygon
            if (_vertexes.size() > 1)
            {
                Line Line = new Line(_vertexes.get(_vertexes.size() - 2), point);
                _sides.add(Line);
            }

            return this;
        }

        /**
         * 封闭起来
         * @return
         */
        public Builder close()
        {
            validate();

            // add last Line
            _sides.add(new Line(_vertexes.get(_vertexes.size() - 1), _vertexes.get(0)));
            _isClosed = true;

            return this;
        }

        /**
         * 构建多边形
         * @return
         */
        public Polygon build()
        {
            validate();

            if (!_isClosed)
            {
                _sides.add(new Line(_vertexes.get(_vertexes.size() - 1), _vertexes.get(0)));
            }

            Polygon polygon = new Polygon(_sides, _boundingBox);
            return polygon;
        }

        /**
         * 更新设置边界
         * @param point
         */
        private void updateBoundingBox(Point point) {
            if (_firstPoint) {
                _boundingBox = new BoundingBox();
                _boundingBox.xMax = point.x;
                _boundingBox.xMin = point.x;
                _boundingBox.yMax = point.y;
                _boundingBox.yMin = point.y;

                _firstPoint = false;
            }
            else {
                if (point.x > _boundingBox.xMax) {
                    _boundingBox.xMax = point.x;
                }
                else if (point.x < _boundingBox.xMin) {
                    _boundingBox.xMin = point.x;
                }
                if (point.y > _boundingBox.yMax) {
                    _boundingBox.yMax = point.y;
                }
                else if (point.y < _boundingBox.yMin) {
                    _boundingBox.yMin = point.y;
                }
            }
        }

        private void validate() {
            if (_vertexes.size() < 3) {
                throw new RuntimeException("Polygon must have at least 3 points");
            }
        }

        /**
         * 检查是否包含
         * @param point
         * @return
         */
        public boolean contains(Point point) {
            if (inBoundingBox(point)) {
                Line ray = createRay(point);
                int intersection = 0;
                for (Line side : _sides)
                {
                    if (intersect(ray, side)) {
                        intersection++;
                    }
                }

                if (intersection % 2 == 1)
                {
                    return true;
                }
            }
            return false;
        }
        public List<Line> getSides() {
            return _sides;
        }

        /**
         * 检测射线是否与多边形的边相交
         * @param ray
         * @param side
         * @return
         */
        private boolean intersect(Line ray, Line side) {
            Point intersectPoint = null;

            if (!ray.isVertical() && !side.isVertical()) {
                if (ray.getA() - side.getA() == 0) {
                    return false;
                }

                float x = ((side.getB() - ray.getB()) / (ray.getA() - side.getA())); // x = (b2-b1)/(a1-a2)
                float y = side.getA() * x + side.getB(); // y = a2*x+b2
                intersectPoint = new Point(x, y);
            }

            else if (ray.isVertical() && !side.isVertical()) {
                float x = ray.getStart().x;
                float y = side.getA() * x + side.getB();
                intersectPoint = new Point(x, y);
            }

            else if (!ray.isVertical() && side.isVertical()) {
                float x = side.getStart().x;
                float y = ray.getA() * x + ray.getB();
                intersectPoint = new Point(x, y);
            } else {
                return false;
            }
            if (side.isInside(intersectPoint) && ray.isInside(intersectPoint)) {
                return true;
            }

            return false;
        }

        /**
         * 向外发射产生射线
         * @param point
         * @return
         */
        private Line createRay(Point point) {
            float epsilon = (_boundingBox.xMax - _boundingBox.xMin) / 100f;
            Point outsidePoint = new Point(_boundingBox.xMin - epsilon, _boundingBox.yMin);

            Line vector = new Line(outsidePoint, point);
            return vector;
        }

        /**
         * 是否点在边界之内
         * @param point
         * @return
         */
        private boolean inBoundingBox(Point point) {
            if (point.x < _boundingBox.xMin || point.x > _boundingBox.xMax ||
                    point.y < _boundingBox.yMin || point.y > _boundingBox.yMax) {
                return false;
            }
            return true;
        }

        private static class BoundingBox {
            public float xMax = Float.NEGATIVE_INFINITY;
            public float xMin = Float.NEGATIVE_INFINITY;
            public float yMax = Float.NEGATIVE_INFINITY;
            public float yMin = Float.NEGATIVE_INFINITY;
        }
    }

}
