package com.app.runnables;

import com.app.model.User;
import com.app.repo.UserRepository;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

// Callable with return type Integer
public class UserProcessor implements Callable<Integer> {

    private String userRecord;
    private UserRepository userRepository;


    public UserProcessor(String userRecord, UserRepository userRepository) {
        this.userRecord = userRecord;
        this.userRepository = userRepository;
    }

    @Override
    public Integer call() throws Exception {

        StringTokenizer tokenizer =new StringTokenizer(userRecord, ",");
        User user=null;
        int rows=0;
        while(tokenizer.hasMoreTokens()){
            user=new User();
            user.setEmailAddress(tokenizer.nextToken());
            user.setName(tokenizer.nextToken());
            user.setId(Integer.valueOf(tokenizer.nextToken()));
            rows= userRepository.saveUser(user);
        }
        return rows;
    }
}











