
        //4                                                //    combination-sum-iii/







/*
 * pproach
Create 2 lists, one for the result and another for tracking current.
Create generate function for generating the list, accepting result list, current list, no of elements more required, required sum using current no of elements, and start element.
Generate checks if required element is 1 and required sum lies between start and n, if so add that to the current list and insert the list into result and remove the added element from the current list;
If the condition fails, generate starts a loop i = start till 9, and checks if the i is within n and n - i (new sum required) is greater than i (not taking the smaller elements under consideration).
If so, it add the element to the list and calls generate function again with k - 1 no of elements required to form n - i sum.
Complexity
Time complexity:
In the worst case, the code will generate all possible valid combinations of 'k' numbers from 1 to 9. The number of valid combinations is given by the binomial coefficient formula: C(9, k), which is n! / (k! * (n-k)!).

Therefore, the time complexity of the code is O(C(9, k)).

Space complexity:
The maximum depth of recursion is 'k'. Hence, the space complexity for recursion is O(k).

Code
 */



 class Solution {
    public static void generate(List<List<Integer>> result, List<Integer> list, int k, int n, int start) {
        if(k == 1 && start <= n && n <= 9) {
            list.add(n);
            result.add(new ArrayList<>(list));
            list.remove(Integer.valueOf(n));
            return;
        }
        for(int i = start; i <= 9; i++) {
            if(i <= n && n - i > i) {
                list.add(i);
                generate(result, list, k - 1, n - i, i + 1);
                list.remove(Integer.valueOf(i));
            }
            else break;
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generate(result, list, k, n, 1);
        return result;
    }
}