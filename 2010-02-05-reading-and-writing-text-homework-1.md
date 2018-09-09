---
title: Reading and Writing Text Homework 1
slug: reading-and-writing-text-homework-1
date_published: 2010-02-05T16:05:56.000Z
date_updated:   2014-03-29T23:41:20.000Z
---

# Reading and Writing Text Homework 1

For this homework I wanted to mashup 3 Charles Bukowski programs and make them adorable. I started with 3 poems: Death wants more Death, The Riot, and Two Kinds of Hell.

I started with

*cat deathwantsmoredeath.txt theriot.txt twokindsofhell.txt*

This is how I combined multiple files.

I ran python hwfeb05.py <charles#.txt>charles#.txt with the pound being increasing numbers from 0-5

**This is the code for hwfeb05.py this code divides the poem in half**  
 [cc lang=”python”]  
 import sys

count = 0

for line in sys.stdin:

line = line.strip()

if count % 2 == 0:

output = line

else:

output = “”

print output

count += 1  
 [/cc]  
 Then I ran python Â hwfeb05replace.py< charles5.txt>charlesreplace.txt

**Here is Â the code for hwfeb05replace.py. This replace code is what looks for the words I want to make adorable.**  
 [cc lang=”python”]]  
 import sys

for line in sys.stdin:  
 line = line.strip()  
 line = line.replace(‘death’, ‘pandas’)  
 line = line.replace(‘corpses’, ‘puppies’)  
 line = line.replace(‘corpse’, ‘puppy’)  
 line = line.replace(‘drink’, ‘hug’)  
 line = line.replace(‘dark’, ‘puppy-eyed’)  
 line = line.replace(‘drinks’, ‘hugs’)  
 line = line.replace(‘ladies’, ‘unicorns’)  
 line = line.replace(‘lady’, ‘unicorn’)  
 line = line.replace(‘crime’,’party’)  
 line = line.replace(‘enemy’,’buddy’)  
 line = line.replace(‘enemies’,’buddies’)  
 line = line.replace(‘bar’,’playground’)  
 line = line.replace(‘alone’,’holding hands’)  
 line = line.replace(‘body’,’kitten’)  
 line = line.replace(‘bodies’,’kittens’)  
 print line

[/cc]

Finally I ran python hwfeb05finder.py<charlesreplace.txt>charlesfinder.txt

[cc lang=”python”]  
 import sys  
 for line in sys.stdin:  
 line = line.strip()  
 offset = line.find(“pandas”)  
 if offset != -1:  
 print line  
 offset = line.find(“puppies”)  
 if offset != -1:  
 print line  
 offset = line.find(“puppy”)  
 if offset != -1:  
 print line  
 offset = line.find(“hug”)  
 if offset != -1:  
 print line  
 offset = line.find(“puppy-eyed”)  
 if offset != -1:  
 print line  
 offset = line.find(“hugs”)  
 if offset != -1:  
 print line  
 offset = line.find(“unicorns”)  
 if offset != -1:  
 print line  
 offset = line.find(“unicorn”)  
 if offset != -1:  
 print line  
 offset = line.find(“party”)  
 if offset != -1:  
 print line  
 offset = line.find(“buddy”)  
 if offset != -1:  
 print line  
 offset = line.find(“buddies”)  
 if offset != -1:  
 print line  
 offset = line.find(“playground”)  
 if offset != -1:  
 print line  
 offset = line.find(“holding hands”)  
 if offset != -1:  
 print line  
 offset = line.find(“kitten”)  
 if offset != -1:  
 print line  
 offset = line.find(“kittens”)  
 if offset != -1:  
 print line

[/cc]  
 That gave me this output:

<div id="_mcePaste">pandas wants more pandas, and its webs are full:</div><div id="_mcePaste">I would brush the puppies of flies</div><div id="_mcePaste">their sticky, ugly, vibrant kittens</div><div id="_mcePaste">their sticky, ugly, vibrant kittens</div><div id="_mcePaste">towards some puppy-eyed corner</div><div id="_mcePaste">towards some puppy-eyed corner</div><div id="_mcePaste">I sat in the same playground for 7 years, from 5 a.m.</div><div id="_mcePaste">I had no money but the hugs kept</div><div id="_mcePaste">I had no money but the hugs kept</div><div id="_mcePaste">to them I wasn’t the playground clown</div><div id="_mcePaste">and I began to hug holding hands and I found the company</div><div id="_mcePaste">and I began to hug holding hands and I found the company</div><div id="_mcePaste">heart, knocks began upon my door: unicorns</div><div id="_mcePaste">heart, knocks began upon my door: unicorns</div><div id="_mcePaste">and the unicorns arrived one at a time and when it ended with</div><div id="_mcePaste">and the unicorns arrived one at a time and when it ended with</div><div id="_mcePaste">but I remembered the 7 years in the playground, I hardly ever bedded</div><div id="_mcePaste">his simple strength and salvation, they will send the unicorn</div><div id="_mcePaste">and then you remember the playground</div><div id="_mcePaste">somekitten in the playground saying: “hey, sir, forget it, he’s a mental</div><div id="_mcePaste">somekitten in the playground saying: “hey, sir, forget it, he’s a mental</div><div id="_mcePaste">gods arranged to get all those unicorns knocking and you went for</div><div id="_mcePaste">gods arranged to get all those unicorns knocking and you went for</div><div id="_mcePaste">the puff of kitten swelling</div><div id="_mcePaste">looking for the buddy</div><div id="_mcePaste">saw or sensed my party</div>The only thing that I need to figure out now is how not to print out duplicate lines
