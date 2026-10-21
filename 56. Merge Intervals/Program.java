class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> toReturn = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        int highest = 0;

        for (int[] interval : intervals) {
            int cValue = map.getOrDefault(interval[0], -1);

            if (interval[1] > cValue) {
                map.put(interval[0], interval[1]);
            }

            if (interval[1] > highest) {
                highest = interval[1];
            }
        }

        int current = 0;

        int startOfCurrentRun = -1;
        int highestOfCurrentRun = -1;

        while (current <= highest) {
            int cValue = map.getOrDefault(current, -1);

            if (cValue > -1) {
                if (startOfCurrentRun == -1) {
                    startOfCurrentRun = current;
                }

                if (cValue > highestOfCurrentRun) {
                    highestOfCurrentRun = cValue;
                }
            }

            if (current == highestOfCurrentRun) {
                toReturn.add(new int[]{startOfCurrentRun, highestOfCurrentRun});
                startOfCurrentRun = -1;
                highestOfCurrentRun = -1;
            }

            current++;
        }

        if (startOfCurrentRun != -1) {
            toReturn.add(new int[]{startOfCurrentRun, highestOfCurrentRun});
        }

        return toReturn.toArray(new int[0][]);
    }
}