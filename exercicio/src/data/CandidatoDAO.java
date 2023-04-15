package data;

import model.Candidato;
import java.util.List;

public interface CandidatoDAO {
    void  salvar(Candidato a);
    void atualizar (Candidato a);
    void apagar (Candidato a);
    Candidato buscar (int numero);
    List<Candidato> buscarTodos();

}
