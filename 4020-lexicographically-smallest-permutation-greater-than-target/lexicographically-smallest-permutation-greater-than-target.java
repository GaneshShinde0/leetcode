class Solution {
    public String lexGreaterPermutation(String s, String target) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // start with smallest permutation
        boolean[] used = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        String res = dfs(arr, used, sb, target, 0);
        return res == null ? "" : res;
    }

    private String dfs(char[] arr, boolean[] used, StringBuilder sb, String target, int idx) {
        if (idx == arr.length) {
            String candidate = sb.toString();
            if (candidate.compareTo(target) > 0) return candidate;
            return null;
        }

        char prev = 0;
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            if (arr[i] == prev) continue; // skip duplicates to avoid repeated branches
            prev = arr[i];

            // Prune: if we are still matching target and arr[i] < target[idx], skip
            if (sb.toString().compareTo(target.substring(0, idx)) == 0 && arr[i] < target.charAt(idx))
                continue;

            used[i] = true;
            sb.append(arr[i]);
            String result = dfs(arr, used, sb, target, idx + 1);
            if (result != null) return result;
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
        return null;
    }
}
