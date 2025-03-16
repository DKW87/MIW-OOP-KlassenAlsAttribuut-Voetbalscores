package Controller;

import Model.Team;
import Model.Wedstrijd;

import java.util.Scanner;

public class VoetbalScoresMainLauncher {

    // static var
    final static int EIGEN_TEAM = 1;

    public static void main(String[] args) {

        // variabelen
        int aantalTeams;
        int aantalWedstrijden;
        int tellerTeamsAflopend;
        int tellerTeamsOplopend;
        final int MIN_ARRAY_INDEX = 0;
        Scanner userInput = new Scanner(System.in);

        System.out.print("Van hoeveel teams wil je wedstrijden bijhouden? ");
        aantalTeams = userInput.nextInt();
        userInput.nextLine();//clear buffer

        Team[] mijnTeamArray = new Team[aantalTeams];

        for (int i = 0; i < aantalTeams; i++) {
            System.out.printf("Geef de naam van team %d op: ", i + 1);
            mijnTeamArray[i] = new Team(userInput.nextLine());
        }

        aantalWedstrijden = berekenWedstrijden(aantalTeams);
        System.out.println("Aantal wedstrijden: " + aantalWedstrijden);
        System.out.println("Aantal teams: " + aantalTeams);

        Wedstrijd[] mijnWedstrijdArray = new Wedstrijd[aantalWedstrijden];

        tellerTeamsAflopend = aantalTeams - EIGEN_TEAM;
        tellerTeamsOplopend = MIN_ARRAY_INDEX;

        // for loop om alle wedstrijd indexen correct te vullen met de juiste checks om ervoor te zorgen dat er niet
        // tegen een onbestaand team (index out of bounds) of tegen hetzelfde team gespeeld kan worden
        for (int i = 0; i < aantalWedstrijden; i++) {

            // een check om te zorgen dat tellerTeams aflopend niet out of bounds gaat
            if (tellerTeamsAflopend < MIN_ARRAY_INDEX) {
                tellerTeamsOplopend++;
                tellerTeamsAflopend = aantalTeams - EIGEN_TEAM;
                // en checkt vervolgens of oplopend en aflopend niet hetzelfde zijn (om een wedstrijd tegen zichzelf te voorkomen)
                if (tellerTeamsAflopend == tellerTeamsOplopend) {
                    tellerTeamsAflopend--;
                }
            }

            // hier dezelfde check, maar dan andersom
            if (tellerTeamsAflopend == tellerTeamsOplopend) {
                tellerTeamsAflopend--;
                if (tellerTeamsAflopend < MIN_ARRAY_INDEX) {
                    tellerTeamsOplopend++;
                    tellerTeamsAflopend = aantalTeams - EIGEN_TEAM;
                }
            }

            mijnWedstrijdArray[i] = new Wedstrijd(mijnTeamArray[tellerTeamsOplopend], mijnTeamArray[tellerTeamsAflopend]);
            tellerTeamsAflopend--;

        } // for


        for (int i = 0; i < aantalWedstrijden; i++) {
            System.out.printf("Geef van de wedstrijd %s-%s de thuisdoelpunten: ", mijnWedstrijdArray[i].getThuisTeam().getTeamNaam(), mijnWedstrijdArray[i].getUitTeam().getTeamNaam());
            mijnWedstrijdArray[i].setThuisDoelpunten(userInput.nextInt());
            System.out.printf("Geef van de wedstrijd %s-%s de uitdoelpunten: ", mijnWedstrijdArray[i].getThuisTeam().getTeamNaam(), mijnWedstrijdArray[i].getUitTeam().getTeamNaam());
            mijnWedstrijdArray[i].setUitDoelpunten(userInput.nextInt());
            mijnWedstrijdArray[i].setWedstrijdpuntenThuisTeam();
            mijnWedstrijdArray[i].setWedstrijdpuntenUitTeam();
            mijnWedstrijdArray[i].setTotaalDoelpuntenTeams();
        }

        for (int i = 0; i < mijnWedstrijdArray.length; i++) {
            mijnWedstrijdArray[i].printUitslag();
        }

        for (int i = 0; i < mijnTeamArray.length; i++) {
            mijnTeamArray[i].printStatusTeam();
        }

    } // main

    // public methods

    public static int berekenWedstrijden(int aantalTeams) {
        return (aantalTeams) * (aantalTeams - EIGEN_TEAM);
    }

} // klasse
