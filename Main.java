import java.security.Key;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Floyd F= new Floyd();
        Lector leer = new Lector();

        String [] [] Original = leer.Leer("guategrafo.txt");
        String [] [] Matriz = leer.Leer("guategrafo.txt");

        boolean continuar=true;
        while (continuar) {
            System.out.println("\n-----Menu Principal------");
            System.out.println("1)Calcular Destino");
            System.out.println("2)Indicar Centro del grafo");
            System.out.println("3)Modificar Arco ");
            System.out.println("4)Eliminar Arco ");
            System.out.println("5)Salir\n");


            String input = scan.nextLine();


            Matriz=F.recarcular(Original);

            int tam = Matriz.length;

            System.out.println("");
            HashMap<String,Integer> Relaciones =leer.posiciones();
            if (input.equals("1")) {
                boolean Ciudada= true;
                boolean Ciudadb= true;
                int x=0,y=0;
                while (Ciudada)
                {
                    System.out.println("Seleecione la Ciudad de origen");
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <cont)
                        {
                            x=Integer.parseInt(a);
                            Ciudada=false;
                        }
                        else
                        {
                            System.out.println("Opcion invalida");
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }

                while (Ciudadb)
                {
                    System.out.println("Seleecione la Ciudad de llegada");
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <cont)
                        {
                            y=Integer.parseInt(a);
                            Ciudadb=false;
                        }
                        else
                        {
                            System.out.println("Opcion invalida");
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }
                if (!Matriz[x][y].equals("10000000")) {
                    System.out.println("La distancia en Kilometros es de:" + Matriz[x][y]);
                    F.path(x, y);
                }
                else
                {
                    System.out.println("Lo sentimos las carreteras no conectan las ciudades que solicito");
                }

            } else if (input.equals("2")) {
                F.centro();


            } else if (input.equals("3")) {
                boolean Ciudada= true;
                boolean Ciudadb= true;
                int x=0,y=0;
                while (Ciudada)
                {
                    System.out.println("Seleecione la Ciudad de origen");
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
                    System.out.println("Seleecione la Ciudad de llegada");
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
                boolean num=true;
                while (num)
                {
                    System.out.println("Ingrese el nuevo kilometraje");

                    String a=scan.nextLine();
                    try
                    {
                        int res = Integer.parseInt(a);
                        Original[x][y]=res+"";
                        Matriz[x][y]=res+"";
                        num=false;
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }




            }else if (input.equals("4")) {

                boolean Ciudada= true;
                boolean Ciudadb= true;
                int x=0,y=0;
                while (Ciudada)
                {
                    System.out.println("Seleecione la Ciudad de origen");
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
                    System.out.println("Seleecione la Ciudad de llegada");
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
                Original[x][y]=10000000+"";
                Matriz[x][y]=10000000+"";


            }

            else if (input.equals("5")) {
                continuar = false;

            } else {
                System.out.println("Opcion no valida");
            }
        }

    }

}