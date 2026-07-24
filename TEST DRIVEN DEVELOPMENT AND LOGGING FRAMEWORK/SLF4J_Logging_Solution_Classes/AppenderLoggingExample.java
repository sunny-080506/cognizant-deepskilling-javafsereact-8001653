import org.slf4j.*;
public class AppenderLoggingExample{
 private static final Logger logger=LoggerFactory.getLogger(AppenderLoggingExample.class);
 public static void main(String[] args){
  logger.info("Application started");
  logger.warn("Warning message");
  logger.error("Error message");
 }
}
