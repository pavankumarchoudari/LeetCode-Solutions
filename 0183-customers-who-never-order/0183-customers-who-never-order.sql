# Write your MySQL query statement below
select c.name as Customers  FROM Customers as c LEFT JOIN orders as o 
on c.id =  o.customerID where o.customerID IS NULL;