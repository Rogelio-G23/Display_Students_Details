package com.mycompany.main;

public class Student {

    // Private fields - cannot be accessed directly from outside
    private String studentId;
    private String name;
    private String gender;
    private String course;
    private String address;
    private String nationality;
    private int age;
    private int year;
    private int section;
    private int contactNo;

    private Student() {}

    // Getters - the only way to read the private fields
    public String getStudentId(){ 
        return studentId; 
    }
    public String getName(){ 
        return name; 
    }
    public String getGender(){ 
        return gender; 
    }
    public String getCourse(){ 
        return course; 
    }
    public String getAddress(){ 
        return address; 
    }
    public String getNationality(){ 
        return nationality; 
    }
    public int    getAge(){ 
        return age; 
    }
    public int    getYear(){ 
        return year; 
    }
    public int    getSection(){ 
        return section; 
    }
    public int    getContactNo(){ 
        return contactNo; 
    }

    public static class Builder {

        private String studentId;
        private String name;
        private String gender;
        private String course;
        private String address;
        private String nationality;
        private int age;
        private int year;
        private int section;
        private int contactNo;

        public Builder studentId(String studentId){ 
            this.studentId = studentId;
            return this; 
        }
        public Builder name(String name){ 
            this.name = name;
            return this; 
        }
        public Builder gender(String gender){
            this.gender = gender;
            return this; 
        }
        public Builder course(String course){ 
            this.course = course;      
            return this;
        }
        public Builder address(String address){ 
            this.address = address;
            return this;
        }
        public Builder nationality(String nationality){
            this.nationality = nationality;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder year(int year){
            this.year = year;
            return this;
        }
        public Builder section(int section){
            this.section = section;
            return this;
        }
        public Builder contactNo(int contactNo){
            this.contactNo = contactNo;
            return this;
        }

        public Student build() {
            Student s = new Student();
            s.studentId = this.studentId;
            s.name = this.name;
            s.gender = this.gender;
            s.course = this.course;
            s.address = this.address;
            s.nationality = this.nationality;
            s.age = this.age;
            s.year = this.year;
            s.section = this.section;
            s.contactNo = this.contactNo;
            return s;
        }
    }
}
