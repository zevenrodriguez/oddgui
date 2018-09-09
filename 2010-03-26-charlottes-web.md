---
title: Charlotte's Web
slug: charlottes-web
date_published: 2010-03-26T14:30:41.000Z
date_updated:   2014-03-29T23:48:24.000Z
---
#C harlotte's Web


Zeven and I are creating a solar powered tone generator for our final with a form factor of a spider. A miller engine circuit will power the “legs” which will act as switches to set off the tones.

We are using the simple LM 386 amplifier circuit and a hacked into Hex Schmitt Trigger. Both circuits are powered by four solar panels wired in Series and Parallel. The buzzing oscillator sound is a square wave and runs on 6 volts.  
[![](uploads/audiocircuit.jpg "audiocircuit")](uploads/audiocircuit.jpg)

The Miller Engine Circuit is powered by 4 solar panels wired in parallel creating 80 -100 miliamps and 3 volts. A small geared page motor acts as a “leg” switch to turn on the audio circuit.  
[![](uploads/miller-engine.jpg "miller-engine")](uploads/miller-engine.jpg)

Right now we are having an issue with the miller engine. Our amperage for our circuit is being lost somewhere in our circuit. We are only getting 25mA out of a possible 130mA. After testing the capacitors, trigger, and transistor we have found out that those are not the problems. We now assume it could be the signal pin on the voltage trigger not letting all of the amperage through.
