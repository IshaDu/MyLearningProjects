package com.learnSpring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.learnSpring.model.BeautyTreatments;
import com.learnSpring.model.CustomerAppointmentDetails;
import com.learnSpring.model.Users;

public class BeautyTreatmentDAOImpl implements BeautyTreatmentDAO {
	// this is used to create database connectivity
	private JdbcTemplate jdbcTemplate;

	//This constructor creates the jdbcTemplate with data source which later helps to perform operations on db
	public BeautyTreatmentDAOImpl(DataSource dataSource) 
	{ 
		System.out.println("Value of dataSource:  "+dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	// This function adds the new beauty treatments provided by the beauty treatment salon to the database table
	public void addBeautyTreatments(String beautyTreatmentName, String beautyTreatmentPrice) 
	{
		System.out.println("Beauty Treatment Name is Inside BeautyTreatmentDAOImpl: "+beautyTreatmentName);
		System.out.println("Beauty Treatment Price is Inside BeautyTreatmentDAOImpl: "+beautyTreatmentPrice);
		  String query =
		  "INSERT INTO beatytreatments (beautyTreatmentName, beatyTreatmentPrice) " +
		  "VALUES(?,?)";
		  jdbcTemplate.update(query,beautyTreatmentName,beautyTreatmentPrice);
		 
	}
	// This function adds the details of new users who are registering to the application
	public void saveBeautyTreatmentsNewUser(Users user) {
		System.out.println("Inside DAOImpl");
		System.out.println("User's First Name: "+user.getFirstName());
		System.out.println("User's Last Name: "+user.getLastName());
		System.out.println("User's Age: "+user.getAge());
		System.out.println("User's Gender: "+user.getGender());
		System.out.println("User's Address: "+user.getAddress());
		System.out.println("User's Phone: "+user.getPhone());
		
		String query = "INSERT INTO users (userName,password,firstName,lastName,age,gender,address,phone) VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,user.getUserName(),user.getPassword(), user.getFirstName(),user.getLastName(),
									user.getAge(),user.getGender(),user.getAddress(),user.getPhone());
	}

	public boolean verifyUser(final String userName,final String password) {
		
		String query = "SELECT * FROM learn.users WHERE userName = '"
						+userName
						+"' and password='"
						+password
						+"' ";
		
		Users verifiedUser = jdbcTemplate.query(query, new ResultSetExtractor<Users>() {

			public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
				Users users = new Users();
				if(rs.next()) {
					if(rs.getString("userName").equals(userName) &&  rs.getString("password").equals(password)) {
						users.setUserName(rs.getString("userName"));
						users.setPassword(rs.getString("password"));
						users.setFirstName(rs.getString("firstName"));
						users.setLastName(rs.getString("lastName"));
						users.setAge(rs.getString("age"));
						users.setGender(rs.getString("gender"));
						users.setAddress(rs.getString("address"));
						users.setPhone(rs.getString("phone"));
					}
					
					System.out.println("Inside verifyUser() method: ");
					System.out.println("User's First Name: "+users.getFirstName());
					System.out.println("User's Last Name: "+users.getLastName());
					System.out.println("User's Age: "+users.getAge());
					System.out.println("User's Gender: "+users.getGender());
					System.out.println("User's Address: "+users.getAddress());
					System.out.println("User's Phone: "+users.getPhone());
					return users;
				}
				
				return null;
			}
		});
		if(verifiedUser!=null)
			return true;
		
		return false;
	}

	public List<BeautyTreatments> viewAllBeautyTreatmentsAvailable() {
		String query = "SELECT * FROM beatytreatments";
		List<BeautyTreatments> beautyTreatmentsList = new ArrayList<BeautyTreatments>();
		beautyTreatmentsList = jdbcTemplate.query(query, new ResultSetExtractor<List<BeautyTreatments>>(){
			
			public List<BeautyTreatments> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<BeautyTreatments> list = new ArrayList<BeautyTreatments>();
				while(rs.next()) {
					BeautyTreatments beautyTreatments = new BeautyTreatments();
					beautyTreatments.setBeautyTreatmentId(rs.getInt(1));
					beautyTreatments.setBeautyTreatmentName(rs.getString(2));
					beautyTreatments.setBeautyTreatmentPrice(rs.getString(3));
					System.out.println("beautyTreatments inside the rs.next()"+beautyTreatments.getBeautyTreatmentId()
							+" AND "+beautyTreatments.getBeautyTreatmentName()
							+" AND "+beautyTreatments.getBeautyTreatmentPrice());
					list.add(beautyTreatments);
					System.out.println("list is inside the inner function : "+list);
				}
				return list;
			}
			
		});
		System.out.println("List of beauty treatments: Inside dao: "+beautyTreatmentsList);
		return beautyTreatmentsList;
	}

	public void saveCustomerBeautyTreatmentApptmentDetails(CustomerAppointmentDetails customerAppointmentDetails) {
		System.out.println("Inside saveCustomerBeautyTreatmentApptmentDetails : ");
		System.out.println("customerAppointmentDetails.getFirstName() : "+customerAppointmentDetails.getFirstName());
		System.out.println("customerAppointmentDetails.getLastName() : "+customerAppointmentDetails.getLastName());
		System.out.println("customerAppointmentDetails.getApptDate() :"+customerAppointmentDetails.getApptDate());
		System.out.println("customerAppointmentDetails.getApptTime() : "+customerAppointmentDetails.getApptTime());
		System.out.println("customerAppointmentDetails.getBeautyTreatmentName() : "+customerAppointmentDetails.getBeautyTreatmentName());
			
		 String query =
				  "INSERT INTO beautytreatmentappointmentdetails (CustomerFirstName, CustomerLastName,AppointmentDate,"
				  + "AppointmentTime,BeautyTreatmentName) " +
				  "VALUES(?,?,?,?,?)";
				  jdbcTemplate.update(query,customerAppointmentDetails.getFirstName(),customerAppointmentDetails.getLastName(),
						  customerAppointmentDetails.getApptDate(),customerAppointmentDetails.getApptTime(),
						  customerAppointmentDetails.getBeautyTreatmentName());
	}
	
}
