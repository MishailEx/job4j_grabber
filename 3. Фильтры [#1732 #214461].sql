select * from product as p inner join type on p.type_id = type.id where type.name like 'сыр';

select * from product where name like '%мороженное%';

select * from product where expired_date < current_date;

select * from product as p order by price desc limit 1;

select t.name, count(t.id) from product as p inner join type as t on p.type_id = t.id
group by t.name;

select * from product as p inner join type as t on p.type_id = t.id where t.name like 'сыр' or t.name like '%молоко%';

select t.name, count(t.id)
from product as p
inner join type as t on p.type_id = t.id
group by t.name
having count(t.id) < 10;

select p.name, t.name from product as p inner join type as t on p.type_id = t.id;
 