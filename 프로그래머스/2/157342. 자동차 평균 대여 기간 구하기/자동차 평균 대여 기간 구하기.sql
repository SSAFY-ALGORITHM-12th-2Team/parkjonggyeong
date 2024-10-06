-- 코드를 입력하세요
SELECT car_id, round(avg(datediff(end_date, start_date) + 1),1) as AVERAGE_DURATION 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC