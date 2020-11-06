package com.company;

import java.time.LocalDate;
import java.util.*;

public class MovieDB {

    static List<Movie> movieLibrary = new LinkedList<>();
    static List<Director> directorsLibrary = new LinkedList<>();
    static List<Actors> actorsLibrary = new LinkedList<>();

    public static void preaperMovieData() {
        Actors tomCruiz = new Actors("Tom Cruzi");
        Actors tomHanks = new Actors("Tom Hanks");
        Actors juliaRoberts = new Actors("Julia Roberts");
        Actors nataliPortman = new Actors("Natali Protman");
        Actors stevenSegal = new Actors("Steven Segal");

        actorsLibrary = Arrays.asList(tomCruiz, tomHanks, juliaRoberts, nataliPortman, stevenSegal);

        Director stevenSpelberg = new Director("Steven Spelberg");
        Director quentinTarantino = new Director("Quentin Tarantino");

        directorsLibrary = Arrays.asList(stevenSpelberg, quentinTarantino);

        Movie zubma = new Movie("Zubma", stevenSpelberg, MovieType.action, LocalDate.of(2020, 12, 1),
                Arrays.asList(tomCruiz, tomHanks, nataliPortman));

        Movie rambo = new Movie("Rambo", quentinTarantino, MovieType.horror, LocalDate.of(2019, 2, 1),
                Arrays.asList(stevenSegal, juliaRoberts, tomCruiz));

        movieLibrary.add(zubma);
        movieLibrary.add(rambo);
    }

    public static void selectMenu() {
        int i = 0;
        while (i==0) {
            displayMenu();

            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();

            switch (option) {
                case 1:
                    addNewFilm();
                    break;
                case 2:
                    findFilmByName();
                    break;
                case 3:
                    getFilmFromDateRange();
                    break;
                case 4:
                    checkFilmsForActor();
                    break;
                default:
                    i++;
                    System.out.println("Zły wybor");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu\n" +
                "1:dodaj film\n" +
                "2:szukaj filmu po nazwie\n" +
                "3:wypisz filmy z zakresu dat\n" +
                "4:sprawdz w jakich fimach grał dany aktor\n"
        );
    }

    private static void addNewFilm() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj tytul nowego filmu");
        String title = scan.nextLine();

        System.out.println("Podaj imie i nazwisko rezysera");
        String director = scan.nextLine();

        System.out.println("Podaj typ z:  horror,\n" +
                "    action,\n" +
                "    comedy,");
        String type = scan.nextLine();

        System.out.println("podaj date premiery, rok:");
        int fromYear = scan.nextInt();
        System.out.println("podaj date premiery, miesiac:");
        int fromMonth = scan.nextInt();
        System.out.println("podaj date premiery, dzien:");
        int fromDay = scan.nextInt();

        System.out.println("Ilu bedzie aktorów?");
        int actorsCount = scan.nextInt();

        List<Actors> actors = new LinkedList<>();
        for (int i = 0; i <= actorsCount; i++) {
            System.out.println("Podaj imie i nazwisko actora");
            String actorName = scan.nextLine();
            actorsLibrary.stream().filter(actors1 -> actors1.getName().equals(actorName)).forEach(actors::add);
        }

        Movie movie = new Movie(title, getDirectorByName(director), MovieType.valueOf(type), LocalDate.of(fromYear, fromMonth, fromDay), actors);
        movieLibrary.add(movie);
    }

    private static Director getDirectorByName(String director) {
        return directorsLibrary.stream().filter(s -> s.getName().equals(director)).findAny().get();
    }

    private static void findFilmByName() {
        System.out.println("Podaj nazwe");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        for (Movie movie : movieLibrary) {
            if (movie.getTitle().equals(name)) {
                System.out.println(movie.toString());
            }
        }
    }

    private static void getFilmFromDateRange() {
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj date od, rok:");
        int fromYear = scan.nextInt();
        System.out.println("podaj date od, miesiac:");
        int fromMonth = scan.nextInt();
        System.out.println("podaj date od, dzien:");
        int fromDay = scan.nextInt();
        System.out.println("podaj date do, rok:");
        int toYear = scan.nextInt();
        System.out.println("podaj date do, miesiac:");
        int toMonth = scan.nextInt();
        System.out.println("podaj date do, dzien:");
        int toDay = scan.nextInt();
        LocalDate start = LocalDate.of(fromYear, fromMonth, fromDay);
        LocalDate end = LocalDate.of(toYear, toMonth, toDay);
        movieLibrary.stream().filter(
                s -> s.premiereDate.isAfter(start) && s.premiereDate.isBefore(end) || s.premiereDate.equals(start) || s.premiereDate.equals(end))
                .map(Movie::toString).forEach(System.out::println);
    }


    private static void checkFilmsForActor() {
        System.out.println("Podaj imie i nazwisko aktora");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        movieLibrary.forEach(
                movie -> movie.getActorsList()
                        .stream()
                        .filter(actors -> actors.getName().equals(name))
                        .map(actors -> movie.getTitle())
                        .forEach(System.out::println));
    }


}
