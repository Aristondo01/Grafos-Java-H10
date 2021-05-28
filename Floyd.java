import java.util.ArrayList;
import java.util.HashMap;

public class Floyd {

    String Centro = "";
    Integer[][] P;
    String Matriz2 [][];
    public String [] [] recarcular(String [] [] Matriz)
    {
        Matriz2=copiar(Matriz);
        P = new Integer[Matriz2.length][Matriz2.length];
        for(int i=0;i<Matriz2.length;i++) {
            for (int j = 0; j < Matriz2.length; j++) {
                P[i][j]=0;
            }
        }

        for(int k =1;k<Matriz2.length;k++)
        {
            for(int i=1;i<Matriz2.length;i++)
            {
                for(int j=1;j<Matriz2.length;j++)
                {
                    int cambio = Integer.parseInt(Matriz2[i][j]);
                    int a = Integer.parseInt(Matriz2[i][k]);
                    int b = Integer.parseInt(Matriz2[k][j]);

                    if (cambio>a+b)
                    {
                        Matriz2[i][j]=(a+b)+"";
                        P[i][j]=k;
                    }
                }
            }
        }

        return Matriz2;
    }

    public void path(int q, int r)
    {
        if (P[q][r]!=0)
        {
            path(q,P[q][r]);
            System.out.println("Para llegar al destino se paso por:"+ Matriz2[0][P[q][r]]);
            path(P[q][r],r);

        }
    }

    public  void centro()
    {
        HashMap<Integer,Integer> posiciones = new HashMap<>();
        int x=0,y=0;
        int [] menor= new int[Matriz2.length];
        for (int i=1;i< Matriz2.length;i++)
        {
            for (int j=1; j<Matriz2.length;j++)
            {
                if(Integer.parseInt(Matriz2[i][j])>menor[i]) {
                    menor[i]=Integer.parseInt(Matriz2[i][j]);
                    x=i;

                }
            }
            posiciones.put(menor[i],x);

        }
        int menor2=0;
        for (int i =0;i<menor.length-1;i++)
        {
            if(menor[i]<menor[i+1]) {
                menor2=menor[i];
            }
            else
            {
                menor2=menor[i+1];
            }
        }

        System.out.println("El centro del grafo es:"+ Matriz2[posiciones.get(menor2)][0]);
    }

    private String [] [] copiar(String [] [] M1 )
    {
        String [] [] M2 = new String[M1.length][M1.length];

        for (int i =0;i<M1.length;i++)
        {
            for (int j =0;j<M1.length;j++)
            {
                M2[i][j]=M1[i][j];
            }
        }

        return M2;
    }

    public String [][] cambio(String [][] Matriz,int x,int y,String cambio)
    {
        Matriz[x][y]=cambio;
        return  Matriz;
    }


}
