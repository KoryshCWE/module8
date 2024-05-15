SELECT p.ID, p.CLIENT_ID, p.START_DATE, p.FINISH_DATE,
       SUM(w.SALARY) * MONTHS_BETWEEN(p.FINISH_DATE, p.START_DATE) AS PRICE
FROM project p
         JOIN project_worker pw ON p.ID = pw.PROJECT_ID
         JOIN worker w ON pw.WORKER_ID = w.ID
GROUP BY p.ID, p.CLIENT_ID, p.START_DATE, p.FINISH_DATE
ORDER BY PRICE DESC;
