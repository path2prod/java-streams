package com.path2prod;

import java.util.List;
import java.util.Optional;

public record UserProfile(String id,Optional<ContactDetails> contactDetails) {

    public static List<Optional<UserProfile>> getUsers(){
        return List.of(
                    Optional.of(new UserProfile("user1", Optional.of(
                        new ContactDetails(Optional.of("07777777777"), Optional.of("user1@mail.com"))
                    ))),
                    Optional.of(new UserProfile("user2", Optional.empty())),
                    Optional.of(new UserProfile("user3", Optional.of(
                        new ContactDetails(Optional.empty(), Optional.of("user3@mail.com"))
                    ))),
                    Optional.empty()
                );
            }
}
