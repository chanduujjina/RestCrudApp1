## 🔹 Basic Mapping
- @Mapper
- ```
  @Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}

  ```
