package Model;

public class Team {

    // attributen

    private String teamNaam;
    private int totaalWedstrijdpunten;
    private int totaalVoorDoelpunten;
    private int totaalTegenDoelpunten;

    // constructors

    public Team (String teamNaam, int totaalWedstrijdpunten, int totaalVoorDoelpunten, int totaalTegenDoelpunten) {
        this.teamNaam = teamNaam;
        this.totaalWedstrijdpunten = totaalWedstrijdpunten;
        this.totaalVoorDoelpunten = totaalVoorDoelpunten;
        this.totaalTegenDoelpunten = totaalTegenDoelpunten;
    }

    public Team (String teamNaam) {
        this(teamNaam, 0, 0, 0);
    }

    public Team () {
        this("");
    }

    // methoden

    public int getDoelSaldo() {
        return getTotaalVoorDoelpunten() - getTotaalTegenDoelpunten();
    }

    public void printStatusTeam() {
        String negatiefbericht = "";

        if (this.getTotaalWedstrijdpunten() <= 0) {
            negatiefbericht = " (wat slecht zeg, HAHA)";
        }

        System.out.printf("Het team %s heeft %d wedstrijdpunten en een doelsaldo van %d %s %n", this.getTeamNaam(), this.getTotaalWedstrijdpunten(), this.getDoelSaldo(), negatiefbericht);
    }

    // getters en setters

    public String getTeamNaam() {
        return teamNaam;
    }

    public void setTeamNaam(String teamNaam) {
        this.teamNaam = teamNaam;
    }

    public int getTotaalWedstrijdpunten() {
        return totaalWedstrijdpunten;
    }

    public void setTotaalWedstrijdpunten(int totaalWedstrijdpunten) {
        this.totaalWedstrijdpunten = totaalWedstrijdpunten;
    }

    public int getTotaalVoorDoelpunten() {
        return totaalVoorDoelpunten;
    }

    public void setTotaalVoorDoelpunten(int totaalVoorDoelpunten) {
        this.totaalVoorDoelpunten = totaalVoorDoelpunten;
    }

    public int getTotaalTegenDoelpunten() {
        return totaalTegenDoelpunten;
    }

    public void setTotaalTegenDoelpunten(int totaalTegenDoelpunten) {
        this.totaalTegenDoelpunten = totaalTegenDoelpunten;
    }

} // klasse