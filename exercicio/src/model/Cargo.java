package model;

public class Cargo {
    private int idCargo;
    private String cargo;

    public void mostrarDadosCargo(){
        System.out.println("\n Id Cargo: " + getIdCargo() +
                "\n Cargo: " + getCargo());
    }

    public Cargo(String cargo) {
        this.cargo = cargo;
    }

    public Cargo(int idCargo, String cargo) {
        this.idCargo = idCargo;
        this.cargo = cargo;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
