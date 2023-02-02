import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Controller controller = new Controller();
        Author petofi = controller.addAuthor("Petofi Sandor", LocalDate.of(1823,1,1),"male");
        controller.addBook(1234567898, "SQL praktikák", LocalDate.of(1998, 10, 5),  3, petofi);
        System.out.println(controller.allBooks());
        menu.printMenu2();
        System.out.println(controller.allBooks());
controller.addAuthor("Piszkos Fred",LocalDate.of());
        controller.deleteAll();
    }
}
        /*
        könyvek
        1234567898765,SQL praktikák,3,1998-12-10,34543
        1233367898765,SQL praktikák,1,1990-01-10,34543
        2234567898766,Python praktikák,3,2010-02-13,"123211,4532,34543"
        1234568898765,C programozás,1,1988-05-01,4532
        1234564898765,Kertészkedés alapjai,2,1998-12-10,123211
        1234563898765,Konyhatündér,3,1998-12-10,345433
        1234667898765,Bűn és bűnhődés,1,1866-12-10,345434
        boltok
        2332,Budapest Moricz Zsigmond körtér 5,Pinterino Milán
        3456,Szeged Fő utca 9.,Huarty Emilia
        4321,Debrecen Petőfi utca 32.,Lakati Szilárd
        szerzők
        34543,Perusa Miklós,1967-10-03,male
        4532,Kegimen Eszter,1997-02-01,female
        345434,Fjodor Mihajlovics Dosztojevszkij,1821-11-11,male
        345433,Remani Mohamed,1959-07-14,male
        123211,Hubani Anna,1976-03-23,female
        készlet
        1234667898765,2332,10
        1234667898765,3456,5
        1234667898765,4321,1
        1234563898765,4321,5
        1234564898765,3456,10
        1234568898765,2332,1
        1234568898765,4321,2
        2234567898766,2332,10
        1234567898765,2332,2*/