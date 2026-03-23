select
SQ.SCORE,
SQ.EMP_NO,
HE.EMP_NAME,
HE.POSITION,
HE.EMAIL
from HR_EMPLOYEES as HE
    join
        (
        select
            EMP_NO,
            sum(SCORE) as SCORE
        from HR_GRADE
        group by EMP_NO
        ) as SQ
    on HE.EMP_NO = SQ.EMP_NO
order by SQ.SCORE DESC
limit 1
    