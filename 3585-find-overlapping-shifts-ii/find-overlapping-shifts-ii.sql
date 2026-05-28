/*
The problem requires us to calculate maximum number of overlapping shifts and the total duration of overlaps for each employee. We can apporach this by treating shift start and end times as separate events, then using these events to calculate concurrent shifts and overlap durations.

Approach:
1. Create a shift changes table that combines start and ent times, marking start with +1 and ends with -1.
2. Use a cumulative sum over these changes to calculate concurrent shifts at any given time.
3. Find the maximum number of concurrent shifts for each employee.
4. Calculate overlap durations by comparing each shift with all other shifts of the sam employee.
5. Combine the results using LEFT JOINs to include all employees, even those without overlaps.

Complexity: 
O(n^2)
Space: O(n)
*/
With shift_changes AS(
    SELECT employee_id, cast(start_time as date) as shift_date, start_time as change_time, 1 as shift_change
    FROM EmployeeShifts
    UNION ALL
    SELECT employee_id, cast(end_time as date) as shift_date, end_time as change_time, -1 as shift_change
    FROM EmployeeShifts
),
concurrent_shifts as(
    SELECT employee_id, shift_date, change_time, SUM(shift_change) OVER (PARTITION BY employee_id, shift_date ORDER BY change_time) AS concurrent_count 
    FROM shift_changes
),
max_overlaps AS (
    SELECT employee_id, MAX(concurrent_count) as max_overlapping_shifts FROM concurrent_shifts
    GROUP BY employee_id
),
overlap_durations as (
    SELECT e1.employee_id, SUM (
        (
            DATEDIFF(MINUTE,
                IIF(e1.start_time>e2.start_time, e1.start_time, e2.start_time),
                IIF(e1.start_time<e2.start_time, e1.end_time, e2.end_time))
            )
        ) AS total_overlap_duration
    FROM EmployeeShifts e1
    JOIN EmployeeShifts e2 ON e1.employee_id = e2.employee_id AND e1.start_time < e2.start_time
    WHERE e1.end_time > e2.start_time
    GROUP BY e1.employee_id
)
select 
    DISTINCT e.employee_id, COALESCE(m.max_overlapping_shifts,1) AS max_overlapping_shifts,
    COALESCE(o.total_overlap_duration, 0) as total_overlap_duration
FROM EmployeeShifts e
LEFT JOIN
    max_overlaps m on e.employee_id = m.employee_id
LEFT JOIN 
    overlap_durations o ON e.employee_id = o.employee_id
ORDER BY e.employee_id