import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username; 
	private long accountNumber; 
	private String password;
	private long funds; 
	
	public Account(String username, long accountNumber, String password){
		this.username = username;
		this.accountNumber = accountNumber; 
		this.password = password;
		funds = 0;
	}
	
	public void addFunds(long amount, String pass){
		if (amount > 0 &&  password.equals(pass)){
			funds += amount;
		}
	}
	public void withdrawFunds(long amount, String pass){
		if (amount > 0 &&  password.equals(pass)){
			funds -= amount;
		}
	}
	public String toString(){
		String str = accountNumber +"\n"+username + ": $" + funds; 
		
		return str;
	}
	
}
