Select Top(3)
       value As hashtag,
       Count(value) As hashtag_count
From (Select tweet, tweet_date 
      From Tweets 
      Where tweet_date >= '2024-02-01' And tweet_date <= '2024-02-29')
Tweets
Cross Apply String_Split(tweet, ' ')
Where value Like '#%'
Group By value
Order By hashtag_count Desc, hashtag Desc
