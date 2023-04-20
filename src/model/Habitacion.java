package model;

public class Habitacion {
    private Pacient resident;
    private estatHabitacion estat;
    public Habitacion()
    {
        estat = estatHabitacion.NET;
        resident = null;
    }

    public Pacient getResident() {
        return resident;
    }

    public void setResident(Pacient resident) {
        this.resident = resident;
    }

    @Override
    public String toString() {
        if (resident==null)
        {
            return "VUIT | " + estat;
        }

        return resident.getNom() + " | "+ estat;
    }
}
