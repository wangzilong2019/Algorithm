package bit.algorithm.recall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L690GetImportance {

    /**
     * 放入哈希表中因为哈希查询效率较高
     * @param info
     * @param id
     * @return
     */
    public int DFS(Map<Integer, Employee> info, int id) {
        //通过id获取当前员工
        Employee e = info.get(id);
        //获取当前员工的重要性
        int sum = e.importance;
        //获取当前员工的直系下属的重要性
        for (Integer im : e.subordinates) {
            sum += DFS(info, im);
        }
        return sum;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.isEmpty()) {
            return 0;
        }
        //将数据放入hash集合中
        Map<Integer, Employee> hashMap = new HashMap<>();
        for (Employee e : employees) {
            hashMap.put(e.id, e);
        }

        return DFS(hashMap, id);
    }
}

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};