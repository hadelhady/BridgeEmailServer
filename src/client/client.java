package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		try
		{
			String fromEmail , getMassege  , toEmail ,bodyEmail;

			Socket s =  new Socket("127.0.0.1",3000);
			Scanner scn = new Scanner(System.in);
			System.out.println("connected!!");

			System.out.println("Insert email - To : ");
			toEmail = scn.nextLine();

			System.out.println("Insert email - From : ");
			fromEmail = scn.nextLine();

			System.out.println("Insert email - Body : ");
			bodyEmail = scn.nextLine();


			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(toEmail);
			out.println(fromEmail);
			out.println(bodyEmail);

			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			getMassege = in.readLine();

			System.out.println(getMassege);
		}catch(Exception e ){}

	}

}
