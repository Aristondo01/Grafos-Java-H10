import org.junit.Assert;

import java.util.Formattable;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Scanner;
import java.util.regex.MatchResult;

import static org.junit.jupiter.api.Assertions.*;

public class FloydTest {
    Lector leer = new Lector();
    Floyd F= new Floyd();
    @org.junit.Test
    //Esta prueba sigue la logica para poder ingresar un dato
    //Se ingresara según la posicion
    public void CambiarArco() {
        String [][] Matriz = leer.Leer("guategrafo.txt");
        Matriz[1][4]="1";
        assertEquals("1",Matriz[1][4]);
    }
    //Para que el algoritmo de floyd funcionase correctamente
    //si coloco un numero grande para simular infinito
    //Para eliminar una ruta se coloca el inifnito
    @org.junit.Test
    public void Eliminar() {
        String [][] Matriz = leer.Leer("guategrafo.txt");
        Matriz[1][4]="100000";
        assertEquals("100000",Matriz[1][4]);
    }

    //En esta prueba se ingresa 4 relaciones
    //Al recalcular de Antigua a Mixco se tendra una nueva ruta de 30
    //debido a la suma de 5 y 25
    @org.junit.Test
    public void PruebaFloyd() {
        String [][] Matriz = leer.Leer("guategrafo.txt");
        System.out.println("");
        Matriz=F.recarcular(Matriz);

        assertEquals("30",Matriz[1][2]);

    }


}