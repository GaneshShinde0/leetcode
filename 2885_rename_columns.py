import pandas as pd

def renameColumns(employees: pd.DataFrame) -> pd.DataFrame:
    columns_to_rename = {
        'id': 'employee_id',
        'first': 'first_name',
        'last': 'last_name',
        'age': 'age_in_years'
    }
    
    employees.rename(columns=columns_to_rename, inplace=True)
    
    return employees

# Test cases generated with GitHub Copilot
def test_renameColumns():
    test_cases = [
        (pd.DataFrame({'id': [], 'first': [], 'last': [], 'age': []}), pd.DataFrame({'employee_id': [], 'first_name': [], 'last_name': [], 'age_in_years': []})),  # Empty DataFrame
        (pd.DataFrame({'id': [1], 'first': ['John'], 'last': ['Doe'], 'age': [30]}), pd.DataFrame({'employee_id': [1], 'first_name': ['John'], 'last_name': ['Doe'], 'age_in_years': [30]})),  # Single row
        (pd.DataFrame({'id': [1, 2], 'first': ['John', 'Jane'], 'last': ['Doe', 'Smith'], 'age': [30, 25]}), pd.DataFrame({'employee_id': [1, 2], 'first_name': ['John', 'Jane'], 'last_name': ['Doe', 'Smith'], 'age_in_years': [30, 25]})),  # Multiple rows
        (pd.DataFrame({'id': [1, 2, 3], 'first': ['John', 'Jane', 'Alice'], 'last': ['Doe', 'Smith', 'Johnson'], 'age': [30, 25, 28]}), pd.DataFrame({'employee_id': [1, 2, 3], 'first_name': ['John', 'Jane', 'Alice'], 'last_name': ['Doe', 'Smith', 'Johnson'], 'age_in_years': [30, 25, 28]})),  # Multiple rows with different names
    ]

    for i, (df, expected) in enumerate(test_cases):
        result = renameColumns(df.copy())  # Use copy to avoid modifying the original test case
        pd.testing.assert_frame_equal(result, expected, check_dtype=False, check_like=True, obj=f"Test case {i+1}")

# Run tests
test_renameColumns()
