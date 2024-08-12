/* Write your T-SQL query statement below */
SELECT 
    id,
    [Jan] AS Jan_Revenue,
    [Feb] AS Feb_Revenue,
    [Mar] AS Mar_Revenue,
    [Apr] AS Apr_Revenue,
    [May] AS May_Revenue,
    [Jun] AS Jun_Revenue,
    [Jul] AS Jul_Revenue,
    [Aug] AS Aug_Revenue,
    [Sep] AS Sep_Revenue,
    [Oct] AS Oct_Revenue,
    [Nov] AS Nov_Revenue,
    [Dec] AS Dec_Revenue
FROM 
    (SELECT id, revenue, month FROM Department) AS SourceTable
PIVOT
(
    MAX(revenue)
    FOR month IN ([Jan], [Feb], [Mar], [Apr], [May], [Jun], [Jul], [Aug], [Sep], [Oct], [Nov], [Dec])
) AS PivotTable
ORDER BY id;

/*
SELECT id,
SUM(IIF(month='Jan', revenue, NULL)) AS Jan_Revenue,
SUM(IIF(month='Feb', revenue, NULL)) AS Feb_Revenue,
SUM(IIF(month='Mar', revenue, NULL)) AS Mar_Revenue,
SUM(IIF(month='Apr', revenue, NULL)) AS Apr_Revenue,
SUM(IIF(month='May', revenue, NULL)) AS May_Revenue,
SUM(IIF(month='Jun', revenue, NULL)) AS Jun_Revenue,
SUM(IIF(month='Jul', revenue, NULL)) AS Jul_Revenue,
SUM(IIF(month='Aug', revenue, NULL)) AS Aug_Revenue,
SUM(IIF(month='Sep', revenue, NULL)) AS Sep_Revenue,
SUM(IIF(month='Oct', revenue, NULL)) AS Oct_Revenue,
SUM(IIF(month='Nov', revenue, NULL)) AS Nov_Revenue,
SUM(IIF(month='Dec', revenue, NULL)) AS Dec_Revenue
FROM Department
Group BY id;
*/
