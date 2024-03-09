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

  void testMaximumList(Tester t) {
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

  <E> E maximum(E[] arr, Comparator<E> comparator) {
    if (arr.length < 1) {
      return null;
    }

    E max = arr[0];

    for (E elem : arr) {
      if (comparator.compare(elem, max) > 0) {
        max = elem;
      }
    }
    return max;
  }

  void testMaximumArray(Tester t) {
    Integer[] intArr1 = {1, 2, 3, 3};
    Integer[] intArr2 = {};
    Integer[] intArr3 = {1, 2, 3, -1, -2, -3, 4};
    Integer[] intArr4 = {-1, -2, -3, 0, -4, 0};
    Comparator<Integer> integerComparator = Comparator.naturalOrder();
    t.checkExpect(maximum(intArr1, integerComparator), 3);
    t.checkExpect(maximum(intArr2, integerComparator), null);
    t.checkExpect(maximum(intArr3, integerComparator), 4);
    t.checkExpect(maximum(intArr4, integerComparator), 0);

    String[] strArr1 = {"a", "b", "c"};
    String[] strArr2 = {};
    String[] strArr3 = {"z", "d", "q", "Z"};
    String[] strArr4 = {"A", "B", "C", "I"};
    Comparator<String> stringComparator = Comparator.naturalOrder();
    t.checkExpect(maximum(strArr1, stringComparator), "c");
    t.checkExpect(maximum(strArr2, stringComparator), null);
    t.checkExpect(maximum(strArr3, stringComparator), "z");
    t.checkExpect(maximum(strArr4, stringComparator), "I");

    Boolean[] boolArr1 = {true, false, true};
    Boolean[] boolArr2 = {};
    Boolean[] boolArr3 = {false, false, false};
    Boolean[] boolArr4 = {true, true, true};
    Comparator<Boolean> booleanComparator = Comparator.naturalOrder();
    t.checkExpect(maximum(boolArr1, booleanComparator), true);
    t.checkExpect(maximum(boolArr2, booleanComparator), null);
    t.checkExpect(maximum(boolArr3, booleanComparator), false);
    t.checkExpect(maximum(boolArr4, booleanComparator), true);
  }

  <E> List<E> lesserThan(List<E> elst, Comparator<E> comparator, E element) {
    List<E> output = new ArrayList<>();
    for (E elem : elst) {
      if (comparator.compare(elem, element) < 0) {
        output.add(elem);
      }
    }
    return output;
  }
  
  void testLesserThan(Tester t) {
  
    ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    Comparator<Integer> intComparator = Comparator.naturalOrder();
    t.checkExpect(lesserThan(intList, intComparator, 4), Arrays.asList(1, 2, 3));
  
    
    ArrayList<String> strList = new ArrayList<>(Arrays.asList("apple", "banana", "grape", "orange"));
    Comparator<String> strComparator = Comparator.naturalOrder();
    t.checkExpect(lesserThan(strList, strComparator, "orange"), Arrays.asList("apple", "banana", "grape"));
  
    
    ArrayList<Boolean> boolList = new ArrayList<>(Arrays.asList(true, false, true, false, true));
    Comparator<Boolean> boolComparator = Comparator.naturalOrder();
    t.checkExpect(lesserThan(boolList, boolComparator, true), Arrays.asList(false, false));
  }

  <E> boolean inOrder(List<E> lst, Comparator<E> comparator) {
    if (lst.isEmpty() || lst.size() == 1) {
      return true;
    }

    for (int i = 0; i < lst.size() - 1; i++) {
      E current = lst.get(i);
      E next = lst.get(i + 1);

      if (current.equals(null) || next.equals(null)) {
        throw new IllegalArgumentException("null value in list");
      }

      if (current.equals(next) || comparator.compare(current, next) > 0) {
        return false;
      }
    }
    return true;
}

  void testInOrder(Tester t) {
    ArrayList<Integer> intList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    ArrayList<Integer> intList2 = new ArrayList<>();
    ArrayList<Integer> intList3 = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    ArrayList<Integer> intList4 = new ArrayList<>(Arrays.asList(1));
    ArrayList<Integer> intList5 = new ArrayList<>(Arrays.asList(1,1,1,1));
    Comparator<Integer> integerComparator = Comparator.naturalOrder();
    t.checkExpect(inOrder(intList1, integerComparator), true);
    t.checkExpect(inOrder(intList2, integerComparator), true);
    t.checkExpect(inOrder(intList3, integerComparator), false);
    t.checkExpect(inOrder(intList4, integerComparator), true);
    t.checkExpect(inOrder(intList5, integerComparator), false);

    ArrayList<String> strList1 = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));
    ArrayList<String> strList2 = new ArrayList<>();
    ArrayList<String> strList3 = new ArrayList<>(Arrays.asList("orange", "banana", "apple"));
    ArrayList<String> strList4 = new ArrayList<>(Arrays.asList("pear"));
    Comparator<String> stringComparator = Comparator.naturalOrder();
    t.checkExpect(inOrder(strList1, stringComparator), true);
    t.checkExpect(inOrder(strList2, stringComparator), true);
    t.checkExpect(inOrder(strList3, stringComparator), false);
    t.checkExpect(inOrder(strList4, stringComparator), true);

    ArrayList<Boolean> boolList1 = new ArrayList<>(Arrays.asList(true, true, true));
    ArrayList<Boolean> boolList2 = new ArrayList<>();
    ArrayList<Boolean> boolList3 = new ArrayList<>(Arrays.asList(true, false, true));
    ArrayList<Boolean> boolList4 = new ArrayList<>(Arrays.asList(false, false, false));
    Comparator<Boolean> booleanComparator = Comparator.naturalOrder();
    t.checkExpect(inOrder(boolList1, booleanComparator), false);
    t.checkExpect(inOrder(boolList2, booleanComparator), true);
    t.checkExpect(inOrder(boolList3, booleanComparator), false);
    t.checkExpect(inOrder(boolList4, booleanComparator), false);
  }

  <E> boolean inOrder(E[] eArr, Comparator<E> comparator) {

    if (eArr.length <= 1) {
      return true;
    }

    for (int i = 0; i < eArr.length - 1; i++) {
      E curr = eArr[i];
      E next = eArr[i + 1];

      if (curr == null || next == null) {
        throw new IllegalArgumentException("null value in array");
      }

      if (curr.equals(next) || comparator.compare(curr, next) > 0) {
        return false;
      }
    }
    return true;
  }

  void testInOrderArray(Tester t) {
    
    Integer[] intArr1 = {1, 2, 3, 4, 5};
    Integer[] intArr2 = {};
    Integer[] intArr3 = {5, 4, 3, 2, 1};
    Integer[] intArr4 = {1};
    Integer[] intArr5 = {1, 1, 1, 1}; 
    t.checkExpect(inOrder(intArr1, Comparator.naturalOrder()), true);
    t.checkExpect(inOrder(intArr2, Comparator.naturalOrder()), true);
    t.checkExpect(inOrder(intArr3, Comparator.naturalOrder()), false);
    t.checkExpect(inOrder(intArr4, Comparator.naturalOrder()), true);
    t.checkExpect(inOrder(intArr5, Comparator.naturalOrder()), false);

    String[] strArr1 = {"apple", "banana", "grape", "orange"};
    String[] strArr2 = {};
    String[] strArr3 = {"orange", "grape", "banana", "apple"};
    String[] strArr4 = {"pear"};
    String[] strArr5 = {"apple", "banana", "banana", "orange"}; 
    t.checkExpect(inOrder(strArr1, Comparator.naturalOrder()), true);
    t.checkExpect(inOrder(strArr2, Comparator.naturalOrder()), true);
    t.checkExpect(inOrder(strArr3, Comparator.naturalOrder()), false);
    t.checkExpect(inOrder(strArr4, Comparator.naturalOrder()), true);
    t.checkExpect(inOrder(strArr5, Comparator.naturalOrder()), false);
    
    Boolean[] boolArr1 = {true, true, true, true};
    Boolean[] boolArr2 = {};
    Boolean[] boolArr3 = {true, false, true};
    Boolean[] boolArr4 = {false, false, false};
    Boolean[] boolArr5 = {true, false, false, true}; 
    t.checkExpect(inOrder(boolArr1, Comparator.naturalOrder()), false);
    t.checkExpect(inOrder(boolArr2, Comparator.naturalOrder()), true);
    t.checkExpect(inOrder(boolArr3, Comparator.naturalOrder()), false);
    t.checkExpect(inOrder(boolArr4, Comparator.naturalOrder()), false);
    t.checkExpect(inOrder(boolArr5, Comparator.naturalOrder()), false);
  }

  <E> List<E> merge(Comparator<E> comparator, List<E> lst1, List<E> lst2) {
    List<E> merged = new ArrayList<>(lst1.size() + lst2.size());
    for (E elem : lst1) {
      if (elem == null) {
        throw new IllegalArgumentException("null value in first list");
      } else {
        merged.add(elem);
      }
    } 
    for (E elem : lst2) {
      if (elem == null) {
        throw new IllegalArgumentException("null value in second list");
      } else {
        merged.add(elem);
      }
    }
    merged.sort(comparator);
    return merged;
  }

  void testMerged(Tester t) {
    List<Integer> l1 = Arrays.asList(1,0,3,5);
    List<Integer> l2 = Arrays.asList(1,2,3,4);
    List<Integer> l3 = Arrays.asList(-1, 8);
    List<Integer> l4 = Arrays.asList(4,5,6,-2);
    List<Integer> l5 = Arrays.asList(4,5,null,-2);
    Comparator<Integer> intComparator = Comparator.naturalOrder();
    t.checkExpect(merge(intComparator, l1, l2), new ArrayList<>(Arrays.asList(0,1,1,2,3,3,4,5)));
    t.checkExpect(merge(intComparator, l3, l4), new ArrayList<>(Arrays.asList(-2,-1,4,5,6,8)));
    t.checkException(new IllegalArgumentException("null value in first list"), this, "merge", merge(intComparator, l5, l3));
  }
}