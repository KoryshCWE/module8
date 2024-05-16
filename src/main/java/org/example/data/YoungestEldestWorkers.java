package org.example.data;

public class YoungestEldestWorkers {
        private String type;
        private String name;
        private java.sql.Date birthday;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public java.sql.Date getBirthday() {
            return birthday;
        }

        public void setBirthday(java.sql.Date birthday) {
            this.birthday = birthday;
        }
    }