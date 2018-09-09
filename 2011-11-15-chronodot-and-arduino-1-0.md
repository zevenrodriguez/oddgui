---
title: ChronoDot and Arduino 1.0
slug: chronodot-and-arduino-1-0
date_published: 2011-11-15T15:45:14.000Z
date_updated:   2014-03-29T23:26:41.000Z
---

# ChronoDot and Arduino 1.0

Recently I updated LadyAda’s RTC Library for Arduino 1.0 and older versions. In arduino 1.0 the wire library changed. It is now wire.read and wire.write. I also found that when you do use the write(0), Arduino would interpret the 0 as an integer. The new wire library does not. Because of this I had to explicitly say int i = 0;

The code can be found here [https://github.com/adafruit/RTClib](https://github.com/adafruit/RTClib)

[![ChronoDot and Arduino](http://farm7.static.flickr.com/6221/6347082745_30f8665268.jpg)](http://www.flickr.com/photos/zevenrodriguez/6347082745/ "ChronoDot and Arduino by zevenwolf, on Flickr")

The red wire power goes to 3.3v. Black goes to ground. SDA (Data), the green wire, goes to Analog Pin 4. SCL (Clock), the yellow wire, goes to Analog Pin 5.
