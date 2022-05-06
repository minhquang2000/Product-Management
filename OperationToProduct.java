import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 
 * This class manages all functions relate to the product
 * 
 */

public class OperationToProduct {

    /**
     * 
     * Creating and returning a product with info input from keyboard.
     *
     * 
     * 
     * @return The product
     * 
     */

    public Product createProduct() throws Exception {
        FileOutputStream fout = new FileOutputStream("console_output.txt", true); // Ghi dữ liệu vào console_output.txt
        PrintStream pout = new PrintStream(fout);
        Scanner sc = new Scanner(System.in);
        System.out.print("Input new ID: ");
        String bcode = sc.nextLine();
        pout.println("Input new ID: " + bcode);
        System.out.print("Input Product's name: ");
        String title = sc.nextLine();
        pout.println("Input Product's name: " + title);
        System.out.print("Input Product's quantity: ");
        int quantity = sc.nextInt();
        pout.println("Input Product's quantity: " + quantity);
        System.out.print("Input Product's price: ");
        double price = sc.nextDouble();
        pout.println("Input Product's price: " + price);
        Product info = new Product(bcode, title, quantity, price); // Khởi tạo biến đối tượng dựa trên dữ liệu nhập
        fout.close();
        pout.close();
        return info;
    }

    /**
     * 
     * Reading all products from the file and insert them to the list at tail.
     *
     * 
     * 
     * @param fileName The file name of the file
     * 
     * @param list     The Linked List contains all products that read from file
     * 
     */

    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            // Vòng lặp duyệt qua các dòng của file và thêm vào list
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(" \\| "); // Khởi tạo mảng từ việc phân tách dữ liệu đọc
                String bcode = txt[0];
                String title = txt[1];
                int quantity = Integer.parseInt(txt[2]); // Ép kiểu dữ liệu String sang Integer
                double price = Double.parseDouble(txt[3]); // Ép kiểu dữ liệu String sang Double
                Product info = new Product(bcode, title, quantity, price); // Tạo biến đối tượng
                addLast(list, info); // Thêm biến đối tượng vào cuối linkedlist
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 
     * Reading all products from the file and insert them to the stack.
     *
     * 
     * 
     * @param fileName The file name of the file
     * 
     * @param stack    The Stack contains all products that read from file
     * 
     */

    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        try {
            FileOutputStream fout = new FileOutputStream("console_output.txt", true); // Ghi dữ liệu vào
                                                                                      // console_output.txt
            PrintStream pout = new PrintStream(fout);
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            // Vòng lặp while duyệt qua các dòng của file và thêm vào stack
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(" \\| "); // Tạo mảng từ dữ liệu đọc
                String bcode = txt[0];
                String title = txt[1];
                int quantity = Integer.parseInt(txt[2]); // Ép kiểu dữ liệu String sang Integer
                double price = Double.parseDouble(txt[3]); // Ép kiểu dữ liệu String sang Double
                Product info = new Product(bcode, title, quantity, price); // Tạo biến đối tượng
                stack.push(info); // Thêm biến đối tượng vào stack
            }
            Product item = stack.pop(); // Xóa biến đối tượng trong stack
            while (item != null) { // Vòng lặp kiểm tra và xóa hết phần tử trong stack
                System.out.println(item);
                pout.println(item);
                item = stack.pop();
            }
            fout.close();
            pout.close();
            br.close();
            fr.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 
     * Reading all products from the file and insert them to the queue.
     *
     * 
     * 
     * @param fileName The file name of the file
     * 
     * @param queue    The Queue contains all products that read from file
     * 
     */

    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        try {
            FileOutputStream fout = new FileOutputStream("console_output.txt", true); // Ghi dữ liệu vào
                                                                                      // console_output.txt
            PrintStream pout = new PrintStream(fout);
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            // Vòng lặp while duyệt qua các dòng của file và thêm vào queue
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(" \\| "); // Tạo mảng từ dữ liệu đọc
                String bcode = txt[0];
                String title = txt[1];
                int quantity = Integer.parseInt(txt[2]); // Ép kiểu dữ liệu String sang Integer
                double price = Double.parseDouble(txt[3]); // Ép kiểu dữ liệu String sang Double
                Product info = new Product(bcode, title, quantity, price); // Lưu thông tin vào biến đối tượng
                queue.enqueue(info); // Thêm biến đối tượng vào queue
            }
            Product item = queue.dequeue(); // Xóa biến đối tượng trong queue
            while (item != null) { // Vòng lặp kiểm tra và xóa hết phần tử trong queue
                System.out.println(item);
                pout.println(item);
                item = queue.dequeue();
            }
            fout.close();
            pout.close();
            br.close();
            fr.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 
     * Adding a product to the list, info of the product input from keyboard.
     *
     * 
     * 
     * @param list The Linked list
     * 
     */

    public void addLast(MyList<Product> list, Product item) {
        Node<Product> newNode = new Node<>(item, null);
        // If the Linked list is empty, newNode will be head node
        if (list.head == null) {
            list.head = list.tail = newNode;
            return;
        }
        list.tail.next = newNode;
        list.tail = newNode;
    }

    /**
     * 
     * Printing all products of the list to console screen
     *
     * 
     * 
     * @param list
     * 
     */

    public void displayAll(MyList<Product> list) throws Exception {
        FileOutputStream fout = new FileOutputStream("console_output.txt", true);
        PrintStream pout = new PrintStream(fout);
        Node<Product> current = list.head;
        while (current != null) {
            System.out.println(current.info);
            pout.println(current.info);
            current = current.getNext();
        }
        fout.close();
        pout.close();
    }

    /**
     * 
     * Writing all products from the list to the file
     *
     * 
     * 
     * @param fileName Input file name
     * 
     * @param list     Input Linked list
     * 
     */

    public void writeAllItemsToFile(String fileName, MyList<Product> list) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            Node<Product> current = list.head;
            while (current != null) {
                bw.write(current.info.toString());
                bw.newLine();
                current = current.getNext();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 
     * Searching product by ID input from keyboard.
     *
     * 
     * 
     * @param list
     * 
     */

    public void searchByCode(MyList<Product> list) throws Exception {
        FileOutputStream fout = new FileOutputStream("console_output.txt", true);
        PrintStream pout = new PrintStream(fout);
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the ID to search = ");
        String bcodeSearch = sc.nextLine();
        pout.println("Input the ID to search = " + bcodeSearch);
        Node<Product> current = list.head;
        int count = 0; // Tạo biến đếm số phần tử có mã cần tìm
        while (current != null) { // Vòng lặp duyệt qua phần tử trong list
            // So sánh dữ liệu nhập với thuộc tính bcode của từng node
            if (current.getInfo().getBcode().equalsIgnoreCase(bcodeSearch)) {
                System.out.println("Result: " + current.getInfo().toString());
                pout.println("Result: " + current.getInfo().toString());
                count++;
            }
            current = current.getNext();
        }
        if (current == null && count == 0) {
            System.out.println("Not found");
            pout.println("Not found");
        }
        fout.close();
        pout.close();
    }

    /**
     * 
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * 
     * 
     * @param list
     * 
     */

    public void deleteByCode(MyList<Product> list) throws Exception {
        FileOutputStream fout = new FileOutputStream("console_output.txt", true); // Ghi dữ liệu vào file
        PrintStream pout = new PrintStream(fout);
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the bcode to delete: ");
        String bcodeToDelete = sc.nextLine();
        pout.println("Input the bcode to delete: " + bcodeToDelete);
        Node<Product> current = list.head;
        while (current != null) { // Vòng lặp duyệt qua phần tử trong list
            // So sánh dữ liệu nhập với thuộc tính bcode của node
            if (current.getInfo().getBcode().equalsIgnoreCase(bcodeToDelete)) {
                if (current == list.head) { // Khi dữ liệu nhập = head
                    list.head = current.getNext();
                } else if (current.getNext() == null) { // Khi dữ liệu nhập = tail
                    list.deleteTail();
                }
                list.deleteElement(current.getInfo()); // Trường hợp khác
            }
            current = current.getNext();
        }
        System.out.println("Deleted!");
        pout.println("Deleted!");
        fout.close();
        pout.close();
    }

    // takes first and last node,
    // but do not break any links in
    // the whole linked list
    public Node<Product> paritionLast(Node<Product> start, Node<Product> end) {
        MyList<Product> list = new MyList<>();
        if (start == end || start == null || end == null)
            return start;

        Node<Product> pivot_prev = start;
        Node<Product> curr = start;
        String pivot = end.getInfo().getBcode();

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.getInfo().getBcode().compareTo(pivot) < 0) {
                // keep tracks of last modified item
                pivot_prev = curr;
                list.swap(curr, start);
                curr = curr.getNext();
            }
            start = start.next;
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        list.swap(curr, end);

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    /**
     * 
     * Sorting products in linked list by ID
     *
     * 
     * 
     * @param list  The Linked list
     * @param start
     * @param end
     * 
     */

    public void sortByCode(MyList<Product> list, Node<Product> start, Node<Product> end) {
        if (start == null || start == end || start == end.getNext())
            return;

        // split list and partition recurse
        Node<Product> pivot_prev = paritionLast(start, end);
        sortByCode(list, start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sortByCode(list, pivot_prev.next, end);

        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                && pivot_prev.next != null)
            sortByCode(list, pivot_prev.next.next, end);
    }

    /**
     * 
     * Convert a decimal to a integer number. Example: input i = 18 -> Output =
     * 10010
     * 
     * @param i Input decimal number
     * 
     * @return a integer numbers
     * 
     */

    public int convertToBinary(int i) {
        String string = "";
        while (i > 0) {
            int remainder = i % 2;
            string = remainder + string;
            i /= 2;
        }
        return Integer.parseInt(string); // Ép kiểu dữ liệu String sang Integer
    }
}