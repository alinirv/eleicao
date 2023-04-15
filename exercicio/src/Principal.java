
import model.Candidato;
import model.Partido;
import model.Cargo;

import data.CandidatoSQliteDAO;
import data.PartidoSQliteDAO;
import data.CargoSQliteDAO;

import java.util.List;


public class Principal {
    public static void main(String[] args) {

        Cargo cargo1 = new Cargo(3,"Deputado");
        Cargo cargo2 = new Cargo(2,"Prefeito");
        Cargo cargo3 = new Cargo("Presidente");

        CargoSQliteDAO cargoDao = new CargoSQliteDAO();

        //cargoDao.salvar(cargo1);
        //cargoDao.atualizar(cargo3);
        //cargoDao.apagar(cargo2);

        //Cargo cargoSelecionado = cargoDao.buscar(3);
        //cargoSelecionado.mostrarDadosCargo();

        /*List<Cargo> listaCargos=cargoDao.buscarTodos();
        for (Cargo c : listaCargos )
            c.mostrarDadosCargo();*/

        //************************************************************

        Partido partido1 =new Partido(12,"sol","SL");
        Partido partido2 =new Partido(5,"ceu","MT");
        Partido partido3 =new Partido(50,"estrela","ST");

        PartidoSQliteDAO partidoDAO = new PartidoSQliteDAO();

        //partidoDAO.salvar(partido1);
        //partidoDAO.atualizar(partido2);
        //partidoDAO.apagar(partido2);

        //Partido partidoSelecionado = partidoDAO.buscar(50);
        //partidoSelecionado.mostrarDadosPartido();

        /*List<Partido> listaPartidos = partidoDAO.buscarTodos();
        for (Partido p : listaPartidos)
            p.mostrarDadosPartido();*/

        //***************************************************************


        Candidato candidato1 = new Candidato(7875,"Carlos", partido1, cargo1 );
        Candidato candidato2 = new Candidato(111,"Antonio", partido3, cargo2 );

        CandidatoSQliteDAO candidatoDao = new CandidatoSQliteDAO();

        //candidatoDao.salvar(candidato1);
        //candidatoDao.salvar(candidato2);

        Candidato candidatoselecionado = candidatoDao.buscar(111);
        candidatoselecionado.mostrarDadosCandidato();

        List<Candidato> listaCandidatos = candidatoDao.buscarTodos();
        for (Candidato c : listaCandidatos)
            c.mostrarDadosCandidato();














    }

}
