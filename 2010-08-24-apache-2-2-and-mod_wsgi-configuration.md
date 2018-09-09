---
title: Apache 2.2 and mod_wsgi configuration
slug: apache-2-2-and-mod_wsgi-configuration
date_published: 2010-08-24T19:34:27.000Z
date_updated:   2014-03-29T23:52:29.000Z
---

# Apache 2.2 and mod_wsgi configuration


I finally got mod_wsgi to work. mod_wsgi is a module that lets you run python scripts on your webserver. You need to have access to install applications and configure apache

For information about mod_wsgi and more elaborate explanations on configuration and installation visit http://code.google.com/p/modwsgi/

I am running centos5.4, apache 2.2, and python 2.6.5

First create a directory to do the initial download of mod_wsgi’s code

cd into that directory

Then do a wget mod_wsgi’s google code site and find the version you need

That should look something like this:  
 wget http://modwsgi.googlecode.com/files/mod_wsgi-3.3.tar.gz

This command unpacks the tarball:  
 tar xvfz mod_wsgi-3.3.tar.gz

cd into the unpacked mod_wsgi-3.3 folder

type: ./configure

once configured

type: make

type: make install

Once that is done we want to restart the apache server

cd into etc/ from your top most or / directory and

type: service httpd stop

You will get and OK if everything is fine

type: service httpd start

One way to know that it installed correctly is going into your apache modules file and making sure that mod_wsgi.so is in that folder. In my install of apache2.2, the modules are located in etc/httpd/modules

The most important part of configuring apache with mod_wsgi is to make sure what your DocumentRoot is.

In CentOS my apache2.2 configuration file was located in etc/httpd/conf/httpd.conf

cd into etc/httpd/conf

when you type: nano httpd.conf it loads the nano file editor

The DocumentRoot is where when you visit www.example.com  
 the initial directory that opens when you visit your website

httpdocs is my root directory. All of my site files are located there

DocumentRoot /var/www/vhosts/zevenwolf.com/httpdocs

Apache wants the serverpath of where files like index.html might reside

load module enables mod_wsgi when a person visits the script

This should be placed with in your Apache sites configuration which is normally located at the bottom of the httpd.conf file

LoadModule wsgi_module modules/mod_wsgi.so

This portion of the code tells mod_wsgi that in the python_projects directory located in the serverpath var/www/vhosts/zevenwolf.com/httpdocs/python_projects/  
 there are files that need to run mod_wsgi

WSGIScriptAlias /python_projects/ /var/www/vhosts/zevenwolf.com/httpdocs/python_projects/

<directory>  
 Order deny,allow  
 Allow from all  
</directory>

The mistake I initially made was not putting the httpdocs. I originally wanted to host this folder outside of httpdocs, so my serverpath looked like this:

/var/www/vhosts/zevenwolf.com/python_projects/

Because the DocumentRoot is set at /var/www/vhosts/zevenwolf.com/httpdocs/

When you visit www.zevenwolf.com/python_projects  
 the serverpath you go to is /var/www/vhosts/zevenwolf.com/httpdocs/python_projects

So once I added the httpdocs it worked. My final apache code for my site looks like this:

<virtualhost>  
 DocumentRoot /var/www/vhosts/zevenwolf.com/httpdocs  
 ServerName www.zevenwolf.com  
 ServerAlias zevenwolf.com zevenrodriguez.com www.zevenrodriguez.com zevenwithaz.com www.zevenwithaz.com  
 ErrorLog logs/zevenwolf.com-error_log  
 CustomLog logs/zevenwolf.com-access_log common  
<directory>  
 AllowOverride All  
</directory>  
 ScriptAlias /cgi-bin/ /var/www/vhosts/zevenwolf.com/cgi-bin/</virtualhost>

LoadModule wsgi_module modules/mod_wsgi.so

WSGIScriptAlias /python_projects/ /var/www/vhosts/zevenwolf.com/httpdocs/python_projects/

//<directory>  
 Order deny,allow  
 Allow from all  
 //</directory>

//
