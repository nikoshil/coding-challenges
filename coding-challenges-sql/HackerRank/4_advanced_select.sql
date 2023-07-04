SELECT
  CASE
	WHEN (A + B) <= C THEN 'Not A Triangle'
	WHEN (A + C) <= B THEN 'Not A Triangle'
	WHEN (B + C) <= A THEN 'Not A Triangle'
    WHEN A = B AND A = C THEN 'Equilateral'
    WHEN A = B AND B != C THEN 'Isosceles'
    WHEN B = C AND C != A THEN 'Isosceles'
    WHEN A = C AND C != B THEN 'Isosceles'
    ELSE 'Scalene'
  END AS triangle
FROM triangles;

WITH RECURSIVE pattern_cte(num) AS (
  SELECT 1
  UNION ALL
  SELECT num + 1 FROM pattern_cte WHERE num < 20
)
SELECT REPEAT('* ', num) AS Pattern
FROM pattern_cte
ORDER BY num DESC;

WITH RECURSIVE pattern_cte(num) AS (
  SELECT 20
  UNION ALL
  SELECT num - 1 FROM pattern_cte WHERE num > 1
)
SELECT REPEAT('* ', num) AS Pattern
FROM pattern_cte
ORDER BY num ASC;