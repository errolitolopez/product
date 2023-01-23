````
// getLastName

-> business logic
  -> api call
    -> result
-> dao
  -> query
    -> result

postman
````

```
class Scratch {
    public static void main(String[] args) {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setUsername("rols");
        request.setPassword("123");
        request.setConfirmPassword("123");
        boolean isValid = isValidPassword(request);
    }

    public static boolean isValidPassword(UserRegistrationRequest userRegistrationRequest) {
        boolean isValid = userRegistrationRequest.getPassword().equals(userRegistrationRequest.getConfirmPassword());
        System.out.println("Password for user=" + userRegistrationRequest.getUsername() + " is matched.");
        return isValid;
    }

    public static class UserRegistrationRequest {
        private String username;
        private String password;
        private String confirmPassword;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }
    }
}
```

```
dao
    - entities - data mapping
    - interfaces - collection of methods
    - implementations - implements interfaces
    - exception - errors 

service
    - interfaces
    - implementations
    - exception
    
controller / rs
    - interfaces
    - implementations
```