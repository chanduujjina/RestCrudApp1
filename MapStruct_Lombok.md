<!-- Lombok -->
```
<!-- MapStruct -->

	  <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.34</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.5.5.Final</version>
    </dependency>

    <!-- MapStruct processor -->
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>1.5.5.Final</version>
        <scope>provided</scope>
    </dependency>

	<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
            <configuration>
                <source>17</source>
                <target>17</target>
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.mapstruct</groupId>
                        <artifactId>mapstruct-processor</artifactId>
                        <version>1.5.5.Final</version>
                    </path>
                    <path>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                        <version>1.18.34</version>
                    </path>
                </annotationProcessorPaths>
            </configuration>
        </plugin>
    </plugins>
</build>
```
---

# 📘 Lombok Annotations Summary

| Annotation           | Description                                                                 | Example Snippet                                                                 |
|----------------------|-----------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| `@Getter`            | Generates getter methods for all fields                                     | `@Getter private String name;`                                                  |
| `@Setter`            | Generates setter methods for all fields                                     | `@Setter private int age;`                                                      |
| `@ToString`          | Generates `toString()` method                                                | `@ToString public class User { ... }`                                           |
| `@EqualsAndHashCode` | Generates `equals()` and `hashCode()` methods                               | `@EqualsAndHashCode public class User { ... }`                                  |
| `@NoArgsConstructor` | Creates a no-arg constructor                                                  | `@NoArgsConstructor public class User { ... }`                                  |
| `@AllArgsConstructor`| Creates a constructor with all fields                                        | `@AllArgsConstructor public class User { ... }`                                 |
| `@RequiredArgsConstructor` | Constructor for final / `@NonNull` fields                         | `@RequiredArgsConstructor public class User { ... }`                            |
| `@Data`              | Combines `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`, and `@RequiredArgsConstructor` | `@Data public class User { ... }`                          |
| `@Value`             | Immutable version of `@Data` (all fields final)                             | `@Value public class User { ... }`                                              |
| `@Builder`           | Implements Builder pattern                                                   | `User.builder().name("John").age(30).build();`                                  |
| `@SneakyThrows`      | Bypass declaring checked exceptions                                          | `@SneakyThrows public void read() { Files.readAllLines(path); }`               |
| `@NonNull`           | Null check for parameters                                                    | `@NonNull private String name;`                                                 |
| `@Slf4j`             | Creates `log` field using Slf4j                                              | `log.info("Hello");`                                                            |
| `@Cleanup`           | Calls `.close()` automatically on resources

