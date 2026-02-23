/* Write your T-SQL query statement below */
SELECT America, Asia, Europe
FROM
(
    SELECT name
    , continent
    , ROW_NUMBER() OVER(PARTITION BY continent ORDER BY name) AS rowNum
    FROM Student
)tab
PIVOT
(
    MIN(name)
    FOR continent IN (America, Asia, Europe)
)pvt