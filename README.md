# hibernate-jug-id-generators
Entity Id Generators for Hibernate based on the Java Uuid Generator project. Initially just uses the time based uuid generator to implement a URL safe, ordered id.
### Usage
To use it decorate the id field of the Hibernate entity with
```
@Id
@GenericGenerator(name="time-based-url-safe", 
                  strategy = "com.imc.hibernate.id.TimeBasedUrlSafeIdGenerator")
@GeneratedValue(generator="time-based-url-safe")
public String id;
```