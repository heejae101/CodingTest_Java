    SELECT A.MEMBER_NAME, B.REVIEW_TEXT, TO_CHAR(B.REVIEW_DATE, 'YYYY-MM-DD') REVIEW_DATE
      FROM MEMBER_PROFILE A
INNER JOIN REST_REVIEW B
        ON A.MEMBER_ID = B.MEMBER_ID
      WHERE A.MEMBER_ID IN (   SELECT MEMBER_ID
                             FROM REST_REVIEW 
                         GROUP BY MEMBER_ID
                           HAVING COUNT(*) = (  SELECT MAX(COUNT(*))
                                                  FROM REST_REVIEW
                                              GROUP BY MEMBER_ID))
  ORDER BY 3, 2;