import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Aden D'Occhio
 * Problem Description:
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * ----------------------------------------------------------------
 * This probelm was sovled by first sorting the interval array by the starting index of each meeting time. now that we
 * have an ordered list we can spimple look to see if the result is empty or no overlap occures with the next meeting time to
 * decide if we want to add it to the result list. if a overlap occurs then we simply take the last element from the linked list
 * and merge the two meeting times into a simplified form. this is then repeated for each interval in intervals.
 * time complexity O(nlogn) space complexity is O(n)
 */
public class QuestionEight {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //sorts intervals by start int O(nlog(n))
    LinkedList<int[]> merged = new LinkedList<>();

    for (int[] interval : intervals) {
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      }
      else { // overlap occurred
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
}


