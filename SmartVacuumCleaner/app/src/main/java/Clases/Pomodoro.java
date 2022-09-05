package Clases;

import java.util.ArrayList;

public class Pomodoro {
    private String nombre;
    private ArrayList<Double> actividades;

    public Pomodoro(String nombre) {
        this.nombre = nombre;
        ArrayList<Double> act = new ArrayList<>();
        act.add(25.0);
        act.add(5.0);
        act.add(25.0);
        act.add(5.0);
        act.add(25.0);
        this.actividades = act;

    }

    public Pomodoro(String nombre, ArrayList<Double> actividades) {
        this.nombre = nombre;
        this.actividades = actividades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Double> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Double> actividades) {
        this.actividades = actividades;
    }
}
