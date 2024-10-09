import pandas as pd

def selectData(students: pd.DataFrame) -> pd.DataFrame:
    return students.loc[students['student_id'] == 101, ['name', 'age']]

# Test cases generated with GitHub Copilot
def test_selectData():
    test_cases = [
        (pd.DataFrame({'student_id': [], 'name': [], 'age': []}), pd.DataFrame({'name': [], 'age': []})),  # Empty DataFrame
        (pd.DataFrame({'student_id': [101], 'name': ['Alice'], 'age': [20]}), pd.DataFrame({'name': ['Alice'], 'age': [20]})),  # Single matching student
        (pd.DataFrame({'student_id': [102], 'name': ['Bob'], 'age': [21]}), pd.DataFrame({'name': [], 'age': []})),  # Single non-matching student
        (pd.DataFrame({'student_id': [101, 102], 'name': ['Alice', 'Bob'], 'age': [20, 21]}), pd.DataFrame({'name': ['Alice'], 'age': [20]})),  # One matching, one non-matching
        (pd.DataFrame({'student_id': [101, 101], 'name': ['Alice', 'Charlie'], 'age': [20, 22]}), pd.DataFrame({'name': ['Alice', 'Charlie'], 'age': [20, 22]})),  # Two matching students
        (pd.DataFrame({'student_id': [102, 103], 'name': ['Bob', 'David'], 'age': [21, 23]}), pd.DataFrame({'name': [], 'age': []})),  # Two non-matching students
        (pd.DataFrame({'student_id': [101, 102, 103], 'name': ['Alice', 'Bob', 'David'], 'age': [20, 21, 23]}), pd.DataFrame({'name': ['Alice'], 'age': [20]})),  # One matching, two non-matching
        (pd.DataFrame({'student_id': [101, 101, 101], 'name': ['Alice', 'Charlie', 'Eve'], 'age': [20, 22, 24]}), pd.DataFrame({'name': ['Alice', 'Charlie', 'Eve'], 'age': [20, 22, 24]})),  # Three matching students
        (pd.DataFrame({'student_id': [102, 103, 104], 'name': ['Bob', 'David', 'Frank'], 'age': [21, 23, 25]}), pd.DataFrame({'name': [], 'age': []})),  # Three non-matching students
        (pd.DataFrame({'student_id': [101, 102, 103, 104], 'name': ['Alice', 'Bob', 'David', 'Frank'], 'age': [20, 21, 23, 25]}), pd.DataFrame({'name': ['Alice'], 'age': [20]}))  # One matching, three non-matching
    ]

    for i, (df, expected) in enumerate(test_cases):
        result = selectData(df)
        pd.testing.assert_frame_equal(result.reset_index(drop=True), expected.reset_index(drop=True), check_dtype=False, check_like=True, obj=f"Test case {i+1}")

# Run tests
test_selectData()
