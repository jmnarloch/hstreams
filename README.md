# Hibernate Streams

A  JDK 8 wrapper on top of Hibernate Query API

[![Build Status](https://travis-ci.org/jmnarloch/hstreams.svg?branch=hstreams-43)](https://travis-ci.org/jmnarloch/hstreams)

## Features

* Retrieval of Optional query results
* Query to stream conversion
* Typed queries

Current compatibility: [Hibernate 4.3.x](/jmnarloch/hstreams/tree/hstreams-43) / [Hibernate 5.x](/jmnarloch/hstreams/tree/hstreams-5)

See the document that summarizes the introduced [API](api.adoc) changes

## Setup

In order to start and running simply add the artifact to your Maven/Gradle build.

```
<dependency>
    <groupId>com.github.jmnarloch</groupId>
    <artifactId>hstreams43</artifactId>
    <version>1.0.2</version>
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

* LocalDate and LocalTime support - will be natively supported through Hibernate 5
* Optional<?> custom type handler/converter
