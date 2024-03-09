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
    return Boolean.compare(b1, b2);                     // AS THIS
  }
}

class CompareLists {

  <E> E maximum(List<E> lst, Comparator<E> comparator) {
    if (lst.isEmpty()) {
      return null;
    }
    
    E max = lst.get(0);

    for (E elem : lst) {
      if (comparator.compare(elem, max) > 0) {           // the comparator.compare will essentially look like ^^^
        max = elem;                                      // when it is called :p 
      }
    }
    return max;
  }

  void testMaximum(Tester t) {
    List<Integer> Ilst1 = Arrays.asList(1,2,3,3); 
    List<Integer> Ilst2 = Arrays.asList();
    List<Integer> Ilst3 = Arrays.asList(1,2,3,-1,-2,-3,4); 
    List<Integer> Ilst4 = Arrays.asList(-1,-2,-3, 0,-4, 0); 
    Comparator<Integer> integerComparator = Comparator.naturalOrder();
    t.checkExpect(maximum(Ilst1, integerComparator), 3);
    t.checkExpect(maximum(Ilst2, integerComparator), null);
    t.checkExpect(maximum(Ilst3, integerComparator), 4);
    t.checkExpect(maximum(Ilst4, integerComparator), 0);
  
    List<String> Slst1 = Arrays.asList("a", "b", "c");
    List<String> Slst2 = Arrays.asList();
    List<String> Slst3 = Arrays.asList("z", "d", "q", "Z");
    List<String> Slst4 = Arrays.asList("A", "B", "C", "I");
    Comparator<String> stringComparator = Comparator.naturalOrder();
    t.checkExpect(maximum(Slst1, stringComparator), "c");
    t.checkExpect(maximum(Slst2, stringComparator), null);
    t.checkExpect(maximum(Slst3, stringComparator), "z");
    t.checkExpect(maximum(Slst4, stringComparator), "I");
  
    List<Boolean> Blst1 = Arrays.asList(true, false, true);
    List<Boolean> Blst2 = Arrays.asList();
    List<Boolean> Blst3 = Arrays.asList(false, false, false);
    List<Boolean> Blst4 = Arrays.asList(true, true, true);
    Comparator<Boolean> booleanComparator = Comparator.naturalOrder();
    t.checkExpect(maximum(Blst1, booleanComparator), true);
    t.checkExpect(maximum(Blst2, booleanComparator), null);
    t.checkExpect(maximum(Blst3, booleanComparator), false);
    t.checkExpect(maximum(Blst4, booleanComparator), true);
  }

}