# APM-Demo-App-WorldView
Convoluted Java EE/ADF application for demonstration purposes: we use it to demonstrate Oracle Management Cloud - Application Performance Monitoring and Log Analytics. 

Application runs at application context root: http://host:port/TheWorldView
The REST service is exposed at: http://host:port/TheWorldAtRestService/resources/world-rss/feed/cnn (the wadl is at TheWorldAtRestService/resources/application.wadl)


The application contains:
- two static HTML files that include the APM browser agent (so these pages are tracked as well)
- multiple ADF Faces pages with associated backing beans that write logging
- a page that shows the contents from an RSS News feed; the contents of the feed is retrieved from a REST service that calls out to CNN, BBC, ABC, reuters etc.
- the REST service is also part of the application; created using JAX-RS. (so one part of the application calls out to another part - over REST)
- an ADF BC application module that connects to a database schema
- said database schema contains a view, a table (with all countries of the world) and a PL/SQL functioon; the View calls out to the PL/SQL function; the function slows down any country record in Asia (a performance problem)
