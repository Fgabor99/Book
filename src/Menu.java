import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    void printMenu(){
        System.out.println("         Könyvek (1)     ");
        System.out.println("         Szerzők (2)     ");
        System.out.println("         Boltok  (3)     ");
        System.out.println("Üsd be a megfelelő számot");
    }
    void menu(){
        printMenu();
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        if(num == 1){
            bookMenu(scanner);
        }
        if(num == 2){
            authorMenu(scanner);
       }
        if (num == 3){
         storeMenu(scanner);
       }
    }
    public void bookMenu(Scanner scanner){
        Controller controller=new Controller();

        System.out.println(" új könyv hozzáadása (1) ");
        System.out.println(" könyv módosítás     (2) ");
        System.out.println(" könyv keresés       (3) ");
        System.out.println(" könyv kivonása      (4) ");
        System.out.println(" vissza a menübe     (0) ");

        int num = scanner.nextInt();

        if(num ==1){
            String fgf = scanner.nextLine(); // magyarázzátok el el ne felejtsd

            System.out.println("írd be a könyv ISBN-ÉT ");
            int isbn = Integer.parseInt(scanner.nextLine());

            System.out.println("írd be a könyv Címét ");
            String title = scanner.nextLine();

            System.out.println("írd be a könyv kiadási dátuma ebben a sorrendben --> (YYYY-MM-DD)");
            String date = scanner.nextLine();
            LocalDate releaseDate = LocalDate.parse(date);

            System.out.println("kiadás szám");
            int edition=scanner.nextInt();

            System.out.println("írd be a könyv Szerző ID-t");
            int authorId=scanner.nextInt();

            controller.addBook(isbn,title,releaseDate,edition, authorId);
        }
        if(num == 2 ){
            String fgf = scanner.nextLine();

            System.out.println("írd be a könyv ID-T");
            int id=scanner.nextInt();

            System.out.println("írd be a könyv ISBN-ÉT ");
            int isbn = Integer.parseInt(scanner.nextLine());

            System.out.println("írd be a könyv Címét ");
            String title = scanner.nextLine();

            System.out.println("írd be a könyv kiadási dátuma ebben a sorrendben --> (YYYY-MM-DD)");
            String date = scanner.nextLine();
            LocalDate releaseDate = LocalDate.parse(date);

            System.out.println("kiadás szám");
            int edition=scanner.nextInt();

            System.out.println("írd be a könyv Szerző ID-t");
            int authorId=scanner.nextInt();

            controller.modifyBook(id,isbn,title,releaseDate,edition,authorId);
        }
        if(num == 3 ){
            System.out.println("Mi alaőján szeretnél keresni ?");
            System.out.println("         Szerző (1)           ");
            System.out.println("         Cím    (2)           ");
            System.out.println("         ISBN   (3)           ");

            int num1 = scanner.nextInt();

            if(num1 == 1){

                System.out.println("írd be a szerző teljes nevét ");
                String name = scanner.nextLine();
                controller.findBookByAuthor(name);
            }
            if(num1 ==2 ){
                System.out.println("írd be a konyv teljes címét");
                String bookName = scanner.nextLine();
                controller.findBookByTitle(bookName);
            }
            if(num1 == 3 ) {
                System.out.println("írd be a könyv ISBN-T");
                int isbn = scanner.nextInt();
                controller.findBookByIsbn(isbn);
            }
        }
        if(num == 4 ){}
        if(num == 0 ){menu();}
    }
    public void authorMenu(Scanner scanner){
        Controller controller=new Controller();

        System.out.println("\tszerző hozzáadása (1) ");
        System.out.println("\tszerző módosítás  (2) ");
        System.out.println("\tszerző törlése    (3) ");
        System.out.println("\tvissza a menübe   (0) ");

        int num = scanner.nextInt();
        if(num == 1){
            String fgf = scanner.nextLine(); // magyarázzátok el el ne felejtsd

            System.out.println(" írd be a szerző nevét");
            String name = scanner.nextLine();

            System.out.println("ird be a születési dátumát ebben a sorrendben --> (YYYY-MM-DD)");
            String bday = scanner.nextLine();
            LocalDate releaseDate = LocalDate.parse(bday);

            System.out.println("írd be a szerző nemét");
            String gender = scanner.nextLine();

            controller.addAuthor(name,releaseDate,gender);
        }
        if(num == 2){
            System.out.println("írd be a szerző ID-t");
            int id =scanner.nextInt();
            String fgf = scanner.nextLine(); // magyarázzátok el el ne felejtsd

            System.out.println(" írd be az új  nevét");
            String name = scanner.nextLine();

            System.out.println("ird be az új születési dátumát ebben a sorrendben --> (YYYY-MM-DD)");
            String bday = scanner.nextLine();
            LocalDate releaseDate = LocalDate.parse(bday);

            System.out.println("írd be a szerző nemét");
            String gender = scanner.nextLine();

            controller.modifyAuthor(id,name,releaseDate,gender);
        }
        if(num == 3){
            System.out.println("ird be a szerző ID-t");
            int id = scanner.nextInt();
            controller.deleteAuthor(id);
        }
        if(num == 0 ){menu();}
    };
    public void storeMenu(Scanner scanner){
        Controller controller = new Controller();

        System.out.println(" új bolt hozzáadása  (1)");
        System.out.println("    bolt módosítása  (2)");
        System.out.println("szerződés módósítása (3)");
        System.out.println(" vissza a menübe (0)");

        int num=scanner.nextInt();
        if(num == 1 ){
            System.out.println("írd be a bolt nevét");
            String name=scanner.nextLine();

            String fgf = scanner.nextLine(); // magyarázzátok el el ne felejtsd

            System.out.println("írd be a bolt címét");
            String address=scanner.nextLine();

            System.out.println("írd be a tulajdonos nevét");
            String owner=scanner.nextLine();

            System.out.println("szerződés true vagy false");
            Boolean contract=scanner.hasNext();

            controller.addStore(name,address,owner,contract);
        }
        if(num == 2 ){

        }
        if(num == 3 ){}
        if(num == 0 ){menu();}
    };
}