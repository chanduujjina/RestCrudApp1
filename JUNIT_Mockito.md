## ✅ Includes JUnit 5 + Mockito + Spring Test

| Annotation                            | Description                                        |
| ------------------------------------- | -------------------------------------------------- |
| `@Mock`                               | Creates a mock instance                            |
| `@Spy`                                | Wraps a real object but lets you mock some methods |
| `@InjectMocks`                        | Injects mock fields into the tested object         |
| `@MockBean`                           | Spring Boot-specific, injects mock into context    |
| `@ExtendWith(MockitoExtension.class)` | Enables Mockito support in JUnit 5                 |
----
## Stubbing

| Syntax                               | Purpose                                   | Example Output                                       |
| ------------------------------------ | ----------------------------------------- | ---------------------------------------------------- |
| `Mockito.mock(Class.class)`          | Manually create a mock                    | `UserService mock = mock(UserService.class)`         |
| `when(...).thenReturn(...)`          | Stub a method call                        | `when(repo.findById(1L)).thenReturn(user)`           |
| `verify(mock).method()`              | Verify a method was called                | `verify(service).getUser(1L)`                        |
| `verify(mock, times(2)).method()`    | Verify call count                         | `verify(repo, times(2)).save(any())`                 |
| `doReturn(...).when(spy).method()`   | Stub method on a spy                      | `doReturn("Hi").when(spy).greet()`                   |
| `doThrow(...).when(mock).method()`   | Throw exception on method call            | `doThrow(new RuntimeException()).when(svc).delete()` |
| `ArgumentCaptor<T>`                  | Capture method arguments                  | `captor.getValue()`                                  |
| `reset(mock)`                        | Reset interactions                        | Clears previous stubbing/verifications               |
| `MockitoAnnotations.openMocks(this)` | Init mocks (alternative to `@ExtendWith`) | Often used in legacy setups                          |
---
