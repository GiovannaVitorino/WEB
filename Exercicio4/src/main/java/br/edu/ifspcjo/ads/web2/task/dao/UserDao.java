package br.edu.ifspcjo.ads.web2.task.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import br.edu.ifspcjo.ads.web2.task.model.User;
import br.edu.ifspcjo.ads.web2.task.utils.PasswordEncoder;

public class UserDao {

	private DataSource dataSource;

	public UserDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
		
	public Boolean save(User user){
		Optional<User> optional = getUserByEmail(user.getEmail());
		if(optional.isPresent()) {
			return false;
		}
		String sql = "insert into user (name, email, password, "
				+ "birth_date, gender, active) values (?,?,?,?,?,?)";
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setBoolean(6, true);
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a escrita no BD", e);
		}
		return true;
	}
}