# Write your MySQL query statement below
select p.firstName,p.lastName,A.city,A.state FROM Person as p
LEFT JOIN
Address as A 
ON p.personId = A.personId;
