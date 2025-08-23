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


