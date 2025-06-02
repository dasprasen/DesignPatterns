package com.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Interview_Examples {
    public static void main(String[] args) {
        // immutable list, allow nulls
        var immutableList = Stream.of("red", "green", null).toList();
        System.out.println(immutableList);

        //modifiable list, allow nulls
        var modifiableList = Stream.of("red", "green", null).collect(Collectors.toList());
        modifiableList.add("yellow");
        System.out.println(modifiableList);

        record Product(String name, String category, int price) {};
        Stream<Product> products = Stream.of(
                new Product("Laptop", "Electronics", 1000),
                new Product("TV", "Electronics", 1500),
                new Product("Sofa", "Furniture", 700),
                new Product("Table", "Furniture", 300),
                new Product("Lamp", "Home Decor", 50)
        );

        // grouping product by category
//        Map<String, List<Product>> groupProductByCategory =
//                products.collect(Collectors.groupingBy(Product::category));
//        System.out.println(groupProductByCategory);

        //calculate the total price in each category
//        Map<String, Integer> totalPriceByCategory =
//                products.collect(Collectors.groupingBy(Product::category, Collectors.summingInt(Product::price)));
//        System.out.println(totalPriceByCategory);

        // counting of products with category
//        Map<String, Long> countingProductByCategory =
//                products.collect(Collectors.groupingBy(Product::category, Collectors.counting()));
//        System.out.println(countingProductByCategory);

        // products with price greater than 50
//        var filteredProducts = products.filter(product -> product.price > 50).toList();
//        System.out.println(filteredProducts);

        // extract product categories
//        var extractProductCategories = products.map(Product::category).distinct().collect(Collectors.toList());
//        System.out.println(extractProductCategories);


        // separate products into expensive and cheap
//        var partitionedProducts = products.collect(Collectors.partitioningBy(product -> product.price > 1000));
//        System.out.println(partitionedProducts);

        // using summary statistics for product prices
        Map<String, IntSummaryStatistics> summaryStatisticsByCategory = products.collect(
                Collectors.groupingBy(Product::category, Collectors.summarizingInt(Product::price)));
        System.out.println(summaryStatisticsByCategory);
    }
}
