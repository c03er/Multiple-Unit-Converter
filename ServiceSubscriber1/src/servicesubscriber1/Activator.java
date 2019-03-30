package servicesubscriber1;

import datatransferrateprovider.DataRateService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import lengthprovider.Length;
import massprovider.Mass;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import temperatureprovider.Temperature;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference TemperatureReference;
	private ServiceReference LengthReference;
	private ServiceReference MassReference;
	private ServiceReference DTRReference;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		System.out.println("Start Subscriber Service");
		
		TemperatureReference = context.getServiceReference(Temperature.class.getName());
		Temperature temperature = (Temperature) context.getService(TemperatureReference);
		
		LengthReference = context.getServiceReference(Length.class.getName());
		Length length = (Length) context.getService(LengthReference);
		
		MassReference = context.getServiceReference(Mass.class.getName());
		Mass mass = (Mass) context.getService(MassReference);
		
		DTRReference = context.getServiceReference(DataRateService.class.getName());
		DataRateService dtr = (DataRateService) context.getService(DTRReference);
		
		try {
			System.out.println("------------------------------------------");
			System.out.println("\n\n\n");
			System.out.println("Select Number to Proceed");
			System.out.println("01 - Data Rate Conversions");
			System.out.println("02 - Length Conversions");
			System.out.println("03 - Temperature Rate Conversions");
			System.out.println("04 - Mass Conversions");
			System.out.println("\n\n");
			System.out.println("------------------------------------------");
			System.out.println("Enter blank line to exit program");

			String inputStream = "";
			BufferedReader bufferedStream = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				System.out.println("Select option Number : \n");
				inputStream = bufferedStream.readLine();

				if (inputStream.isEmpty()) {
					System.out.println("Exiting......");
					break;
				} else if (inputStream.equals("1")) {
					dtr.KbPsToMbPs(100);

				} else if (inputStream.equals("2")) {
					length.KMtoMiles(100);

				} else if (inputStream.equals("3")) {
					temperature.startTemperatureService();

				} else if (inputStream.equals("4")) {
					mass.MassTest();

				}

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}