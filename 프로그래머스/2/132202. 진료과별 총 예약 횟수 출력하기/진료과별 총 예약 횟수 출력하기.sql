select
MCDP_CD as '진료과코드',
count(APNT_NO) as '5월예약건수'
from
APPOINTMENT
where APNT_YMD >= '2022-05-01' and APNT_YMD < '2022-06-01'
group by MCDP_CD
order by 5월예약건수, 진료과코드