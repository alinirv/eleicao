package data;

import model.Partido;
import java.util.List;

public interface PartidoDAO {
    void  salvar(Partido p);
    void atualizar (Partido p);
    void apagar (Partido p);
    Partido buscar (int numero);
    List<Partido> buscarTodos();
}
