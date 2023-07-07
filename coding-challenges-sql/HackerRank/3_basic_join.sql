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

SELECT 
    CASE WHEN grade < 8 THEN 'NULL' ELSE name END,
    grade,
    marks
FROM students
    LEFT JOIN grades ON marks BETWEEN min_mark AND max_mark
ORDER BY grade DESC, name ASC, marks ASC;

SELECT submissions.hacker_id, hackers.name 
FROM submissions
    JOIN hackers ON hackers.hacker_id = submissions.hacker_id
    JOIN challenges ON challenges.challenge_id = submissions.challenge_id
    JOIN difficulty ON difficulty.difficulty_level = challenges.difficulty_level
WHERE submissions.score = difficulty.score    
GROUP BY submissions.hacker_id, hackers.name
HAVING COUNT(submissions.hacker_id) > 1
ORDER BY COUNT(submissions.hacker_id) DESC, submissions.hacker_id ASC;

