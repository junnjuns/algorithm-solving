select
hd.DEPT_ID,
hd.DEPT_NAME_EN,
round(AVG(he.SAL), 0) as AVG_SAL
from HR_DEPARTMENT as hd
    join HR_EMPLOYEES as he
    on hd.DEPT_ID = he.DEPT_ID
group by hd.DEPT_ID
order by AVG_SAL desc
