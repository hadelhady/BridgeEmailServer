package server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.regex.Pattern;

public class server {

	public static void main(String[] args) {
		try
		{
			String toEmail, fromEmail , bodyEmail;

			ServerSocket server =  new ServerSocket(3000);
			Socket s = server.accept();
			System.out.println("connected");

			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			toEmail = in.readLine();
			fromEmail = in.readLine();
			bodyEmail = in.readLine();
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);

			if(isValid(toEmail) && (isValid(fromEmail))){
				out.println(checkEmailTypeAndSendEmailByType(fromEmail));
			}
			else
			{
				out.println("The email not valid - from or to email");
			}

		}catch(Exception e ){}


	}

	private static String checkEmailTypeAndSendEmailByType(String email){

		if(email.isEmpty()){
			return "the email is empty";
		}

		if( !isValid(email)){
			return "The Email is not valid";	
		}

		String[] array = email.split("@");

		switch (array[1]) {
		case "gmail.com" :
			//send the email using API gmail.
			return "The email from type gmail.com sending successfully!";

		case "walla.co.il" :
			//send the email using API walla.
			return "The email from type walla.co.il sending successfully!";

		case "yahoo.com" :
			//send the email using API yahoo.
			return "The email from type yahoo.com sending successfully!";			

		default:

			return "The email not include in the list of vendors : gmail, walla and yahoo";
		}

	}

	private static boolean isValid(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
