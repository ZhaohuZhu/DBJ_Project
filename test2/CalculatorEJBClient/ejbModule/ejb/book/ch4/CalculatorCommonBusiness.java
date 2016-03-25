package ejb.book.ch4;

/**
 * Contains the contract for operations common to 
 * all business interfaces of the CalculatorEJB
 *
 * @author <a href="mailto:andrew.rubinger@jboss.org">ALR</a>
 */

public interface CalculatorCommonBusiness {


	   /**
	    * Adds all arguments
	    * 
	    * @return The sum of all arguments
	    */
	   int add(int... arguments);

	}
