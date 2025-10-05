class GfG {
    public static int maxSum(String s) {
        int n = s.length();
        int[] left = new int[n], right = new int[n];

        // find longest odd-length palindrome ending 
        // at each position
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                left[r] = Math.max(left[r], 2 * (r - i + 1) - 1);
                l--; r++;
            }
        }

        // find longest odd-length palindrome starting 
        // at each position
        for (int i = n - 1; i >= 0; i--) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                right[l] = Math.max(right[l], 2 * (i - l + 1) - 1);
                l--; r++;
            }
        }

        // relax left array to get max till i
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i], left[i - 1]);
        }

        // relax right array to get max from i
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i], right[i + 1]);
        }

        // compute the answer by combining non-overlapping palindromes
        int maxi = 0;
        for (int i = 1; i < n; i++) {
            maxi = Math.max(maxi, left[i - 1] + right[i]);
        }

        return maxi;
    }

    public static void main(String[] args) {
        String s = "xyabacbcz";
        System.out.println(maxSum(s));
    }
}
