
package LotterySystem;

    public class Customer {


        // name, birth of date, address, phone, email
        private String name;
        private String birthday;
        private String address;
        private int phone;
        private String email;

        //constructor


        public Customer(String name, String birthday, String address, int phone, String email) {
            this.name = name;
            this.birthday = birthday;
            this.address = address;
            this.phone = phone;
            this.email = email;
        }

        public Customer(){};


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return  "Customer's information{ "
                    + "Name: " + name
                    + " Birthday: " + birthday
                    + " Address: " + address
                    + " Phone: " + phone
                    + " Mail: " + email + '\'' + "}";
        }


    }


