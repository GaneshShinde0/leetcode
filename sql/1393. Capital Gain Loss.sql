/* Write your T-SQL query statement below */
SELECT DISTINCT stock_name, capital_gain_loss = SUM(CASE WHEN OPERATION = 'Sell' then price end) - SUM(Case When Operation='Buy' then price end)
FROM Stocks
GROUP by stock_name;

/*
SELECT stock_name, 
	SUM(CASE WHEN operation = 'Buy' THEN -price ELSE price END) AS capital_gain_loss
FROM Stocks
GROUP BY stock_name

SELECT stock_name, SUM(IIF(operation = 'Sell', 1, -1) * price) AS capital_gain_loss
FROM Stocks
GROUP BY stock_name;

SELECT 
     DISTINCT
     stock_name,
     SUM(CASE WHEN operation = 'Sell' THEN price ELSE NULL END) 
        OVER(PARTITION BY Stock_name ORDER BY (SELECT NULL)) -
     SUM(CASE WHEN operation = 'Buy' THEN price ELSE NULL END) 
        OVER(PARTITION BY Stock_name ORDER BY (SELECT NULL)) capital_gain_loss
FROM
    Stocks

    SELECT DISTINCT
    stock_name,
    -- data from tblStockGroup 
    -- LAST_VALUE is Sell data, FIRST_VALUE is Buy data
    -- result = LAST_VALUE - FIRST_VALUE
    LAST_VALUE(price) OVER(PARTITION BY stock_name ORDER BY (SELECT NULL))
    -
    FIRST_VALUE(price) OVER( PARTITION BY stock_name ORDER BY (SELECT NULL)) capital_gain_loss
FROM
    (
        SELECT
            stock_name,
            SUM(price) price
            -- per stock_name has 2 rows
            -- 1 row for sell and 1 row for Buy
        FROM
            Stocks
        GROUP BY
            stock_name,
            operation
    )tblStockGroup;
*/
