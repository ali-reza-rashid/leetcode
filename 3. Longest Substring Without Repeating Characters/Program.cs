public class Solution {
    public int LengthOfLongestSubstring(string s) {
        int[] charIndex = new int[128];
        Array.Fill(charIndex, -1);

        int highest = 0;
        int leftPointer = 0;

        for (int i=0; i<s.Length; i++) {
            char c = s[i];

            if (charIndex[c] >= leftPointer) {
                int size = i - leftPointer;
                if (size > highest) {
                    highest = size;
                }
                leftPointer = charIndex[c] + 1;
            }

            charIndex[c] = i;
        }
        
        int lastSize = s.Length - leftPointer;
        if (lastSize > highest) {
            highest = lastSize;
        }

        return highest;
    }
}