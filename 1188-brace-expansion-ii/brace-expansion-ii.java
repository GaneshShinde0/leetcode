import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        List<Set<String>> stk = new ArrayList<>();
        stk.add(new HashSet<>(Arrays.asList("")));

        for (char c : expression.toCharArray()) {
            if (c == ',') {
                // stk[-2:] = [stk[-2] | stk[-1], {""}]
                Set<String> top = stk.remove(stk.size() - 1);
                Set<String> second = stk.remove(stk.size() - 1);
                Set<String> merged = new HashSet<>(second);
                merged.addAll(top);
                stk.add(merged);
                stk.add(new HashSet<>(Arrays.asList("")));
            } else if (c == '}') {
                // stk[-3:] = [{l+r for r in (stk[-1]|stk[-2]) for l in stk[-3]}]
                Set<String> top = stk.remove(stk.size() - 1);
                Set<String> second = stk.remove(stk.size() - 1);
                Set<String> third = stk.remove(stk.size() - 1);

                Set<String> union = new HashSet<>(second);
                union.addAll(top);

                Set<String> product = new HashSet<>();
                for (String l : third) {
                    for (String r : union) {
                        product.add(l + r);
                    }
                }
                stk.add(product);
            } else if (c == '{') {
                // stk += [set(), {""}]
                stk.add(new HashSet<>());
                stk.add(new HashSet<>(Arrays.asList("")));
            } else {
                // stk[-1] = {pre + ch for pre in stk[-1]}
                Set<String> top = stk.remove(stk.size() - 1);
                Set<String> newTop = new HashSet<>();
                for (String pre : top) {
                    newTop.add(pre + c);
                }
                stk.add(newTop);
            }
        }

        List<String> res = new ArrayList<>(stk.get(stk.size() - 1));
        Collections.sort(res);
        return res;
    }
}