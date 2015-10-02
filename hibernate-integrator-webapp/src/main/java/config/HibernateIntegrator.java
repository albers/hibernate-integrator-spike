package config;

import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

public class HibernateIntegrator implements Integrator {

	private final String action = "create";
	private final Logger logger = Logger.getLogger(HibernateIntegrator.class);

	@Override
	public void integrate(Configuration config, SessionFactoryImplementor factory, 
			SessionFactoryServiceRegistry registry) {
		logger.info("current value: " + config.getProperty(HBM2DDL_AUTO));
		config.setProperty(HBM2DDL_AUTO, action);
		logger.info("updated value: " + config.getProperty(HBM2DDL_AUTO));
	}

	@Override
	public void integrate(MetadataImplementor metadata, SessionFactoryImplementor factory,
			SessionFactoryServiceRegistry registry) {
	}

	@Override
	public void disintegrate(SessionFactoryImplementor factory, SessionFactoryServiceRegistry registry) {
	}

}
