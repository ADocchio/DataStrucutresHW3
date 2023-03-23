/**
 * @author Aden D'Occhio
 * Problem Description:
 * Given a string s, find the length of the longest substring without repeating characters.
 * -----------------------------------------------------------------------------
 * I solve this problem by useing a slideing window that moves acrros the string adding each charater to a current substring
 * untill a duplicate is found. here the substring if it is longer than the cuurent backup Substring is set to the backupSubstring
 * and the current sub is set to the current substring withought the duplication. this conintues acrros the string untill the end were
 * the length of the largest substring is returned. This was testeded using many test cases with no duplicates, duplicates, and even
 * strings that include there logest substring blocked by two repeating charaters. O(n) time complexity , space complexity
 * O(1)
 */

public class QuestionSeven {
    public static int lengthOfLongestSubstring(String s) {
      String currentSub = "";
      String backupSub = "";
      for(char c : s.toCharArray()){
        int restartIndex = currentSub.indexOf(c); // where duplication might occur
        if(restartIndex != -1){ // if duplicate found
          if(currentSub.length() > backupSub.length()){
            backupSub = currentSub;
          }
          currentSub = currentSub.substring(restartIndex + 1, currentSub.length()); //window reset to were duplication occurred
        }
        currentSub += c;
      }
      return Math.max(currentSub.length(), backupSub.length());
    }
}
