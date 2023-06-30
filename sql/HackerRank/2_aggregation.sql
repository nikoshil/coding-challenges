SELECT SUM(Population)
FROM city
WHERE CountryCode = 'JPN';

SELECT MAX(Population) - MIN(Population)
FROM city;

SELECT CEILING(
 AVG(Salary)
 -
 AVG(CAST(REPLACE(CAST(Salary AS FLOAT), '0', '') AS UNSIGNED)))
FROM employees;

SELECT
   (SELECT MAX(Salary * Months) AS Max_Remuneration FROM employee) AS Max_Remuneration ,
   (SELECT COUNT(*) FROM employee WHERE(Salary * Months = Max_Remuneration));
   
SELECT
  (SELECT ROUND(SUM(Lat_N), 2) FROM station),
  (SELECT ROUND(SUM(Long_W), 2) FROM station);
   
SELECT ROUND(SUM(Lat_N), 4) 
FROM station
WHERE Lat_N BETWEEN 38.7880 AND 137.2345;

SELECT ROUND(MAX(Lat_N), 4) 
FROM station
WHERE Lat_N < 137.2345;

SELECT ROUND(Long_W, 4) 
FROM station
WHERE Lat_N < 137.2345
ORDER BY Lat_N DESC
LIMIT 1;

SELECT ROUND(MIN(Lat_N), 4) 
FROM station
WHERE Lat_N > 38.7780;

SELECT ROUND(Long_W, 4) 
FROM station
WHERE Lat_N > 38.7780
ORDER BY Lat_N ASC
LIMIT 1;

SELECT ROUND(((MAX(Lat_N) - MIN(Lat_N)) + (MAX(Long_W) - MIN(Long_W))), 4) FROM station;

SELECT
    ROUND(
        SQRT(
            POW(
                (MAX(Lat_N) - MIN(Lat_N)),2) +
            POW(
                (MAX(Long_W) - MIN(Long_W)),2)
            ),4) 
FROM station;


SELECT ROUND(S.LAT_N, 4) FROM station AS S 
WHERE (SELECT COUNT(Lat_N) 
       FROM station 
	   WHERE Lat_N < S.LAT_N ) 
	   = 
	  (SELECT COUNT(Lat_N) 
	   FROM station 
	   WHERE Lat_N > S.LAT_N);

SELECT ROUND(AVG(Population))
FROM city;

SELECT SUM(Population)
FROM city
WHERE District = 'California';

SELECT AVG(Population)
FROM city
WHERE District = 'California';

SELECT COUNT(City)
FROM city
WHERE Population > 100000;