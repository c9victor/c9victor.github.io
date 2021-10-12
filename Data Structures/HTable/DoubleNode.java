public class DoubleNode {
  private double x;
  private double y; 
  private DoubleNode next;

  public DoubleNode(double _x, double _y, DoubleNode _next) {
    x = _x;
    y = _y;
    next = _next;
  }

  public double getX() {
    return x;
  }

  public void setX(double _key) {
    x = _key;
  }

  public DoubleNode getNext() {
    return next;
  }

  public void setNext(DoubleNode _next) {
    next = _next;
  }

  public double getY() {
    return y;
  }

  public void setY(double _key) {
    y = _key;
  }

}
