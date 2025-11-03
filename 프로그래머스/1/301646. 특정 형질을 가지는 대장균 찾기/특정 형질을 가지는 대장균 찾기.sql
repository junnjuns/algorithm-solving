select count(ID) as COUNT
from ECOLI_DATA
where genotype & 2 = 0 and ( genotype & 4 > 0 or genotype & 1 > 0)