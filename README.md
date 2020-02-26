This is a simple distributed JMS poject using the message broker ActiveMQ.

The project is composed of 3 parts:

1. [producer](https://github.com/achrafsmlali/simple_jms_activeMQ_exemple_spring_boot/tree/master/producer)
2. [consumer](https://github.com/achrafsmlali/simple_jms_activeMQ_exemple_spring_boot/tree/master/consumer)
3. the message broker

For the message broker to be simple I lanched activemq docker image by running the following command. 

`docker run --name actviemq -p 61616:61616 -p 8161:8161 rmohr/activemq`

This commande will expose the broker in the port 61616 and the Web Console in the port 8161.

If you do not want to run in it using docker check this [link](https://activemq.apache.org/version-5-getting-started.html) .


After running the 3 parts you can now send a simple message to the queue by executing a Get request on localhost:8080/messageTosendHere. you will see in the producer logs a log info indicating that the message was sent by the producer to the queue and a secand one in the consumer log indicating that the message was consumed. You can also check the AciveMQ Web console to see the number of pending messages, the number of consumers, messages enqueued and messages Dequeued.  

If you are asked for a username and password while accessing the ActiveMQ Web Console then it's 'admin' for both.

Feel free to suggest edits using Pull Requests.
