---
title: Traceroute Miami and New York
slug: traceroute-miami-and-new-york
date_published: 2010-10-05T12:36:58.000Z
date_updated:   2014-03-29T23:49:31.000Z
---

# Traceroute Miami and New York

For Understand Networks, we had to run a traceroute on 24 sites. I did it located in Miami and New York. I wrote a python parser that takes in a large text file with all of the traceroutes and sorts what IPs were hit the most. I ran the traceroute on windows with this command tracert thensite.com >>master.txt. The >> appends to the end of an existing file. One thing I noticed with these maps is that most of my traffic was routed through the same IPs.

[![](uploads/newyorktraceroute1.jpg "newyorktraceroute")](uploads/newyorktraceroute1.jpg)

[![](uploads/miamiTraceroute.jpg "miamiTraceroute")](uploads/miamiTraceroute.jpg)

This is the site I used to make the map.

[http://www.topwebhosts.org/tools/ip-locator.php](http://www.topwebhosts.org/tools/ip-locator.php)

[cc lang=”python”]  
 import re  
 from operator import itemgetter  
 def makeDict(site):  
 superList = list()  
 tempList = list()  
 ip = str()  
 timeList = list()  
 avTime = int()  
 map = dict()  
 textAddress = ‘ ‘  
 siteLister = list()  
 for line in site:  
 line = line.strip()  
 siteLister.append(line)

 for i in range(4,len(siteLister)):  
 if i >=4:  
 listSplit = siteLister[i].split(‘ ‘)  
 for num in range(0,len(listSplit)):  
 if ‘ms’ in listSplit[num]:  
 if (‘1:  
 print (w + ” : ” + str(allMap[w]))

bigList = list()  
 bigList1 = list()  
 masterSite = open(‘sites/master.txt’)  
 masterSite1 = open(‘site2/master.txt’)

print “MIAMI”  
 bigList = makeDict(masterSite)  
 sortIps(bigList)  
 print ” ”  
 print “NEW YORK”  
 bigList1 = makeDict(masterSite1)  
 sortIps(bigList1)

#for ips in bigSetList:  
 # if allMap[ips]>1:  
 # print (ips + ” : ” + str(allMap[ips]))

[/cc]

This is the output from the parser  
 [cc lang=”text”]

MIAMI  
 : 261  
 65.14.121.204 : 24  
 12.122.106.94 : 24  
 12.122.1.45 : 24  
 192.168.1.254 : 24  
 12.122.5.142 : 21  
 12.81.8.24 : 19  
 65.14.121.181 : 13  
 68.152.169.161 : 11  
 12.81.8.98 : 10  
 12.122.80.185 : 6  
 12.81.8.9 : 5  
 74.175.192.182 : 5  
 74.175.192.190 : 4  
 74.175.192.186 : 4  
 12.81.8.73 : 4  
 199.181.132.250 : 4  
 12.81.8.17 : 4  
 74.175.192.178 : 4  
 12.122.84.21 : 3  
 12.81.8.71 : 3  
 12.122.1.174 : 3  
 12.81.8.15 : 3  
 74.175.192.166 : 2  
 67.16.138.214 : 2  
 74.175.192.202 : 2  
 64.125.31.54 : 2  
 12.122.84.113 : 2  
 205.186.154.181 : 2  
 69.195.198.147 : 2  
 192.205.35.90 : 2  
 64.30.230.20 : 2  
 152.52.20.247 : 2  
 12.122.1.5 : 2  
 209.170.90.66 : 2  
 12.122.87.61 : 2  
 12.123.22.25 : 2  
 64.125.27.61 : 2  
 12.122.5.185 : 2  
 64.210.15.78 : 2  
 12.81.8.13 : 2  
 12.81.8.19 : 2  
 209.131.112.94 : 2  
 69.60.7.195 : 2  
 12.81.8.7 : 2  
 207.97.227.239 : 2  
 192.205.35.234 : 2  
 69.63.181.12 : 2  
 64.124.161.42 : 2  
 69.60.7.199 : 2  
 64.131.82.241 : 2  
 63.246.23.232 : 2  
 192.205.37.82 : 2  
 208.80.152.2 : 2  
 74.175.192.174 : 2  
 74.125.67.83 : 2  
 192.205.35.218 : 2

NEW YORK  
 : 278  
 173.56.121.1 : 24  
 192.168.1.1 : 24  
 130.81.180.4 : 12  
 130.81.29.238 : 12  
 130.81.29.236 : 12  
 130.81.49.94 : 12  
 152.63.16.185 : 9  
 152.63.17.21 : 9  
 4.69.138.254 : 7  
 152.63.3.118 : 6  
 4.68.127.21 : 6  
 4.69.138.222 : 5  
 4.69.141.21 : 4  
 152.63.10.25 : 4  
 199.181.132.250 : 4  
 4.69.132.89 : 3  
 4.69.132.65 : 3  
 152.63.10.29 : 3  
 152.63.9.249 : 3  
 4.69.135.185 : 2  
 69.63.189.16 : 2  
 173.194.35.83 : 2  
 152.52.20.247 : 2  
 4.71.152.22 : 2  
 69.195.198.147 : 2  
 4.69.132.61 : 2  
 12.122.1.209 : 2  
 4.78.132.98 : 2  
 4.68.111.137 : 2  
 4.69.132.53 : 2  
 205.186.154.181 : 2  
 4.69.140.190 : 2  
 152.63.18.73 : 2  
 152.63.21.133 : 2  
 209.131.112.94 : 2  
 69.60.7.195 : 2  
 207.97.227.239 : 2  
 4.68.105.36 : 2  
 64.30.230.20 : 2  
 64.131.82.241 : 2  
 63.246.23.232 : 2  
 63.85.36.74 : 2  
 208.80.152.2 : 2  
 69.60.7.199 : 2  
 152.63.1.57 : 2  
 4.69.141.17 : 2

[/cc]
