
SELECT user_id, gender from GENDERS 
ORDER BY DENSE_RANK() OVER (PARTITION BY Gender ORDER BY user_id asc) asc, len(gender) desc