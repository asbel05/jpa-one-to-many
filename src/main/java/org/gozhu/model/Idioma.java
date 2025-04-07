package org.gozhu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "idioma")
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_idioma")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "nombre", length = 100)
    private TipoIdioma tipoIdioma;
    @OneToMany(mappedBy = "idioma", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
        libro.setIdioma(this);
    }

    public Idioma(TipoIdioma tipoIdioma) {
        this.tipoIdioma = tipoIdioma;
    }
}
