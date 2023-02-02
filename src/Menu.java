import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    void printMenu(){
        System.out.println("\tKönyvek (1) ");
        System.out.println("\tSzerzők (2) ");
        System.out.println("\tBoltok  (3) ");
        System.out.println("\tÜsd be a megfelelő számot");
    }
    void printMenu2(){
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num == 1){
            bookMenu(scanner);
        }
//        if(num == 2){
//            authorMenu();
//        }
//        if (num == 3){
//         storeMenu();
//        }
    }
    public void bookMenu(Scanner scanner){
        Controller controller=new Controller();
        System.out.println("\t új könyv hozzáadása (1) ");
        System.out.println("\t könyv módosítás     (2) ");
        System.out.println("\t könyv keresés       (3) ");
        System.out.println("\t könyv kivonása      (4) ");
        System.out.println("\t vissza a menübe     (0) ");
        int num = scanner.nextInt();
        if(num ==1){
            String fgf = scanner.nextLine();
            System.out.println("írd be a könyv ISBN-ÉT ");
            int isbn = Integer.parseInt(scanner.nextLine());
            System.out.println("írd be a könyv Címét");
            String title = scanner.nextLine();
            System.out.println("írd be a könyv Kiadás Dátuma (YYYY-MM-DD)");
            String date = scanner.nextLine();
            LocalDate releaseDate = LocalDate.parse(date);
            System.out.println("kiadás szám");
            int edition=scanner.nextInt();
            System.out.println("írd be a könyv Szerző ID-t");
            int authorId=scanner.nextInt();
            controller.addBook(isbn,title,releaseDate,edition, authorId);
        }
        if(num == 2 ){}
        if(num == 3 ){}
        if(num == 4 ){}
        if(num == 0 ){printMenu2();}
    }
    public void authorMenu(Scanner scanner){
        Controller controller=new Controller();

        System.out.println("\tszerző hozzáadása (1) ");
        System.out.println("\tszerző módosítás  (2) ");
        System.out.println("\tszerző törlése    (3) ");
        System.out.println("\tvissza a menübe   (0) ");
        int num=scanner.nextInt();
        if(num == 0 ){printMenu2();}

    };
    public void storeMenu(Scanner scanner){
        Controller controller = new Controller();

        System.out.println(" új könyv hozzáadása (1)");
        System.out.println(" új könyv hozzáadása (2)");
        System.out.println(" új könyv hozzáadása (3)");
        System.out.println(" új könyv hozzáadása (4)");
        System.out.println(" új könyv hozzáadása (5)");
        System.out.println(" vissza a menübe (0)");
        int num=scanner.nextInt();
        if(num == 0 ){printMenu2();}

    };
}
