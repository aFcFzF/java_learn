# Write your MySQL query statement below

select FirstName, LastName, City, State
from Address as A
right join Person as P on (A.personId = P.personId);