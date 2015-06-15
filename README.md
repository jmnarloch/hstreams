# Hibernate Streams

A  JDK 8 wrapper on top of Hibernate Query API

[![Build Status](https://travis-ci.org/jmnarloch/hstreams.svg?branch=master)](https://travis-ci.org/jmnarloch/hstreams)

## Features

* Retrieval of Optional query results
* Query to stream conversion
* LocalDate and LocalTime as query parameters
* Typed queries

Current compatibility: Hibernate 4.3.x / Hibernate 5.x

See the document that summarizes the introduced [API](api.adoc) changes

## Setup

In order to start and runing simply add the artifact to your Maven/Gradle build.

```
<dependency>
    <groupId>com.github.jmnarloch</groupId>
    <artifactId>hstreams</artifactId>
</dependency>
```

## Example

```
SessionFactory originalFactory = ...;

StreamSessionFactory factory = Streams.wrap(originalFactory);
StreamSession session = factory.getCurrentSession();

long count = session.createQuery("from User")
        .stream()
        .count();

Optional<User> admin = session.createTypedQuery("from User where id = :id", User.class)
        .setParameter("id", 1l)
        .stream()
        .findFirst();

Optional<User> user = session.getOptional("User", 1l);
```

## Todo

* Optional<?> custom type handler/converter 
