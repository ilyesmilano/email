package com.springbootsmtp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity {

    private String recipient;
    private String msgBody;
    private String subject;
}
