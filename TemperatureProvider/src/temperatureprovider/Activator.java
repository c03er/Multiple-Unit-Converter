package temperatureprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration serviceRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Temperature temperatureService = new TemperatureImpl();
		serviceRegistration = context.registerService(Temperature.class.getName(), temperatureService, null);
		System.out.println("Temperature provider started");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		serviceRegistration.unregister();
		System.out.println("Temperature provider stopped");
	}

}
