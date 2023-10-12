package Domain.Production.Patterns.Creational;

public class ClientBuilder {
    public static class clientBuilder {
        private String username;
        private String password;

        public clientBuilder setUsername(String user){
            this.username = user;
            return this;
        }

        public clientBuilder setPassword(String password){
            this.password = password;
            return this;
        }
    }
}
