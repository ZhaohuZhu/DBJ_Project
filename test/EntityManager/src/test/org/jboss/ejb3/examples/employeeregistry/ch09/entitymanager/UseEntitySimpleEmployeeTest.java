package test.org.jboss.ejb3.examples.employeeregistry.ch09.entitymanager;

import static org.junit.Assert.*;

import org.jboss.ejb3.examples.employeeregistry.ch09.entitymanager.SimpleEmployee;
import org.jboss.ejb3.examples.employeeregistry.ch09.entitymanager.UseEntitySimpleEmployee;
import org.junit.Test;

public class UseEntitySimpleEmployeeTest {

	
	@Test
	public void testInsert() {
		
		UseEntitySimpleEmployee use = new UseEntitySimpleEmployee();	
		use.deleteAll(SimpleEmployee.class);	
		
		assertTrue(
				"Employee should be managed now, after call to persist",
				use.insert());
		
	}

}
