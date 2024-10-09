class 1BitAnd2BitChars {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;

        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2; // Skip the next bit as it is part of a two-bit character
            } else {
                i += 1; // Move to the next bit
            }
        }

        // If we reach the last bit and it is at index n-1, it's a one-bit character
        return i == n - 1;
    }
}
