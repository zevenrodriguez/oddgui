---
title: Sparkfun OpAmp Breakout  LMV358
slug: sparkfun-opamp-breakout-lmv358
date_published: 2011-10-18T19:56:37.000Z
date_updated:   2014-03-29T23:26:52.000Z
---

# Sparkfun OpAmp Breakout  LMV358

The LMV358/LMV324 are low voltage (2.7â5.5V) versions of the dual and quad op amps, LM358/LMV324, which currently operate at 5â30V. If you need to use a piezo as an analog sensor into the arduino, this is the chip and breakout board to use. Most OpAmp chips operate by looking at 2 voltages and amplifying the difference between them. Â  The chip has a pot that lets you dial in the amplitude of that difference. One thing I noticed is that when I hit the piezo you get negative values. This can be fixed by using an absolute value function. This happens because in order to contain huge spikes in the voltage of a piezo(+30v), the breakout board uses a voltageÂ dividerÂ which manages that voltage and sets the output of the OpAmp at 2.5 volts. Tom and I used anÂ oscilloscopeÂ to verify this. This is important because the when you hit the piezo it spikes to +5 and to 0. This makes sure that we do not send too much positive voltage to the arduino and negative voltage which would fry it.

[http://www.sparkfun.com/products/9816](http://www.sparkfun.com/products/9816)

[![Sparkfun OpAmp Breakout LMV358](http://farm7.static.flickr.com/6234/6258550298_af86510473.jpg)](http://www.flickr.com/photos/zevenrodriguez/6258550298/ "Sparkfun OpAmp Breakout LMV358 by zevenwolf, on Flickr")
