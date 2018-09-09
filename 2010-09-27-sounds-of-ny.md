---
title: Sounds of NY
slug: sounds-of-ny
date_published: 2010-09-28T00:44:04.000Z
date_updated:   2014-03-29T23:50:08.000Z
---

# Sounds of NY

[Sounds of NY](http://zevenwolf.com/mobilemedia/soundsofNY/) is a project that lets you submit sounds of the city. It uses an email php parser and a processing sketch. The [parser ](http://itp.nyu.edu/~sve204/mobilemedia_spring09/php_popper.zip)was written by Shawn Van Every. By emailing z e v e n w o l f . p i c s Â at Â g m a i l . c o m and attach your mp3 the sketch picks up the last sound uploaded.

The one thing I had to used fix the parser was when I would post to the database it included my server’s httpdocs in the url path. I used regular expressions to take the /httpdocs/ out. In php, the / starts and ends the regular expression. [^A-Za-z0-9] this sections chooses any non-number and letter in this case the first /. Then it finds httpdocs. Then [^A-Za-z0-9] finds the second /.

[cc lang=”php”]

$tempData = $data[0][‘sound’];  
 $patterns = “/[^A-Za-z0-9]httpdocs[^A-Za-z0-9]/”;  
 $replacements = ‘/’;  
 echo preg_replace($patterns, $replacements, $tempData);  
 [/cc]
