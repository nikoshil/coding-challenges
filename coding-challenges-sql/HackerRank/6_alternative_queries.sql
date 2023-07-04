WITH RECURSIVE pattern_cte(num) AS (
  SELECT 1
  UNION ALL
  SELECT num + 1 FROM pattern_cte WHERE num < 20
)
SELECT REPEAT('* ', num) AS Pattern
FROM pattern_cte
ORDER BY num DESC;