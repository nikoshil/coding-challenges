SELECT * 
FROM city
WHERE CountryCode = 'USA' AND Population > 100000;

SELECT Name
FROM city
WHERE CountryCode = 'USA' AND Population > 120000;

SELECT *
FROM city;

SELECT *
FROM city
WHERE Id = 1661;

SELECT *
FROM city
WHERE CountryCode = 'JPN';

SELECT City, State
FROM station;

SELECT DISTINCT City
FROM station
WHERE Id % 2 = 0;

SELECT COUNT(DISTINCT City) AS unique_cities
FROM station;

SELECT COUNT(DISTINCT Lat_N, Long_W) AS unique_cities
FROM station;

SELECT COUNT(DISTINCT Lat_N, Long_W) - COUNT(DISTINCT City) AS difference
FROM station;

/* selects the city with the shortest name, if there are multiple cities with this lenght it will select the first occurence */
SELECT City
FROM station
ORDER BY LENGTH(City) DESC
LIMIT 1;

/* selects the city with the shortest name, if there are multiple cities with this lenght it will select the first by alpabetical order */
SELECT City
FROM station
WHERE LENGTH(City) = (SELECT MIN(LENGTH(City)) FROM station)
ORDER BY City ASC
LIMIT 1

/* selects the two cities both with the shortest and longest names */
SELECT City, LENGTH(City)
FROM station
WHERE LENGTH(City) = (SELECT MIN(LENGTH(City)) FROM station)
ORDER BY City ASC
LIMIT 1;
/* use UNION */
SELECT City, LENGTH(City)
FROM station
WHERE LENGTH(City) = (SELECT MAX(LENGTH(City)) FROM station)
ORDER BY City ASC
LIMIT 1;

SELECT DISTINCT City
FROM station
WHERE LEFT(City, 1) IN ('a', 'e', 'i', 'o', 'u');

SELECT DISTINCT City
FROM station
WHERE RIGHT(City, 1) IN ('a', 'e', 'i', 'o', 'u');

SELECT DISTINCT City
FROM station
WHERE RIGHT(City, 1) IN ('a', 'e', 'i', 'o', 'u') AND LEFT(City, 1) IN ('a', 'e', 'i', 'o', 'u');

SELECT DISTINCT City
FROM station
WHERE LEFT(UPPER(City), 1) NOT IN ('A', 'E', 'I', 'O', 'U') ;

SELECT DISTINCT CITY
FROM STATION
WHERE (NOT(CITY  Like 'A%' OR CITY LIKE 'E%' OR CITY LIKE 'O%' OR CITY LIKE 'I%' OR CITY LIKE 'U%')) OR
	  (NOT (CITY LIKE '%a' OR CITY  LIKE '%e' OR CITY LIKE '%i' OR CITY LIKE '%o' OR CITY LIKE '%u'))
ORDER BY CITY;
/* or */
SELECT DISTINCT City
FROM station
WHERE RIGHT(City, 1) NOT IN ('a', 'e', 'i', 'o', 'u') 
   OR LEFT(City, 1) NOT IN ('a', 'e', 'i', 'o', 'u');
   
SELECT Name
FROM students
WHERE Marks > 75
ORDER BY RIGHT(Name, 3) ASC, Id ASC;

Select Name
From employee
ORDER BY Name;

Select Name
From employee
WHERE Months < 10 AND Salary > 2000
ORDER BY Employee_Id;