erDiagram
    USER ||--|| PROFILE : "has one"          %% One-to-One
    USER ||--o{ ORDER : "places"             %% One-to-Many
    ORDER }o--|| PRODUCT : "contains"        %% Many-to-One
