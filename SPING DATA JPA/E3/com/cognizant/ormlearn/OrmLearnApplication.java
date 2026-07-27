package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.AttemptService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.ParseException;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    private static AttemptService attemptService;   // for Hands-on 3

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        attemptService = context.getBean(AttemptService.class);

        // Uncomment the test you want to run
        // testGetAllPermanentEmployees();      // Hands-on 2
        // testGetAverageSalary();              // Hands-on 4
        // testGetAllEmployeesNative();         // Hands-on 5
        // testGetAttempt();                    // Hands-on 3
    }

    // -------------------- Hands-on 2 --------------------
    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", employees);
        employees.forEach(e -> LOGGER.debug("Skills: {}", e.getSkillList()));
        LOGGER.info("End");
    }

    // -------------------- Hands-on 4 --------------------
    private static void testGetAverageSalary() {
        LOGGER.info("Start");
        double avg = employeeService.getAverageSalary(1); // change department id as needed
        LOGGER.debug("Average salary of department 1: {}", avg);
        LOGGER.info("End");
    }

    // -------------------- Hands-on 5 --------------------
    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("All employees (native): {}", employees);
        LOGGER.info("End");
    }

    // -------------------- Hands-on 3 (Quiz) --------------------
    private static void testGetAttempt() {
        LOGGER.info("Start");
        Attempt attempt = attemptService.getAttempt(1, 1); // userId, attemptId
        LOGGER.debug("Attempt details: {}", attempt);
        
        attempt.getAttemptQuestions().forEach(aq -> {
            LOGGER.debug("Question: {}", aq.getQuestion().getText());
            aq.getAttemptOptions().forEach(ao -> {
                LOGGER.debug("Option: {}  Score: {}  Selected: {}",
                        ao.getOption().getText(),
                        ao.getOption().getScore(),
                        ao.isSelected());
            });
        });
        LOGGER.info("End");
    }
}
