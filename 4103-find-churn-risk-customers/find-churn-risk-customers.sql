/* Write your T-SQL query statement below */
WITH LAST_EVENT AS(
    SELECT user_id, max(event_id) as last_event, max(monthly_amount) as max_historical_amount  FROM subscription_events GROUP BY user_id
),
ONE_DOWNGRADE AS(
    SELECT DISTINCT user_id FROM subscription_events WHERE event_type = 'downgrade'
),
SUBSCRIBER_FOR_60_DAYS AS(
    SELECT DISTINCT user_id, DATEDIFF(DAY, MIN(event_date),MAX(EVENT_DATE)) as days_as_subscriber  FROM subscription_events 
    GROUP BY user_id
),
CHURN_USERS AS (SELECT se.user_id, se.plan_name as current_plan , se.monthly_amount as current_monthly_amount, le.max_historical_amount, sf60.days_as_subscriber  FROM subscription_events se right join LAST_EVENT le on le.user_id = se.user_id and le.last_event = se.event_id 
JOIN SUBSCRIBER_FOR_60_DAYS sf60 on se.user_id = sf60.user_id 
JOIN ONE_DOWNGRADE od on se.user_id = od.user_id
where se.event_type <>'cancel' AND sf60.days_as_subscriber>=60 AND se.monthly_amount/le.max_historical_amount<0.5)
SELECT * FROM CHURN_USERS
ORDER BY days_as_subscriber DESC, user_id ASC