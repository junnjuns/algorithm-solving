select
ANIMAL_TYPE,
count(ANIMAL_ID) as count
from ANIMAL_INS
where ANIMAL_TYPE in ('Cat', 'Dog')
group by ANIMAL_TYPE
order by case when ANIMAL_TYPE = 'Cat' then 1
              else 2
              end