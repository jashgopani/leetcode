-- # Write your MySQL query statement below
SELECT a.firstName, a.lastName, b.city, b.state
FROM person a LEFT JOIN address b
ON a.personId = b.personId;
