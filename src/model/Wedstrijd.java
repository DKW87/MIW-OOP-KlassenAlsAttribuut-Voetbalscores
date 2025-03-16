package Model;

public class Wedstrijd {

    // attributen

    private Team thuisTeam;
    private Team uitTeam;
    private int thuisDoelpunten;
    private int uitDoelpunten;

    // constructors

    public Wedstrijd(Team thuisTeam, Team uitTeam, int thuisDoelpunten, int uitDoelpunten) {
        this.thuisTeam = thuisTeam;
        this.uitTeam = uitTeam;
        this.thuisDoelpunten = thuisDoelpunten;
        this.uitDoelpunten = uitDoelpunten;
    }

    public Wedstrijd(Team thuisTeam, Team uitTeam) {
        this(thuisTeam, uitTeam, 0, 0);
    }

    public Wedstrijd() {
        this(new Team(), new Team());
    }

    // methoden

    public int getWedstrijdpuntenThuisTeam() {
        int aantalPunten;
        final int VERLIES = 0;
        final int GELIJK = 1;
        final int WINST = 3;

        if (this.thuisDoelpunten > this.uitDoelpunten) {
            aantalPunten = WINST;
        } else if (this.thuisDoelpunten < this.uitDoelpunten) {
            aantalPunten = VERLIES;
        } else {
            aantalPunten = GELIJK;
        }
        return aantalPunten;
    }

    public int getWedstrijdpuntenUitTeam() {
        int aantalPunten;
        final int VERLIES = 0;
        final int GELIJK = 1;
        final int WINST = 3;

        if (this.uitDoelpunten > this.thuisDoelpunten) {
            aantalPunten = WINST;
        } else if (this.uitDoelpunten < this.thuisDoelpunten) {
            aantalPunten = VERLIES;
        } else {
            aantalPunten = GELIJK;
        }
        return aantalPunten;
    }

    public void setWedstrijdpuntenThuisTeam() {
        this.thuisTeam.setTotaalWedstrijdpunten(this.getWedstrijdpuntenThuisTeam() + this.thuisTeam.getTotaalWedstrijdpunten());
    }

    public void setWedstrijdpuntenUitTeam() {
        this.uitTeam.setTotaalWedstrijdpunten(this.getWedstrijdpuntenUitTeam() + this.uitTeam.getTotaalWedstrijdpunten());
    }

    public void setTotaalDoelpuntenTeams() {
        // thuisteam
        this.thuisTeam.setTotaalVoorDoelpunten(this.thuisTeam.getTotaalVoorDoelpunten() + this.thuisDoelpunten);
        this.thuisTeam.setTotaalTegenDoelpunten(this.thuisTeam.getTotaalTegenDoelpunten() + this.uitDoelpunten);

        //uitteam
        this.uitTeam.setTotaalVoorDoelpunten(this.uitTeam.getTotaalVoorDoelpunten() + this.uitDoelpunten);
        this.uitTeam.setTotaalTegenDoelpunten(this.uitTeam.getTotaalTegenDoelpunten() + this.thuisDoelpunten);

    }

    public void printUitslag(){
        System.out.printf("Uitslag van de wedstrijd %s-%s: %d-%d %n",
                this.thuisTeam.getTeamNaam(), this.uitTeam.getTeamNaam(), this.thuisDoelpunten, this.uitDoelpunten);
    }

    public void printWedstrijdpunten() {
        System.out.printf("Dit levert %d wedstrijdpunten voor %s en %d wedstrijdpunten voor %s op. %n",
                this.getWedstrijdpuntenThuisTeam(), this.thuisTeam.getTeamNaam(), this.getWedstrijdpuntenUitTeam(), this.uitTeam.getTeamNaam());
    }

    // getters en setters

    public Team getThuisTeam() {
        return thuisTeam;
    }

    public void setThuisTeam(Team thuisTeam) {
        this.thuisTeam = thuisTeam;
    }

    public Team getUitTeam() {
        return uitTeam;
    }

    public void setUitTeam(Team uitTeam) {
        this.uitTeam = uitTeam;
    }

    public int getThuisDoelpunten() {
        return thuisDoelpunten;
    }

    public void setThuisDoelpunten(int thuisDoelpunten) {
        this.thuisDoelpunten = thuisDoelpunten;
    }

    public int getUitDoelpunten() {
        return uitDoelpunten;
    }

    public void setUitDoelpunten(int uitDoelpunten) {
        this.uitDoelpunten = uitDoelpunten;
    }

} // klasse