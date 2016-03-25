package ejb.book.ch4;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculatorBean
 */


@Stateless
@Remote(CalculatorRemoteBusiness.class)
public class CalculatorBean extends CalculatorBeanBase implements CalculatorCommonBusiness {

    public CalculatorBean() {
    }

}
