import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileWriter;
import java.io.File; 
import java.util.Scanner;
import java.io.IOException; 
import java.io.FileNotFoundException;  // Import this class to handle errors
public class Transaction {
	
	private  static Transaction instance;
	
	

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()&& instance == null) {
            try {
				book.borrowBook();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            
            saveTransaction(transactionDetails);
            instance = new Transaction(); 
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
        
    }

    // Perform the returning of a book
    public boolean returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
            return true;
        } else {
            System.out.println("This book was not borrowed by the member.");
            return false;
        }
    }

    // Get the current date and time in a readable format
    private static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

	public String displayTransactionHistory() {
		String data = null;
	      File myObj = new File("transactions.txt");
	      try {
			Scanner myReader = new Scanner(myObj);
			 while (myReader.hasNextLine()) {
			        data = myReader.nextLine();
			      }
			 myReader.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	     
	      
		
		return data;
	}
	
	public void saveTransaction(String details)
	{
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("transactions.txt");
		      myWriter.write(details);
		      myWriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		
	}
	
	
}