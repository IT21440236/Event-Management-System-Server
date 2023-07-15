package com.spm.eventmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name", length = 100)
    private String userName;

    private String email;

    private String password;
}



//Notes

/*
Q)difference between @GeneratedValue(strategy = GenerationType.IDENTITY) and @GeneratedValue(strategy = GenerationType.AUTO)

The `@GeneratedValue` annotation in Java is used to specify how the values for generated primary keys should be generated. It is commonly used in conjunction with the `@Id` annotation to define the primary key of an entity class.

The `strategy` attribute of the `@GeneratedValue` annotation determines the strategy for generating the primary key values. Here are the differences between the `GenerationType.IDENTITY` and `GenerationType.AUTO` strategies:

1. GenerationType.IDENTITY: This strategy is typically used with databases that support an auto-incrementing or identity column. When using this strategy, the underlying database assigns an incrementing value to the primary key column upon insertion of a new row. The generated value is assigned to the entity's primary key property, and the assigned value is immediately available after the entity is persisted.

2. GenerationType.AUTO: This strategy delegates the generation of primary key values to the underlying database. The specific strategy used depends on the database provider and configuration. It may use identity columns, sequences, or other mechanisms provided by the database. The exact behavior is determined by the persistence provider. With this strategy, the generated value may not be immediately available after the entity is persisted and may require an additional round-trip to the database to retrieve the assigned value.

In summary, `GenerationType.IDENTITY` is typically used with databases that support auto-incrementing columns, while `GenerationType.AUTO` delegates the generation strategy to the underlying database. The choice of strategy depends on the database capabilities and specific requirements of your application.

=====================================================================
Q)database column naming conventions

When it comes to naming database columns, it's important to follow naming conventions to ensure consistency and readability. While there are various naming conventions in practice, here are some commonly used guidelines:

1. Use lowercase letters: It is generally recommended to use lowercase letters for column names. This improves readability and avoids confusion with table names, which are often written in uppercase or mixed case.

2. Separate words with underscores: To improve readability and distinguish between multiple words, it's common to separate them with underscores (e.g., `first_name`, `date_of_birth`). This convention is known as snake_case.

3. Be descriptive and concise: Choose column names that accurately describe the data they represent. Use clear and concise names that convey the purpose of the column.

4. Avoid using reserved words: Make sure to avoid using reserved words or keywords specific to your database system as column names. This can prevent conflicts and errors in SQL queries.

5. Use singular nouns: Column names should typically be singular nouns (e.g., `user`, `product`, `address`). This helps maintain consistency and follows the principle of representing a single instance of the data.

6. Avoid abbreviations and acronyms: While brevity is important, it's generally recommended to avoid excessive abbreviations or acronyms in column names. Use descriptive names instead to ensure clarity and understanding.

7. Follow the naming conventions of your database or ORM framework: Some databases or Object-Relational Mapping (ORM) frameworks may have specific naming conventions or guidelines. It's advisable to adhere to those conventions to maintain consistency within the project or organization.

Remember that consistency is key when naming database columns. By following these conventions, you can make your database schema more organized, readable, and maintainable.

 */
