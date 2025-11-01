-- /* Write your T-SQL query statement below */
-- WITH CTE as(
--     SELECT account_id, ip_address, 
--         case when logout>=lead(login) over (partition by account_id order by login) and ip_address!=lead(ip_address) OVER 
--         (PARTITION BY account_id order by login) then 1 else 0 end as flag from loginfo
-- )

-- SELECT account_id FROM CTE WHERE flag = 1 GROUP BY account_id

SELECT l1.account_id FROM LogInfo l1 LEFT JOIN logInfo l2 on l1.account_id = l2.account_id 
AND l1.ip_address<>l2.ip_address 
AND l1.logout>=l2.login
and l1.login<=l2.logout
GROUP BY l1.account_id 
having count(l2.account_id)>1