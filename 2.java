                       //2// high-access-employees   



/*Data Structure:

The solution uses a map named when to store access times for each employee. The key is the employee's name, and the value is a vector of access times.
Processing Input:
The input vector access_times is processed, and access times are stored in the map for each employee.
Checking Access Patterns:
The code iterates through each employee in the map.
Access times for each employee are sorted.
It checks for consecutive accesses within a 100-minute window.
Flagging High-Access Employees:
If an employee has consecutive accesses within a 100-minute window, the flag is set to true, indicating that the employee is a high-access employee.
Result Vector:
Names of high-access employees are stored in the ret vector.
Complexity
Time complexity:
O(klogk)O(klogk)O(klogk)

Space complexity:
O(n)O(n)O(n) */

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        int n = access_times.size();
        Map<String, List<Integer>> map = new HashMap<>();
        for(List<String> access_time : access_times){
            String employee = access_time.get(0);
            int time = Integer.valueOf(access_time.get(1));
            map.computeIfAbsent(employee, v->new ArrayList<>()).add(time);
        }
        List<String> defaulter = new ArrayList<>();
        for(String employee : map.keySet()){
            List<Integer> times = map.get(employee);
            if(times.size() <= 2)
                continue;
            Collections.sort(times);
            int len = times.size();
            for(int i=0; i<len-2; i++){
                if(times.get(i)+ 100 > times.get(i+1) && times.get(i)+ 100 > times.get(i+2)){
                    defaulter.add(employee);
                    break;
                }
            }
        }
        return defaulter;
    }
}
