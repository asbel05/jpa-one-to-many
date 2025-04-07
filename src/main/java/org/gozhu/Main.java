package org.gozhu;

import org.gozhu.model.Idioma;
import org.gozhu.model.Libro;
import org.gozhu.model.TipoIdioma;
import org.gozhu.service.IdiomaService;

public class Main {
    public static void main(String[] args) {
        IdiomaService idiomaService = new IdiomaService();

        Idioma french = new Idioma(TipoIdioma.French);
        Idioma germany = new Idioma(TipoIdioma.German);

        Libro libroFrench = new Libro("Pierre et Jean");
        Libro libroFrench2 = new Libro("Le Colonel Chabert");
        Libro libroGermany = new Libro("Hitler 1945");
        Libro libroGermany2 = new Libro("Die Nachtwachen des Bonaventura");

        french.agregarLibro(libroFrench);
        french.agregarLibro(libroFrench2);
        germany.agregarLibro(libroGermany);
        germany.agregarLibro(libroGermany2);

        idiomaService.crearIdioma(french);
        idiomaService.crearIdioma(germany);

        System.out.println("Total de idiomas en la base de datos: " + idiomaService.contarIdiomas());
        System.out.println("Total de libros en la base de datos: " + idiomaService.contarLibros());

        System.out.println("Listado de idiomas con sus libros:");
        idiomaService.obtenerIdiomas().forEach(idioma -> {
            System.out.println("Idioma: " + idioma.getTipoIdioma());
            System.out.println("Libros:");
            idioma.getLibros().forEach(libro ->
                    System.out.println("  - " + libro.getTitulo())
            );
            System.out.println("---------------------------------");
        });

        idiomaService.cerrar();
    }
}