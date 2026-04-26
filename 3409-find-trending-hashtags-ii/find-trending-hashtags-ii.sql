WITH CTE AS(
    SELECT value as hashtag, count(*) as count, rank() OVER (ORDER BY count(*) DESC, value DESC) as RNK
    FROM Tweets CROSS APPLY STRING_SPLIT(tweet, ' ')
    WHERE value like '#%' and MONTH(tweet_Date) = 2 and YEAR(tweet_date) = 2024 
    GROUP BY VALUE
)
SELECT hashtag, count FROM CTE WHERE RNK <= 3