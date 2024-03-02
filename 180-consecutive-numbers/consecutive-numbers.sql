# Write your MySQL query statement below
select distinct(a.num) as ConsecutiveNums
from logs as a
where (
    select count(b.id) 
    from logs as b 
    where b.num=a.num and b.id in (a.id+1,a.id+2)
) >= 2 ;