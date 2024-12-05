import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();
   

    private boolean checkBook(int inpNum) {
    	boolean found = false;
    	for (int i = 0; i<books.size();i++)
    	{
    		if (books.get(i).getId() ==inpNum)
    		{
    			found = true;
    		}
    	}
    	return found;
    }
    private boolean checkMember(int inpNum) {
    	boolean found = false;
    	for (int i = 0;i< members.size();i++)
    	{
    		if (members.get(i).getId() ==inpNum)
    		{
    			found = true;
    		}
    	}
    	return found;
    }
    // Add a new member to the library
    public void addMember(Member member) {
    	if (checkMember(member.getId())==false)
    	{
    		members.add(member);
    		 System.out.println("Member added to library successfully.");
    	}
    	else 
    	{
    		System.out.print("this memeber already exists.\n");
    	}
    }
    
    // Add a new book to the library
    public void addBook(Book book) {
    	if (checkBook(book.getId())==false)
    	{
    		books.add(book);
    		System.out.println("Book added successfully.");
    	}
    	else 
    	{
    		System.out.print("this book already exists. \n");
    	}
        
    }

    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of members
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of books
    public List<Book> getBooks() {
        return books;
    }
    
}
