# Hibernate Integrator Spike

This is a simple demonstration webapp that runs on Wildfly without any previous configuration.

It does so by
- using H2 as the database (available by default on Wildfly)
- creating a datasource with a `*-ds.xml` file
- using `hibernate.hbm2ddl.auto=create` to create tables
- importing saple data from a `import.sql` file

Tested on Wildfly 9.0.1.Final and JBoss AS 7.1.1.Final

## Running the demo

Just build and deploy.
The webapp is available at `http://localhost:8080/hibernate-integrator-spike/`

## Where to activate schema generation

This example works if you set `hibernate.hbm2ddl.auto=create`
in `persistence.xml`.

It does *not* work if you remove the property from `persistence.xml`
and rely on `config.HibernateIntegrator` setting it.
The integrator is being called (see log statements), but no schema
generation is triggered.
