select
    date_format(DATETIME, '%k') as HOUR,
    count(*) as COUNT
from
    ANIMAL_OUTS
where date_format(DATETIME, '%k') >= 9 and date_format(DATETIME, '%k') <= 19
group by date_format(DATETIME, '%k')
order by HOUR(datetime)