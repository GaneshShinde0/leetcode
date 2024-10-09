import pandas as pd
from typing import List

def getDataframeSize(players: pd.DataFrame) -> List[int]:
    return list(players.shape)

# Test cases generated with GitHub Copilot
def test_getDataframeSize():
    test_cases = [
        (pd.DataFrame(), [0, 0]),  # Empty DataFrame
        (pd.DataFrame({'A': []}), [0, 1]),  # DataFrame with one column, no rows
        (pd.DataFrame({'A': [1]}), [1, 1]),  # DataFrame with one column, one row
        (pd.DataFrame({'A': [1, 2, 3]}), [3, 1]),  # DataFrame with one column, three rows
        (pd.DataFrame({'A': [1, 2], 'B': [3, 4]}), [2, 2]),  # DataFrame with two columns, two rows
        (pd.DataFrame({'A': [1, 2, 3], 'B': [4, 5, 6], 'C': [7, 8, 9]}), [3, 3]),  # DataFrame with three columns, three rows
        (pd.DataFrame({'A': range(100)}), [100, 1]),  # DataFrame with one column, 100 rows
        (pd.DataFrame({'A': range(50), 'B': range(50)}), [50, 2]),  # DataFrame with two columns, 50 rows
        (pd.DataFrame({'A': range(10), 'B': range(10), 'C': range(10), 'D': range(10)}), [10, 4]),  # DataFrame with four columns, 10 rows
        (pd.DataFrame({'A': range(1000), 'B': range(1000), 'C': range(1000)}), [1000, 3])  # DataFrame with three columns, 1000 rows
    ]

    for i, (df, expected) in enumerate(test_cases):
        result = getDataframeSize(df)
        assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"

# Run tests
test_getDataframeSize()
