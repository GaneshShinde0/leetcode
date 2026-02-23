-- /* Write your T-SQL query statement below */
-- SELECT 
--     co.name AS country
-- FROM 
--     person p
--     JOIN 
--         country co
--         ON SUBSTRING(phone_number, 1,3) = country_code
--     JOIN 
--         calls c
--         ON p.id IN (c.caller_id,c.callee_id)
-- GROUP BY co.name
-- HAVING AVG(duration)>(SELECT AVG(duration) FROM CALLS)

WITH CallDetails AS (
    SELECT caller_id AS id, duration FROM Calls
    UNION ALL
    SELECT callee_id AS id, duration FROM Calls
)
SELECT 
    co.name AS country
FROM 
    Person p
JOIN 
    Country co
    ON SUBSTRING(p.phone_number, 1, 3) = co.country_code
JOIN 
    CallDetails c
    ON p.id = c.id
GROUP BY 
    co.name
HAVING 
    AVG(c.duration) > (SELECT AVG(duration) FROM Calls);