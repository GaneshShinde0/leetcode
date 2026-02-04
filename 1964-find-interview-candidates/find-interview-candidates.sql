/* Write your T-SQL query statement below */

WITH gotmedal as (
    SELECT gold_medal as [user], contest_id from contests
    UNION ALL 
    SELECT silver_medal as [user], contest_id from contests
    UNION ALL 
    SELECT bronze_medal as [user], contest_id from contests
),
userToConest as (
    SELECT [user], contest_id, row_number() OVER(PARTITION BY [user] ORDER BY contest_id) as rn from gotmedal
),
result as (
    SELECT [user] as user_id FROM userToConest
    GROUP BY  [user], contest_id - rn
    HAVING count(*) >= 3

    UNION ALL

    SELECT gold_medal as user_id FROM contests GROUP BY gold_medal having count(*)>=3
)
SELECT distinct u.name, u.mail FROM result left join users u on result.user_id = u.user_id