import tester.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Point {
  int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}

class PointCompare implements Comparator<Point> {

  public int compare(Point p1, Point p2) {
    if (p1.x > p2.x) {
      return 1;
    } else if (p1.x < p2.x) {
      return -1;
    } else if (p1.x == p2.x) {
      if (p1.y > p2.y) {
        return 1;
      } else {
        return -1;
      }
    } else {
      return 0;
    }
  }
}

class PointDistanceCompare implements Comparator<Point> {

  public int compare(Point p1, Point p2) {
    Point cP = new Point(0, 0);
    if (p1.distance(cP) < p2.distance(cP)) {
      return -1;
    } else if (p1.distance(cP) < p2.distance(cP)) {
      return 1;
    } else {
      return 0;
    }
  }
}

class StringCompare implements Comparator<String> {
  
  public int compare(String str1, String str2) {
    return str1.compareTo(str2);
  }
}

class StringLengthCompare implements Comparator<String> {

  public int compare(String str1, String str2) {
    if (str1.length() > str2.length()) {
      return 1;
    } else if (str1.length() < str2.length()) {
      return -1;
    } else {
      return 0;
    }
  }
}

class BooleanCompare implements Comparator<Boolean> {

  public int compare(Boolean b1, Boolean b2) {
    return Boolean.compare(b1, b2);
  }
}