package ProgettoOOP.app.filters;

import java.io.IOException;

import ProgettoOOP.app.database.DatabaseCountryAllStatus;
import ProgettoOOP.app.exception.NotValidStatus;

public class FiltersAllStatus {

		public static String gettingfilterStatus(String status) throws IOException {

			if (status.toLowerCase().contentEquals("confirmed"))
				return DatabaseCountryAllStatus.OrderingConfirmed();
			else if (status.toLowerCase().contentEquals("deaths"))
				return DatabaseCountryAllStatus.OrderingDeaths();
			else if (status.toLowerCase().contentEquals("recovered"))
				return DatabaseCountryAllStatus.OrderingRecovered();
			else if (status.toLowerCase().contentEquals("active"))
				return DatabaseCountryAllStatus.OrderingActive();
			else
				throw new NotValidStatus();
			
		}

}
