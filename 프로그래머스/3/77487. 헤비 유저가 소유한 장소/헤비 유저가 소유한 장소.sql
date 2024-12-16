-- 코드를 입력하세요
SELECT P.ID, P.NAME, P.HOST_ID
FROM PLACES P
WHERE HOST_ID IN (SELECT HOST_ID FROM PLACES
                 GROUP BY HOST_ID
                 HAVING COUNT(*) >= 2)
                 ORDER BY ID;