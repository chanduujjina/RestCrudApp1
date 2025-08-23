## 🔹 Basic Mapping
- @Mapper
 ``` java
  @Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}

  ```
