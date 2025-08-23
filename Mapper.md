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


