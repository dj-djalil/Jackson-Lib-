package com.jackson.json.demo;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
	public static void main(String[] args) {

		try {

			// create Object Mapper
			ObjectMapper mapper = new ObjectMapper();
//******************************************************************************
			// Read JSON File and Map/Converct to java POJO

			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			// you can use String 'str' instead of reading from file
			// String str =
			// "{\"id\":12,\"firstName\":\"test1\",\"lastName\":\"test2\",\"active\":
			// true}";

			// print first Name and last Name ...
			System.out.println("First Name :" + theStudent.getFirstName());
			System.out.println("Last Name  :" + theStudent.getLastName());
			System.out.println("Address (city) :" + theStudent.getAddress().getCity());
			System.out.println("Languages :");

			for (int i = 0; i < theStudent.getLanguages().length; i++)
				System.out.println(theStudent.getLanguages()[i]);
//*****************************************************************************
			// converting Object to String "JSON format "
			String str1 = mapper.writeValueAsString(theStudent);
			System.out.println(str1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
