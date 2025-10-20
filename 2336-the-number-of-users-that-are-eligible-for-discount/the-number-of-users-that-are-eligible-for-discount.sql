CREATE FUNCTION getUserIDs(@startDate DATE, @endDate DATE, @minAmount INT) RETURNS INT AS
BEGIN
    RETURN (
        SELECT count(DISTINCT user_id) as user_cnt FROM Purchases WHERE time_stamp between @startDate and @endDate and amount>@minAmount
    );
END