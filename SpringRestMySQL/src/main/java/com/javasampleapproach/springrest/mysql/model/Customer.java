/*
 * package com.javasampleapproach.springrest.mysql.model;
 * 
 * import org.springframework.data.annotation.Id; import
 * org.springframework.data.mongodb.core.mapping.Document; import
 * org.springframework.data.mongodb.core.mapping.Field;
 * 
 * @Document(collection = "CUSTOMER") public class Customer {
 * 
 * @Id private long id;
 * 
 * @Field("name") private String name;
 * 
 * @Field("age") private int age;
 * 
 * @Field("active") private boolean active;
 * 
 * public Customer() { }
 * 
 * public Customer(String name, int age) { this.name = name; this.age = age;
 * this.active = false; }
 * 
 * public long getId() { return id; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public String getName() { return this.name; }
 * 
 * public void setAge(int age) { this.age = age; }
 * 
 * public int getAge() { return this.age; }
 * 
 * public boolean isActive() { return active; }
 * 
 * public void setActive(boolean active) { this.active = active; }
 * 
 * @Override public String toString() { return "Customer [id=" + id + ", name="
 * + name + ", age=" + age + ", active=" + active + "]"; } }
 */