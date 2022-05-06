import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class AS2_Main {

    public static String showMenu() {
        String showMenu = "\nChoose one of this options:" + "\nProduct list:" + "\n1. Load data from file and display"
                + "\n2. Input & add to the end" + "\n3. Display data" + "\n4. Save product list to file"
                + "\n5. Search by ID" + "\n6. Delete by ID" + "\n7. Sort by ID" + "\n8. Convert to Binary"
                + "\n9. Load to stack and display" + "\n10. Load to queue and display" + "\n0. Exit\n";
        return showMenu;
    }

    public static void main(String[] args) throws Exception {
        FileOutputStream fout = new FileOutputStream("console_output.txt", true); // Ghi dữ liệu vào console_output.txt
        PrintStream pout = new PrintStream(fout);
        Scanner sc = new Scanner(System.in);
        OperationToProduct op = new OperationToProduct(); // Khai báo class OperationToProduct chứa các hàm chức năng
        MyList<Product> list = new MyList<>(); // Khai báo class MyList
        MyStack<Product> stack = new MyStack<>(); // Khai báo class MyStack
        MyQueue<Product> queue = new MyQueue<>(); // Khai báo class MyQueue
        String showMenu = showMenu();
        do {
            System.out.println(showMenu);
            System.out.print("Choice(0-10): ");
            int choice = sc.nextInt();
            pout.println(showMenu);
            pout.println("Choice(0-10): " + choice);
            switch (choice) {
                case 1:
                    System.out.println("ID ! Title | Quantity | Price");
                    System.out.println("-------------------------------");
                    pout.println("ID ! Title | Quantity | Price");
                    pout.println("-------------------------------");
                    list.clear(); // Làm mới linkedlist
                    op.getAllItemsFromFile("Data.txt", list);
                    op.displayAll(list);
                    break;
                case 2:
                    Product item = op.createProduct(); // Khai báo thông tin sản phẩm mới và lưu vào biến đối tượng
                    op.addLast(list, item); // Lưu biến vào cuối linkedlist
                    break;
                case 3:
                    System.out.println("ID ! Title | Quantity | Price");
                    System.out.println("-------------------------------");
                    pout.println("ID ! Title | Quantity | Price");
                    pout.println("-------------------------------");
                    op.displayAll(list);
                    break;
                case 4:
                    op.writeAllItemsToFile("Data.txt", list);
                    System.out.println("Successfully!");
                    pout.println("Successfully!");
                    break;
                case 5:
                    op.searchByCode(list);
                    break;
                case 6:
                    op.deleteByCode(list);
                    break;
                case 7:
                    // Gán giá trị node cuối trong linkedlist cho biến n
                    Node<Product> end = list.head;
                    while (end.getNext() != null) { // Vòng lặp duyệt đến cuối linkedlist
                        end = end.getNext();
                    }
                    op.sortByCode(list, list.head, end);
                    System.out.println("Successfully!");
                    pout.println("Successfully!");
                    break;
                case 8:
                    int quantityOfFirstNode = list.head.getInfo().getQuantity(); // Đặt biến = quantity của head
                    int quantityConvertToBinary = op.convertToBinary(quantityOfFirstNode); // Đổi sang nhị phân
                    System.out.println("Quantity = " + quantityOfFirstNode + " => (" + quantityConvertToBinary + ")");
                    pout.println("Quantity = " + quantityOfFirstNode + " => (" + quantityConvertToBinary + ")");
                    break;
                case 9:
                    System.out.println("ID ! Title | Quantity | Price");
                    System.out.println("-------------------------------");
                    pout.println("ID ! Title | Quantity | Price");
                    pout.println("-------------------------------");
                    op.getAllItemsFromFile("Data.txt", stack);
                    break;
                case 10:
                    System.out.println("ID ! Title | Quantity | Price");
                    System.out.println("-------------------------------");
                    pout.println("ID ! Title | Quantity | Price");
                    pout.println("-------------------------------");
                    op.getAllItemsFromFile("Data.txt", queue);
                    break;
                case 0:
                    System.out.println(" Good bye, have a nice day!");
                    pout.println(" Good bye, have a nice day!");
                    pout.close();
                    fout.close();
                    return;
                default:
                    System.out.println("**Invalid choice. Try again.**");
                    pout.println("**Invalid choice. Try again.**");
            }
        } while (true);
    }

}