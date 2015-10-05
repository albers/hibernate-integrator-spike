# Hibernate Integrator Spike

This is a simple demonstration webapp that runs on Wildfly without any previous configuration.

It does so by
- using H2 as the database (available by default on Wildfly)
- creating a datasource with a `*-ds.xml` file
- using Hibernate auto schema creation to create tables
- importing sample data from a `import.sql` file

Tested on Wildfly 9.0.1.Final and JBoss AS 7.1.1.Final

## The Modules

**model** contains the persistence classes. Note that the `persistence.xml` does not set the property `hibernate.hbm2ddl.auto`.

**webapp** uses **model**. It uses a Hibernate `Integrator` to enable auto schema generation for just this deployment unit.

## Running the demo

Just build and then deploy the webapp.
The webapp is available at `http://localhost:8080/hibernate-integrator-spike/`

## Why should I do this?

This is not meant for use in production.
Use this if you want to supply a simple demonstration webapp alongside with your
persistence modules. 