package com.example.demo.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class Result {
    private static final String resultCodeError="Error";
    private static final String resultCodeSuccess="Success";

}
