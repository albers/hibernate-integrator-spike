package config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Settings;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * This {@link Integrator} enables Hibernate schema generation during deployment.
 * <p>
 * The Integrator is invoked too late to accomplish this by setting the
 * {@code hibernate.hbm2ddl.auto} property, so the {@link Settings} have to be
 * manipulated directly via relection.
 * <p>
 * I don't think this should be used in production.
 */
public class AutoCreateSchemaIntegrator implements Integrator {

	private final Logger logger = Logger.getLogger(AutoCreateSchemaIntegrator.class);

	@Override
	public void integrate(Configuration config, SessionFactoryImplementor factory, 
			SessionFactoryServiceRegistry registry) {
		Settings settings = factory.getSettings();
		logger.info("AutoCreateSchema is " + settings.isAutoCreateSchema());
		
		try {
			setAutoCreateSchema(settings);
			logger.info("AutoCreateSchema set to " + settings.isAutoCreateSchema());
		} catch (Exception e) {
			logger.error("could not update Hibernate configuration", e);
		}

	}

	private void setAutoCreateSchema(Settings settings)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method setter = settings.getClass().getDeclaredMethod("setAutoCreateSchema", boolean.class);
		setter.setAccessible(true);
		setter.invoke(settings, true);
	}

	@Override
	public void integrate(MetadataImplementor metadata, SessionFactoryImplementor factory,
			SessionFactoryServiceRegistry registry) {
	}

	@Override
	public void disintegrate(SessionFactoryImplementor factory, SessionFactoryServiceRegistry registry) {
	}

}
