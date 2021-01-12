package leetCode._399_除法求值;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<String, String> parents;
    static Map<String, Double> val;


    public String find(String x) {

        if (!x.equals(parents.get(x))) {
            String tmpParent = parents.get(x);
            String root = find(tmpParent);
            double oldVal = val.get(x);
            val.put(x, oldVal * val.get(tmpParent));
            parents.put(x, root);
        }
        return parents.get(x);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parents = new HashMap<>();
        val = new HashMap<>();
        int i = 0;
        for (List<String> equation : equations) {
            String from = equation.get(0);
            String to = equation.get(1);
            double cur = values[i];
            if (!parents.containsKey(from) && !parents.containsKey(to)) {
                parents.put(from, to);
                val.put(from, cur);
                parents.put(to, to);
                val.put(to, 1.0);
            } else if (!parents.containsKey(from)) {
                parents.put(from, to);
                val.put(from, cur);
            } else if (!parents.containsKey(to)) {
                parents.put(to, from);
                val.put(to, 1 / cur);
            } else {
                String pa = find(from);
                String pb = find(to);
                if (!pa.equals(pb)) {
                    parents.put(pa, pb);
                    val.put(pa, cur * val.get(to) / val.get(from));
                }
            }
            i++;
        }
        i = 0;
        double[] res = new double[queries.size()];
        for (List<String> query : queries) {
            String from = query.get(0);
            String to = query.get(1);
            if (!parents.containsKey(from) || !parents.containsKey(to)) {
                res[i++] = -1;
                continue;
            }
            String pa = find(from);
            String pb = find(to);
            if (!pa.equals(pb)) res[i] = -1;
            else {
                res[i] = val.get(from) / val.get(to);
            }
            i++;
        }
        return res;
    }
}
