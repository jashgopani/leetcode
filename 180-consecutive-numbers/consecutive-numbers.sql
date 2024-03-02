# Write your MySQL query statement below
select distinct(a.num) as ConsecutiveNums
from logs as a join logs as b
on a.id = (b.id+1) and a.num=b.num
join logs as c
on (a.id) = (c.id+2) 
and a.num=c.num;