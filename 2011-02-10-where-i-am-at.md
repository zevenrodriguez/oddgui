---
title: Where I am at.....
slug: where-i-am-at
date_published: 2011-02-10T13:01:21.000Z
date_updated:   2014-03-29T23:29:13.000Z
---

# Where I am at.....

*Skip to **how it works** if you have read my previous thesis post  
*  
 Zevensuy Rodriguez

Last semester I embark on creating a interactive art installation controlled by a mobile phone. The main thing I learned from that project was that people are not accustomed to using the phone to control installations. Touchscreens from phones to larger touch surfaces are all over the place. There is an underlying vocabulary(gestures) on how to use touchscreens. Yet, the vocabulary on how touchscreens can successfully work installations has yet to be fully explored.  
 Understanding how touchscreens and interactive installations can work effectively is the key. For my thesis, I will lay out the framework for use cases and best practices for touchscreens in interactive installation. I will make the interface builder and establishing the protocol by which to talk to the networked installations. By offering this service, designers could start thinking of how to make exhibits interaction with touchscreens more viable. This will create the dialogue between the users and the institutions that use the service.  
 The philosophy of the project is simplicity. I want users to be able to design, monitor, and simplify wiring of the projects. This allows for a quick turn around in the creating, testing, and implementation phase. When patrons use the system, logging user interactions can quantify what works and does not work in interface and the exhibit. By being able to iterate and collect data from projects, we can further the dialogue and ultimately create an exhibit or installation that fully conveys the designers intent.  
 What I would like to achieve with my project is be able to let designers tell a story through a user’s interaction with touchscreens and use that input to interact with an exhibit or art piece. For example, by using touch screens from a mobile device we can display information about an exhibit but we can also highlight important objects or parts of objects by letting users control the exhibit. By making interactive exhibits networked objects, we could make them more vibrant, up-to-date, and collect user interaction information.  
 The main goal is to let designers create an interface that will control an installation. The user will login to their project on the website. Then they will setup what the interface will control, i.e. motor, light, projection, etc. The program will supply you with the code to interface between the online interface and the micro controller. You will have to put to the circuits together and provide a touchscreen surface to display your interface. The site will offer approved hardware and tutorials as a guide. This is the ultimate goal for the project.

Questions to be asked:  
 What is your favorite interactive exhibit or art piece you’ve made?

What piece you’ve made has had the most sophisticated interaction?

What is your least successful interaction in an exhibit and why?

When do you use a touchscreen for interaction?

Have you used touchscreens to control physical objects?

Have you considered a phones touch screen as a method for interaction? Ie like a remote control

Given the chance and ease, would you redesign exhibit interfaces on a regular bases?

Is remote monitoring of an exhibit important to you?

How it works?  
 This project uses TCP/IP for communication between the input and output devices. There are 3 layers used project: input (touchscreen or interaction device and the web interface layout), processing(turning the input into output), and output(installation being controlled). All interactions with the system are logged into a database from clicking a button to LED brightness. This allows monitoring and fixing of issues that could arise in an installation. By making individual elements in the system networked object, we have the flexibility of changing interactions and diagnosing issues from a remote distance.

Input  
 One of the goals of this project is to simplify the interaction with physical objects. I am not interested in the creation of touchscreens, but in the interface that determines the interaction. The interface builder is a way to prototype and deploy the interaction for an exhibit. When you log on the your project, a general setup is required. Choosing the micro-controller, LEDs, motors, video, or any other software/hardware device will give the program an idea of how to setup the output. Setting up your buttons, sliders, or gestures involve you telling them what they will control. For example, BUTTON1 turns LED1 ON or OFF.

Processing  
 Once done with setting up and deploying your interface, we need to transfer your input into output. Every time an interaction is made, a message is sent out to update the database which then is translated into the output. Since this is a web based system, every interaction can be viewed as a click from a mouse. When BUTTON1 is pressed, it hits a web page which tells the database change the LED1 to ON. All this happens on the same page, thus making a smooth interactive experience.

 In order to keep a simple yet modular communication we use a RESTian model. The reason to use this model is as the project grows it will make it easy to interface with other internet input and output devices. In our example, BUTTON1 turns LED1 ON or OFF, we said that it hits a web page that changes the database and subsequently turns on the LED. Normally a website would handle this with the query string: www.controllingsite.com/project/input.php?Button1=LED1&LED1=ON. This looks ugly and though legible makes it more difficult to create a standardized approach to access the system. Under a RESTian model the URL would look like this: www.controllingsite.com/project/input/BUTTON1/LED1/ON. This gives us a logical order and a simple pattern to work with. Virtually any internet device can be setup to control the led. This is because the led is linked to this adddress www.controllingsite.com/project/input/BUTTON1/LED1/ON. When you hit this link the LED would turn on.

Output  
 As inputs change state or value, they are update on the database. The web application would output an xml or json object. These are standardized formats that can easily be read in by hardware and software. The hardware or software constantly checks these files for changes and ultimately would change the interaction when the interface changes. They provide the blue print for seamless communication between the online interface and the exhibit.

Why touchscreens?  
 Touchscreens are displays with a layer capable of transferring touch into a location on the screen. Most touchscreens use either lcd or projector to display content. Touchscreen use either electronic or optical sensors to detect the position of the touch. There are a myriad of different technologies that can be used in touchscreens that range in price, sophistication, and size. This has helped propagate touchscreen virtually in all elements in our life.

 The advantage of using touchscreens is the fact that because it is a display surface you can change. Being able to update content easily is crucial to the project. The system will give you a project overview. Designers can study usage patterns and update the user experience based on the overview.

Vocabulary  
 It is important to understand what kinds of interactions translate from a touchscreen to a physical object. Prior to the launch of the Iphone, touchscreens were a tool for corporations. Touchscreen interaction was limited to a stylus and simple finger clicks. Museums used touchscreens for basic interactions like clicking. The smartphone and more importantly the Iphone came into the market giving users a new interactive experience. The Iphone introduced to the masses a series of gesture, click and hold, flick, pinch in and out, slide, and rotate. Gestures is not a new concept. Early Palm devices used the stylus to make gestures. The Iphone increase our touchscreen vocabulary. More importantly it transferred us from the stylus to our finger. This makes us more connected to what we are controlling.

 More and more gestures are being explored. Due to current web technology, multi-touch on the web is in its early stages. Understanding simple actions like click and slide effectively are important before we can start talking about multi-touch gestures.

 Movies from Star Trek to Minority Report gave us ideas of possible large touchscreen interactions. The Iphone has sold millions of devices but we do not all have a Microsoft Surface in our apartments or offices. The expense of a large touchscreen is rather large. Luckily we live in an age where there is a strong DIY movement. Open hardware/software groups like the NUI Group have create resources and programs that have brought the price point of a large touchscreen from $10,000 to under a $1000. The question is how do we use touchscreens properly?

 Understanding how and when to use a large touchscreen or mobile device in an installation is a difficult. Large touchscreens can add a community environment to an exhibit. People can gather around and share, collaborate, and learn from each other. Mobile phones can add a community to your exhibit. People are more introverted on their phones, but there is a possibility to add an infinite number of users with a given piece. Because these are soft interfaces on the web, the possibility arises to tailor and experience from a large touchscreen to a mobile phone.

Inspiration  
 TouchOSC  
 http://hexler.net/software/touchosc

 TouchOSC is a remote control application that uses open sound control messages to control media. It runs on mobile devices like Iphone, Ipad, and Android devices. One device controls the other over a local wifi network. Open Sound Control or OSC is a standardized communication protocol. It takes a RESTian approach to interface with different programing languages and software. The model for the message looks like this: /servo/position 512. The program on the micro-controller or software can breakdown the message and your code can follow the instruction. Because touchOSC’s interface only outputs these osc messages, it does not have to deal with receiving the message. This puts the onus on the user to interpret the message in their program. TouchOSC offers an interface builder. The builder has a set number of interface modules and uses a specific esthetic. With the editor you can design your layout and load it on your device.  
 TouchOSC is meant to run on a mobile device and control software or hardware. Its use case is for controlling music software. So it is intended as a one to one communication. A local network is used to communicate from your mobile device to a computer. This requires additional setup which makes the end user experience a bit clunky.

Open Exhibits  
 Open exhibits is a Adobe Flash based touchscreen interface builder. The main audience is in the educational space, like museums and educational institutions. It uses and open API and a series of modules that help connect to social media sites and sites like youtube and flickr. This could be interesting because institutions can take advantage of there presence on these networks. They would be able to reuse content that has already be produced in there exhibit. It has capability of understanding gestures which makes it able to mimic similar interactions we are used to with our phones. Because it is flash based, you need to know flash to program it. This also makes it difficult to deploy in the mobile space. Because it is meant to interface with existing web content it is not suited to interface with hardware.

LemurTron  
 http://www.lemurbots.org/PressPhotos/Images/LEMURtron3_Evan_Cairo.jpg  
 http://www.lemurbots.org/PressPhotos/Images/LEMURtron4_Evan_Cairo.jpg

 LemurTron is an robotic instrument orchestra controlled by physical user input. A series of robotic instruments are placed around the room. In the center is a projected interface that changes. A camera placed on top captures movement of the users on the interface. As the interface changes, the interaction with the instrument changes. What is interesting about this project is that the hardware stays the same, but the interactions can change. This makes for the user experience to always be fresh. By making the interfaces web based, more interfaces could be added and tested remotely.  
 At a talk that Eric Singer from the Lemur Group gave, he mentioned that diagnosing issues was a crucial part for this project since it was a traveling exhibit. He was able to monitor it by placing a webcam in the room and looking to see if the robots were working correctly. By making the robot networked object, one would be able to control the robots remotely. If sensors were added to the robot, you could check on there operation remotely with out a webcam setup.

Bibliography

Sheridan, Thomas B. Telerobotics, Automation, and Human Supervisory Control. Cambridge, MA: MIT, 1992. Print.  
 Kuniavsky, Mike.Â Smart Things: Ubiquitous Computing User Experience Design. Amsterdam: Morgan Kaufmann, 2010. Print.  
 Geller, Matthew.Â From receiver to remote control: the TV set. New York: The New Museum of Contemporary Art, 1990. Print.  
 Goldberg, Ken, and Roland Siegwart.Â Beyond Webcams: an Introduction to Online Robots. Cambridge, MA: MIT, 2002. Print.  
 Kintzig, Claude.Â Communicating with Smart Objects. London: Kogan Page Science, 2003. Print.

Norman, Donald A.Â The Design of Everyday Things. New York: Basic, 2002. Print.

3quarksdaily. Web. 10 Feb. 2011. <>. </>
