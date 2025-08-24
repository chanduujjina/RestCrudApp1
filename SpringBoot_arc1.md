# 🌐 Spring Boot Application Architecture

```mermaid
flowchart TD

%% Web Layer
Client[Client] --> Controller["REST Controller"]

%% Global Exception Handler
Controller --> ExceptionHandler["Global Exception Handler - ControllerAdvice"]
ExceptionHandler --> Client

%% DTO <-> Entity Mapping
Controller --> Service["Service Layer"]
Service --> Mapper["MapStruct DTO <-> Entity"]

%% Data Access
Service --> Repository["Spring Data JPA Repository"]
Repository --> Database["MySQL Database"]
Database --> Repository

%% Responses
Repository --> Service
Mapper --> Service
Service --> Controller
Controller --> Client
