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

# ✅ Best Practices for Designing REST APIs

## 1. **Use Nouns for Resource URIs**
- URIs should represent **resources**, not actions.
- **Good**: `/api/employees/101`
- **Bad**: `/api/getEmployee?id=101`

---

## 2. **Use Plural Nouns**
- Use plural nouns for collections.
- **Good**: `/api/employees`
- **Bad**: `/api/employee`

---

## 3. **Use HTTP Methods Correctly**
- `GET` → Retrieve data  
- `POST` → Create a new resource  
- `PUT` → Replace/update a resource  
- `PATCH` → Partially update a resource  
- `DELETE` → Remove a resource  

---

## 4. **Version Your API**
- Use versioning to avoid breaking clients when changes occur.
- **Example**:  
  - `/api/v1/employees`  
  - `/api/v2/employees`

---

## 5. **Use Meaningful Status Codes**
- `200 OK` → Successful GET/PUT/PATCH/DELETE  
- `201 Created` → Successful POST  
- `204 No Content` → Successful DELETE/PUT (no response body)  
- `400 Bad Request` → Invalid input  
- `401 Unauthorized` → Authentication required  
- `403 Forbidden` → Permission denied  
- `404 Not Found` → Resource doesn’t exist  
- `500 Internal Server Error` → Server failure  

---

## 6. **Support Filtering, Sorting & Pagination**
- Use query parameters for searching & sorting.  
  - `/api/employees?department=IT&sort=name&order=asc&page=2&limit=10`

---

## 7. **Use Consistent Naming & Conventions**
- Snake_case ❌  
- camelCase ❌  
- kebab-case ✅ (preferred in URLs)
- Example: `/api/employees/{employee-id}`

---

## 8. **Return Standardized Error Responses**
Use a consistent error format:
```json
{
  "timestamp": "2025-08-17T10:20:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Employee not found",
  "path": "/api/employees/999"
}
```


