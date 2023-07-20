package com.krah.spik.serviceone.dto;

import com.krah.spik.serviceone.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends User {
    private Long productCount;
}
