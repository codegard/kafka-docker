# Kafka with Docker



### How to run application

To run application you need to have installed Docker with Docker Compose. 

After clone set `services.kafka.environment.KAFKA_ADVERTISED_HOST_NAME` in `docker-compose.yml` to your Docker instance IP address and then type  

```
docker-compose up --build
```

in main directory with `docker-compose.yml` file to build and run application

After that all components like Zookeeper, Kafka broker, Kafka consumer and Kafka producer should be ready. 
You don't need to install Kafka or Java, in your Docker terminal you should see information about consumed and 
skipped messages.

### Producer

Kafka producer is sending two types of message - Person and Orc. Person message is sent every 2 seconds, Orc is sent
every 5 seconds. 

### Consumer

Kafka consumer is adjusted only to Person message, each Orc message will be skipped after deserialization attempt.

## Authors

* **Mateusz Rataj** - [Mats30](https://github.com/Mats30)
