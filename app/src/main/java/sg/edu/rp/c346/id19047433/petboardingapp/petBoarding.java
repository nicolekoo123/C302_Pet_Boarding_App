package sg.edu.rp.c346.id19047433.petboardingapp;

import java.util.Date;

public class petBoarding {
    private Date boardDate;
    private String name;
    private int numDays;
    private String petType;
    private Boolean vaccinated;

    @Override
    public String toString() {
        return "petBoarding{" +
                "boardDate='" + boardDate + '\'' +
                ", name='" + name + '\'' +
                ", numDays='" + numDays + '\'' +
                ", petType='" + petType + '\'' +
                ", vaccinated='" + vaccinated + '\'' +
                '}';
    }

    public petBoarding() {
// Default constructor required for calls to snapshot.toObject(Message.class)
    }

    public Date getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(Date boardDate) {
        this.boardDate = boardDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public petBoarding(Date boardDate, String name, int numDays, String petType, Boolean vaccinated) {
        this.boardDate = boardDate;
        this.name = name;
        this.numDays = numDays;
        this.petType = petType;
        this.vaccinated = vaccinated;
    }
}
