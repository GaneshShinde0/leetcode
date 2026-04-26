WITH CTE AS(
    SELECT seat_id, seat_id-row_number() OVER (order by seat_id asc) as diff from Cinema Where Free=1
)
SELECT first_seat_id, last_seat_id, consecutive_seats_len FROM (
    SELECT min(seat_id) as first_seat_id, max(seat_id) as last_seat_id, count(*) as consecutive_seats_len, rank() OVER (order by count(*) DESC) as rnk
    FROM CTE group by diff
) src WHERE rnk = 1
ORDER BY first_seat_id asc 