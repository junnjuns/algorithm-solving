# 대여 중인 자동차 정보 테이블 : CAR_RENTAL_COMPANY_CAR
# 자동차 대여 기록 정보 테이블 : CAR_RENTAL_COMPANY_RENTAL_HISTORY
# 자동차 종류 별 대여 기간 할인률 정책 테이블 : CAR_RENTAL_COMPANY_DISCOUNT_PLAN

# 세단 or SUV
# 2022년 11월 1~30일 대여 가능
# 50 <= 한 달 대여 금액 < 200
# 대여 금액 내림차순 정렬
    # 금액 같으면 종류 기준으로 오름차순 정렬
        # 종류 같으면 ID 기준 내림차순 정렬
        

        
select
    nt.car_id as CAR_ID,
    nt.car_type as CAR_TYPE,
    truncate(nt.car_fee * ((100 - CDP.DISCOUNT_RATE) / 100) * 30, 0) as FEE
from
(
    select
        CC.CAR_ID as car_id,
        CC.CAR_TYPE as car_type,
        CC.DAILY_FEE as car_fee
    from
        (
        select
            CAR_ID,
            CAR_TYPE,
            DAILY_FEE
        from
            CAR_RENTAL_COMPANY_CAR
        where 
            CAR_TYPE in ('세단', 'SUV')
        ) as CC
    left join 
        (
        select
            CAR_ID
        from
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where 
            START_DATE <= '2022-11-30' and END_DATE >= '2022-11-01'
        group by 
            CAR_ID
        ) as CRH
    on 
        CC.CAR_ID = CRH.CAR_ID
    where
        CRH.CAR_ID is null
) as nt
left join
    (    
        select
            CAR_TYPE,
            DISCOUNT_RATE
        from 
            CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        where 
            DURATION_TYPE = '30일 이상'
    ) as CDP
on
    nt.CAR_TYPE = CDP.CAR_TYPE
where
    truncate(nt.car_fee * ((100 - CDP.DISCOUNT_RATE) / 100) * 30, 0) >= 500000 
    and
    truncate(nt.car_fee * ((100 - CDP.DISCOUNT_RATE) / 100) * 30, 0) < 2000000
order by FEE desc, CAR_TYPE, CAR_ID desc

