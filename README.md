## 🔹 What is RESTful Web Service?

- REST = REpresentational State Transfer

- It is an architectural style for building web services, not a protocol.

- RESTful services use HTTP (GET, POST, PUT, DELETE, etc.) for communication.

- They exchange data typically in JSON or XML format.

## 🔹 Key Principles of REST

- Stateless

- Each request from client to server must contain all the info needed to understand it.

- Server does not store client state between requests.

- Client-Server

- Client (frontend/app) and server (backend service) are separate.

## Uniform Interface

- Use standard HTTP methods:
  - GET → Retrieve data

  - POST → Create new resource

  - PUT → Update entire resource

  - PATCH → Partially update resource
  - DELETE → Remove resource
 
## Resources Identified by URI

- Each resource has a unique URI (Uniform Resource Identifier)

Example:

/api/employees → list of employees

/api/employees/101 → employee with ID 101
