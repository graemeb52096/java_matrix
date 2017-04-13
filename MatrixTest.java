package matrix;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MatrixTest {
	public Matrix m;
	public Node n;

	@Before
	public void setUp() throws Exception {
		m = new Matrix(10, 10);
		n = new Node(10);
	}

	@After
	public void tearDown() throws Exception {
		m = null;
		n = null;
	}

	@Test
	public void testSet() {
		System.out.println("Running test for get/set");
		if(m.get_val(1, 1) != 0){
			fail("Value should be 0");	
		}
		m.set_val(1, 1, 1);
		if(m.get_val(1, 1) != 1){
			fail("Value should have updated to 1");
		}
		if(m.get_val(1, 2) != 0){
			fail("Value should have not been affected");
		}
		
	}
	
	@Test
	public void testGetRow(){
		System.out.println("Running test get row");
		Matrix comp_matrix = new Matrix(1, 10);
		if(m.get_row(1) != comp_matrix){
			fail("Matrix should equal");
		}
		m.set_val(2, 1, 9);
		comp_matrix.set_val(2, 1, 0);
		if(m.get_row(2) != comp_matrix){
			fail("Matrix should equal");
		}
	}

}
