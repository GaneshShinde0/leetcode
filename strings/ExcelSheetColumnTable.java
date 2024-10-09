class ExcelSheetColumnTable {
    public String convertToTitleWithStringBuilder(int columnNumber) {

        // Here we used StringBuilder so that performance will be faster
        StringBuilder title = new StringBuilder();
        while (columnNumber > 0) {
            // Adjust index to be 0-based for the calculation
            columnNumber--;
            // Find the corresponding letter for the current position
            title.append((char) ('A' + (columnNumber % 26)));
            // Move to the next digit
            columnNumber /= 26;
        }
        // The result is built backwards, so reverse it before returning
        return title.reverse().toString();
    }
    // Following will be roughly 10th to 100th times slower than String concatenation due to the reduction in overhead and memory allocation.
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber!=0){
            columnNumber--;
            sb.append((char) ('A'+columnNumber%26));
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }
}
