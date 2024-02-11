Chain of Responsibility
=======================

* Decouple senders of requests from receivers
* Allow more than one object to attempt to handle a request
* Pass the request along a behaviour chain of receivers until it is handled
* Only one object handles the request
* Some requests might not be handled

If a client was given an instance of a handler (created at run time):
```.java
    MessageHandler handler = 
      new BlackListHandler(
        new SpamHandler(
          new ForwardingHandler(
            new DeliveryHandler(null))));
```
The client would simply do:
```.java
    handler.handle(emailMessage);
```