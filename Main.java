import java.security.Key;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Floyd F= new Floyd();
        Lector leer = new Lector();
        String [] [] Matriz = leer.Leer("guategrafo.txt");
        boolean continuar=true;
        while (continuar) {
            System.out.println("\n1)Calcular Destino");
            System.out.println("2)Indicar Centro del grafo");
            System.out.println("3)Modificar Arco ");
            System.out.println("4)Salir\n");


            String input = scan.nextLine();

            Matriz=F.recarcular(Matriz);
            int tam = Matriz.length;
            for (int i =0;i<tam;i++)
            {
                System.out.println("\n");
                for (int j =0;j<tam;j++)
                {
                    System.out.print(Matriz[i][j]+"\t\t");
                }

            }
            System.out.println("");
            HashMap<String,Integer> Relaciones =leer.posiciones();
            if (input.equals("1")) {
                boolean Ciudada= true;
                boolean Ciudadb= true;
                int x=0,y=0;
                while (Ciudada)
                {
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <=cont)
                        {
                            x=Integer.parseInt(a);
                            Ciudada=false;
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }

                while (Ciudadb)
                {
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <=cont)
                        {
                            y=Integer.parseInt(a);
                            Ciudadb=false;
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }
                System.out.println("La distancia en Kilometros es de:"+Matriz[x][y]);
                F.path(x,y);

            } else if (input.equals("2")) {


            } else if (input.equals("3")) {


            } else if (input.equals("4")) {
                continuar = false;

            } else {
                System.out.println("Opcion no valida");
            }
        }

    }

}