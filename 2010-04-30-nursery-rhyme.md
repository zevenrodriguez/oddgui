---
title: Nursery Rhyme
slug: nursery-rhyme
date_published: 2010-04-30T09:49:15.000Z
date_updated:   2014-03-29T23:56:07.000Z
---

# Nursery Rhyme

<div id="_mcePaste">The idea for the project was to mash-up nursery rhymes. I used speeches from obama and palin to re-populate the rhymne</div><div></div><div>Little Mr. barack, sat on a check</div><div id="_mcePaste">Eating his curds and growth</div><div id="_mcePaste">Along came a crisis</div><div id="_mcePaste">Who sat down beside his</div><div id="_mcePaste">And frightened Mr. barack month</div><div></div><div><div>Little Mr. barack, sat on a stock</div><div>Eating his curds and risk</div><div>Along came a crisis</div><div>Who sat down beside his</div><div>And frightened Mr. barack risk</div><div></div>

<div>Little Mr. barack, sat on a check</div><div>Eating his curds and applause.</div><div>Along came a This</div><div>Who sat down beside his</div><div>And frightened Mr. barack applause.</div><div></div>

<div>Little Mr. barack, sat on a pick</div><div>Eating his curds and issue</div><div>Along came a is</div><div>Who sat down beside his</div><div>And frightened Mr. barack rescue</div><div></div>

<div>Little Mr. barack, sat on a pick</div><div>Eating his curds and come</div><div>Along came a this</div><div>Who sat down beside his</div><div>And frightened Mr. barack outcome</div><div></div>

<div></div><div>Little Miss palin, sat on a win</div><div>Eating her curds and kill</div><div>Along came a never</div><div>Who sat down beside her</div><div>And frightened Miss Â palin still</div><div></div>

<div>Little Miss palin, sat on a McCain</div><div>Eating her curds and Al</div><div>Along came a pollster</div><div>Who sat down beside her</div><div>And frightened Miss palin Al</div><div></div>

<div>Little Miss palin, sat on a remain</div><div>Eating her curds and food</div><div>Along came a teleprompter</div><div>Who sat down beside her</div><div>And frightened Miss palin good</div><div></div>

<div>Little Miss palin, sat on a again</div><div>Eating her curds and “TARP</div><div>Along came a another</div><div>Who sat down beside her</div><div>And frightened Miss palin “TARP</div><div></div>

<div>Little Miss sarah, sat on a Yeah</div><div>Eating her curds and question[s]</div><div>Along came a together</div><div>Who sat down beside her</div><div>And frightened Miss sarah question[s]</div></div>

<div></div><div></div><div></div>[cc lang=”python”]  
 from BeautifulSoup import BeautifulSoup  
 import urllib  
 import sys  
 import random

words = set()  
 wordSet = set()  
 rhyme = dict()  
 rhymeList = list()

url = “littlemuffet.html”  
 changer = sys.argv[1]  
 name = sys.argv[2]

data = urllib.urlopen(url).read()  
 soup = BeautifulSoup(data)

genderID1 = “Mr.”  
 genderID2 = “his”

#parses speech  
 for line in sys.stdin:  
 line = line.strip()  
 line_words = line.split(” “)  
 for word in line_words:  
 words.add(word)

for word in words:  
 wordLength = len(word)  
 if (“.”) in word:  
 wordSet.add(word[:(wordLength-1)])  
 elif (“,”) in word:  
 wordSet.add(word[:(wordLength-1)])  
 elif (“;”) in word:  
 wordSet.add(word[:(wordLength-1)])  
 elif (“?”) in word:  
 wordSet.add(word[:(wordLength-1)])  
 elif (“:”) in word:  
 wordSet.add(word[:(wordLength-1)])  
 else:  
 wordSet.add(word)

for word in wordSet:  
 wordLength = len(word)  
 lastLetter = word[wordLength-2:wordLength]

if lastLetter in rhyme.keys():  
 rhyme[lastLetter].append(word)  
 else:  
 rhyme[lastLetter]=[word]

if “true” in changer:  
 gender1 = soup.findAll(‘span’, { “id” : “1” }, { “gender” : changer })  
 gender2 = soup.findAll(‘span’, { “id” : “4” }, { “gender” : changer })

for i in range(0,len(gender1)):  
 gender1[i].replaceWith(genderID1)  
 for i in range(0,len(gender2)):  
 gender2[i].contents[0].replaceWith(genderID2)  
 else:  
 gender1 = soup.findAll(‘span’, { “id” : “1” }, { “gender” : changer })  
 for i in range(0,len(gender1)):  
 origWord = gender1[i].contents[0]  
 gender1[i].replaceWith(origWord)

namer = soup.findAll(‘span’, { “id” : “2” }, { “namer” : “1” })  
 for i in range(0,len(namer)):  
 namer[i].contents[0].replaceWith(name)

#rhyme 1  
 rhyme1 = soup.findAll(‘span’,{ “rhyme” : “1” })  
 baseRhyme1 = str(rhyme1[0].contents[0])  
 baseRhyme1Last = baseRhyme1[len(baseRhyme1)-2:len(baseRhyme1)]  
 rhyme1Search = rhyme[baseRhyme1Last]  
 rhyme1Word = random.choice(rhyme1Search)  
 rhyme1[0].replaceWith(baseRhyme1)  
 rhyme1[1].replaceWith(rhyme1Word)  
 rhyme1[2].replaceWith(baseRhyme1)

#rhyme 1  
 rhyme2 = soup.findAll(‘span’,{ “rhyme” : “2” })  
 letters = random.choice(rhyme.keys())  
 randomList = rhyme[letters]  
 rhyme2Word1 = random.choice(randomList)  
 rhyme2Word2 = random.choice(randomList)

rhyme2[0].replaceWith(rhyme2Word1)  
 rhyme2[1].replaceWith(rhyme2Word2)

#rhyme 3  
 rhyme3 = soup.findAll(‘span’,{ “rhyme” : “3” })  
 baseRhyme3 = str(rhyme3[0].contents[0])  
 baseRhyme3Last = baseRhyme3[len(baseRhyme3)-2:len(baseRhyme3)]  
 rhyme3Search = rhyme[baseRhyme3Last]  
 rhyme3Word = random.choice(rhyme3Search)  
 rhyme3[0].replaceWith(baseRhyme3)  
 rhyme3[1].replaceWith(rhyme3Word)  
 rhyme3[2].replaceWith(baseRhyme3)

print soup

[/cc]  
 [cc lang=”html”]  
 Little <span id="1">Miss</span><span id="2">Muffet</span>, sat on a <span id="3">tuffet</span>

Eating <span id="4">her</span> curds and <span id="5">whey</span>

Along came a <span id="5">spider</span>

Who sat down beside <span id="4">her</span>

And frightened <span id="1">Miss</span><span id="2">Muffet</span><span id="6">away</span>

[/cc]

<div style="text-align: center;"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="300" width="400"><param name="allowfullscreen" value="true"></param><param name="allowscriptaccess" value="always"></param><param name="src" value="http://vimeo.com/moogaloop.swf?clip_id=11550696&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1"></param><embed allowfullscreen="true" allowscriptaccess="always" height="300" src="http://vimeo.com/moogaloop.swf?clip_id=11550696&server=vimeo.com&show_title=1&show_byline=1&show_portrait=0&color=&fullscreen=1" type="application/x-shockwave-flash" width="400"></embed></object></div>[Political Nursery Rhyme](http://vimeo.com/11550696) from [Zeven Rodriguez](http://vimeo.com/user2302394) on [Vimeo](http://vimeo.com).
