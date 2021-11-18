package isbnvalidator;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class ValidateISBNTest2 {
    private ValidateISBN validateISBN=new ValidateISBN();

    @Test
    public void test_checkISBN_getTrue(){
        boolean check=validateISBN.checkISBN("1452156433");
        Assert.assertTrue(check);
    }

    @Test
    public void test_checkISBN_getValidISBN(){
        boolean check=validateISBN.checkISBN("1452156433");
        Assert.assertTrue("First Get True",check);
        check=validateISBN.checkISBN("1579656714");
        Assert.assertTrue("Second Get True",check);
    }

    @Test
    public void test_checkISBN_invalidISBN(){
        boolean check=validateISBN.checkISBN("1450156433");
        Assert.assertFalse(check);
    }

    @Test(expected = NumberFormatException.class)
    public void test_notAllowedNineDigitas(){
        validateISBN.checkISBN("145015643");
    }

    @Test(expected = NumberFormatException.class)
    public void test_NonNumericException(){
        validateISBN.checkISBN("hellowwold");
    }

    @Test
    public void test_ValidIbsnwithX(){
        boolean check = validateISBN.checkISBN("012000030X");
       assertTrue("Valid ISBN",check);
    }


}