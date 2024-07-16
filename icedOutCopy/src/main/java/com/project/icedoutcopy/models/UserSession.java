package com.project.icedoutcopy.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {
    private User loggedInUser;
    public User getLoggedInUser() {return loggedInUser;}
    public void setLoggedInUser(User loggedInUser) {this.loggedInUser = loggedInUser;}
}
