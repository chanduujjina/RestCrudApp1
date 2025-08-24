# 🌐 Spring Boot Application Architecture

```mermaid
flowchart TD

%% Web Layer
Client([Client]) -->|HTTP Request| Controller[REST Controller]

%% Global Exception Handler
Controller -->|Throws Error| ExceptionHandler[@ControllerAdvice <br/> Global Exception Handling]
ExceptionHandler -->|Return Error Response| Client

%% DTO <-> Entity Mapping
Controller -->|Calls Service| Service[Service Layer]
Service -->|Uses MapStruct| Mapper[MapStruct <br/> (DTO ↔ Entity)]

%% Data Access
Service -->|Calls Repository| Repository[Spring Data JPA Repository]
Repository -->|Executes Queries| MySQL[(MySQL Database)]
MySQL --> Repository

%% Responses
Repository -->|Entity| Service
Mapper -->|Convert Entity → DTO| Service
Service -->|Return DTO| Controller
Controller -->|HTTP Response (JSON/XML)| Client
```
