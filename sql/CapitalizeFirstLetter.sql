SELECT user_id, CONCAT(UPPER(LEFT(name,1)),LOWER(RIGHT(name,LEN(name)-1))) as name from Users ORDER BY user_id
