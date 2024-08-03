SELECT product_id, 'store1' as store, store1 AS price FROM products
WHERE store1 IS NOT NULL
UNION
SELECT product_id, 'store2' as store, store2 AS price FROM products
WHERE store2 IS NOT NULL
UNION
SELECT product_id, 'store3' as store, store3 AS price FROM products
WHERE store3 IS NOT NULL

/*SELECT product_id, store, price
FROM products
UNPIVOT (
    price FOR store IN (store1, store2, store3)
) AS unpivoted
WHERE price IS NOT NULL;
*/
