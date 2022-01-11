import java.io.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("account1");
		Account account1;
		if(!file.exists()){
			System.out.println("Creating File");
			try {
				account1 = new Account("jonny", 907, "password");
				System.out.println(account1.toString());
				save(file, account1);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("File Created");
			
		}
		
		if(file.exists()){
			System.out.println("File exists");
			try {
				ObjectInputStream oin = new ObjectInputStream(new FileInputStream (file));
				account1 = (Account) oin.readObject();
				System.out.println(account1.toString());
				account1.addFunds(100, "password");
				oin.close();
				
				System.out.println("adding funds"+account1.toString());
				save(file,account1);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void save(File file,Account target) throws FileNotFoundException, IOException{
		if(file.exists()){
			//file.delete();
		}
		file.createNewFile();
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream (file));
		oout.writeObject(target);
		oout.close();
	}
	
}
