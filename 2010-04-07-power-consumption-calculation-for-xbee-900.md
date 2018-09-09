---
title: Power Consumption Calculation for xbee 900
slug: power-consumption-calculation-for-xbee-900
date_published: 2010-04-07T13:15:03.000Z
date_updated:   2014-03-29T23:48:58.000Z
---


# Power Consumption Calculation for xbee 900


First we calculate our [battery ](http://www.sparkfun.com/commerce/product_info.php?products_id=8818)  
 The battery is rated at 3.7v @ 200 mA to make it easier to convert later we turn it into micro volts.

To calculate the Watt hours = voltage * Amps  
 740,000 micro watt hours = 3.7volts * 200,000 micro amp hours

Now we Calculate the xbee 900 which run at 3.3v:  
 The xbee has 3 modes we have to deal with their consumption:  
 sleep mode: 60 micro amp hours  
 transmit mode: 210,000 micro amp hours  
 receive mode: 80,000 micro amp hours

next is calculating the time ratio  
 We are sending and receiving 100 times a day  
 each takes 1 second  
 thats 200 seconds everyday 73,000 seconds  
 31,556,926 seconds in one year  
 73,000 secs/31,556,926 secs = .002 the xbee is transmitting and receiving during the year

We have combined the 2 events so we can average:  
 80,000 micro amps and 210,00 micro amps = 135,000 micro amps

Now that we have a time ratio we calculate  
 (.002)(3.3volts)(135,000 micro volts) + (.998)(3.3volts)(60 micro volts) = 740, 000 micro amp hours  
 The right side of our calculation gives use Watts and the left gives us Watt hours

891 watts + 197 watts = 740,000 micro amp hours  
 1088 watts = 740,000 micro amp hours  
 740,000/1088 = 680 hours or 35 days on one battery  
 we need this to last at least a year and a half  
 That will be 27 batteries but we’ll need closer to 36 batteries to be safe

The most important number is that for a year and a half we need more then 3600 milliamps at 3.3v
