package Rique.servicex.categoria.resources;

import Rique.servicex.categoria.domain.Categoria;
import Rique.servicex.categoria.repositories.CategoriaRepository;
import Rique.servicex.categoria.services.CategoriaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CategoriaResourceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    @Test
    public void testCriarCategoria_Sucesso() {
        Categoria categoria = new Categoria();
        categoria.setNomeCategoria("New Category");

        when(categoriaRepository.existsByNomeCategoria(categoria.getNomeCategoria())).thenReturn(false);
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria result = categoriaService.criarCategoria(categoria);

        assertNotNull(result);
        assertEquals("New Category", result.getNomeCategoria());

        verify(categoriaRepository).existsByNomeCategoria(categoria.getNomeCategoria());
        verify(categoriaRepository).save(any(Categoria.class));
    }
}