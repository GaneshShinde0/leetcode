WITH valid_city as(
SELECT state, count(*) as matching_letter_Count from cities
WHERE LEFT(state,1) = left(city,1)
GROUP BY state
)

SELECT c.state, string_agg(city,', ') WITHIN group(ORDER BY city asc) as cities, MAX(matching_letter_Count) as matching_letter_Count
FROM valid_city vc, cities c
WHERE vc.state = c.state
GROUP BY c.state
having count(city)>=3
ORDER BY matching_letter_Count desc, state asc