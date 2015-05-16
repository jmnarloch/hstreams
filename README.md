# hibernate-streams-wrapper 

A  JDK 8 wrapper on top of Hibernate Query API

[![Build Status](https://travis-ci.org/jmnarloch/hibernate-streams-wrapper.svg?branch=master)](https://travis-ci.org/jmnarloch/hibernate-streams-wrapper)

## Features

* Retrieval of Optional query results
* Query to stream conversion

## Example

```
SessionFactory originalFactory = ...;

StreamSessionFactory factory = Streams.wrap(originalFactory);
StreamSession session = factory.getCurrentSession();

long count = session.createQuery("from User")
        .stream()
        .count();

Optional<?> admin = session.createQuery("from User where id = :id")
        .setParameter("id", 1l)
        .optionalResult();

Optional<?> user = session.getOptional("User", 1l);
```

## Todo

* Typed queries
* Optional<?> custom type handler/converter 
