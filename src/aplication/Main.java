package aplication;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            sc.nextLine();

            System.out.println("Product #" + i + " data:");
            char c;
            do {
                System.out.print("Common, used or imported (c/u/i)? ");
                c = sc.next().charAt(0);
                sc.nextLine();
            } while (c != 'c' && c != 'u' && c != 'i');

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price =  sc.nextDouble();

            Product prod;

            switch (c) {
                case 'i':
                    sc.nextLine();
                    System.out.print("Customs fee: ");
                    Double customsFee = sc.nextDouble();
                    prod = new ImportedProduct(name, price, customsFee);
                    break;
                case 'u':
                    sc.nextLine();
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    Date manufactureDate = sdf.parse(sc.nextLine());
                    prod = new UsedProduct(name, price, manufactureDate);
                    break;
                default:
                    prod = new Product(name, price);
            }
            products.add(prod);
        }

        System.out.println("PRICE TAGS:");
        for (Product p : products){
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}
