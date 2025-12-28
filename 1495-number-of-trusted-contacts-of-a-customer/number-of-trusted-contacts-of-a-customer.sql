/* Write your T-SQL query statement below */

wITH CTE as (SELECT email from Customers)

SELECT invoice_id, cust.customer_name, price, COUNT(cnt.user_id) as contacts_cnt, COUNT(DISTINCT cust2.customer_name)  as trusted_contacts_cnt
FROM Invoices inv left join Customers cust on inv.user_id = cust.customer_id
LEFT JOIN Contacts cnt on inv.user_id = cnt.user_id
LEFT join customers cust2 on cnt.contact_email=cust2.email
GROUP BY 
 invoice_id, cust.customer_name, price