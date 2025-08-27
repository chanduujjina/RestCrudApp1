# 🔄 Event-Driven Microservices - Sequence Diagram

```mermaid
sequenceDiagram
    participant C as Client
    participant OS as Order Service
    participant EB as Event Bus (Kafka/RabbitMQ)
    participant PS as Payment Service
    participant IS as Inventory Service
    participant NS as Notification Service

    C->>OS: Place Order Request
    OS->>EB: Publish OrderCreated Event
    EB-->>PS: Consume OrderCreated Event
    EB-->>IS: Consume OrderCreated Event

    PS->>EB: Publish PaymentProcessed Event
    IS->>EB: Publish InventoryReserved Event

    EB-->>NS: Consume PaymentProcessed and InventoryReserved
    NS->>C: Send Order Confirmation Notification
