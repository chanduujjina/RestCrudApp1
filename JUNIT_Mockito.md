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
## ✅ Common Assertions in JUnit 5

| Assertion Method                           | Description                                         | Example                                                       |
| ------------------------------------------ | --------------------------------------------------- | ------------------------------------------------------------- |
| `assertEquals(expected, actual)`           | Asserts that two values are equal                   | `assertEquals(5, result)`                                     |
| `assertNotEquals(unexpected, actual)`      | Asserts that two values are not equal               | `assertNotEquals(0, result)`                                  |
| `assertTrue(condition)`                    | Asserts that the condition is `true`                | `assertTrue(user.isActive())`                                 |
| `assertFalse(condition)`                   | Asserts that the condition is `false`               | `assertFalse(user.isDeleted())`                               |
| `assertNull(value)`                        | Asserts that the object is `null`                   | `assertNull(result)`                                          |
| `assertNotNull(value)`                     | Asserts that the object is **not** `null`           | `assertNotNull(user)`                                         |
| `assertSame(expected, actual)`             | Asserts that two objects refer to the same instance | `assertSame(obj1, obj2)`                                      |
| `assertNotSame(unexpected, actual)`        | Asserts that two objects are not the same instance  | `assertNotSame(obj1, obj2)`                                   |
| `assertArrayEquals(expected, actual)`      | Asserts two arrays are equal                        | `assertArrayEquals(new int[]{1,2}, arr)`                      |
| `assertAll(...)`                           | Group multiple assertions — all are run             | `assertAll(() -> ..., () -> ...)`                             |
| `assertThrows(Exception.class, codeBlock)` | Asserts an exception is thrown                      | `assertThrows(RuntimeException.class, () -> service.doBad())` |
| `assertDoesNotThrow(codeBlock)`            | Asserts that no exception is thrown                 | `assertDoesNotThrow(() -> method())`                          |
| `assertTimeout(Duration, codeBlock)`       | Asserts execution completes within time             | `assertTimeout(Duration.ofSeconds(1), () -> service.run())`   |
---

## Assert with Mock Verification (Mockito)

| Assertion                         | Example                             |
| --------------------------------- | ----------------------------------- |
| `verify(mock).method()`           | `verify(repo).save(any())`          |
| `verify(mock, times(2)).method()` | `verify(repo, times(2)).save(user)` |
| `verifyNoInteractions(mock)`      | `verifyNoInteractions(service)`     |
| `verifyNoMoreInteractions(mock)`  | `verifyNoMoreInteractions(repo)`    |
| `assertThat(value)` (AssertJ)     | `assertThat(list).hasSize(3)`       |
---
