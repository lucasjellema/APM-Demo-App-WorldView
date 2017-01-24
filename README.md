# APM-Demo-App-WorldView
Convoluted Java EE/ADF application for demonstration purposes: we use it to demonstrate Oracle Management Cloud - Application Performance Monitoring and Log Analytics. 

Application runs at application context root: http://host:port/TheWorldView
The REST service is exposed at: http://host:port/TheWorldAtRestService/resources/world-rss/feed/cnn (the wadl is at TheWorldAtRestService/resources/application.wadl)
The servlet worldlytalk can be accessed directly at http://host:port/TheWorldView/worldlytalk

The application contains:
- two static HTML files that include the APM browser agent (so these pages are tracked as well)
- multiple ADF Faces pages with associated backing beans that write logging
- a page that shows the contents from an RSS News feed; the contents of the feed is retrieved from a REST service that calls out to CNN, BBC, ABC, reuters etc.
- the REST service is also part of the application; created using JAX-RS. (so one part of the application calls out to another part - over REST)
- an ADF BC application module that connects to a database schema
- said database schema contains a view, a table (with all countries of the world) and a PL/SQL functioon; the View calls out to the PL/SQL function; the function slows down any country record in Asia (a performance problem)
- two servlets (/worldlytalk and /moreworldlytalk)

Special problems in the application:
* servlet /worldlytalk has a 20% chance of slowing down for 3 secs; it also has a link to moreworldlytalk - that will fail with an error - and a link to a nonexistent servlet /nonexistingservletmoreworldlytalk
* servlet /moreworldlytalk throws an error (division by zero)
* the REST service for BBC http://141.144.34.222/TheWorldAtRestService/resources/world-rss/feed/bbc slows down deliberately (4 secs at the moment);
  - this REST service can be invoked directly
  - the REST service is also invoked from managed bean NewsRssBean; this bean could be quite a bit more efficient if it would cache information retrieved from the REST service 
* the CountriesCatalog page has two problems:
  - when X is entered as filter value in any of the column headings, an exception is thrown in the ADF BC ViewObjectImpl class
  - each country record returned from the database for a country in Asia is slowed down by 200 ms in PL/SQL function derive_rich_placeholder that is called from view countries_vw on which the Entity Object is based; filter for example on Europe or Africa and the query is quite fast. Include Asian records, and the response time increases.
 * index.html has two  dead image reference (https://xx.yy/non-existing-image.jpg and images/non-existing-image.jpg) and a dead link (imaginarysuperindex.html)
 * News of the World page has "do not press this button' button that will throw and exception

Note: the application produces quite a bit of logging – from the managed beans, the ADF BC components, the Servlets and the JAX-RS classes. Most issues perceived by the end user and found in APM can be related to logfile entries that Log Analytics makes available.
