select
o.ANIMAL_ID,
o.name
from ANIMAL_INS as i right join ANIMAL_OUTS as o on i.ANIMAL_ID = o.ANIMAL_ID
where i.ANIMAL_ID is null