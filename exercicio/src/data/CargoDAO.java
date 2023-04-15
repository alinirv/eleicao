package data;

import model.Cargo;
import java.util.List;

public interface CargoDAO {
    void  salvar(Cargo c);
    void atualizar (Cargo c);
    void apagar (Cargo c);
    Cargo buscar (int idCargo);
    List<Cargo> buscarTodos();
}
