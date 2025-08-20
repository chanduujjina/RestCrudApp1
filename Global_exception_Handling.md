```java
@ExceptionHandler(exception =MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleBadRequest(MethodArgumentNotValidException  ex){
		
		 Map<String, Object> body = new HashMap<>();
		
		 body.put("timestamp", LocalDateTime.now());
		 body.put("status", HttpStatus.BAD_REQUEST);
		 body.put("error", "Validation Failed");
		 
		 Map<String, String> fieldErrors = new HashMap<>();
		 ex.getBindingResult().getFieldErrors().forEach(error -> {
			 fieldErrors.put(error.getField(),  error.getDefaultMessage());
			 
		 });
		 body.put("message", fieldErrors);
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, String>> handleMissingParam(MissingServletRequestParameterException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("parameter", ex.getParameterName());
        error.put("message", "Request parameter is missing or required");
        return ResponseEntity.badRequest().body(error);
    }
```
---
| Annotation                          | Target Types                                  | Description                                          | Example                                       |
| ----------------------------------- | --------------------------------------------- | ---------------------------------------------------- | --------------------------------------------- |
| **@AssertFalse**                    | `Boolean`, `boolean`                          | Value must be `false`.                               | `@AssertFalse private boolean inactive;`      |
| **@AssertTrue**                     | `Boolean`, `boolean`                          | Value must be `true`.                                | `@AssertTrue private boolean active;`         |
| **@CreditCardNumber** *(Hibernate)* | `String`                                      | Must be a valid credit card number (Luhn check).     | `@CreditCardNumber private String card;`      |
| **@Currency** *(Hibernate)*         | `String`                                      | Must be a valid ISO 4217 currency code.              | `@Currency private String currency;`          |
| **@DecimalMax**                     | `BigDecimal`, `BigInteger`, numeric types     | Value ≤ max.                                         | `@DecimalMax("100.0")`                        |
| **@DecimalMin**                     | `BigDecimal`, `BigInteger`, numeric types     | Value ≥ min.                                         | `@DecimalMin("10.0")`                         |
| **@Digits**                         | `BigDecimal`, `BigInteger`, `String`, numeric | Must be number with `integer` and `fraction` limits. | `@Digits(integer = 5, fraction = 2)`          |
| **@Email**                          | `String`                                      | Must be a valid email.                               | `@Email private String email;`                |
| **@Future**                         | Date/Time                                     | Must be a future date.                               | `@Future private LocalDate expiry;`           |
| **@FutureOrPresent**                | Date/Time                                     | Must be present or future date.                      | `@FutureOrPresent private LocalDate booking;` |
| **@ISBN** *(Hibernate)*             | `String`                                      | Must be a valid ISBN.                                | `@ISBN private String bookCode;`              |
| **@Length** *(Hibernate)*           | `String`                                      | String length between min/max.                       | `@Length(min=2,max=30)`                       |
| **@Max**                            | numeric                                       | Value ≤ max.                                         | `@Max(100)`                                   |
| **@Min**                            | numeric                                       | Value ≥ min.                                         | `@Min(18)`                                    |
| **@Negative**                       | numeric                                       | Value < 0.                                           | `@Negative private int debt;`                 |
| **@NegativeOrZero**                 | numeric                                       | Value ≤ 0.                                           | `@NegativeOrZero private int balance;`        |
| **@NotBlank**                       | `String`                                      | Must not be null/empty/whitespace.                   | `@NotBlank private String username;`          |
| **@NotEmpty**                       | `String`, `Collection`, `Map`, `Array`        | Must not be null or empty.                           | `@NotEmpty private List<String> tags;`        |
| **@NotNull**                        | any                                           | Must not be null.                                    | `@NotNull private String id;`                 |
| **@Null**                           | any                                           | Must be null.                                        | `@Null private String temp;`                  |
| **@Past**                           | Date/Time                                     | Must be a past date.                                 | `@Past private LocalDate dob;`                |
| **@PastOrPresent**                  | Date/Time                                     | Must be past or present date.                        | `@PastOrPresent private LocalDate created;`   |
| **@Pattern**                        | `String`                                      | Must match regex.                                    | `@Pattern(regexp="\\d{10}")`                  |
| **@Positive**                       | numeric                                       | Must be > 0.                                         | `@Positive private int count;`                |
| **@PositiveOrZero**                 | numeric                                       | Must be ≥ 0.                                         | `@PositiveOrZero private int stock;`          |
| **@Range** *(Hibernate)*            | numeric                                       | Must be between min/max.                             | `@Range(min=1,max=100)`                       |
| **@Size**                           | `String`, `Collection`, `Map`, `Array`        | Size/length between min/max.                         | `@Size(min=2,max=10)`                         |
| **@URL** *(Hibernate)*              | `String`                                      | Must be valid URL.                                   | `@URL private String website;`                |
| **@UUID** *(Hibernate)*             | `String`                                      | Must be valid UUID.                                  | `@UUID private String uid;`                   |

---

## 📝 Example DTO using Mixed Annotations

```java
public class UserDto {

    @NotNull
    private Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "\\d{10}")
    private String phone;

    @Min(18) @Max(99)
    private int age;

    @Past
    private LocalDate dob;

    @Future
    private LocalDate subscriptionExpiry;

    @AssertTrue
    private boolean acceptedTerms;
}
```

---

⚡ Quick summary:  
- **Nullity** → `@NotNull`, `@NotEmpty`, `@NotBlank`  
- **String** → `@Size`, `@Pattern`, `@Email`, `@Length`  
- **Numbers** → `@Min`, `@Max`, `@Positive`, `@Digits`, `@Range`  
- **Dates** → `@Past`, `@Future`, etc.  
- **Booleans** → `@AssertTrue`, `@AssertFalse`  
- **Hibernate extras** → `@URL`, `@CreditCardNumber`, `@UUID`, etc.  
