# 📘 Spring Data JPA Finder Methods Cheatsheet

Spring Data JPA generates queries automatically from method names.  
This guide covers the most common keywords and examples.

---

## 🔹 Basic Keywords

| Keyword            | Example Method                              | Generated Query                          |
|--------------------|---------------------------------------------|------------------------------------------|
| `findBy`           | `findByName(String name)`                   | `WHERE name = ?`                         |
| `readBy`           | `readByEmail(String email)`                 | `WHERE email = ?`                        |
| `getBy`            | `getById(Long id)`                          | `WHERE id = ?`                           |
| `queryBy`          | `queryByStatus(String status)`              | `WHERE status = ?`                       |
| `existsBy`         | `existsByEmail(String email)`               | `EXISTS (WHERE email = ?)`               |
| `countBy`          | `countByStatus(String status)`              | `COUNT(*) WHERE status = ?`              |
| `deleteBy`         | `deleteByName(String name)`                 | `DELETE WHERE name = ?`                  |
| `removeBy`         | `removeByName(String name)`                 | `DELETE WHERE name = ?`                  |

---

## 🔹 Multiple Conditions

| Keyword         | Example Method                                                | Generated Query                                        |
|-----------------|---------------------------------------------------------------|--------------------------------------------------------|
| `And`           | `findByFirstNameAndLastName(String first, String last)`       | `WHERE first_name = ? AND last_name = ?`              |
| `Or`            | `findByEmailOrPhone(String email, String phone)`              | `WHERE email = ? OR phone = ?`                        |
| `Between`       | `findBySalaryBetween(BigDecimal min, BigDecimal max)`         | `WHERE salary BETWEEN ? AND ?`                        |
| `LessThan`      | `findByAgeLessThan(int age)`                                  | `WHERE age < ?`                                       |
| `LessThanEqual` | `findByAgeLessThanEqual(int age)`                             | `WHERE age <= ?`                                      |
| `GreaterThan`   | `findBySalaryGreaterThan(BigDecimal salary)`                  | `WHERE salary > ?`                                    |
| `GreaterThanEqual` | `findBySalaryGreaterThanEqual(BigDecimal salary)`          | `WHERE salary >= ?`                                   |
| `After`         | `findByStartDateAfter(LocalDate date)`                        | `WHERE start_date > ?`                                |
| `Before`        | `findByStartDateBefore(LocalDate date)`                       | `WHERE start_date < ?`                                |

---

## 🔹 String Matching

| Keyword           | Example Method                                  | Generated Query                          |
|-------------------|-------------------------------------------------|------------------------------------------|
| `Like`            | `findByNameLike(String name)`                   | `WHERE name LIKE ?`                      |
| `NotLike`         | `findByNameNotLike(String name)`                | `WHERE name NOT LIKE ?`                  |
| `StartingWith`    | `findByNameStartingWith(String prefix)`         | `WHERE name LIKE 'prefix%'`              |
| `EndingWith`      | `findByNameEndingWith(String suffix)`           | `WHERE name LIKE '%suffix'`              |
| `Containing`      | `findByNameContaining(String infix)`            | `WHERE name LIKE '%infix%'`              |
| `NotContaining`   | `findByNameNotContaining(String infix)`         | `WHERE name NOT LIKE '%infix%'`          |
| `IgnoreCase`      | `findByNameIgnoreCase(String name)`             | `WHERE LOWER(name) = LOWER(?)`           |

---

## 🔹 Null Checks

| Keyword    | Example Method                          | Generated Query         |
|------------|-----------------------------------------|-------------------------|
| `IsNull`   | `findByEmailIsNull()`                   | `WHERE email IS NULL`   |
| `IsNotNull`| `findByEmailIsNotNull()`                | `WHERE email IS NOT NULL` |

---

## 🔹 Boolean Checks

| Keyword   | Example Method                           | Generated Query                |
|-----------|------------------------------------------|--------------------------------|
| `True`    | `findByActiveTrue()`                     | `WHERE active = true`          |
| `False`   | `findByActiveFalse()`                    | `WHERE active = false`         |

---

## 🔹 Ordering & Limiting

| Keyword   | Example Method                                        | Generated Query                             |
|-----------|-------------------------------------------------------|---------------------------------------------|
| `OrderBy` | `findByStatusOrderByCreatedAtDesc(String status)`     | `WHERE status = ? ORDER BY created_at DESC` |
| `First`   | `findFirstByOrderBySalaryDesc()`                      | `SELECT * ORDER BY salary DESC LIMIT 1`     |
| `Top`     | `findTop3ByOrderByAgeAsc()`                           | `SELECT * ORDER BY age ASC LIMIT 3`         |

---

## 🔹 Collections

| Keyword       | Example Method                                | Generated Query                      |
|---------------|-----------------------------------------------|--------------------------------------|
| `In`          | `findByIdIn(List<Long> ids)`                  | `WHERE id IN (?)`                    |
| `NotIn`       | `findByIdNotIn(List<Long> ids)`               | `WHERE id NOT IN (?)`                |
| `Containing`  | `findByTagsContaining(String tag)`            | `WHERE tags LIKE %tag%` (if String)  |

---

## 🔹 Example Repository

```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Single field
    Employee findByEmail(String email);

    // Multiple conditions
    List<Employee> findByFirstNameAndLastName(String first, String last);

    // Comparisons
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);

    // String matching
    List<Employee> findByNameContainingIgnoreCase(String name);

    // Null checks
    List<Employee> findByPassportIsNull();

    // Boolean
    List<Employee> findByActiveTrue();

    // Ordering
    List<Employee> findByDepartmentOrderByJoiningDateDesc(String dept);

    // Limit
    Employee findFirstByOrderBySalaryDesc();
    List<Employee> findTop3ByOrderByAgeAsc();

    // Collections
    List<Employee> findByIdIn(List<Long> ids);
}
```
