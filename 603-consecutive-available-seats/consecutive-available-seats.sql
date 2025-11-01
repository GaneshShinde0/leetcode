-- SELECT a.seat_id, a.free, b.seat_id, b.free FROM cinema a, cinema b;
-- SELECT a.seat_id, a.free, b.seat_id, b.free FROM cinema a join cinema b ON abs(a.seat_id-b.seat_id)=1 and a.free=1 and b.free=1;

SELECT distinct a.seat_id FROM cinema a join cinema b ON abs(a.seat_id-b.seat_id)=1 and a.free=1 and b.free=1 ORDER BY a.seat_id