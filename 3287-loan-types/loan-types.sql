# Write your MySQL query statement below
/*
SELECT distinct user_id FROM Loans where user_id in (SELECT user_id from Loans WHERE loan_type='Refinance') AND user_id in (SELECT user_id from loans where loan_type='Mortgage') order by user_id asc
*/
SELECT
    l1.user_id
FROM
    Loans l1
INNER JOIN
    Loans l2 ON l1.user_id = l2.user_id
WHERE
    l1.loan_type = 'Mortgage' AND l2.loan_type = 'Refinance'
GROUP BY
    l1.user_id
ORDER BY
    l1.user_id ASC;