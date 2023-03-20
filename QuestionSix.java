import java.util.HashMap;

/**
 * @author Aden D'Occhio
 * Problem Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that
 * they add up to target.
 * ----------------------------------------------------------------
 * I solve this problem by putting the nums array into a hashmap takeing o(n) time. then I look through the nums array takeing
 * the target - the current index and see if the value is in the map, if so return the indexs of both values.
 */
public class QuestionSix {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length;i++){ //load map
      map.put(nums[i], i);
    }

    for(int j = 0; j < nums.length;j++){ //find partner
      Integer partner = map.get(target - nums[j]);
      if(partner != null && partner != j){
        return new int[]{j, map.get(target - nums[j])};
      }
    }
    return new int[]{-1, -1};
  }
}
