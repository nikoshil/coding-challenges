/* 
Assume you're given two tables containing data about Facebook Pages and their respective likes (as in "Like a Facebook Page").
Write a query to return the IDs of the Facebook pages that have zero likes. 
The output should be sorted in ascending order based on the page IDs.
*/

SELECT pages.page_id
FROM pages
INNER JOIN page_likes on pages.page_id = page_likes.page_id
ORDER BY page_id ASC;

SELECT pages.page_id
FROM pages
LEFT OUTER JOIN page_likes ON pages.page_id = page_likes.page_id
WHERE page_likes.page_id IS NULL;

SELECT page_id
FROM pages
WHERE page_id NOT IN (
  SELECT page_id
  FROM page_likes
  WHERE page_id IS NOT NULL
);

SELECT pages.page_id
FROM pages
EXCEPT
    SELECT page_id
FROM page_likes;

SELECT page_id
FROM pages
WHERE NOT EXISTS (
  SELECT page_id
  FROM page_likes
  WHERE page_likes.page_id = pages.page_id
;)