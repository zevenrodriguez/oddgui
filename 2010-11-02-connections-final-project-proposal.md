---
title: "Connections: Final Project Proposal"
slug: connections-final-project-proposal
date_published: 2010-11-02T10:12:58.000Z
date_updated:   2014-03-29T23:31:36.000Z
---
# Connections: Final Project Proposal


Connections is an multiuser interactive installation that uses a mobile web application as a collaboration tool. The system uses various nodes to accomplish this. The mobile application is the input method. A computer with a projector and arduino control the output. A server processes and syncs all communication between the computer, arduino, and mobile application.

**Goal **  
 This project is to highlight the importance of peoples connections. We emit alot of noise in the world, but at at some point we make that connection with someone that drowns out the rest of it.

[![](uploads/com-300x225.jpg "com")](uploads/com.jpg)

<object bgcolor="#000000" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="225" width="400"><param name="data" value="http://www.flickr.com/apps/video/stewart.swf?v=71377"></param><param name="flashvars" value="intl_lang=en-us&photo_secret=be825df155&photo_id=5286114994"></param><param name="allowFullScreen" value="true"></param><param name="src" value="http://www.flickr.com/apps/video/stewart.swf?v=71377"></param><param name="allowfullscreen" value="true"></param><embed allowfullscreen="true" bgcolor="#000000" data="http://www.flickr.com/apps/video/stewart.swf?v=71377" flashvars="intl_lang=en-us&photo_secret=be825df155&photo_id=5286114994" height="225" src="http://www.flickr.com/apps/video/stewart.swf?v=71377" type="application/x-shockwave-flash" width="400"></embed></object>

Here is the working display. The selects 2 bottom squares.

**How it works?**  
 The user visits a website. They will be greeted with this application.

[![](uploads/screens-1024x380.png "screens")](uploads/screens.png)

There they select a color the represents them, followed by selecting a block that will start emitting connection particles. Simultaneously a block (of the same color) will appear in the center “arena”. This is a worm hole for particles. So, if you create a red emitter you create a red collector. Particles have strong rules that attract them to the worm holes. The particles can only make connections once they are in the center “arena”. When particles start emitting they will have there own sound. Finally, at some point 2 different particles will make a connection. Once particles make a connection their combined tone will drown out the rest of the emitting particles.

<div style="align: center;">[![connections](http://farm6.static.flickr.com/5086/5286117978_a198ee0cbb.jpg)](http://www.flickr.com/photos/zevenrodriguez/5286117978/ "connections by zevenwolf, on Flickr")  
 Laying out a pattern to cut out the foam. This was used to fit the the LED blocks.

</div>[![Connections](http://farm6.static.flickr.com/5168/5241719596_3462d17b8c.jpg)](http://www.flickr.com/photos/zevenrodriguez/5241719596/ "Connections by zevenwolf, on Flickr")  
 This the first fitting of the blocks on the foam

[![Connections](http://farm6.static.flickr.com/5287/5241125193_606c65001e.jpg)](http://www.flickr.com/photos/zevenrodriguez/5241125193/ "Connections by zevenwolf, on Flickr")  
 Rune making the connections for the LED blocks

<object bgcolor="#000000" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="226" width="400"><param name="data" value="http://www.flickr.com/apps/video/stewart.swf?v=71377"></param><param name="flashvars" value="intl_lang=en-us&photo_secret=f94a2e0430&photo_id=5241701094"></param><param name="allowFullScreen" value="true"></param><param name="src" value="http://www.flickr.com/apps/video/stewart.swf?v=71377"></param><param name="allowfullscreen" value="true"></param><embed allowfullscreen="true" bgcolor="#000000" data="http://www.flickr.com/apps/video/stewart.swf?v=71377" flashvars="intl_lang=en-us&photo_secret=f94a2e0430&photo_id=5241701094" height="226" src="http://www.flickr.com/apps/video/stewart.swf?v=71377" type="application/x-shockwave-flash" width="400"></embed></object>  
 Testing the interfacing between the computer and led blocks

<object bgcolor="#000000" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" height="225" width="400"><param name="data" value="http://www.flickr.com/apps/video/stewart.swf?v=71377"></param><param name="flashvars" value="intl_lang=en-us&photo_secret=0c4ae6288d&photo_id=5241123965"></param><param name="allowFullScreen" value="true"></param><param name="src" value="http://www.flickr.com/apps/video/stewart.swf?v=71377"></param><param name="allowfullscreen" value="true"></param><embed allowfullscreen="true" bgcolor="#000000" data="http://www.flickr.com/apps/video/stewart.swf?v=71377" flashvars="intl_lang=en-us&photo_secret=0c4ae6288d&photo_id=5241123965" height="225" src="http://www.flickr.com/apps/video/stewart.swf?v=71377" type="application/x-shockwave-flash" width="400"></embed></object>  
 Running the web app with projection display

[![connections](http://farm6.static.flickr.com/5126/5286087468_3895270848.jpg)](http://www.flickr.com/photos/zevenrodriguez/5286087468/ "connections by zevenwolf, on Flickr")  
 Our most excited user.

**Next Steps**

- Fix power issue. Because we are stringing so many of these addressable LEDs. They have a voltage drop off of .3 volts. We are going to address this by using multiple power supplies
- Skin the front
- Create more graphical interaction when particles connect

**Issues**

- We found that decoupling the ground and the data by adding a .1 microfarad cap and 1k resistor in parallel fixed some syncing issues. We found that when we touched the wire the data and clocks would sync up. Eric Rosenthal gave us the idea of decoupling ground and data. We still hadÂ issuesÂ at the end of the 64 leds with sync
