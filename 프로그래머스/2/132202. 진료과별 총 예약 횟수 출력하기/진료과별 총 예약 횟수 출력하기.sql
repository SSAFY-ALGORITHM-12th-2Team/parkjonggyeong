SELECT MCDP_CD as '진료과코드', COUNT(apnt_ymd) as '5월예약건수' from appointment
where apnt_ymd like '2022-05-%'
group by MCDP_CD
ORDER BY COUNT(APNT_YMD) ASC, MCDP_CD ASC;