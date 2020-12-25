# Write your MySQL query statement below
select name as Customers from Customers as C where C.Id not in (select CustomerId from Orders) ;