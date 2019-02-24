package hliu.spring.pkg;

public class Point {

    private float x;
    private float y;
    private String msg;

    public Point(String msg, float x, float y) {
        this.x = x;
        this.y = y;
        this.msg = msg;
    }

    public Point(String msg, int x, int y) {
        this.x = x;
        this.y = y;
        this.msg = msg;
    }

    public Point(Point point) {
        this.msg = point.getMsg();
        this.x = point.getY();
        this.y = point.getY();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {return this.msg;}

    @Override
    public String toString() {
        return this.msg + "(" + getX() + "," + getY() + ")";
    }

}
