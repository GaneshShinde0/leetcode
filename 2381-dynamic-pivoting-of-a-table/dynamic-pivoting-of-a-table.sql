CREATE PROCEDURE PivotProducts AS
BEGIN

DECLARE @query as NVARCHAR(MAX)
DECLARE @store_columns as NVARCHAR(MAX)

SELECT @store_columns =  STRING_AGG('SUM(CASE WHEN store = ''' +store+''' THEN price else NULL END) as ['+store+']',',') WITHIN GROUP (ORDER BY Store ASC) FROM (SELECT DISTINCT store FROM Products) as src;
SET @query = 'SELECT product_id, ' +@store_columns+' FROM Products Group BY product_id'

EXEC(@query)
END
