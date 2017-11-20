select distinct t1.*
from stadium t1, stadium t2, stadium t3
where t1.people >= 100 and t2.people >= 100 and t3.people >= 100
and
(
      (t1.id - t2.id = 1 and t1.id - t3.id = 2 and t2.id - t3.id =1)  -- t1, t2, t3
    or
    (t2.id - t1.id = 1 and t2.id - t3.id = 2 and t1.id - t3.id =1) -- t2, t1, t3
    or
    (t3.id - t2.id = 1 and t2.id - t1.id =1 and t3.id - t1.id = 2) -- t3, t2, t1
)
order by t1.id



select * 
FROM (
    SELECT s1.id, s1.date, s1.people
    FROM
    stadium s1, stadium s2, stadium s3
    WHERE s1.id = s2.id - 1 AND s1.id = s3.id + 1
          AND s1.people >= 100 
          AND s2.people >= 100 
          AND s3.people >= 100 

    UNION 

    SELECT s1.id, s1.date, s1.people
    FROM
    stadium s1, stadium s2, stadium s3
    WHERE s1.id = s2.id + 1 AND s1.id = s3.id + 2
          AND s1.people >= 100 
          AND s2.people >= 100 
          AND s3.people >= 100 


    UNION 

    SELECT s1.id, s1.date, s1.people
    FROM
    stadium s1, stadium s2, stadium s3
    WHERE s1.id = s2.id - 1 AND s1.id = s3.id - 2
          AND s1.people >= 100 
          AND s2.people >= 100 
          AND s3.people >= 100 
) as s
order by s.id 


########
# WRONG : Incorrect usage of UNION and ORDER BY
#####
SELECT *
from (
    SELECT s1.id, s1.date, s1.people
    FROM
    stadium s1, stadium s2, stadium s3
    WHERE s1.id = s2.id - 1 AND s1.id = s3.id + 1
          AND s1.people >= 100 
          AND s2.people >= 100 
          AND s3.people >= 100 
    ORDER BY s1.id

    UNION 
    SELECT s1.id, s1.date, s1.people
    FROM
    stadium s1, stadium s2, stadium s3
    WHERE s1.id = s2.id + 1 AND s1.id = s3.id + 2
          AND s1.people >= 100 
          AND s2.people >= 100 
          AND s3.people >= 100 
    ORDER BY s1.id

    UNION 
    SELECT s1.id, s1.date, s1.people
    FROM
    stadium s1, stadium s2, stadium s3
    WHERE s1.id = s2.id - 1 AND s1.id = s3.id - 2
          AND s1.people >= 100 
          AND s2.people >= 100 
          AND s3.people >= 100 

    ORDER BY s1.id
    
) as t
ORDER BY t.id