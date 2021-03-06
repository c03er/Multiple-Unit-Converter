package datatransferrateprovider;

public class DataRateImpl implements DataRateService{

	@Override
	public double KbPsToMbPs(double amount) {
		System.out.println("Converting Kbps to Mbps");
		return amount * 0.0009765625;
		
	}

	@Override
	public double MbPsToKbPs(double amount) {
		return amount * 1024;
	}

	@Override
	public double MbPsToGbPs(double amount) {
		return amount * 0.000977;
	}

	@Override
	public double GbPsToMbPs(double amount) {
		return amount * 1024;
	}

	@Override
	public double KbPsToGbPs(double amount) {
		return amount * 0.000001;
	}

	@Override
	public double GbPsToKbPs(double amount) {
		return amount * 1048576;
	}
}
