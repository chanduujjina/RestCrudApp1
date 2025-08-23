## 🔹 Basic Mapping
###  @Mapper
 ``` java
  @Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
 ```
### @Mapping
  
  ``` java
  @Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "fullName", target = "name")
    UserDto toDto(User user);
}
```

