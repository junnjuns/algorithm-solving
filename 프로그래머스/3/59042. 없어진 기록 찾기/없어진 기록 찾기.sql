select
ao.ANIMAL_ID,
ao.NAME
from ANIMAL_INS as ai
right join ANIMAL_OUTS as ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where  ai.ANIMAL_ID is null
order by ao.ANIMAL_ID, ao.NAME