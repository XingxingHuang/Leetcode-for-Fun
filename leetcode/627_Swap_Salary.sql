2017.07.23   

UPDATE salary SET sex = IF(sex = 'm', 'f', 'm')

update salary set sex = CHAR(ASCII('f') ^ ASCII('m') ^ ASCII(sex));

UPDATE salary
    SET sex  = (CASE WHEN sex = 'm' 
        THEN  'f' 
        ELSE 'm' 
        END)