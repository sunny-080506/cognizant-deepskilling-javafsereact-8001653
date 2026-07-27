package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    private static CountryRepository countryRepository;
    private static StockRepository stockRepository;

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        countryRepository = context.getBean(CountryRepository.class);
        stockRepository = context.getBean(StockRepository.class);

        // Uncomment the method you want to test

        // Hands-on 1: Country queries
        // testCountryQueries();

        // Hands-on 2: Stock queries
        // testStockQueries();

        // Hands-on 4: Get Employee with Department
        // testGetEmployee();

        // Hands-on 4: Add Employee
        // testAddEmployee();

        // Hands-on 4: Update Employee
        // testUpdateEmployee();

        // Hands-on 5: Get Department with Employees (EAGER)
        // testGetDepartment();

        // Hands-on 6: Add Skill to Employee
        // testAddSkillToEmployee();
    }

    // -------------------- Hands-on 1 --------------------
    private static void testCountryQueries() {
        LOGGER.info("Start");

        // 1. Containing "ou"
        List<Country> containing = countryRepository.findByNameContaining("ou");
        LOGGER.debug("Countries containing 'ou': {}", containing);

        // 2. Containing "ou" sorted ascending
        List<Country> sorted = countryRepository.findByNameContainingOrderByNameAsc("ou");
        LOGGER.debug("Countries containing 'ou' sorted: {}", sorted);

        // 3. Starting with 'Z'
        List<Country> startingZ = countryRepository.findByNameStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", startingZ);

        LOGGER.info("End");
    }

    // -------------------- Hands-on 2 --------------------
    private static void testStockQueries() throws ParseException {
        LOGGER.info("Start");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 1. Facebook in September 2019
        Date start = sdf.parse("2019-09-01");
        Date end = sdf.parse("2019-09-30");
        List<Stock> fbSept = stockRepository.findByCodeAndDateBetween("FB", start, end);
        LOGGER.debug("FB stocks Sept 2019: {}", fbSept);

        // 2. Google stocks with close > 1250
        List<Stock> googleHigh = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250);
        LOGGER.debug("Google stocks with close > 1250: {}", googleHigh);

        // 3. Top 3 highest volume
        List<Stock> topVolume = stockRepository.findTop3ByOrderByVolumeDesc();
        LOGGER.debug("Top 3 volumes: {}", topVolume);

        // 4. Three lowest Netflix stocks
        List<Stock> netflixLow = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        LOGGER.debug("Lowest Netflix stocks: {}", netflixLow);

        LOGGER.info("End");
    }

    // -------------------- Hands-on 4 --------------------
    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkillList());  // Hands-on 6
        LOGGER.info("End");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setSalary(50000);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date()); // dummy

        Department dept = departmentService.get(1);
        employee.setDepartment(dept);

        employeeService.save(employee);
        LOGGER.debug("Employee saved: {}", employee);
        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        Department newDept = departmentService.get(2);
        employee.setDepartment(newDept);
        employeeService.save(employee);
        LOGGER.debug("Employee updated: {}", employee);
        LOGGER.info("End");
    }

    // -------------------- Hands-on 5 --------------------
    private static void testGetDepartment() {
        LOGGER.info("Start");
        Department dept = departmentService.get(1); // assume id 1 has multiple employees
        LOGGER.debug("Department: {}", dept);
        LOGGER.debug("Employees: {}", dept.getEmployeeList());
        LOGGER.info("End");
    }

    // -------------------- Hands-on 6 --------------------
    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(2); // choose an employee without that skill
        Skill skill = skillService.get(3); // choose a skill not already assigned

        employee.getSkillList().add(skill);
        employeeService.save(employee);
        LOGGER.debug("Skill added to employee: {}", employee);
        LOGGER.info("End");
    }
}
