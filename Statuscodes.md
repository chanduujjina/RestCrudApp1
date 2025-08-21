## ✅ 1xx: Informational


| Code    | Status              | Description                                                |
| ------- | ------------------- | ---------------------------------------------------------- |
| **100** | Continue            | Request received, continue sending.                        |
| **101** | Switching Protocols | Server is switching protocols as requested.                |
| **102** | Processing          | Server has received request but still processing (WebDAV). |
| **103** | Early Hints         | Prepares the client to start preloading resources.         |


## 🟢 2xx: Success

| Code    | Status                        | Description                                              |
| ------- | ----------------------------- | -------------------------------------------------------- |
| **200** | OK                            | Standard response for success.                           |
| **201** | Created                       | A new resource has been created.                         |
| **202** | Accepted                      | Request accepted for processing but not completed.       |
| **203** | Non-Authoritative Information | Returned meta-information is not from the origin server. |
| **204** | No Content                    | Successful but no response body.                         |
| **205** | Reset Content                 | Tells client to reset the document view.                 |
| **206** | Partial Content               | Server is returning partial resource (range requests).   |
| **207** | Multi-Status                  | Multiple statuses for multiple operations (WebDAV).      |
| **208** | Already Reported              | Members of a collection already reported (WebDAV).       |
| **226** | IM Used                       | Response is a result of instance-manipulations.          |


## 🟡 3xx: Redirection
| Code    | Status                   | Description                                         |
| ------- | ------------------------ | --------------------------------------------------- |
| **300** | Multiple Choices         | Multiple options for the resource.                  |
| **301** | Moved Permanently        | Resource has been permanently moved.                |
| **302** | Found                    | Temporary redirect.                                 |
| **303** | See Other                | Response can be found at another URI (after POST).  |
| **304** | Not Modified             | Resource not modified since last request (caching). |
| **305** | Use Proxy *(Deprecated)* | Resource must be accessed via proxy.                |
| **307** | Temporary Redirect       | Temporary redirect, method not changed.             |
| **308** | Permanent Redirect       | Resource permanently moved, method not changed.     |


## 🔴 4xx: Client Errors

| Code    | Status                          | Description                                      |
| ------- | ------------------------------- | ------------------------------------------------ |
| **400** | Bad Request                     | Invalid syntax or request.                       |
| **401** | Unauthorized                    | Authentication required.                         |
| **402** | Payment Required *(Reserved)*   | Future use (e.g., digital payments).             |
| **403** | Forbidden                       | Server refuses to authorize the request.         |
| **404** | Not Found                       | Resource not found.                              |
| **405** | Method Not Allowed              | HTTP method not allowed on resource.             |
| **406** | Not Acceptable                  | Resource cannot return acceptable response.      |
| **407** | Proxy Authentication Required   | Client must authenticate with proxy.             |
| **408** | Request Timeout                 | Server timed out waiting for request.            |
| **409** | Conflict                        | Request conflicts with current resource state.   |
| **410** | Gone                            | Resource no longer available.                    |
| **411** | Length Required                 | Missing `Content-Length` header.                 |
| **412** | Precondition Failed             | Preconditions in headers not met.                |
| **413** | Payload Too Large               | Request body too large.                          |
| **414** | URI Too Long                    | Request-URI is too long.                         |
| **415** | Unsupported Media Type          | Media type not supported.                        |
| **416** | Range Not Satisfiable           | Requested range not satisfiable.                 |
| **417** | Expectation Failed              | `Expect` header not met.                         |
| **418** | I'm a Teapot (RFC 2324)         | Joke code for HTCPCP/coffee pots ☕.              |
| **421** | Misdirected Request             | Request sent to wrong server.                    |
| **422** | Unprocessable Entity            | Semantic errors in request (WebDAV).             |
| **423** | Locked                          | Resource is locked (WebDAV).                     |
| **424** | Failed Dependency               | Request failed due to previous failure (WebDAV). |
| **425** | Too Early                       | Server unwilling to risk replay attack.          |
| **426** | Upgrade Required                | Must upgrade protocol (e.g., HTTP to HTTPS).     |
| **428** | Precondition Required           | Server requires precondition headers.            |
| **429** | Too Many Requests               | Rate limiting applied.                           |
| **431** | Request Header Fields Too Large | Request headers too large.                       |
| **451** | Unavailable For Legal Reasons   | Blocked due to legal restrictions.               |


## 🔥 5xx: Server Errors

| Code    | Status                          | Description                                      |
| ------- | ------------------------------- | ------------------------------------------------ |
| **500** | Internal Server Error           | Generic server error.                            |
| **501** | Not Implemented                 | Server doesn’t support functionality.            |
| **502** | Bad Gateway                     | Invalid response from upstream server.           |
| **503** | Service Unavailable             | Server temporarily overloaded/unavailable.       |
| **504** | Gateway Timeout                 | No timely response from upstream server.         |
| **505** | HTTP Version Not Supported      | Version not supported by server.                 |
| **506** | Variant Also Negotiates         | Server configuration error.                      |
| **507** | Insufficient Storage            | Server cannot store representation (WebDAV).     |
| **508** | Loop Detected                   | Infinite loop detected (WebDAV).                 |
| **510** | Not Extended                    | Further extensions required.                     |
| **511** | Network Authentication Required | Client must authenticate to gain network access. |
