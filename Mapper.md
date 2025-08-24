## 🔹 Basic Mapping
###  @Mapper -> Defines a mapper interface.
 ``` java
  @Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
 ```
### @Mapping -> Maps fields between source and target.
  
  ``` java
  @Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "fullName", target = "name")
    UserDto toDto(User user);
}
```

### @Mappings -> Group of multiple @Mapping.
```
@Mappings({
    @Mapping(source = "fullName", target = "name"),
    @Mapping(source = "birthDate", target = "dob")
})
UserDto toDto(User user);

```

### @InheritInverseConfiguration -> Reverses mappings automatically
```java
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "fullName", target = "name")
    UserDto toDto(User user);

    @InheritInverseConfiguration
    User toEntity(UserDto dto);
}

```

### @InheritConfiguration -> Reuses mappings from another method.
```java
@Mapping(source = "fullName", target = "name")
UserDto toDto(User user);

@InheritConfiguration(name = "toDto")
User toEntity(UserDto dto);
```
### @AfterMapping -> Runs after automatic mapping is done.
```java
@AfterMapping
default void setDefaults(@MappingTarget User user, UserDto dto) {
    if (user.getName() == null) {
        user.setName("Unknown");
    }
}

```
### @BeforeMapping -> Runs before automatic mapping. 

```java
@BeforeMapping
default void normalize(UserDto dto) {
    if (dto.getFullName() != null) {
        dto.setFullName(dto.getFullName().trim());
    }
}

```

### Nested Mapping
```java
@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);
}

```
### Iterable / List Mapping
```java
List<UserDto> toDtoList(List<User> users);
List<User> toEntityList(List<UserDto> dtos);

```

### Map Mapping
```java
@Mapping(target = "password", ignore = true)
UserDto toDto(User user);
```

### @Mapping(expression = "java(...)") -> Custom Java expression.

```java
@Mapping(target = "age", expression = "java(Period.between(user.getDob(), LocalDate.now()).getYears())")
UserDto toDto(User user);

```
### @BeanMapping -> Customize mapping strategy.
```java
@BeanMapping(ignoreByDefault = true)
@Mapping(source = "id", target = "id")
UserDto toDto(User user);
```

# ⚙️ MapStruct Workflow in Spring Boot

MapStruct is a **compile-time code generator** for mapping between **DTOs** and **Entities**.  
Here’s how the workflow looks:

---

## 🔹 Workflow Steps

1. **Define Mapper Interface**  
   - You declare a `@Mapper` interface with methods like `toDto()` and `toEntity()`.

2. **Compile-Time Code Generation**  
   - MapStruct generates an **implementation class** (e.g., `UserMapperImpl`) during compilation.  
   - This class contains the actual field-by-field mapping code.

3. **Spring Integration**  
   - If `@Mapper(componentModel = "spring")` is used, the generated implementation becomes a Spring Bean.  
   - You can `@Autowired` it anywhere in your app.

4. **Mapping Flow at Runtime**  
   - **Service Layer** calls the Mapper.  
   - **DTO → Entity**: Used before saving data into DB.  
   - **Entity → DTO**: Used before returning API responses.  
   - Custom logic can be added with `@BeforeMapping` and `@AfterMapping`.

---

## 🔹 MapStruct Workflow (Sequence Diagram)

```mermaid
sequenceDiagram
    participant C as Client (API Request)
    participant Ctrl as REST Controller
    participant S as Service Layer
    participant M as MapStruct Mapper
    participant R as Repository (Spring Data JPA)
    participant DB as MySQL Database

    C->>Ctrl: Send DTO in HTTP Request
    Ctrl->>S: Forward DTO
    S->>M: Convert DTO to Entity
    M-->>S: Return Entity
    S->>R: Save Entity
    R->>DB: Insert into Database
    DB-->>R: Acknowledgement
    R-->>S: Return Entity
    S->>M: Convert Entity to DTO
    M-->>S: Return DTO
    S-->>Ctrl: Return DTO
    Ctrl-->>C: Send HTTP Response

