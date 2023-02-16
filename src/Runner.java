import by.gsu.pm.Customer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Runner {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader("src\\inFirst.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            int id = 0;
            while(sc.hasNextLine()){
                customers.add(new Customer(id, sc.next(), sc.next(), sc.next(), sc.next() + " " + sc.next() + ", " + sc.next(), sc.nextLong(), sc.nextLong()));
                System.out.println(customers.get(id));
                id++;
                if (sc.hasNextLine()) sc.nextLine();
            }
            Collections.sort(customers);
            writeInFile(customers, "full_sort_list.txt");
            writeInFileRange(customers, "range_list.txt", 2000000000000000L, 8000000000000000L);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

    }

    public static void writeInFile(List<Customer> customers, String txtName) {
        try(FileWriter writer = new FileWriter(txtName, false))
        {
            for (Customer customer : customers) {
                writer.write(customer.toString());
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void writeInFileRange(List<Customer> customers, String txtName, long start, long end) {
        try(FileWriter writer = new FileWriter(txtName, false))
        {
            for (Customer customer : customers) {
                if (customer.getCardNumber() >= start && customer.getCardNumber() <= customer.getCardNumber()) {
                    writer.write(customer.toString());
                    writer.append('\n');
                }
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
