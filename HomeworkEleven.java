import java.util.Scanner;

public class HomeworkEleven {

      public static void main(String[] args) {
    // код ДЗ №11
        Book bookOne = new Book("The Hobbit, or There and Back Again", 1939);
        Book bookTwo = new Book("Fahrenheit 451", 1956);
        Book bookThree = new Book("The Thorn Birds", 1977);
        Book bookFour = new Book("The Grapes of Wrath", 1939);
        Book bookFive = new Book("1984", 1949);
        Book bookSix = new Book("Brave New World",  1939);
        Book bookSeven = new Book("Flowers for Algernon", 1966);
        Book bookEight = new Book("Hatter’s Castle", 1939);
        Book bookNine = new Book("The Masterpiece",  1886);
        Book bookTen = new Book("My Family and Other Animals", 1956);

        Book[] booksArray = new Book[10];
        booksArray[0] = bookOne;
        booksArray[1] = bookTwo;
        booksArray[2] = bookThree;
        booksArray[3] = bookFour;
        booksArray[4] = bookFive;
        booksArray[5] = bookSix;
        booksArray[6] = bookSeven;
        booksArray[7] = bookEight;
        booksArray[8] = bookNine;
        booksArray[9] = bookTen;

        printBook(booksArray);

//        // код ДЗ №9
        String[] books = {"The Hobbit, or There and Back Again", "Fahrenheit 451", "The Thorn Birds", "The Grapes of Wrath", "1984",
                "Brave New World", "Flowers for Algernon", "Hatter’s Castle", "The Masterpiece", "My Family and Other Animals"};
        int[] years = {1939, 1977, 1949, 1966, 1886, 1956};
        int[] connections = {0, 5, 1, 0, 2, 0, 3, 0, 4, 5};

        String[] dialoguesEn = {"Hello! Please, input year of published from: ", "0 - exit from system", "You input incorrect year ",
                "You chose exit from system.", "Please, repeat input.", "Thanks. Bye!", "Book with title = ", ", year of published = "};
        String[] dialoguesUkr = {"Добрий день! Будь ласка, оберіть рік видання з: ", "0 - вихід із системи", "Ви ввели некоректний рік ",
                "Ви обрали вихід із системи.", "Будь ласка, повторіть ввод.", "Дякуємо. До побачення!", "Книга з назвою = ", ", рік видання = "};
        String[] dialoguesRus = {"Добрый день! Пожалуйста, выберете год издательства из: ", "0 - виход из системы", "Вы ввели некорректный год ",
                "Вы выбрали виход из системы.", "Пожалуйста, повторите ввод.", "Спасибо. До свидания!", "Книга с названием = ", ", год издательства = "};
        String[] dialogues = new String[8];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, chose language of dialogue: ");
        System.out.println("1 - English, 2 - Українська мова, 3 - Русский язык");

        while (true) {
            int userLanguageChoice = getUserData(scanner);
            switch (userLanguageChoice) {
                case 1:
                    dialogues = dialoguesEn;
                    break;
                case 2:
                    dialogues = dialoguesUkr;
                    break;
                case 3:
                    dialogues = dialoguesRus;
                    break;
               default:
                    System.out.println("Repeat input, please.");
                    continue;
            }
            break;
        }

        System.out.println(dialogues[0]);
        printYears(years);
        System.out.println(dialogues[1]);

        while (true) {
            int userData = getUserData(scanner);
            if (userData > 0) {
                boolean resultCheck = checkYear(years, userData);
                if (resultCheck) {
                    printBookByYearFilter(books, years, connections, userData, dialogues);
                    break;
                }
                System.out.println(dialogues[2] + userData);
            }
            if (userData == 0) {
                System.out.println(dialogues[3]);
                break;
            }
            System.out.println(dialogues[4]);
        }
        System.out.println(dialogues[5]);

        scanner.close();
    }

        public static void printBook(Book[] booksArray) {
        for (int i = 0; i < booksArray.length; i++) {
            Book book = booksArray[i];
            System.out.println("Book with title = " + book.getName() + ", year of published = " + book.getYear());
        }
    }

    public static void printBookByYearFilter(String[] books, int[] years, int[] connections, int userYear, String[] dialogues) {
        for (int i = 0; i < books.length; i++) {
            String book = books[i];
            int yearIndex = connections[i];
            int year = years[yearIndex];
            if (year == userYear) {
                System.out.println(dialogues[6] + book + dialogues[7] + year);
            }
        }
    }

    public static boolean checkYear(int[] years, int userInputYear) {
        for (int year : years) {
            if (year == userInputYear) {
                return true;
            }
        }
        return false;
    }

    public static int getUserData(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.next());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void printYears(int[] years) {
        for (int year : years) {
            System.out.print(year + " ");
        }
        System.out.println();
    }
}
