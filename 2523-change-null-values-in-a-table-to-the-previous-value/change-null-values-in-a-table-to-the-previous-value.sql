-- We have to remember what last row was; incase current row is null.
-- The tool: Window Functions (Over Clause)
/*
Window functions perform a calculation across a set of table rows that are related to current row. Thye are "window" to see other rows. 
They are always used with an over() clause.. We can use a trick with COUNT() window function to create our groups.

Step 1: Create the Groups with COUNT()

The function COUNT(drink) only counts rows where the drink column is not nulll. 
WHEN we use it with OVER(Order BY id). It creates a running total of the non-null drinks encountered so far.
*/ 
/*
SELECT id, drink, 
-- This creates a running count of non-null drinks, ordered by id.
-- This count will act as our group identifier.
COUNT(drink) OVER (ORDER BY id ASC) as group_id
FROM 
CoffeeShop;
This query produces following result

| id | drink             | group_id |
| -- | ----------------- | -------- |
| 1  | Orange Margarita  | 1        |
| 2  | null              | 1        |
| 3  | St Germain Spritz | 2        |
| 6  | null              | 2        |
| 7  | null              | 2        |
| 9  | Rum and Coke      | 3        |

*/
/*
Note: The id s in the example are out of order, so the ORDER BY id is crucial. Our question asks us to provide rows which are in same order as input.
Same order as input? We can achieve this by giving blank order by... But SQL Server DOES NOT allow that, lets take order by null.
This will give us some id which maintains input ID.
Syntax for that in SQL Server will be 


WITH CTE as (
SELECT id,drink,
ROW_NUMBER() OVER(ORDER BY (SELECT NULL)) as row FROM CoffeeShop
)

*/
/*
We also want to get how many distinct drinks are present until each row.

SELECT id, drink, row, COUNT(DRINK) over(order by row) as count FROM CTE

*/

/*
We got how many distinct drinks are present .. now we will need to have ffirst value of that drink.

We can get that by
SELECT id, first_value(drink) OVER(PARTITION BY cnt order by rn) as drink
*/

WITH CTE AS (
    SELECT a.id, a.drink, row_number() OVER(ORDER BY (SELECT NULL)) as rn FROM CoffeeShop a
)
SELECT id, FIRST_VALUE(drink) OVER(PARTITION BY cnt ORDER BY rn) as drink
FROM(
    SELECT 
        id, drink, rn, count(drink) OVER(ORDER BY rn) as cnt
    FROM CTE
) as T