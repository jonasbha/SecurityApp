package com.example.app.controller;

import com.example.app.tools.MainAdapter;
import com.example.core.model.Course;
import com.example.core.model.communication.Message;
import com.example.core.model.persistence.repository.IAccountRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuestController {

    IAccountRepository accountRepository;

    public GuestController(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<String> getCourseEntries() {
        List<String> courses = new ArrayList<>();
        for (int i = 0; i < accountRepository.getCourses().size(); i++)
            courses.add(accountRepository.getCourses().get(i).getCourseCode());

        return courses;
    }

    public MainAdapter getMessageComments(String courseCode) {
        HashMap<String, ArrayList<String>> listChild = new HashMap<>();
        ArrayList<String> listGroup = new ArrayList<>();

        List<Message> messages = accountRepository.getCourse(extract(courseCode)).getMessages();

        for (int i = 0; i < messages.size(); i++) {

            listGroup.add(messages.get(i).getSender() + ": " + messages.get(i).getText());

            ArrayList<String> arrayList = new ArrayList<>();

            for (int j = 0; j < messages.get(i).getComments().size(); j++) {
                arrayList.add(messages.get(i).getComments().get(j).getText());
            }

            listChild.put(listGroup.get(i), arrayList);
        }

        return new MainAdapter(listChild, listGroup);
    }

    public MainAdapter getTestAdapter() {
        HashMap<String, ArrayList<String>> listChild = new HashMap<>();
        ArrayList<String> listGroup = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            listGroup.add("Geir: hello "+i);

            ArrayList<String> arrayList = new ArrayList<>();

            for (int j = 0; j <5; j++) {
                arrayList.add("commenter: hei"+j);
            }

            listChild.put(listGroup.get(i), arrayList);
        }

        return new MainAdapter(listChild, listGroup);
    }

    private Course extract(String courseCode) {
        Course course = null;
        for (int i = 0; i < accountRepository.getCourses().size(); i++)
            if (accountRepository.getCourses().get(i).getCourseCode().equals(courseCode))
                course = accountRepository.getCourses().get(i);
        return course;
    }

}
