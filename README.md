# Hibernate Integrator Spike

This is a simple JPA based demonstration webapp that runs on Wildfly without any previous configuration.

It does so by
- using H2 as the database (available by default on Wildfly)
- creating a datasource with a `*-ds.xml` file
- using Hibernate auto schema creation to create tables
- importing data from an `import.sql` file

Tested on Wildfly 9.0.2.Final and JBoss AS 7.1.1.Final

## The Webapp

The demo is a simple JSF based page that shows all the names stored in the database.
You can add names to that database.

## The Modules

**model** contains the persistence classes. Note that the `persistence.xml` does _not_ set the property `hibernate.hbm2ddl.auto`.

**webapp** uses **model**. It uses a Hibernate `Integrator` to enable auto schema generation for just this deployment unit.

## Running the Ddemo

Just build and then deploy the webapp.
The webapp is available at http://localhost:8080/hibernate-integrator-spike/

## Why Should I do This?

This is not meant for use in production.
Use this if you want to supply a simple demonstration webapp alongside with your persistence modules. 

See this [stackoverflow post](http://stackoverflow.com/questions/32762150/how-to-set-hibernate-hbm2ddl-auto-on-deployment-in-wildfly-not-using-persistence) for the motivation behind this demo.
