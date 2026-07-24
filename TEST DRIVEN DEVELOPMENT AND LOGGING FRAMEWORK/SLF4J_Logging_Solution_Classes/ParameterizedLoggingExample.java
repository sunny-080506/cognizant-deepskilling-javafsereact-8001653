import org.slf4j.*;
public class ParameterizedLoggingExample{
 private static final Logger logger=LoggerFactory.getLogger(ParameterizedLoggingExample.class);
 public static void main(String[] args){
  String user="Alice"; int age=25;
  logger.info("User {} is {} years old",user,age);
  logger.debug("Processing user {}",user);
 }
}
