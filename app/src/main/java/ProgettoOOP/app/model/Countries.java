package ProgettoOOP.app.model;

public class Countries {
		private String Country;
		private static String Slug;
		private String ISO2;

		public Countries(String country, String slug, String iSO2) {
			this.Country = country;
			Countries.Slug = slug;
			this.ISO2 = iSO2;
		}

		public String getCountry() {
			return Country;
		}
		public void setCountry(String country) {
			this.Country = country;
		}

		public static String getSlug() {
			return Slug;
		}
		public void setSlug(String slug) {
			Countries.Slug = slug;
		}

		public String getISO2() {
			return ISO2;
		}
		public void setISO2(String iSO2) {
			this.ISO2 = iSO2;
		}
		
	
}
