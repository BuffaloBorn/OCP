import java.io.*;
import java.sql.*;
interface I1{   void m1() throws IOException;}
interface I2{   void m1() throws SQLException;}
public class TestClass implements I1, I2
{
    public static void main(String args[])  throws Exception
    {
        TestClass tc = new TestClass();
        I1 i1 = (I1) tc; //This is valid.
        i1.m1();

        I2 i2 = (I2) tc; //This is valid too.
        i2.m1();

    }

    public void m1()
    {
        System.out.println("Hi there");
    }
}