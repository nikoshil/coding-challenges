SELECT SUM(city.Population)
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Continent = 'Asia';

SELECT city.Name
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Continent = 'Africa';

SELECT country.Continent, FLOOR(AVG(city.Population))
FROM city
JOIN country ON city.CountryCode = country.Code
GROUP BY country.Continent;




