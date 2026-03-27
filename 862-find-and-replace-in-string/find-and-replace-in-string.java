class Solution {
    class IndexSourceTarget {
        int index;
        String source;
        String target;

        IndexSourceTarget(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }

    public String findReplaceStringInitial(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(s);
        int m = sources.length;
        IndexSourceTarget[] arr = new IndexSourceTarget[m];
        int diff = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = new IndexSourceTarget(indices[i], sources[i], targets[i]);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.index, b.index));
        for (int i = 0; i < m; i++) {
            IndexSourceTarget curr = arr[i];
            int idx = curr.index;
            String currSource = curr.source;
            String currTarget = curr.target;
            if (s.indexOf(currSource, idx) == idx) {
                sb.delete(idx + diff, idx + diff + currSource.length());
                sb.insert(idx + diff, currTarget);
                diff += currTarget.length() - currSource.length();
            }
        }
        return sb.toString();
    }

    public String findReplaceString2(String s, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++)
            sorted.add(new int[] { indexes[i], i });
        Collections.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        StringBuilder sb = new StringBuilder(s);
        int diff = 0;
        for (int[] ind : sorted) {
            int idx = ind[0], j = ind[1];
            String currSource = sources[j], currTarget = targets[j];
            if (s.indexOf(currSource, idx) == idx) {
                sb.delete(idx + diff, idx + diff + currSource.length());
                sb.insert(idx + diff, currTarget);
                diff += currTarget.length() - currSource.length();
            }
        }
        return sb.toString();
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        // match[i] will store the index of the replacement if one starts at s[i]
        int[] match = new int[n];
        Arrays.fill(match, -1);

        for (int i = 0; i < indices.length; i++) {
            // Check if the source matches at the specified index
            if (s.startsWith(sources[i], indices[i])) {
                match[indices[i]] = i;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n;) {
            if (match[i] != -1) {
                // If a valid replacement starts here, append the target
                int replacementIdx = match[i];
                res.append(targets[replacementIdx]);
                // Jump over the original source string
                i += sources[replacementIdx].length();
            } else {
                // Otherwise, keep the original character
                res.append(s.charAt(i));
                i++;
            }
        }
        return res.toString();
    }
}

/*
"vmokgggqzp"

-"vmosggqzp"
-"vmossozp"
-"vbfrssozp"


*/