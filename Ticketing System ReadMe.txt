Ticketing System
How to run this application?

Pre requisites:
MongoDB
Tomcat 7 or any other similar server
Eclipse or other similar IDE

Technologies used:
a. RESTful web services
b. MongoDB
c. AngularJS

Enter new ticket?
http://localhost:8080/TicketingSystem/rest/ticket/insert/{customer Name}/{comments}/{created by}/{assigned to}/{status}
EX: http://localhost:8080/TicketingSystem/rest/ticket/insert/hardi2/order%20not%20delivered/mary/thomas/new
EX: http://localhost:8080/TicketingSystem/rest/ticket/insert/durva/incomplete%20order%20received/mary/thomas/new

View all tickets?
http://localhost:8080/TicketingSystem/rest/ticket/getTickets

View a ticket by name?
http://localhost:8080/TicketingSystem/rest/ticket/get/{custName}
EX: http://localhost:8080/TicketingSystem/rest/ticket/get/hardi

Update a ticket?
http://localhost:8080/TicketingSystem/rest/ticket/update/{customer Name}/{comments}/{created by}/{assigned to}/{status}
EX: http://localhost:8080/TicketingSystem/rest/ticket/update/durva/order%20completed/mary/thomas/closed

Delete a ticket?
http://localhost:8080/TicketingSystem/rest/ticket/update/{customer Name}
EX: http://localhost:8080/TicketingSystem/rest/ticket/update/hardi

Application GUI is available at http://localhost:8080/TicketingSystem/?


Other:
1. Try to insert ticket once. Application will automatically create required db and collection in your mongodb database running locally. Database Name: "myDB" , Collection Name: "ticketingsystem"
2. Open application in any IDE..Eclipse is preferrable


