import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Lector
{

    public Vector [] [] Leer(String nombre)
    {
        int x,y,cont;
        x=1;
        y=1;
        cont=0;


        Vector [] [] temp = new Vector[0][0];
        try
        {
            File Archivo = new File(nombre);
            Scanner Lector = new Scanner(Archivo);

            while (Lector.hasNextLine())
            {
                String Line = Lector.nextLine();
                String [] separar = Line.split(" ");

                for (int i=0 ; i < x*2;i++)
                {
                    if (!temp[0][i].toString().equals(separar[cont]))
                    {
                        temp[0][x++].add(separar[cont++]);
                    }

                }
                cont=0;

                for(int j=0 ; j<y*2;j++)
                {
                    if (!temp[j][0].toString().equals(separar[cont]))
                    {
                        temp[0][y++].add(separar[cont++]);
                    }



                }





            }

        }
        catch (Exception e)
        {
            System.out.println("Error al abrir el archivo "+ e);
        }
        return temp;
    }

}