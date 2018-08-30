package part02;

public enum SupRegion {
	UNITED_KINGDOM {
		@Override
		String getEnumAsString() {
			// TODO Auto-generated method stub
			return "United Kingdom";
		}
	}, EUROPE {
		@Override
		String getEnumAsString() {
			// TODO Auto-generated method stub
			return "Europe";
		}
	}, OUTSIDE_EU {
		@Override
		String getEnumAsString() {
			// TODO Auto-generated method stub
			return "Outside EU";
		}
	};
	
	abstract String getEnumAsString();

}
