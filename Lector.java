import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Lector
{
    HashMap<String,Integer> posx;
    public String [] [] Leer(String nombre)
    {
        ArrayList<String> temporal = new ArrayList<>();
        try {
            File Archivo = new File(nombre);
            Scanner Lector = new Scanner(Archivo);

            while (Lector.hasNextLine()) {

                String Line = Lector.nextLine();
                String[] separar = Line.split(" ");

                if (temporal.size()==0)
                {
                    temporal.add(separar[0]);
                    temporal.add(separar[1]);
                }
                else
                {
                    if (!temporal.contains(separar[0]))
                    {
                        temporal.add(separar[0]);
                    }
                    if (!temporal.contains(separar[1]))
                    {
                        temporal.add(separar[1]);
                    }
                }

            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error al abrir el archivo "+ e);
        }
        int tam = temporal.size()+1;
        String [] [] paises = new String[tam][tam];
        posx = new HashMap<String, Integer>();

        for (int i =0;i<tam;i++)
        {

            for (int j =0;j<tam;j++)
            {
                paises[i][j]="10000000";
            }

        }

        for (int j =0;j<tam;j++)
        {
            paises[j][j]="0";
        }




        int x=1;
        int y=0;
        try
        {
            File Archivo = new File(nombre);
            Scanner Lector = new Scanner(Archivo);

            while (Lector.hasNextLine())
            {

                String Line = Lector.nextLine();
                String [] separar = Line.split(" ");
                boolean bandera =true;
                if (x==1)
                {
                    paises[0][x]=separar[0];
                    paises[x][0]=separar[0];
                    posx.put(separar[0],x);
                    x++;
                    paises[0][x]=separar[1];
                    paises[x][0]=separar[1];
                    posx.put(separar[1],x);
                    x++;
                }
                else
                {

                    y=0;

                    for (int k=0;k<2;k++) {
                        bandera=true;
                        for (int i = 0; i < paises[0].length; i++) {
                            if (paises[0][i].equals(separar[k])) {
                                bandera=false;
                            }
                        }
                        if (bandera)
                        {
                            paises[0][x]=separar[k];
                            posx.put(separar[k],x);
                            paises[x][0]=separar[k];

                            x++;
                        }


                    }
                }
                paises[posx.get(separar[0])][posx.get(separar[1])]=separar[2];
            }

            for (int i =0;i<tam;i++)
            {
                System.out.println("\n");
                for (int j =0;j<tam;j++)
                {
                    System.out.print(paises[i][j]+"\t\t");
                }

            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error al abrir el archivo "+ e);
        }
        return paises;
    }

    public HashMap<String,Integer> posiciones() {
        return posx;
    }

}

