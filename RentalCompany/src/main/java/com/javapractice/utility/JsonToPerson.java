package com.javapractice.utility;

import com.javapractice.model.person.Person;

import java.io.FileReader;
import java.io.InputStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.File;


public class JsonToPerson {

    private String fileName;
    Gson gson = new Gson();

    public JsonToPerson(String fileName) {
        this.fileName = fileName;
    }

    public Person getPerson() {
        Person person = null;
        try {
            JsonReader reader = new JsonReader(new FileReader(fileName));
            person = gson.fromJson(reader, Person.class);
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        return person;
    }

    public static void main(String[] args) {
        JsonToPerson jsonParser = new JsonToPerson("src/main/resources/test.json");
        Person person = jsonParser.getPerson();

        System.out.println(person.getName() + " " + person.getLastName());
        System.out.println(person.getAddress());
        System.out.println(person.getPhoneNumber());
        System.out.println(person.getEmail());
    }
}