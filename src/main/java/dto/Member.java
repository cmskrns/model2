package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {

		private String id;
		private String password;
		private String name;
		private String gender;
		private String birth;
		private String mail;
		private String phone;
		private String address;
		private String regist_day;
}
