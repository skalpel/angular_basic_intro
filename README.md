Very basic introduction to AngularJS.
=====================================

Repository consists of two projects. **yoblog** is web client used to publish and list blog posts.
It is Angular application generated by *yo* with *angular generator*. **sparking** is Java backend for the blog.
It provides some simple storage for the blog and its posts. It uses *Sparkjava* web framework to process client requests.

#### How to run application

There are multiple ways to do that but one of most user friendly is to:
* On command line go to *sparking* directory and call 'mvn compile exeec:java -Dexec.mainClass="com.codeforfun.App"'
* On command line go to *yoblog* directory and run 'grunt serve' (make sure all bower and npm components has already been installed,
if not please run 'bower install & npm install'). It shall deploy client on embedded server and open browser with running application.

#### Tools used to scaffold client.
* [Yeoman](http://yeoman.io/): Used to scaffold web applications. It supports e.g. scaffolding angular applications
* [Grunt](http://gruntjs.com/): JavaScript task runner. It has multiple plugins that let e.g. deploy and run application on embedded jetty server,
do real TDD (listening to code and test changes and runing all unit tests if necessary)
* [Bower](http://yeoman.io/): JavaScript dependency manager.
* [WebStorm](http://yeoman.io/): Web application (including JavaScript) friendly IDE

#### Recommended tutorials.
* Yeoman, Grunt, Bower and scaffolding AngularJS application (it is also good for getting basic knowledge about how AngularJS works): [http://yeoman.io/codelab.html](http://yeoman.io/codelab.html)
* AngularJS: [http://campus.codeschool.com/courses/shaping-up-with-angular-js/intro](http://campus.codeschool.com/courses/shaping-up-with-angular-js/intro)