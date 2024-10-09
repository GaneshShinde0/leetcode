import pandas as pd

def findHeavyAnimals(animals: pd.DataFrame) -> pd.DataFrame:
    # Filter animals weighing strictly more than 100 kilograms
    filtered_animals = animals[animals['weight'] > 100]

    # Sort the filtered animals by weight in descending order
    sorted_animals = filtered_animals.sort_values(by='weight', ascending=False) 
    return sorted_animals

# Test cases generated with GitHub Copilot
def test_findHeavyAnimals():
    test_cases = [
        (pd.DataFrame({'name': [], 'weight': []}), pd.DataFrame({'name': [], 'weight': []})),  # Empty DataFrame
        (pd.DataFrame({'name': ['Elephant'], 'weight': [5000]}), pd.DataFrame({'name': ['Elephant'], 'weight': [5000]})),  # Single heavy animal
        (pd.DataFrame({'name': ['Mouse'], 'weight': [0.02]}), pd.DataFrame({'name': [], 'weight': []})),  # Single light animal
        (pd.DataFrame({'name': ['Elephant', 'Mouse'], 'weight': [5000, 0.02]}), pd.DataFrame({'name': ['Elephant'], 'weight': [5000]})),  # One heavy, one light
        (pd.DataFrame({'name': ['Elephant', 'Horse'], 'weight': [5000, 400]}), pd.DataFrame({'name': ['Elephant', 'Horse'], 'weight': [5000, 400]})),  # Two heavy animals
        (pd.DataFrame({'name': ['Elephant', 'Horse', 'Mouse'], 'weight': [5000, 400, 0.02]}), pd.DataFrame({'name': ['Elephant', 'Horse'], 'weight': [5000, 400]})),  # Two heavy, one light
        (pd.DataFrame({'name': ['Elephant', 'Horse', 'Dog'], 'weight': [5000, 400, 30]}), pd.DataFrame({'name': ['Elephant', 'Horse'], 'weight': [5000, 400]})),  # Two heavy, one light
        (pd.DataFrame({'name': ['Elephant', 'Horse', 'Dog', 'Cat'], 'weight': [5000, 400, 30, 5]}), pd.DataFrame({'name': ['Elephant', 'Horse'], 'weight': [5000, 400]})),  # Two heavy, two light
        (pd.DataFrame({'name': ['Elephant', 'Horse', 'Dog', 'Cat', 'Mouse'], 'weight': [5000, 400, 30, 5, 0.02]}), pd.DataFrame({'name': ['Elephant', 'Horse'], 'weight': [5000, 400]})),  # Two heavy, three light
        (pd.DataFrame({'name': ['Elephant', 'Horse', 'Dog', 'Cat', 'Mouse', 'Whale'], 'weight': [5000, 400, 30, 5, 0.02, 20000]}), pd.DataFrame({'name': ['Whale', 'Elephant', 'Horse'], 'weight': [20000, 5000, 400]}))  # Three heavy, three light
    ]

    for i, (df, expected) in enumerate(test_cases):
        result = findHeavyAnimals(df)
        pd.testing.assert_frame_equal(result.reset_index(drop=True), expected.reset_index(drop=True), check_dtype=False, check_like=True, obj=f"Test case {i+1}")

# Run tests
test_findHeavyAnimals()
