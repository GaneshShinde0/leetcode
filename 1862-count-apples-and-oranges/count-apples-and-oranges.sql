/* Write your T-SQL query statement below */
SELECT SUM(b.apple_count)+COALESCE(sum(c.apple_count),0) as apple_count , SUM(b.orange_count)+COALESCE(SUM(c.orange_count),0) as orange_count FROM
Boxes b left join
Chests c on b.chest_id=c.chest_id