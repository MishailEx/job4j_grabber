select p.name as NamePerson, c.name as Company from person as p
join company as c on p.company_id = c.id where company_id != 5

select c.name,  count (p.company_id) 
from company as c inner join person as p on p.company_id = c.id
group by c.name
order by count desc
limit 1

