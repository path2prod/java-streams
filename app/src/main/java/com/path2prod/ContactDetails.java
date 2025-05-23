package com.path2prod;

import java.util.Optional;

public record ContactDetails(Optional<String> phoneNumber, Optional<String> address) {}
