package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DummyClass
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        PlayingField field = new PlayingField("ooo\nxxx\nooo");

        while (true) {
            console.readLine();

            PlayingField newField = field.evolve();
            System.out.println(newField.toString());

            field = newField;
        }

   }
}
