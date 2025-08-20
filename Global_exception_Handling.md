```java
@ExceptionHandler(exception =MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleBadRequest(MethodArgumentNotValidException  ex){
		
		 Map<String, Object> body = new HashMap<>();
		
		 body.put("timestamp", LocalDateTime.now());
		 body.put("status", HttpStatus.BAD_REQUEST);
		 body.put("error", "Validation Failed");
		 
		 Map<String, String> fieldErrors = new HashMap<>();
		 ex.getBindingResult().getFieldErrors().forEach(error -> {
			 fieldErrors.put(error.getField(),  error.getDefaultMessage());
			 
		 });
		 body.put("message", fieldErrors);
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, String>> handleMissingParam(MissingServletRequestParameterException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("parameter", ex.getParameterName());
        error.put("message", "Request parameter is missing or required");
        return ResponseEntity.badRequest().body(error);
    }
```
