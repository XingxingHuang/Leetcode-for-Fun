# Write your MySQL query statement below
/* get all the even numbered rows as odd numbered rows */
SELECT s1.id - 1 as id, s1.student
FROM Seat s1
WHERE s1.id MOD 2 = 0

UNION

/* get all the odd numbered rows as even numbered rows */
SELECT s2.id + 1 as id, s2.student
FROM Seat s2
WHERE s2.id MOD 2 = 1 AND s2.id != (SELECT MAX(id) FROM Seat)
/* Just don't get the last row as we will handle it in the next UNION */

UNION

/* get the last row if odd and don't change the id value */
SELECT s3.id, s3.student
FROM Seat s3
WHERE s3.id MOD 2 = 1 AND s3.id = (SELECT MAX(id) FROM Seat)

/* Order the result by id */
ORDER BY id ASC;





SELECT
    COUNT(*) AS counts
FROM
    seat


SELECT
    (CASE
        WHEN MOD(id, 2) != 0 AND counts != id THEN id + 1
        WHEN MOD(id, 2) != 0 AND counts = id THEN id
        ELSE id - 1
    END) AS id,
    student
FROM
    seat,
    (SELECT
        COUNT(*) AS counts
    FROM
        seat) AS seat_counts
ORDER BY id ASC;