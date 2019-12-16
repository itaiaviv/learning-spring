# learning-spring
My first spring project for Spring learning

The service demonstrate Hotel rooms reservation system.

After the server is up and running, you can use it's API as follow:
1. Look for guests
  All guests: <service_url>/api/guests
  Specific guest by full name: <service_url>/api/guests?firstName=Israel&lastName=Avraham
  Specific guests by first name: <service_url>/api/guests?firstName=Israel
  Specific guests by last name: <service_url>/api/guests?lastName=Avraham
  
2. Look for reservation
  All reservation: <service_url>/api/reservations
 
3. Look for Room-Reservation 
  All room-reservations: <service_url>/api/room-reservation
  All room-reservations in specific date (in format yyyy-MM-dd): <service_url>/api/room-reservation?date=2019-12-31
  
4. Look for room details
  All rooms: <service_url>/api/rooms
