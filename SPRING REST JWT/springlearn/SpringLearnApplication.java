// Hands-on 4: Display Country
public void displayCountry() {
    LOGGER.info("START - displayCountry()");
    
    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    Country country = context.getBean("country", Country.class);
    Country anotherCountry = context.getBean("country", Country.class);
    
    LOGGER.debug("Country : {}", country.toString());
    LOGGER.debug("Another Country : {}", anotherCountry.toString());
    
    // Check if same instance (Singleton vs Prototype)
    LOGGER.debug("Same instance: {}", country == anotherCountry);
    
    LOGGER.info("END - displayCountry()");
}

// Hands-on 6: Display Countries List
@SuppressWarnings("unchecked")
public void displayCountries() {
    LOGGER.info("START - displayCountries()");
    
    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    java.util.ArrayList<Country> countryList = context.getBean("countryList", java.util.ArrayList.class);
    
    LOGGER.debug("Countries List: {}", countryList);
    
    for (Country country : countryList) {
        LOGGER.debug("Country: {} - {}", country.getCode(), country.getName());
    }
    
    LOGGER.info("END - displayCountries()");
}
