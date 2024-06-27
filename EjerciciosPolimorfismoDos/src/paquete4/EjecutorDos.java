/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class EjecutorDos {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int contador;
        int tipoArriendo;

        ArrayList<Arriendo> listaArriendos = new ArrayList<>();

        System.out.print("Cuantos arriendos desea ingresar: ");
        int totalArriendo = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Tipo de Arriendo a ingresar\n"
                + "Ingrese (1) para Ariendo local comida\n"
                + "Ingrese (2) para Arriendo Local Comercial\n"
                + "Ingrese (3) para Arriendo Local Sesiones");
        tipoArriendo = entrada.nextInt();
        entrada.nextLine();

        contador = 0;

        while (contador < totalArriendo) {

            if (tipoArriendo == 1) {

                ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                        "Christian Shepherd", 300);
                arriendoComida.establecerIva(10); // en porcentaje
                arriendoComida.establecerValorAgua(20.2); // en $
                arriendoComida.establecerValorLuz(40.2); // en $

                listaArriendos.add(arriendoComida);

            } else if (tipoArriendo == 2) {

                ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                        "Andrew Schroeder", 400);
                arriendoComercial.establecerValorAdicionalFijo(100); // en $

                listaArriendos.add(arriendoComercial);

            } else {

                ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                        "Angela Watson", 350);
                arriendoSesiones.establecerValorSillas(10); // en $
                arriendoSesiones.establecerValorAmplificacion(20); // en $

                listaArriendos.add(arriendoSesiones);
            }
            contador = contador + 1;
        }

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial("La Pradera",
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }
}
