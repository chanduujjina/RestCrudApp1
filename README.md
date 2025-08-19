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


## Representation of Resources

- A resource can be represented in JSON, XML, or other formats.

Example:
```json
{
  "id": 101,
  "name": "John Doe",
  "department": "IT"
}

```

# POST vs PUT in REST

## 🔹 Overview

| Aspect | **POST** | **PUT** |
|--------|----------|---------|
| **Purpose** | Create a **new resource** | Create **or update** a resource (idempotent) |
| **Idempotency** | **Not idempotent** – calling multiple times creates multiple resources | **Idempotent** – calling multiple times produces the same result |
| **When to use** | When the server should generate a new resource ID (like auto-increment) | When the client already knows the resource ID and wants to update/replace it |
| **URI** | Generally on **collection URI** (e.g., `/api/employees`) | Generally on **specific resource URI** (e.g., `/api/employees/101`) |
| **Behavior on Existing Resource** | Adds a new resource | Replaces existing resource (or creates if not present, depending on API design) |

---

# POST vs PATCH in REST

## 🔹 Overview

| Aspect | **POST** | **PATCH** |
|--------|----------|-----------|
| **Purpose** | Create a **new resource** | Partially **update an existing resource** |
| **Idempotency** | **Not idempotent** – multiple calls may create multiple resources | **Idempotent (ideally)** – multiple calls with the same data result in the same update |
| **When to use** | When adding a brand-new resource to the server | When modifying only certain fields of an existing resource |
| **URI** | Generally on **collection URI** (e.g., `/api/employees`) | On a **specific resource URI** (e.g., `/api/employees/101`) |
| **Behavior** | Creates a new entry in the collection | Applies a **partial modification** without replacing the whole object |

---

# POST vs PATCH in REST

## 🔹 Overview

| Aspect | **POST** | **PATCH** |
|--------|----------|-----------|
| **Purpose** | Create a **new resource** | Partially **update an existing resource** |
| **Idempotency** | **Not idempotent** – multiple calls may create multiple resources | **Idempotent (ideally)** – multiple calls with the same data result in the same update |
| **When to use** | When adding a brand-new resource to the server | When modifying only certain fields of an existing resource |
| **URI** | Generally on **collection URI** (e.g., `/api/employees`) | On a **specific resource URI** (e.g., `/api/employees/101`) |
| **Behavior** | Creates a new entry in the collection | Applies a **partial modification** without replacing the whole object |

---

# GET vs POST in REST

## 🔹 Overview

| Aspect | **GET** | **POST** |
|--------|---------|----------|
| **Purpose** | Retrieve **data** from the server (read-only) | Send data to the server to **create** or **process** something |
| **Idempotency** | **Idempotent** – calling multiple times does not change server state | **Not idempotent** – multiple calls may create duplicate resources |
| **Request Body** | Not allowed (or ignored) | Allowed (used to send data in body) |
| **Parameters** | Data sent via **query string** (URL) or headers | Data sent via **request body** |
| **Caching** | Responses are easily **cacheable** by browsers/CDNs | Responses are **not cached** (by default) |
| **Security** | Less secure – parameters appear in URL (can be logged/bookmarked) | More secure – data sent in request body (not visible in URL) |
| **Typical Use Case** | Fetching a resource (e.g., list of employees, user profile) | Submitting forms, creating a new record, uploading files |

---




