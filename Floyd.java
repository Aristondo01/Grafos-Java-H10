import java.util.ArrayList;

public class Floyd {

    String Centro = "";
    Integer[][] P;
    String Matriz2 [][];
    public String [] [] recarcular(String [] [] Matriz)
    {
        Matriz2=Matriz;
        P = new Integer[Matriz.length][Matriz.length];
        for(int i=0;i<Matriz.length;i++) {
            for (int j = 0; j < Matriz.length; j++) {
                P[i][j]=0;
            }
        }

        for(int k =1;k<Matriz.length;k++)
        {
            for(int i=1;i<Matriz.length;i++)
            {
                for(int j=1;j<Matriz.length;j++)
                {
                    int cambio = Integer.parseInt(Matriz[i][j]);
                    int a = Integer.parseInt(Matriz[i][k]);
                    int b = Integer.parseInt(Matriz[k][j]);

                    if (cambio>a+b)
                    {
                        Matriz[i][j]=(a+b)+"";
                        P[i][j]=k;
                    }
                }
            }
        }

        return Matriz;
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
}
