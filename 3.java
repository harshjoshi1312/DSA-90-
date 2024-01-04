//3                                //query-kth-smallest-trimmed-number//



/* 
 * make the array with trimmed values, (store both index and value using a custom object class) 
 * sort it using it's "value" variable and then put it in a hashmap with it's associated trim value.
 *  Now, say we need to find the index of 4rd smallest value from nums trimmed to the 2nd rightmost value, we get the array assosiated with the trim value of 2, find the object at (4-1)th index, and get it's "index" variable.
 */



 class Solution {

    class Pair {
        int idx;
        String s;

        Pair(String s, int idx) {
            this.s = s;
            this.idx = idx;
        }
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        HashMap<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            String s = nums[i];
            int n = s.length();
            int l = n;

            for (int j = 0; j < n; j++) {
                map.putIfAbsent(l, new ArrayList<>());
                Pair p = new Pair(s.substring(j), i);
                map.get(l--).add(p);
            }
        }

        int ans[] = new int[queries.length];
        int idx = 0;
        for (int arr[] : queries) {
            int k = arr[0];
            int trim = arr[1];
            List<Pair> list = map.get(trim);

            Collections.sort(list, (a, b) -> {
                if (a.s.equals(b.s))
                    return a.idx - b.idx;
                return a.s.compareTo(b.s);
            });

            ans[idx++] = list.get(k - 1).idx;
        }
        return ans;
    }
}