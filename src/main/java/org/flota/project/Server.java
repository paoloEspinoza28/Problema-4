package org.flota.project;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;

import org.flota.project.models.EntregaProgramada;
import org.flota.project.models.GuiaEntrega;
import org.flota.project.models.Ventana;

import javafx.application.Application;

public class Server {

    public static void main(String[] args) {

        RegistroLog.getInstance().log("Iniciando servidor");

        //ArcGISRuntimeEnvironment.setInstallDirectory("/Users/tatsudy/Downloads/arcgis-runtime-sdk-java-100.8.0");
        ArcGISRuntimeEnvironment.setInstallDirectory("C:\\Java\\arcgis-runtime-sdk-java-100.8.0");

        GuiaEntrega guia = new GuiaEntrega();
        guia.agregarEntrega(new EntregaProgramada("09:00-10:00", "23/07/2020"));
        guia.agregarEntrega(new EntregaProgramada("10:00-11:00", "23/07/2020"));
        guia.agregarEntrega(new EntregaProgramada("12:00-13:00", "23/07/2020"));
        
        GuiaEntrega guia2 = new GuiaEntrega();
        guia2.agregarEntrega(new EntregaProgramada("10:00-11:00", "24/07/2020"));
        guia2.agregarEntrega(new EntregaProgramada("11:00-12:00", "24/07/2020"));
        guia.agregarEntrega( guia2 );

        //Para la minivan...
        GuiaEntrega guia3 = new GuiaEntrega();
        guia3.agregarEntrega(new EntregaProgramada("09:30-10:30", "25/07/2020"));
        guia3.agregarEntrega(new EntregaProgramada("10:30-11:30", "25/07/2020"));
        guia.agregarEntrega( guia3);
        
        guia.listarEntrega();
        System.out.println( "Costo: " + guia.calcularCosto() );

        Application.launch(Ventana.class, args);
    }

}