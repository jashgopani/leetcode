# Write your MySQL query statement below
select a.firstName, a.lastName, b.city,b.state
from person as a left join address as b
on a.personId = b.personId;
