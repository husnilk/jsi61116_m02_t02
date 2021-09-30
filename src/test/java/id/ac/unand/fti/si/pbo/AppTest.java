package id.ac.unand.fti.si.pbo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void firstTest() {

        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("13\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        App.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);
        String outputText = byteArrayOutputStream.toString();
        String key = "adalah";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        assertEquals(output, "bilangan prima");
    }

    @Test
    public void secondTest() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("100\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        App.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);
        String outputText = byteArrayOutputStream.toString();
        String key = "bukan";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        assertEquals(output, "bilangan prima");
    }

    @Test
    public void inputInvalidTest() {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("-5\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        App.main(new String[0]);
        System.setIn(stdin);
        System.setOut(stdout);
        String outputText = byteArrayOutputStream.toString();
        String key = "besar dari";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        assertEquals(output, "0");
    }

}
