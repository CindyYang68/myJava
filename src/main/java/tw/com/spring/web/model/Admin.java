package tw.com.spring.web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import tw.com.spring.web.annotation.UniqueAdminName;
import tw.com.spring.web.annotation.UniqueEmail;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length = 20, nullable = false,unique = true)
    @NotBlank(message = "帳號不可為空")
    //@UniqueAdminName
    private String name;

    @Column(name="email", length = 20, nullable = false,unique = true)
    @Email(message = "信箱格式錯誤")
    @NotBlank(message = "信箱不可為空")
    //@UniqueEmail
    private String email;

    @Column(name="password", length = 20, nullable = false)
    @Size(min = 8, message = "密碼不可少於8位")
    @NotBlank(message = "密碼不可為空")
    private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
