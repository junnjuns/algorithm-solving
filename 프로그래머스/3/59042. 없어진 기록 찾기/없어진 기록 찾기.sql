# 입양 간 기록 있지만, 보호소 기록에 없는 동물 조회

select
AO.ANIMAL_ID,
AO.NAME
from ANIMAL_OUTS as AO left join ANIMAL_INS AI on AI.ANIMAL_ID = AO.ANIMAL_ID
where AI.ANIMAL_ID is null