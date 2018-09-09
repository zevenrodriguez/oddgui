---
title: "RWET Midterm: SOS Poem"
slug: rwet-midterm-sos-poem
date_published: 2010-03-12T11:43:18.000Z
date_updated:   2014-03-29T23:47:15.000Z
---

# RWET Midterm: SOS Poem

The SOS Poem structure is based on the Morse code sequence . . . _ _ _ Â . . . Another goal for the poem is to follow theÂ rhythm of SOS by using the following word structure: Name and Name Adverb Verb Adverb Name and Name. Also each name is composed of three letter names and the adverbs and verbs are composed of nine letter words. You can also see that it has a palindrome feel to it. Because of how the code is set up it words best when you input a list of names and another source text.

The source text is a list of congress people and the Obama Health Care bill

Lee and Jos gradually clarifying gradually Lee and Jos  
 Ken and Ron currently conducting currently Ken and Ron  
 Dan and Max seriously increased seriously Dan and Max  
 Ike and Joe primarily empowering primarily Ike and Joe

For and Fee gradually clarifying gradually For and Fee  
 All and One currently conducting currently All and One  
 But and Tax seriously increased seriously But and Tax  
 Act and Key primarily empowering primarily Act and Key

[cc lang=”python”]  
 import sys  
 import re  
 congress = set()  
 congressName = list()  
 bill = set()  
 billWords = list()  
 verbs = set()  
 verbsList = list()  
 adverbs = set()  
 adverbsList = list()  
 state = “New”  
 name = ” ”  
 words = ” ”  
 verb = ” ”  
 adverb = ” ”  
 congressCounter = 0  
 verbCounter = 0  
 adverbCounter = 0  
 displayCounter = 0  
 fileObj = open(‘obamacare.txt’)

lines = fileObj.readlines()

for line in sys.stdin:  
 line.strip()  
 for matching_string in re.findall(r’s[A-Z][a-z][a-z]b’, line):  
 name = matching_string  
 congress.add(name)

congress.remove(” New”)

congressCounter = len(congress)  
 for num in range(0,congressCounter):  
 name = congress.pop()  
 name=name[1:]  
 congressName.append(name)

for words in lines:  
 words.strip()  
 for matching_verb in re.findall(r”bw{7}ed|bw{7}ing”,words):  
 verb = matching_verb  
 verb = verb.lower()  
 verbs.add(verb)

verbCounter = len(verbs)  
 for num in range(0,verbCounter):  
 verb = verbs.pop()  
 verbsList.append(verb)

for words in lines:  
 words.strip()  
 for matching_adverb in re.findall(r”bw{7}ly”,words):  
 adverb = matching_adverb  
 adverb = adverb.lower()  
 adverbs.add(adverb)

adverbCounter = len(adverbs)  
 for num in range(0,adverbCounter):  
 adverb = adverbs.pop()  
 adverbsList.append(adverb)

if congressCounter < verbCounter and congressCounter < adverbCounter:  
 displayCounter = congressCounter  
 elif verbCounter < congressCounter and verbCounter < adverbCounter:  
 displayCounter = verbCounter  
 elif adverbCounter < verbCounter and adverbCounter < congressCounter:  
 displayCounter = adverbCounter

for num in range(0,displayCounter,2):  
 #print num  
 if num < displayCounter:  
 nameone = congressName[num]  
 nametwo = congressName[num +1]  
 print(nameone + ” and ” + nametwo + ” ” + adverbsList[num] + ” ” + verbsList[num] + ” ” + adverbsList[num] + ” ” + nameone + ” and ” + nametwo)

[/cc]

[Congress Text](http://www.zevenwolf.com/blog/rwet/congress.txt)  
[Obama Care Text](http://www.zevenwolf.com/blog/rwet/obamacare.txt)



---
