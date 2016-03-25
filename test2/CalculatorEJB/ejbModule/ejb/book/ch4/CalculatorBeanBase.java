package ejb.book.ch4;

import java.util.logging.Logger;

/**
 * Base for bean implementation classes of the CalculatorEJB, 
 * provides business logic for required contracts
 *
 * @author <a href="mailto:andrew.rubinger@jboss.org">ALR</a>
 */

public class CalculatorBeanBase implements CalculatorCommonBusiness {

	
	private static final Logger log = Logger.getLogger(CalculatorBeanBase.class.getName());

	@Override
	public int add(int... arguments) {
		 // Initialize
	      final StringBuffer sb = new StringBuffer();
	      sb.append("Adding arguments: ");
	      int result = 0;

	      // Add all arguments
	      for (final int arg : arguments)
	      {
	         result += arg;
	         sb.append(arg);
	         sb.append(" ");
	      }

	      // Return
	      log.info(sb.toString());
	      log.info("Result: " + result);
	      return result;
	}

}
