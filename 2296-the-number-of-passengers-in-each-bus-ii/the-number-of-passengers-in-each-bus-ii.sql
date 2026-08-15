WITH 

    -- Adding a column to track the arrival time of the previous bus
    UpdatedBuses AS (
        SELECT
            B.bus_id,
            B.arrival_time,
            B.capacity,
            -- Use LAG to find the arrival time of the previous bus
            COALESCE(LAG(B.arrival_time) OVER (ORDER BY B.arrival_time), 0) AS previous_bus_arrival
        FROM Buses B
    ),

    -- Counting new passengers arriving between the current and previous bus
    PassengerArrivalCounts AS (
        SELECT
            B.bus_id,
            B.arrival_time,
            B.capacity,
            B.previous_bus_arrival,
            -- Counting passengers arriving after the previous bus and before this bus
            COUNT(P.passenger_id) AS new_passengers,
            ROW_NUMBER() OVER (ORDER BY B.arrival_time) AS bus_sequence_number
        FROM UpdatedBuses B
        LEFT JOIN Passengers P
            ON P.arrival_time <= B.arrival_time AND P.arrival_time > B.previous_bus_arrival
        GROUP BY B.bus_id, B.arrival_time, B.capacity, B.previous_bus_arrival
    ),

    -- Recursive CTE to calculate passengers boarded and remaining for each bus
    BusBoardingDetails AS (
        -- Base case: Processing the first bus
        SELECT
            bus_sequence_number,
            bus_id,
            -- Boarding passengers limited by bus capacity
            IIF(capacity<new_passengers, capacity, new_passengers) AS passengers_boarded,
            -- Remaining passengers who couldn't board the bus
            (new_passengers - IIF(capacity<new_passengers, capacity, new_passengers)) AS passengers_remaining
        FROM PassengerArrivalCounts
        WHERE bus_sequence_number = 1

        UNION ALL

        -- Recursive case: Processing subsequent buses
        SELECT
            PAC.bus_sequence_number,
            PAC.bus_id,
            -- Boarding passengers, considering remaining passengers from previous buses
            IIF(PAC.capacity< PAC.new_passengers + REC.passengers_remaining, PAC.capacity, PAC.new_passengers + REC.passengers_remaining) AS passengers_boarded,
            -- Calculating remaining passengers
            (PAC.new_passengers + REC.passengers_remaining) - IIF(PAC.capacity< PAC.new_passengers + REC.passengers_remaining, PAC.capacity, PAC.new_passengers + REC.passengers_remaining) AS passengers_remaining
        FROM
            BusBoardingDetails REC,
            PassengerArrivalCounts PAC
        WHERE
            PAC.bus_sequence_number = REC.bus_sequence_number + 1
    )

-- Selecting the final bus boarding details
SELECT
    bus_id,
    passengers_boarded AS passengers_cnt
FROM BusBoardingDetails
ORDER BY bus_id;