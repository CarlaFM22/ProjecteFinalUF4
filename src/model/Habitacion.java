package model;

public class Habitacion {
    private Pacient resident;
    private estatHabitacion estat;
    public Habitacion()
    {
        estat = estatHabitacion.NET;
        resident = null;
    }

    public estatHabitacion getEstat() {
        return estat;
    }

    public void setEstat(estatHabitacion estat) {
        this.estat = estat;
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

    public String CURAT()
    {
        return "FELICITATS HAS CURAT A "+resident.getNom();
    }
    public String MORT()
    {
        return "EL PACIENT "+ resident.getNom()+" HA MORT";
    }
}
