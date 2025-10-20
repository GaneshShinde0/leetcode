CREATE PROCEDURE getUserIDs(@startDate DATE, @endDate DATE, @minAmount INT) AS
BEGIN
    SELECT DISTINCT user_id FROM purchases where amount>=@minAmount and
    time_stamp between @startDate and @endDate ORDER BY user_id
END