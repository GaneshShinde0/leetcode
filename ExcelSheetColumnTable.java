class ExcelSheetColumnTable {
    public String convertToTitle(int columnNumber) {
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
}
